package rentcar.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class ModelDAO {
	private static ModelDAO instance = new ModelDAO();
	public static ModelDAO getInstance() {
		return instance;
	}
	
	public List<ModelVO> getList() throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT MD_ID, ");
		builder.append(" 	   MD_NM, ");
		builder.append("  	   MD_RENT_FEE, ");
		builder.append(" 	   MD_SIZE,");
		builder.append(" 	   MD_FUEL, ");
		builder.append("	   UPDATE_DT, ");
		builder.append("	   DELETE_KEY ");
		builder.append("  FROM MODEL ");
		builder.append(" WHERE DELETE_KEY = 0");
		String sql = builder.toString();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		List<ModelVO> list = new ArrayList<ModelVO>();
		while(resultSet.next()) {
			String mdId = resultSet.getString("MD_ID");
			String mdNm = resultSet.getString("MD_NM");
			int mdRentFee = resultSet.getInt("MD_RENT_FEE");
			String mdSize = resultSet.getString("MD_SIZE");
			String mdFuel = resultSet.getString("MD_FUEL");
			String updateDt = resultSet.getString("UPDATE_DT");
			ModelVO vo = new ModelVO(mdId, mdNm, mdRentFee, mdSize, mdFuel, updateDt);
			list.add(vo);
		}
		
		statement.close();
		connection.close();
		resultSet.close();
		return list;
	}
	public ModelVO getModel(String searchNum) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT MD_ID, ");
		builder.append(" 	   MD_NM, ");
		builder.append("  	   MD_RENT_FEE, ");
		builder.append(" 	   MD_SIZE,");
		builder.append(" 	   MD_FUEL, ");
		builder.append("	   UPDATE_DT ");
		builder.append("  FROM MODEL ");
		builder.append(" WHERE MD_ID = '"+ searchNum +"'");
		builder.append("   AND DELETE_KEY = 0");
		String sql = builder.toString();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		ModelVO model = null;
		if(resultSet.next()) {
			String mdId = resultSet.getString("MD_ID");
			String mdNm = resultSet.getString("MD_NM");
			int mdRentFee = resultSet.getInt("MD_RENT_FEE");
			String mdSize = resultSet.getString("MD_SIZE");
			String mdFuel = resultSet.getString("MD_FUEL");
			String updateDt = resultSet.getString("UPDATE_DT");
			model = new ModelVO(mdId, mdNm, mdRentFee, mdSize, mdFuel, updateDt);
		}
		statement.close();
		connection.close();
		resultSet.close();
		return model;
	}
	public int insertModel(ModelVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO");
		builder.append("	   MODEL (MD_ID, MD_NM, MD_RENT_FEE, MD_SIZE, MD_FUEL, UPDATE_DT) ");
		builder.append("VALUES");
		builder.append("      (SEQ_MDID.NEXTVAL,");
		builder.append("       ?,");
		builder.append("       ?,");
		builder.append("       ?,");
		builder.append("       ?,");
		builder.append("       SYSDATE)");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getMdNm());
		statement.setInt(2, vo.getMdRentFee());
		statement.setString(3, vo.getMdSize());
		statement.setString(4, vo.getMdFuel());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
	}
	public int updateModel(ModelVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE MODEL ");
		builder.append("   SET MD_RENT_FEE = ?, ");
		builder.append("       MD_SIZE = ?, ");
		builder.append("       MD_FUEL = ?, ");
		builder.append("       UPDATE_DT = SYSDATE ");
		builder.append(" WHERE MD_ID = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, vo.getMdRentFee());
		statement.setString(2, vo.getMdSize());
		statement.setString(3, vo.getMdFuel());
		statement.setString(4, vo.getMdId());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
		
	}
	public int deleteModel(String deleteId) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE MODEL ");
		builder.append("   SET DELETE_KEY = 1, ");
		builder.append("       DELETE_DT = SYSDATE ");
		builder.append(" WHERE MD_ID = '"+ deleteId + "'");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
		
	}

}
