package rentcar.model;

public class ModelVO {
	private String mdId;
	private String mdNm;
	private int mdRentFee;
	private String mdSize;
	private String mdFuel;
	private String updateDt;
	private String deleteDt;
	private int deleteKey;
	
	
	public ModelVO() {}
	public ModelVO(String mdId, String mdNm, int mdRentFee, String mdSize, String mdFuel) {
		super();
		this.mdId = mdId;
		this.mdNm = mdNm;
		this.mdRentFee = mdRentFee;
		this.mdSize = mdSize;
		this.mdFuel = mdFuel;
	}
	public ModelVO(String mdId, String mdNm, int mdRentFee, String mdSize, String mdFuel, String updateDt) {
		super();
		this.mdId = mdId;
		this.mdNm = mdNm;
		this.mdRentFee = mdRentFee;
		this.mdSize = mdSize;
		this.mdFuel = mdFuel;
		this.updateDt = updateDt;
	}
	public String getMdId() {
		return mdId;
	}
	public void setMdId(String mdId) {
		this.mdId = mdId;
	}
	public String getMdNm() {
		return mdNm;
	}
	public void setMdNm(String mdNm) {
		this.mdNm = mdNm;
	}
	public int getMdRentFee() {
		return mdRentFee;
	}
	public void setMdRentFee(int mdRentFee) {
		this.mdRentFee = mdRentFee;
	}
	public String getMdSize() {
		return mdSize;
	}
	public void setMdSize(String mdSize) {
		this.mdSize = mdSize;
	}
	public String getMdFuel() {
		return mdFuel;
	}
	public void setMdFuel(String mdFuel) {
		this.mdFuel = mdFuel;
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
	
}
