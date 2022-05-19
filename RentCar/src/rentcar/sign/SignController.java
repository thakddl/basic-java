package rentcar.sign;

import rentcar.RentCarApplication;
import rentcar.common.HomeMenu;
import rentcar.join.MemberVO;

public class SignController {
	private static SignController instance = new SignController();

	public static SignController getInstance() {
		return instance;
	}

	private SignController() {
	}

	private SignService service = SignService.getInstance();

	private MemberVO session = RentCarApplication.getSession();

	public MemberVO signIn(MemberVO vo) {
		MemberVO custom = service.findUser(vo);
		session.setBranchId(custom.getBranchId());
		session.setMemId(custom.getMemId());
		session.setMemNm(custom.getMemNm());
		session.setMemLv(custom.getMemLv());
		session.setDeleteKey(custom.getDeleteKey());
		return custom;
		
	}

	public int signOut() {
		// 세션 초기화 /로그아웃
		session.invalidate();
		return HomeMenu.HOME.getMenu();
	}
}