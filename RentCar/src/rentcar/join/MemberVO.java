package rentcar.join;

public class MemberVO {
	private String memId;
	private String memPw;
	private String memNm;
	private String memPh;
	private String memAdrs;
	private String licenseType;
	private String deleteDt;
	private String updateDt;
	private String branchId;
	private int deleteKey;
	private int memLv;

	public MemberVO() {
	}

	public MemberVO(String memId, String memPw) {
		this.memId = memId;
		this.memPw = memPw;
	}

	public MemberVO(String memId, String memPw, String memNm, String memPh, String memAdrs, String licenseType) {
		this.memId = memId;
		this.memPw = memPw;
		this.memNm = memNm;
		this.memPh = memPh;
		this.memAdrs = memAdrs;
		this.licenseType = licenseType;
	}

	public MemberVO(String memId, String memPw, String memNm, String memPh, String memAdrs, String licenseType,
			String deleteDt, String updateDt, int deleteKey, int memLv) {
		this.memId = memId;
		this.memPw = memPw;
		this.memNm = memNm;
		this.memPh = memPh;
		this.memAdrs = memAdrs;
		this.licenseType = licenseType;
		this.deleteDt = deleteDt;
		this.updateDt = updateDt;
		this.deleteKey = deleteKey;
		this.memLv = memLv;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemNm() {
		return memNm;
	}

	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}

	public String getMemPh() {
		return memPh;
	}

	public void setMemPh(String memPh) {
		this.memPh = memPh;
	}

	public String getMemAdrs() {
		return memAdrs;
	}

	public void setMemAdrs(String memAdrs) {
		this.memAdrs = memAdrs;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getDeleteDt() {
		return deleteDt;
	}

	public void setDeleteDt(String deleteDt) {
		this.deleteDt = deleteDt;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public int getDeleteKey() {
		return deleteKey;
	}

	public void setDeleteKey(int deleteKey) {
		this.deleteKey = deleteKey;
	}

	public int getMemLv() {
		return memLv;
	}

	public void setMemLv(int memLv) {
		this.memLv = memLv;
	}

	public void invalidate() {
		this.memId = null;
		this.memPw = null;
		this.memNm = null;
		this.memPh = null;
		this.memAdrs = null;
		this.licenseType = null;
		this.deleteDt = null;
		this.updateDt = null;
		this.deleteKey = 0;
		this.memLv = 0;
	}
	/*
	 * @Override public String toString() { final StringBuilder sb = new
	 * StringBuilder("CustomerVO{"); sb.append("custId=").append(custId);
	 * sb.append(", name='").append(name).append('\'');
	 * sb.append(", address='").append(address).append('\'');
	 * sb.append(", phone='").append(phone).append('\'');
	 * sb.append(", password='").append(password).append('\''); sb.append('}');
	 * return sb.toString();
	 */

}
