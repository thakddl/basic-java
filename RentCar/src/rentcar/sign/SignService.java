package rentcar.sign;
import rentcar.join.MemberVO;

public class SignService {
	private static SignService instance = new SignService();

	public static SignService getInstance() {
		return instance;
	}

	private SignService() {
	}

	private SignDAO dao = SignDAO.getInstance();

	public MemberVO findUser(MemberVO vo) {
		MemberVO vo2 = dao.findUser(vo);
		if(vo2.getMemLv() == 0 || vo2.getMemLv() == 2) {	
			String branchId = dao.getEmpBranchId(vo.getMemId()).getBranchId();
			vo2.setBranchId(branchId);
		}
		return vo2;
	}

}
