package rentcar.branch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import oracle.jdbc.driver.OracleDriver;
import rentcar.RentCarApplication;

public class BranchDAO {
	private static BranchDAO instance = new BranchDAO();
	public static BranchDAO getInstance() {
		return instance;
	}
	private BranchDAO() {}
	
	private JdbcTemplate template = RentCarApplication.getTemplate();
	
	public BranchVO findBranch(String branchNm) {
		return template.queryForObject("SELECT BRANCH_ID, BRANCH_NM, BRANCH_ADRS, BRANCH_PH FROM BRANCH WHERE BRANCH_NM = ?", new BeanPropertyRowMapper<>(BranchVO.class), branchNm);
	}
	public BranchVO branchFromAll(String branchNm) {
		return template.queryForObject("SELECT BRANCH_NM, BRANCH_ADRS, BRANCH_PH FROM BRANCH WHERE BRANCH_NM = ?", new BeanPropertyRowMapper<>(BranchVO.class), branchNm);
	}
    public int insertBranch(BranchVO vo) {
        return template.update("INSERT INTO BRANCH (BRANCH_ID, BRANCH_NM, BRANCH_ADRS, BRANCH_PH, UPDATE_DT) VALUES (SEQ_BRANCH_ID.NEXTVAL, ?, ?, ?, SYSDATE)", vo.getBranchNm(), vo.getBranchAdrs(), vo.getBranchPh());
    }
    public int modifyBranchNm(BranchVO vo) {
    	return template.update("UPDATE BRANCH SET BRANCH_NM = ?, UPDATE_DT = TO_DATE(SYSDATE) WHERE BRANCH_ID = ?", vo.getBranchNm(), vo.getBranchId());
    }
    public int modifyBranchAdrs(BranchVO vo) {
        return template.update("UPDATE BRANCH SET BRANCH_ADRS = ?, UPDATE_DT = TO_DATE(SYSDATE) WHERE BRANCH_NM = ?", vo.getBranchAdrs(), vo.getBranchNm());
    }
    public int modifyBranchPh(BranchVO vo) {
        return template.update("UPDATE BRANCH SET BRANCH_PH = ?, UPDATE_DT = TO_DATE(SYSDATE) WHERE BRANCH_NM = ?", vo.getBranchPh(), vo.getBranchNm());
    }
    public int withdrawlBranch(BranchVO vo) {
        return template.update("UPDATE BRANCH SET DELETE_KEY = ?, UPDATE_DT = TO_DATE(SYSDATE) WHERE BRANCH_NM = ?", vo.getDeleteKey(), vo.getBranchNm());
    }
	public List<BranchVO> getList() throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.44.15:1521:xe", "BASIC", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT BRANCH_ID, ");
		builder.append(" 	   BRANCH_NM, ");
		builder.append("  	   BRANCH_PH, ");
		builder.append(" 	   BRANCH_ADRS,");
		builder.append("	   UPDATE_DT, ");
		builder.append("	   DELETE_KEY ");
		builder.append("  FROM BRANCH ");
		builder.append(" WHERE DELETE_KEY = 0");
		String sql = builder.toString();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		List<BranchVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String branchId = resultSet.getString("BRANCH_ID");
			String branchNm = resultSet.getString("BRANCH_NM");
			String branchPh = resultSet.getString("BRANCH_PH");
			String branchAdrs = resultSet.getString("BRANCH_ADRS");
			String updateDt = resultSet.getString("UPDATE_DT");
			BranchVO vo = new BranchVO(branchId, branchNm, branchPh, branchAdrs, updateDt);
			list.add(vo);
		}
		
		statement.close();
		connection.close();
		resultSet.close();
		return list;
	}

}
