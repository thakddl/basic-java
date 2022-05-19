package rentcar.repairshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class RepairShopDAO {
	private static RepairShopDAO instance = new RepairShopDAO();

	public static RepairShopDAO getInstance() {
		return instance;
	}

	// 1. 정비소 목록
	public List<RepairShopVO> repairshopList() throws Exception {
		List<RepairShopVO> list = new ArrayList<RepairShopVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement
				.executeQuery("SELECT BS_RGT_NUM, RS_NM, RS_PH, RS_ADRS FROM REPAIR_SHOP WHERE DELETE_KEY IS NULL");
		while (resultSet.next()) {
			String bsRgtNum = resultSet.getString("BS_RGT_NUM");
			String rsNm = resultSet.getString("RS_NM");
			String rsPh = resultSet.getString("RS_PH");
			String rsAdrs = resultSet.getString("RS_ADRS");
			list.add(new RepairShopVO(bsRgtNum, rsNm, rsPh, rsAdrs));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	// 2.정비소 상세
	public RepairShopVO getRepairShop(String searchRgtNum) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		Statement statement = connection.createStatement();

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("    BS_RGT_NUM, ");
		builder.append("    RS_NM, ");
		builder.append("    RS_PH, ");
		builder.append("    RS_ADRS, ");
		builder.append("    UPDATE_DT, ");
		builder.append("    DELETE_KEY, ");
		builder.append("    DELETE_DT ");
		builder.append("FROM ");
		builder.append("   REPAIR_SHOP ");
		builder.append("WHERE ");
		builder.append("    BS_RGT_NUM = '" + searchRgtNum + "' ");

		String sql = builder.toString();

		ResultSet resultSet = statement.executeQuery(sql);
		RepairShopVO vo = null;

		if (resultSet.next()) {
			String bsRgtNum = resultSet.getString("BS_RGT_NUM");
			String rsNm = resultSet.getString("RS_NM");
			String rsPh = resultSet.getString("RS_PH");
			String rsAdrs = resultSet.getString("RS_ADRS");
			String updateDt = resultSet.getString("UPDATE_DT");
			String deleteKey = resultSet.getString("DELETE_KEY");
			String deleteDt = resultSet.getString("DELETE_DT");
			vo = new RepairShopVO(bsRgtNum, rsNm, rsPh, rsAdrs, updateDt, deleteKey, deleteDt);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}

	// 3.새 정비소 등록

	public int insertRepairShop(RepairShopVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();

		builder.append(" 	INSERT ");
		builder.append(" 	INTO ");
		builder.append(" 	REPAIR_SHOP ");
		builder.append(" 	(BS_RGT_NUM, ");
		builder.append(" 	RS_NM, ");
		builder.append(" 	RS_PH, ");
		builder.append(" 	RS_ADRS, ");
		builder.append(" 	DELETE_KEY, ");
		builder.append(" 	DELETE_DT, ");
		builder.append(" 	UPDATE_DT) ");
		builder.append(" 	VALUES ( ");
		builder.append(" 	?, ");
		builder.append(" 	?, ");
		builder.append(" 	?, ");
		builder.append(" 	?, ");
		builder.append(" 	NULL, ");
		builder.append(" 	NULL, ");
		builder.append(" 	SYSDATE) ");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getBsRgtNum());
		statement.setString(2, vo.getRsNm());
		statement.setString(3, vo.getRsPh());
		statement.setString(4, vo.getRsAdrs());
		// executeUpdate = insert delete update
		// executeQuery = select
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();

		return executeUpdate;
	}

	// 4.정비소 정보 수정
	public int updateRepairShop(RepairShopVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE ");
		builder.append("      REPAIR_SHOP");
		builder.append("      SET");
		builder.append("            RS_NM = ?,");
		builder.append("            RS_PH = ?,");
		builder.append("            RS_ADRS = ?,");
		builder.append("            UPDATE_DT = SYSDATE ");
		builder.append(" WHERE ");
		builder.append("            BS_RGT_NUM = ?");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getRsNm());
		statement.setString(2, vo.getRsPh());
		statement.setString(3, vo.getRsAdrs());
		statement.setString(4, vo.getBsRgtNum());
		// executeUpdate = insert delete update
		// executeQuery = select
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();

		return executeUpdate;
	}

	// 5-1. 정비소 삭제키 상태 변경
	public int deleteRepairShop(RepairShopVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE ");
		builder.append("      REPAIR_SHOP");
		builder.append("      SET");
		builder.append("            DELETE_KEY = 1, ");
		builder.append("            DELETE_DT = SYSDATE ");
		builder.append(" WHERE ");
		builder.append("            BS_RGT_NUM = ?");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getBsRgtNum());
		// executeUpdate = insert delete update
		// executeQuery = select
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();

		return executeUpdate;
	}

	// 5-2. 삭제된 정비소 보기
	public List<RepairShopVO> repairshopDelList() throws Exception {
		List<RepairShopVO> DelList = new ArrayList<RepairShopVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		Statement statement = connection.createStatement();

		ResultSet delResultSet = statement
				.executeQuery("SELECT BS_RGT_NUM, RS_NM, RS_PH, RS_ADRS FROM REPAIR_SHOP WHERE DELETE_KEY IS NOT NULL");
		while (delResultSet.next()) {
			String bsRgtNum = delResultSet.getString("BS_RGT_NUM");
			String rsNm = delResultSet.getString("RS_NM");
			String rsPh = delResultSet.getString("RS_PH");
			String rsAdrs = delResultSet.getString("RS_ADRS");
			DelList.add(new RepairShopVO(bsRgtNum, rsNm, rsPh, rsAdrs));
		}
		delResultSet.close();
		statement.close();
		connection.close();
		return DelList;
	}

	// 5-3. 정비소 복원
	public int ReDeleteRepairShop(RepairShopVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE ");
		builder.append("      REPAIR_SHOP");
		builder.append("      SET");
		builder.append("            DELETE_KEY = NULL, ");
		builder.append("            DELETE_DT = NULL, ");
		builder.append("            UPDATE_DT = SYSDATE ");
		builder.append(" WHERE ");
		builder.append("            BS_RGT_NUM = ?");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getBsRgtNum());
		// executeUpdate = insert delete update
		// executeQuery = select
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();

		return executeUpdate;
	}

	// 5-4. 정비소 완전삭제
	public int ComDeleteRepairShop(RepairShopVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("DELETE FROM ");
		builder.append("      REPAIR_SHOP");
		builder.append(" WHERE ");
		builder.append("            BS_RGT_NUM = ?");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getBsRgtNum());
		// executeUpdate = insert delete update
		// executeQuery = select
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();

		return executeUpdate;
	}

	public int deleteMember(String id) {
		return 0;
	}
}