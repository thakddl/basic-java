package rentcar.join;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import rentcar.RentCarApplication;

public class JoinDAO {
    private static JoinDAO instance = new JoinDAO();
    public static JoinDAO getInstance() {
        return instance;
    }
    private JoinDAO() {}

    private JdbcTemplate template = RentCarApplication.getTemplate();

    public MemberVO findMember(String memId) {
        return template.queryForObject("SELECT MEM_ID, MEM_NM, MEM_ADRS, MEM_PH FROM MEMBER WHERE MEM_ID = ?", new BeanPropertyRowMapper<>(MemberVO.class), memId);
    }
    public MemberVO admFindMember(String memId) {
    	return template.queryForObject("SELECT MEM_ID, MEM_NM, MEM_ADRS, MEM_PH, LICENSE_TYPE, MEM_LV FROM MEMBER WHERE MEM_ID = ?", new BeanPropertyRowMapper<>(MemberVO.class), memId);
    }

    public int join(MemberVO vo) {
        return template.update("INSERT INTO MEMBER (MEM_ID, MEM_NM, MEM_ADRS, MEM_PH, MEM_PW, LICENSE_TYPE, UPDATE_DT) VALUES (?, ?, ?, ?, ?, ?, TO_DATE(SYSDATE))", vo.getMemId(), vo.getMemNm(), vo.getMemAdrs(), vo.getMemPh(), vo.getMemPw(), vo.getLicenseType());
    }

    public int modifyName(MemberVO vo) {
        return template.update("UPDATE MEMBER SET MEM_NM = ?, UPDATE_DT = TO_DATE(SYSDATE) WHERE MEM_ID = ?", vo.getMemNm(), vo.getMemId());
    }

    public int modifyAddress(MemberVO vo) {
        return template.update("UPDATE MEMBER SET MEM_ADRS = ?, UPDATE_DT = TO_DATE(SYSDATE) WHERE MEM_ID = ?", vo.getMemAdrs(), vo.getMemId());
    }

    public int modifyPhone(MemberVO vo) {
        return template.update("UPDATE MEMBER SET MEM_PH = ?, UPDATE_DT = TO_DATE(SYSDATE) WHERE MEM_ID = ?", vo.getMemPh(), vo.getMemId());
    }

    public int modifyPassword(MemberVO vo) {
        return template.update("UPDATE MEMBER SET MEM_PW = ?, UPDATE_DT = TO_DATE(SYSDATE) WHERE MEM_ID = ?", vo.getMemPw(), vo.getMemId());
    }
    public int modifyLicenseType(MemberVO vo) {
    	return template.update("UPDATE MEMBER SET LICENSE_TYPE = ?, UPDATE_DT = TO_DATE(SYSDATE) WHERE MEM_ID = ?", vo.getLicenseType(), vo.getMemId());
    }
    public int modifyMemLv(MemberVO vo) {
    	return template.update("UPDATE MEMBER SET MEM_LV = ?, UPDATE_DT = TO_DATE(SYSDATE) WHERE MEM_ID = ?", vo.getMemLv(), vo.getMemId());
    }
    public int withdrawl(MemberVO vo) {
    	return template.update("UPDATE MEMBER SET DELETE_KEY = ?, UPDATE_DT = TO_DATE(SYSDATE), DELETE_DT = TO_DATE(SYSDATE) WHERE MEM_ID = ?", vo.getDeleteKey(), vo.getMemId());
    }
}