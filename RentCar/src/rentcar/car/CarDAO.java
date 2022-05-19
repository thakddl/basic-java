package rentcar.car;

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

public class CarDAO {
	private static CarDAO instance = new CarDAO();
	public static CarDAO getInstance() {
		return instance;
	}

	MemberVO session = RentCarApplication.getSession();
	
	public List<CarVO> getList() throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		String sBranchId = session.getBranchId();
		
		builder.append("SELECT C.CAR_NUM, ");
		builder.append(" 	   M.MD_NM, ");
		builder.append("  	   C.CAR_TOTAL_KM, ");
		builder.append(" 	   C.CAR_STATUS,");
		builder.append(" 	   B.BRANCH_NM, ");
		builder.append("	   C.UPDATE_DT ");
		builder.append("  FROM CAR C, MODEL M, BRANCH B");
		builder.append(" WHERE C.CAR_STATUS != 9999");
		builder.append("   AND C.BRANCH_ID='"+ sBranchId +"' ");	
		builder.append("   AND C.DELETE_KEY = 0");
		builder.append("   AND C.MD_ID = M.MD_ID");
		builder.append("   AND C.BRANCH_ID = B.BRANCH_ID");
		
		String sql = builder.toString();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		List<CarVO> list = new ArrayList<CarVO>();
		while(resultSet.next()) {
			CarVO vo = new CarVO();
			vo.setCarNum(resultSet.getString("CAR_NUM"));
			vo.setCarTotalKm(resultSet.getInt("CAR_TOTAL_KM"));
			vo.setCarStatus(resultSet.getInt("CAR_STATUS"));
			vo.setBranchNm(resultSet.getString("BRANCH_NM"));
			vo.setMdNm(resultSet.getString("MD_NM"));
			vo.setUpdateDt(resultSet.getString("UPDATE_DT"));
			list.add(vo);
		}		
		statement.close();
		connection.close();
		resultSet.close();
		return list;
	}
	public CarVO getCar(String searchNum) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT C.CAR_NUM, ");
		builder.append(" 	   M.MD_NM, ");
		builder.append("  	   C.CAR_TOTAL_KM, ");
		builder.append(" 	   C.CAR_STATUS,");
		builder.append(" 	   B.BRANCH_NM, ");
		builder.append("	   C.UPDATE_DT ");
		builder.append("  FROM CAR C, MODEL M, BRANCH B");
		builder.append(" WHERE C.CAR_STATUS != 9999");
		builder.append("   AND C.CAR_NUM = '"+searchNum+"'");
		builder.append("   AND C.DELETE_KEY = 0");
		builder.append("   AND C.MD_ID = M.MD_ID");
		builder.append("   AND C.BRANCH_ID = B.BRANCH_ID");
		String sql = builder.toString();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		CarVO vo = new CarVO();
		if(resultSet.next()) {
			vo.setCarNum(resultSet.getString("CAR_NUM"));
			vo.setCarTotalKm(resultSet.getInt("CAR_TOTAL_KM"));
			vo.setCarStatus(resultSet.getInt("CAR_STATUS"));
			vo.setBranchNm(resultSet.getString("BRANCH_NM"));
			vo.setMdNm(resultSet.getString("MD_NM"));
			vo.setUpdateDt(resultSet.getString("UPDATE_DT"));
		}
		statement.close();
		connection.close();
		resultSet.close();
		return vo;
	}
	public int insertCar(CarVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO");
		builder.append("	   CAR ");
		builder.append("VALUES");
		builder.append("      (?,");
		builder.append("       0,");
		builder.append("       0,");
		builder.append("       ?,");
		builder.append("       ?,");
		builder.append("       SYSDATE,");
		builder.append("       0,");
		builder.append("       SYSDATE)");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getCarNum());
		statement.setString(2, vo.getBranchId());
		statement.setString(3, vo.getMdId());
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
	}
	public int updateCar(CarVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE CAR ");
		builder.append("   SET CAR_TOTAL_KM = ?, ");
		builder.append("       UPDATE_DT = SYSDATE ");
		builder.append(" WHERE CAR_NUM = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, vo.getCarTotalKm());
		statement.setString(2, vo.getCarNum());
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
	}
	
	public int updateCarStatus(CarVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE CAR ");
		builder.append("   SET CAR_STATUS = ?, ");
		builder.append("       UPDATE_DT = SYSDATE ");
		builder.append(" WHERE CAR_NUM = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, vo.getCarStatus());
		statement.setString(2, vo.getCarNum());
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
	}
	
	public int deleteCar(String deleteId) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE CAR ");
		builder.append("   SET DELETE_KEY = 1, ");
		builder.append("       DELETE_DT = SYSDATE ");
		builder.append(" WHERE CAR_NUM = '"+ deleteId + "'");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
	}

}
