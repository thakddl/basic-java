package rentcar.sign;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import rentcar.RentCarApplication;
import rentcar.join.MemberVO;

public class SignDAO {
	private static SignDAO instance = new SignDAO();
	public static SignDAO getInstance() {
		return instance;
	}
	private SignDAO() {
	}
	private JdbcTemplate template = RentCarApplication.getTemplate();
	
	public MemberVO findUser(MemberVO vo) {
        try {
            return template.queryForObject("SELECT MEM_ID, MEM_PW, MEM_NM, MEM_ADRS, MEM_PH, MEM_LV FROM MEMBER WHERE MEM_ID = ? AND MEM_PW = ? AND DELETE_KEY != 2", new BeanPropertyRowMapper<>(MemberVO.class), vo.getMemId(), vo.getMemPw());
        } catch (DataAccessException e) {
            return null;	
		}
	}
	public MemberVO getEmpBranchId(String memId) {
        try {
            return template.queryForObject("SELECT BRANCH_ID FROM EMPLOYEES WHERE MEM_ID = ?", new BeanPropertyRowMapper<>(MemberVO.class), memId);
        } catch (DataAccessException e) {
            return null;	
		}
	}
	
}
