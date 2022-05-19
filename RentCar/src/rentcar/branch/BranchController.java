package rentcar.branch;

import java.util.List;

import rentcar.common.HomeMenu;



public class BranchController {
	private static BranchController instance = new BranchController();
	
	public static BranchController getInstance() {
		return instance;
	}
	
	private BranchController() {
	}
	
	private BranchService service = BranchService.getInstance();
	
	public BranchController(BranchService service) {
		this.service = service;
	}
	public BranchVO findBranch(String branchNm) {
		return service.findBranch(branchNm);
	}
	public BranchVO branchFromAll(String branchNm) {
		return service.branchFromAll(branchNm);
	}
	public int insertBranch(BranchVO vo) {
		return service.insertBranch(vo);
	}
	public int modifyBranchInfo(String branchId, String modifyData, HomeMenu menu) {
		BranchVO vo = new BranchVO();
		vo.setBranchId(branchId);
		switch(menu) {
		case MODIFY_BRANCHNM:
			vo.setBranchNm(modifyData);
			break;
		case MODIFY_BRANCHADRS:
			vo.setBranchAdrs(modifyData);
			break;
		case MODIFY_BRANCHPH:
			vo.setBranchPh(modifyData);
			break;
		}
		return service.modifyBranchInfo(vo, menu);
	}
	public int withdrawlBranch(String BranchId) {
		BranchVO vo = new BranchVO();
		vo.setBranchId(BranchId);
		vo.setDeleteKey(2);
		return service.withdrawlBranch(vo);
	}

	public List<BranchVO> getBranchList() throws Exception {
		List<BranchVO> list = service.getBranchList();
		return list;
	}
}
