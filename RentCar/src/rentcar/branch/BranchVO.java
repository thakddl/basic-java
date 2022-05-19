package rentcar.branch;

public class BranchVO {
	private String branchId;
	private String branchNm;
	private String branchAdrs;
	private String branchPh;
	private String updateDt;
	private String deleteDt;
	private int deleteKey;

	public BranchVO() {
	}
	public BranchVO(String branchId, String branchNm, String branchPh, String branchAdrs, String updateDt) {
		this.branchId = branchId;
		this.branchNm = branchNm;
		this.branchPh = branchPh;
		this.branchAdrs = branchAdrs;
		this.updateDt = updateDt;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchNm() {
		return branchNm;
	}

	public void setBranchNm(String branchNm) {
		this.branchNm = branchNm;
	}

	public String getBranchAdrs() {
		return branchAdrs;
	}

	public void setBranchAdrs(String branchAdrs) {
		this.branchAdrs = branchAdrs;
	}

	public String getBranchPh() {
		return branchPh;
	}

	public void setBranchPh(String branchPh) {
		this.branchPh = branchPh;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public String getDeleteDt() {
		return deleteDt;
	}

	public void setDeleteDt(String deleteDt) {
		this.deleteDt = deleteDt;
	}

	public int getDeleteKey() {
		return deleteKey;
	}

	public void setDeleteKey(int deleteKey) {
		this.deleteKey = deleteKey;
	}

	public void invalidate() {
		this.branchId = null;
		this.branchNm = null;
		this.branchAdrs = null;
		this.branchPh = null;
		this.updateDt = null;
		this.deleteDt = null;
		this.deleteKey = 0;
	}
}
