package rentcar.rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;
import rentcar.RentCarApplication;
import rentcar.join.MemberVO;

public class RentalDAO {
	MemberVO session = RentCarApplication.getSession();
	private static RentalDAO instance = new RentalDAO();
	
	public static RentalDAO getInstance() {
		return instance;
	}

	public List<RentalVO> selectList(String branchId, String startDate, int days) throws Exception {
		List<RentalVO> list = new ArrayList<RentalVO>();
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		Statement statement = connection.createStatement();
		
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("      M.MD_NM,M.MD_SIZE,M.MD_RENT_FEE,M.MD_FUEL, M.MD_ID ");
		builder.append("  FROM CAR C, MODEL M ");
		builder.append(" WHERE C.BRANCH_ID = '"+ branchId +"' "); 
		builder.append("   AND CAR_NUM NOT IN(SELECT CAR_NUM ");
		builder.append("                        FROM RENTAL ");
		builder.append("                       WHERE RENT_START_DT BETWEEN TO_DATE("+ startDate +") AND TO_DATE("+ startDate +" )+ "+ days +" ");
		builder.append("                         AND RENT_END_DT BETWEEN TO_DATE("+ startDate +") AND TO_DATE("+ startDate +" )+ " + days +") ");
		builder.append("   AND C.MD_ID=M.MD_ID ");
		String sql = builder.toString();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			String mdName = resultSet.getString("MD_NM");
			String mdSize = resultSet.getString("MD_SIZE");
			int mdRfee = resultSet.getInt("MD_RENT_FEE");
			String mdFuel = resultSet.getString("MD_FUEL");
			String mdId = resultSet.getString("MD_ID");
			list.add(new RentalVO(mdName, mdSize, mdRfee, mdFuel, mdId));
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	
	
	
	
	
	public int rentReservation(RentalVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
				
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO ");
		builder.append("       RENTAL(RENT_ID, RENT_STATUS, RENT_START_DT, RENT_END_DT, RENT_INSURANCE, MEM_ID, BRANCH_ID, MD_ID, RENT_FEE, RENT_PAY_STATUS) ");
		builder.append("VALUES ");
		builder.append("	   (SEQ_RENT_ID.NEXTVAL, ");
		builder.append("        1, ");
		builder.append("        TO_DATE(?)," );
		builder.append("        TO_DATE(?)+?, ");
		builder.append("        ?," );
		builder.append("		"+ session.getMemId() +", ");
		builder.append("		?, ");
		builder.append("        ?, ");
		builder.append("	    (SELECT DISTINCT MD_RENT_FEE FROM MODEL WHERE MD_ID=?)*?,1)	 ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getRentStartDt());
		statement.setString(2, vo.getRentStartDt());
		statement.setInt(3, vo.getDays());
		statement.setInt(4, vo.getRentInsurance());
		statement.setString(5, vo.getBranchId());
		System.out.println(vo.getMdId());
		statement.setString(6, vo.getMdId());
		statement.setString(7, vo.getMdId());
		statement.setInt(8, vo.getDays());
		int executeUpdate = statement.executeUpdate();
				
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	public List<RentalVO> selectRent(String searchId) throws Exception {
		List<RentalVO> list1 = new ArrayList<RentalVO>();
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		Statement statement = connection.createStatement();
		
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("    R.RENT_START_DT, ");
		builder.append("    R.RENT_END_DT, ");
		builder.append("    R.RENT_INSURANCE, ");
		builder.append("    R.CAR_NUM, ");
		builder.append("    R.MEM_ID, ");
		builder.append("    R.MANAGER_ID, ");
		builder.append("    R.RENT_FEE, ");
		builder.append("    R.BRANCH_ID, ");
		builder.append("    M.MD_NM ");
		builder.append("FROM ");
		builder.append("    RENTAL R,MODEL M ");
		builder.append("WHERE ");
		builder.append("    R.MEM_ID = '" + searchId + "' ");
		builder.append("  AND ");
		builder.append("    R.MD_ID = M.MD_ID ");
		
		String sql = builder.toString();

		ResultSet resultSet = statement.executeQuery(sql);
		
		
		while (resultSet.next()) {
			String rsd = resultSet.getString("RENT_START_DT");
			String red = resultSet.getString("RENT_END_DT");
			int ins = resultSet.getInt("RENT_INSURANCE");
			String cnum = resultSet.getString("CAR_NUM");
			String memId = resultSet.getString("MEM_ID");
			String managerId = resultSet.getString("MANAGER_ID");
			int rentFee = resultSet.getInt("RENT_FEE");
			String branchId = resultSet.getString("BRANCH_ID");
			String mdNm = resultSet.getString("MD_NM");
			
			list1.add(new RentalVO(rsd, red, ins, cnum, memId, managerId, rentFee, branchId, mdNm));
		}
		
		
		resultSet.close();
		statement.close();
		connection.close();
		return list1;
	}
	
	public int cencleRental(RentalVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
				
		StringBuilder builder = new StringBuilder();
		builder.append("DELETE ");
		builder.append("    RENTAL ");
		builder.append("WHERE ");
		builder.append("    MEM_ID = ? ");
		builder.append("AND ");
		builder.append("    CAR_NUM = ? ");
				
		
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getMemId());
		statement.setString(2, vo.getCarNum());
		int executeUpdate = statement.executeUpdate();
						
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	

	public int returnCar(RentalVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
				
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE ");
		builder.append("    RENTAL ");
		builder.append("SET ");
		builder.append("    RENT_STATUS = 3, ");
		builder.append("    RENT_PAY_STATUS = 2 ");
		builder.append("WHERE ");
		builder.append("    MEM_ID = '?' ");
		builder.append("AND ");
		builder.append("    CAR_NUM = '?' ");
				
		
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getMemId());
		statement.setString(2, vo.getCarNum());
		int executeUpdate = statement.executeUpdate();
		System.out.println("확인");
		statement.close();
		connection.close();
		
		return executeUpdate;
	}
	
	public RentalVO selectRentalApplication(String selectId) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		Statement statement = connection.createStatement();
		
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("    R.RENT_START_DT, ");
		builder.append("    R.RENT_END_DT, ");
		builder.append("    R.RENT_INSURANCE, ");
		builder.append("    R.MEM_ID, ");
		builder.append("    M.MD_NM, ");
		builder.append("    M.MD_RENT_FEE, ");
		builder.append("    R.BRANCH_ID ");
		builder.append("FROM ");
		builder.append("    RENTAL R,MODEL M ");
		builder.append("WHERE ");
		builder.append("    R.MEM_ID = '" + selectId + "' ");
		builder.append("  AND ");
		builder.append("    R.RENT_STATUS=1 ");
		builder.append("  AND ");
		builder.append("    R.MD_ID=M.MD_ID ");
		
		
		String sql = builder.toString();

		ResultSet resultSet = statement.executeQuery(sql);
		RentalVO vo5 = null;
		
		if (resultSet.next()) {
			String memId = resultSet.getString("MEM_ID");
			String rentStartDt = resultSet.getString("RENT_START_DT");
			String rentEndDt = resultSet.getString("RENT_END_DT");
			int rentInsurance = resultSet.getInt("RENT_INSURANCE");
			String mdNm = resultSet.getString("MD_NM");
			int rentFee = resultSet.getInt("MD_RENT_FEE");
			String branchId = resultSet.getString("BRANCH_ID");
			
			vo5 = new RentalVO(memId, rentStartDt, rentEndDt, rentInsurance,  mdNm, rentFee, branchId);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo5;
	}
	
	public int approvalRent(RentalVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
				
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE  ");
		builder.append("       RENTAL ");
		builder.append("        SET   ");
		builder.append("            CAR_NUM = ?, ");
		builder.append("            RENT_TOTAL_KM = (SELECT CAR_TOTAL_KM ");
		builder.append("		                       FROM CAR ");
		builder.append("		                      WHERE CAR_NUM = ?), ");
		builder.append("            MANAGER_ID = ?, ");
		builder.append("            RENT_STATUS = 2, ");
		builder.append("            RENT_PAY_STATUS = 1, ");
		builder.append("            UPDATE_DT = SYSDATE ");
		builder.append("      WHERE MEM_ID=? ");
				
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getCarNum());
		statement.setString(2, vo.getCarNum());
		statement.setString(3, vo.getManagerId());
		statement.setString(4, vo.getMemId());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	public int confirmCar(RentalVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
				
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE ");
		builder.append("    RENTAL ");
		builder.append("SET ");
		builder.append("    RENT_STATUS = ?, ");
		builder.append("    RENT_TOTAL_KM = ?, ");
		builder.append("    UPDATE_DT = SYSDATE ");
		builder.append("WHERE ");
		builder.append("    MEM_ID = ? ");
		builder.append("AND ");
		builder.append("    CAR_NUM = ? ");
		builder.append("AND ");
		builder.append("    RENT_STATUS = 2 ");
		
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, vo.getCarStatus());
		statement.setInt(2, vo.getCarTotalKm());
		statement.setString(3, vo.getMemId());
		statement.setString(4, vo.getCarNum());
		int executeUpdate = statement.executeUpdate();
				
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	public int updateCar(RentalVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
				
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE ");
		builder.append("    CAR ");
		builder.append("SET ");
		builder.append("    UPDATE_DT = SYSDATE, ");
		builder.append("    CAR_STATUS = ?, ");
		builder.append("    CAR_TOTAL_KM = ? ");
		builder.append("WHERE ");
		builder.append("    CAR_NUM = ? ");
		
				
		
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, vo.getCarStatus());
		statement.setInt(2, vo.getCarTotalKm());
		statement.setString(3, vo.getCarNum());
		int executeUpdate = statement.executeUpdate();
				
		statement.close();
		connection.close();
		return executeUpdate;
	}


	
}
