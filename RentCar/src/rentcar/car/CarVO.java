package rentcar.car;

public class CarVO {
	private String carNum;
	private int carTotalKm;
	private int carStatus;
	private String branchId;
	private String branchNm;
	private String mdId;
	private String mdNm;
	private String updateDt;
	
	public CarVO() {}

	public String getBranchNm() {
		return branchNm;
	}
	public void setBranchNm(String branchNm) {
		this.branchNm = branchNm;
	}
	public String getMdNm() {
		return mdNm;
	}
	public void setMdNm(String mdNm) {
		this.mdNm = mdNm;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public int getCarTotalKm() {
		return carTotalKm;
	}
	public void setCarTotalKm(int carTotalKm) {
		this.carTotalKm = carTotalKm;
	}
	public int getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(int carStatus) {
		this.carStatus = carStatus;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getMdId() {
		return mdId;
	}
	public void setMdId(String mdId) {
		this.mdId = mdId;
	}
	public String getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

}
