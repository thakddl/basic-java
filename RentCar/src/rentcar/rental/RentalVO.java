package rentcar.rental;

public class RentalVO {
   
	private String rentId;
	private	String rentStartDt;
	private	String rentEndDt;
	private	int rentStatus;
	private	int rentTotalKm;
	private	int rentInsurance;
	private	String carNum;
	private	String memId;
	private	String managerId;
	private	String updateDt;
	private	int rentFee;
	private	int lateFee;
	private	int damageFee;
	private	String branchId;
	private	int rentPayStatus;
	private	int rentPaidDt;
	private	int rentTotalFee;
	private	int deleteKey;
	private	int deleteDt;
	
	private	int carTotalKm;
	private	int carStatus;
	
	private	String mdId;
	private	String mdNm;
	private	int mdRentFee;
	private	String mdSize;
	private	String mdFuel;
	
	private	String branchAdrs;
	private	String branchPh;
	private	int days;
	

	public RentalVO() {
		
	}
	
	


	public RentalVO(String mdName, String mdSize2, int mdRfee, String mdFuel, String mdId) {
		this.mdNm = mdName;
		this.mdSize = mdSize2;
		this.mdRentFee = mdRfee;
		this.mdFuel = mdFuel;
		this.mdId = mdId;
	}
	
	public RentalVO(String rentStartDt, String rentEndDt, int rentInsurance, String carNum, String memId, String managerId,
			int rentFee, String branchId, String mdNm) {
		super();
		this.rentStartDt = rentStartDt;
		this.rentEndDt = rentEndDt;
		this.rentInsurance = rentInsurance;
		this.carNum = carNum;
		this.memId = memId;
		this.managerId = managerId;
		this.rentFee = rentFee;
		this.branchId = branchId;
		this.mdNm = mdNm;
	}
	
    


	public RentalVO(String memId, String rentStartDt, String rentEndDt, int rentInsurance,
			String mdNm, int rentFee, String branchId) {
		super();
		this.memId = memId;
		this.rentStartDt = rentStartDt;
		this.rentEndDt = rentEndDt;
		this.rentInsurance = rentInsurance;
		this.mdNm = mdNm;
		this.rentFee = rentFee;
		this.branchId = branchId;
	}




	public String getRentId() {
		return rentId;
	}


	public void setRentId(String rentId) {
		this.rentId = rentId;
	}


	


	public String getRentStartDt() {
		return rentStartDt;
	}




	public void setRentStartDt(String rentStartDt) {
		this.rentStartDt = rentStartDt;
	}




	public String getRentEndDt() {
		return rentEndDt;
	}


	public void setRentEndDt(String rentEndDt) {
		this.rentEndDt = rentEndDt;
	}


	public int getRentStatus() {
		return rentStatus;
	}


	public void setRentStatus(int rentStatus) {
		this.rentStatus = rentStatus;
	}


	public int getRentTotalKm() {
		return rentTotalKm;
	}


	public void setRentTotalKm(int rentTotalKm) {
		this.rentTotalKm = rentTotalKm;
	}


	public int getRentInsurance() {
		return rentInsurance;
	}


	public void setRentInsurance(int rentInsurance) {
		this.rentInsurance = rentInsurance;
	}


	public String getCarNum() {
		return carNum;
	}


	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public String getManagerId() {
		return managerId;
	}


	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}


	public String getUpdateDt() {
		return updateDt;
	}


	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}


	public int getRentFee() {
		return rentFee;
	}


	public void setRentFee(int rentFee) {
		this.rentFee = rentFee;
	}


	public int getLateFee() {
		return lateFee;
	}


	public void setLateFee(int lateFee) {
		this.lateFee = lateFee;
	}


	public int getDamageFee() {
		return damageFee;
	}


	public void setDamageFee(int damageFee) {
		this.damageFee = damageFee;
	}


	public String getBranchId() {
		return branchId;
	}


	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}


	public int getRentPayStatus() {
		return rentPayStatus;
	}


	public void setRentPayStatus(int rentPayStatus) {
		this.rentPayStatus = rentPayStatus;
	}


	public int getRentPaidDt() {
		return rentPaidDt;
	}


	public void setRentPaidDt(int rentPaidDt) {
		this.rentPaidDt = rentPaidDt;
	}


	public int getRentTotalFee() {
		return rentTotalFee;
	}


	public void setRentTotalFee(int rentTotalFee) {
		this.rentTotalFee = rentTotalFee;
	}


	public int getDeleteKey() {
		return deleteKey;
	}


	public void setDeleteKey(int deleteKey) {
		this.deleteKey = deleteKey;
	}


	public int getDeleteDt() {
		return deleteDt;
	}


	public void setDeleteDt(int deleteDt) {
		this.deleteDt = deleteDt;
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


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}


	@Override
	public String toString() {
		return "RentalVO [rentId=" + rentId + ", rentStartDt=" + rentStartDt + ", rentEndDt=" + rentEndDt
				+ ", rentStatus=" + rentStatus + ", rentTotalKm=" + rentTotalKm + ", rentInsurance=" + rentInsurance
				+ ", carNum=" + carNum + ", memId=" + memId + ", managerId=" + managerId + ", updateDt=" + updateDt
				+ ", rentFee=" + rentFee + ", lateFee=" + lateFee + ", damageFee=" + damageFee + ", branchId="
				+ branchId + ", rentPayStatus=" + rentPayStatus + ", rentPaidDt=" + rentPaidDt + ", rentTotalFee="
				+ rentTotalFee + ", deleteKey=" + deleteKey + ", deleteDt=" + deleteDt + ", carTotalKm=" + carTotalKm
				+ ", carStatus=" + carStatus + ", mdId=" + mdId + ", mdNm=" + mdNm + ", mdRentFee=" + mdRentFee
				+ ", mdSize=" + mdSize + ", mdFuel=" + mdFuel + ", branchAdrs=" + branchAdrs + ", branchPh=" + branchPh
				+ ", days=" + days + "]";
	}
	
	
	
	
	
}
