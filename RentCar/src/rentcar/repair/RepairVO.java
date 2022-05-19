package rentcar.repair;

public class RepairVO {

	private String repairNum;
	private String outputDt;
	private String inputDt;
	private String repairCause;
	private String bsRgtNum;
	private String carNum;
	private String branchId;
	private String updateDt;
	private String rcost;
	private String rcostStatus;
	private String rcostPaidDt;
	private String managerId;

	private String rsNm;
	private String rsAdrs;

	private String mdId;

	@Override
	public String toString() {
		return "RepairVO [REPAIR_NUM=" + repairNum + ", OUTPUT_DT=" + outputDt + ", INPUT_DT=" + inputDt
				+ ", REPAIR_CAUSE=" + repairCause + ", BS_RGT_NUM=" + bsRgtNum + ", CAR_NUM=" + carNum + ", BRANCH_ID="
				+ branchId + ", UPDATE_DT=" + updateDt + ", RCOST=" + rcost + ", RCOST_STATUS=" + rcostStatus
				+ ", RCOST_PAID_DT=" + rcostPaidDt + ", MANAGER_ID=" + managerId + "]";
	}

	public RepairVO(String repairNum) {
		super();
		this.bsRgtNum = repairNum;
	}

	public RepairVO(String repairNum, String outputDt, String inputDt, String repairCause, String bsRgtNum,
			String carNum, String branchId, String updateDt, String rcost, String rcostStatus, String rcostPaidDt,
			String managerId) {
		super();
		this.repairNum = repairNum;
		this.outputDt = outputDt;
		this.inputDt = inputDt;
		this.repairCause = repairCause;
		this.bsRgtNum = bsRgtNum;
		this.carNum = carNum;
		this.branchId = branchId;
		this.updateDt = updateDt;
		this.rcost = rcost;
		this.rcostStatus = rcostStatus;
		this.rcostPaidDt = rcostPaidDt;
		this.managerId = managerId;
	}

	public RepairVO(String carNum, String branchId, String mdId, String repairCause, String bsRgtNum, String updateDt,
			String rcost, String rcostStatus) {
		super();
		this.carNum = carNum;
		this.branchId = branchId;
		this.mdId = mdId;
		this.repairCause = repairCause;
		this.bsRgtNum = bsRgtNum;
		this.updateDt = updateDt;
		this.rcost = rcost;
		this.rcostStatus = rcostStatus;
	}

	public RepairVO(String repairNum, String inputDt, String rcost, String rcostStatus, String rcostPaidDt,
			String managerId, String branchId) {
		super();
		this.repairNum = repairNum;
		this.inputDt = inputDt;
		this.rcost = rcost;
		this.rcostStatus = rcostStatus;
		this.rcostPaidDt = rcostPaidDt;
		this.managerId = managerId;
		this.branchId = branchId;
		;
	}

	public RepairVO(String repairNum, String outputDt, String repairCause, String bsRgtNum, String carNum) {
		super();
		this.repairNum = repairNum;
		this.outputDt = outputDt;
		this.repairCause = repairCause;
		this.bsRgtNum = bsRgtNum;
		this.carNum = carNum;
	}

	public RepairVO(String repairNum, String outputDt, String bsRgtNum, String carNum) {
		super();
		this.repairNum = repairNum;
		this.outputDt = outputDt;
		this.bsRgtNum = bsRgtNum;
		this.carNum = carNum;
	}

	public RepairVO(String repairNum, String outputDt, String inputDt, String bsRgtNum, String carNum,
			String RepairCause) {
		super();
		this.repairNum = repairNum;
		this.outputDt = outputDt;
		this.inputDt = inputDt;
		this.bsRgtNum = bsRgtNum;
		this.repairCause = RepairCause;
		this.carNum = carNum;
	}

	public RepairVO(String bsRgtNum, String rsNm, String rsAdrs) {
		super();
		this.rsAdrs = rsAdrs;
		this.bsRgtNum = bsRgtNum;
		this.rsNm = rsNm;
	}

	public RepairVO(String carNum, String rsNm) {
		super();
		this.carNum = carNum;
		this.rsNm = rsNm;
	}

	public String getRepairNum() {
		return repairNum;
	}

	public void setRepairNum(String repairNum) {
		this.repairNum = repairNum;
	}

	public String getOutputDt() {
		return outputDt;
	}

	public void setOutputDt(String outputDt) {
		this.outputDt = outputDt;
	}

	public String getInputDt() {
		return inputDt;
	}

	public void setInputDt(String inputDt) {
		this.inputDt = inputDt;
	}

	public String getRepairCause() {
		return repairCause;
	}

	public void setRepairCause(String repairCause) {
		this.repairCause = repairCause;
	}

	public String getBsRgtNum() {
		return bsRgtNum;
	}

	public void setBsRgtNum(String bsRgtNum) {
		this.bsRgtNum = bsRgtNum;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public String getRcost() {
		return rcost;
	}

	public void setRcost(String rcost) {
		this.rcost = rcost;
	}

	public String getRcostStatus() {
		return rcostStatus;
	}

	public void setRcostStatus(String rcostStatus) {
		this.rcostStatus = rcostStatus;
	}

	public String getRcostPaidDt() {
		return rcostPaidDt;
	}

	public void setRcostPaidDt(String rcostPaidDt) {
		this.rcostPaidDt = rcostPaidDt;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getRsNm() {
		return rsNm;
	}

	public void setRsNm(String rsNm) {
		this.rsNm = rsNm;
	}

	public String getRsAdrs() {
		return rsAdrs;
	}

	public void setRsAdrs(String rsAdrs) {
		this.rsAdrs = rsAdrs;
	}

	public String getMdId() {
		return mdId;
	}

	public void setMdId(String mdId) {
		this.mdId = mdId;
	}

}
