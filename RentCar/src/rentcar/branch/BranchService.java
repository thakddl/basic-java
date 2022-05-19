package rentcar.branch;

import java.util.List;

import rentcar.common.HomeMenu;

public class BranchService {
	private static BranchService instance = new BranchService();

	public static BranchService getInstance() {
		return instance;
	}

	private BranchService() {
	}

	private BranchDAO dao = BranchDAO.getInstance();

	public BranchVO findBranch(String branchNm) {
		return dao.findBranch(branchNm);
	}
	public BranchVO branchFromAll(String branchNm) {
		return dao.branchFromAll(branchNm);
	}

	public int insertBranch(BranchVO vo) {
		return dao.insertBranch(vo);
	}

	public int modifyBranchInfo(BranchVO vo, HomeMenu menu) {
		int result = 0;
		switch (menu) {
		case MODIFY_BRANCHNM:
			result = dao.modifyBranchNm(vo);
			break;
		case MODIFY_BRANCHADRS:
			result = dao.modifyBranchAdrs(vo);
			break;
		case MODIFY_BRANCHPH:
			result = dao.modifyBranchPh(vo);
			break;
		}
		return result;
	}

	public int withdrawlBranch(BranchVO vo) {
		return dao.withdrawlBranch(vo);
	}

	public List<BranchVO> getBranchList() throws Exception {
		return dao.getList();
	}
}
