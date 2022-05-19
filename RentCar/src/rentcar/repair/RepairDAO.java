package rentcar.repair;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.driver.OracleDriver;

	public class RepairDAO {
		private static RepairDAO instance = new RepairDAO();
		public static RepairDAO getInstance() {
			return instance;
		}
	
	// 1.정비필요차량 조회

	public List<RepairVO> repairNeedList() throws Exception {
		List<RepairVO> repairNeedList = new ArrayList<RepairVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		Statement statement = connection.createStatement();

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT CAR_NUM, ");
		builder.append("  BRANCH_ID, ");
		builder.append("  MD_ID ");
		builder.append("       FROM CAR ");
		builder.append("      WHERE CAR_STATUS = 3 ");

		String sql = builder.toString();

		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			String carNum = resultSet.getString("CAR_NUM");
			String branchId = resultSet.getString("BRANCH_ID");
			String mdId = resultSet.getString("MD_ID");
			repairNeedList.add(new RepairVO(carNum, branchId, mdId, null, null, null, null, null));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return repairNeedList;
	}

	// 2. 정비중 차량 조회
	public List<RepairVO> repairingList() throws Exception {
		List<RepairVO> repairingList = new ArrayList<RepairVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement
				.executeQuery("SELECT REPAIR_NUM, CAR_NUM, BS_RGT_NUM, OUTPUT_DT FROM REPAIR WHERE INPUT_DT IS NULL");
		while (resultSet.next()) {
			String repairNum = resultSet.getString("REPAIR_NUM");
			String outputDt = resultSet.getString("OUTPUT_DT");
			String bsRgtNum = resultSet.getString("BS_RGT_NUM");
			String carNum = resultSet.getString("CAR_NUM");
			repairingList.add(new RepairVO(repairNum, outputDt, bsRgtNum, carNum));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return repairingList;
	}

	// 3. 정비내역 조회
	public List<RepairVO> repairList() throws Exception {
		List<RepairVO> repairList = new ArrayList<RepairVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement
				.executeQuery("SELECT REPAIR_NUM, CAR_NUM, BS_RGT_NUM, REPAIR_CAUSE, OUTPUT_DT, INPUT_DT FROM REPAIR");
		while (resultSet.next()) {
			String repairNum = resultSet.getString("REPAIR_NUM");
			String outputDt = resultSet.getString("OUTPUT_DT");
			String inputDt = resultSet.getString("INPUT_DT");
			String bsRgtNum = resultSet.getString("BS_RGT_NUM");
			String carNum = resultSet.getString("CAR_NUM");
			String repairCause = resultSet.getString("REPAIR_CAUSE");
			repairList.add(new RepairVO(repairNum, outputDt, inputDt, bsRgtNum, carNum, repairCause));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return repairList;
	}

	// 4.정비차량 상세조회
	public RepairVO getRepair(String searchRepairNum) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		Statement statement = connection.createStatement();

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("    REPAIR_NUM, ");
		builder.append("    OUTPUT_DT, ");
		builder.append("    INPUT_DT, ");
		builder.append("    REPAIR_CAUSE, ");
		builder.append("    BS_RGT_NUM, ");
		builder.append("    CAR_NUM, ");
		builder.append("    BRANCH_ID, ");
		builder.append("    UPDATE_DT, ");
		builder.append("    RCOST, ");
		builder.append("    RCOST_STATUS, ");
		builder.append("    RCOST_PAID_DT, ");
		builder.append("    MANAGER_ID ");
		builder.append("FROM ");
		builder.append("   REPAIR ");
		builder.append("WHERE ");
		builder.append("    REPAIR_NUM = '" + searchRepairNum + "' ");

		String sql = builder.toString();

		ResultSet resultSet = statement.executeQuery(sql);
		RepairVO vo = null;

		if (resultSet.next()) {
			String repairNum = resultSet.getString("REPAIR_NUM");
			String outputDt = resultSet.getString("OUTPUT_DT");
			String inputDt = resultSet.getString("INPUT_DT");
			String repairCause = resultSet.getString("REPAIR_CAUSE");
			String bsRgtNum = resultSet.getString("BS_RGT_NUM");
			String carNum = resultSet.getString("CAR_NUM");
			String branchId = resultSet.getString("BRANCH_ID");
			String updateDt = resultSet.getString("UPDATE_DT");
			String rcost = resultSet.getString("RCOST");
			String rcostStatus = resultSet.getString("RCOST_STATUS");
			String rcostPaidDt = resultSet.getString("RCOST_PAID_DT");
			String managerId = resultSet.getString("MANAGER_ID");

			vo = new RepairVO(repairNum, outputDt, inputDt, repairCause, bsRgtNum, carNum, branchId, updateDt, rcost,
					rcostStatus, rcostPaidDt, managerId);

		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}

	// 이용 가능 정비소 찾기
	public List<RepairVO> selectShopList(String carNum) throws Exception {
		List<RepairVO> ShopList = new ArrayList<RepairVO>();
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		Statement statement = connection.createStatement();

		StringBuilder builder = new StringBuilder();

		builder.append(" SELECT A.BS_RGT_NUM, ");
		builder.append(" A.RS_NM,  A.RS_ADRS  ");
		builder.append(" FROM REPAIR_SHOP A, ALLIANCE B  ");
		builder.append(" WHERE B.BRANCH_ID = (SELECT BRANCH_ID FROM CAR WHERE CAR_NUM=" + "'" + carNum + "'" + ")");
		builder.append(" AND A.BS_RGT_NUM = B.BS_RGT_NUM ");

		String sql = builder.toString();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			String rsAdrs = resultSet.getString("BS_RGT_NUM");
			String bsRgtNum = resultSet.getString("RS_NM");
			String rsNm = resultSet.getString("RS_ADRS");
			ShopList.add(new RepairVO(rsAdrs, bsRgtNum, rsNm));
		}

		resultSet.close();
		statement.close();
		connection.close();
		return ShopList;
	}

	// 차량 출고(정비소 보내기)

	public int insertRepair(RepairVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");

		StringBuilder builder = new StringBuilder();

		builder.append(" 	INSERT ");
		builder.append(" 	INTO ");
		builder.append(" 	REPAIR ");
		builder.append(" 	(CAR_NUM, ");
		builder.append(" 	BRANCH_ID, ");
		builder.append(" 	BS_RGT_NUM, ");
		builder.append(" 	REPAIR_CAUSE, ");
		builder.append(" 	OUTPUT_DT, ");
		builder.append(" 	REPAIR_NUM, ");
		builder.append(" 	MANAGER_ID, ");
		builder.append(" 	RCOST_STATUS, ");
		builder.append(" 	UPDATE_DT) ");
		builder.append(" 	VALUES ( ");
		builder.append(" 	?, ");
		builder.append("(SELECT BRANCH_ID FROM CAR WHERE CAR_NUM = ?), ");
		builder.append(" 	?, ");
		builder.append(" 	?, ");
		builder.append(" 	to_date(?, 'YYYYMMDD'), ");
		builder.append(" 	(SELECT MAX(REPAIR_NUM) + 1 FROM REPAIR), ");
		builder.append(" 	'EMP_D001', ");
		builder.append(" 	2, ");
		builder.append(" 	SYSDATE) ");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getCarNum());
		statement.setString(2, vo.getCarNum());
		statement.setString(3, vo.getBsRgtNum());
		statement.setString(4, vo.getRepairCause());
		statement.setString(5, vo.getOutputDt());
		// executeUpdate = insert delete update
		// executeQuery = select
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();

		return executeUpdate;

	}

	// 차량 출고(정비소 보내고 업데이트)

	public int insertRepair2(RepairVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");

		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE ");
		builder.append("      CAR ");
		builder.append("      SET ");
		builder.append("             CAR_STATUS = 4,");
		builder.append("            UPDATE_DT = SYSDATE ");
		builder.append(" WHERE ");
		builder.append("            CAR_NUM = ?");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getCarNum());
		// executeUpdate = insert delete update
		// executeQuery = select
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();

		return executeUpdate;
	}

	// 차량 입고
	public int inputCar(RepairVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE ");
		builder.append("      REPAIR");
		builder.append("      SET");
		builder.append("            INPUT_DT = ?, ");
		builder.append("            RCOST = ?, ");
		builder.append("            RCOST_STATUS = 1, ");
		builder.append("            UPDATE_DT = SYSDATE, ");
		builder.append("            RCOST_PAID_DT = SYSDATE ");
		builder.append(" WHERE ");
		builder.append("            REPAIR_NUM = ?");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getInputDt());
		statement.setString(2, vo.getRcost());
		statement.setString(3, vo.getRepairNum());
		// executeUpdate = insert delete update
		// executeQuery = select
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();

		return executeUpdate;
	}

	// 차량 입고(차량상태 업데이트)

	public int inputCar2(RepairVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");

		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE CAR SET ");
		builder.append("      CAR_STATUS = 0, ");
		builder.append("      UPDATE_DT = SYSDATE ");
		builder.append("      WHERE CAR_NUM  = (SELECT A.CAR_NUM ");
		builder.append("  						 FROM CAR A, REPAIR B");
		builder.append(" 					    WHERE B.REPAIR_NUM = ? " );
		builder.append("  						  AND A.CAR_NUM = B.CAR_NUM) ");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getRepairNum());
		// executeUpdate = insert delete update
		// executeQuery = select
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();

		return executeUpdate;
	}

	// 삭제 DAO

	public RepairVO DeleteRepair(String repairNum) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		Statement statement = connection.createStatement();

		StringBuilder builder = new StringBuilder();
		builder.append("DELETE ");
		builder.append("    REPAIR ");
		builder.append("WHERE ");
		builder.append("    REPAIR_NUM = '" + repairNum + "' ");

		String sql = builder.toString();

		ResultSet resultSet = statement.executeQuery(sql);
		RepairVO vo3 = null;

		resultSet.close();
		statement.close();
		connection.close();
		return vo3;
	}

}