package rentcar.join;

import rentcar.RentCarApplication;
import rentcar.common.HomeMenu;

public class JoinController {
	private static JoinController instance = new JoinController();

	public static JoinController getInstance() {
		return instance;
	}

	private JoinController() {
	}

	private JoinService service = JoinService.getInstance();
	private MemberVO session = RentCarApplication.getSession();

	public JoinController(JoinService service) {
		this.service = service;
	}

	public MemberVO findMember() {
		return service.findMember(session.getMemId());
	}

	public MemberVO admFindMember(String MemId) {
		return service.admFindMember(MemId);
	}

	public int join(MemberVO vo) {
		try {
			if (service.join(vo) == 1) {
				return HomeMenu.HOME.getMenu();
			}
		} catch (Exception e) {
			System.out.println("알 수 없는 오류가 발생하였습니다.");
			return HomeMenu.JOIN.getMenu();
		}
		return HomeMenu.HOME.getMenu();
	}

	public int modifyInfo(String modifyData, HomeMenu menu) {
		MemberVO vo = new MemberVO();
		vo.setMemId(session.getMemId());
		switch (menu) {
			case MODIFY_NAME:
				vo.setMemNm(modifyData);
				break;
			case MODIFY_ADDRESS:
				vo.setMemAdrs(modifyData);
				break;
			case MODIFY_PHONE:
				vo.setMemPh(modifyData);
				break;
		}
		return service.modifyInfo(vo, menu);
	}

	public int modifyPassword(String password) {
		MemberVO vo = new MemberVO();
		vo.setMemId(session.getMemId());
		vo.setMemPw(password);
		return service.modifyPassword(vo);
	}
	public int withdrawl() {
		MemberVO vo = new MemberVO();
		vo.setMemId(session.getMemId());
		vo.setDeleteKey(2);
		return service.withdrawl(vo);
	}
	

	public int modifyMemLv(String oldMemId, int memberLevel) {
		MemberVO vo = new MemberVO();
		vo.setMemId(oldMemId);
		vo.setMemLv(memberLevel);
		return service.modifyMemLv(vo);
	}

}
