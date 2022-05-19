package rentcar.join;

import rentcar.common.HomeMenu;

public class JoinService {
	private static JoinService instance = new JoinService();

	public static JoinService getInstance() {
		return instance;
	}

	private JoinService() {
	}

	private JoinDAO dao = JoinDAO.getInstance();

	public MemberVO findMember(String memId) {
		return dao.findMember(memId);
	}
	public MemberVO admFindMember(String memId) {
		return dao.admFindMember(memId);
	}

	public int join(MemberVO vo) {
		return dao.join(vo);
	}

	public int modifyInfo(MemberVO vo, HomeMenu menu) {
		int result = 0;
		switch (menu) {
		case MODIFY_NAME:
			result = dao.modifyName(vo);
			break;
		case MODIFY_ADDRESS:
			result = dao.modifyAddress(vo);
			break;
		case MODIFY_PHONE:
			result = dao.modifyPhone(vo);
			break;
		}
		return result;
	}

	public int modifyPassword(MemberVO vo) {
		return dao.modifyPassword(vo);
	}
	public int withdrawl(MemberVO vo) {
		return dao.withdrawl(vo);
	}

	public int modifyMemLv(MemberVO vo) {
		return dao.modifyMemLv(vo);
	}

}
