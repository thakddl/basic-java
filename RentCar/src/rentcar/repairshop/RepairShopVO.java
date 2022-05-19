package rentcar.repairshop;

public class RepairShopVO {
 private   String bsRgtNum;
 private   String rsNm;
 private   String rsPh;
 private   String rsAdrs;
 private   String updateDt;
 private   String deleteKey;
 private   String deleteDt;


    @Override
    public String toString() {
       return "RepairShopVO [BS_RGT_NUM=" + bsRgtNum + ", RS_NM=" + rsNm + ", RS_PH=" + rsPh
       		 + ", RS_ADRS=" + rsAdrs + ", UPDATE_DT=" + updateDt + ", DELETE_KEY=" + deleteKey
             +  ", DELETE_DT=" + deleteDt + "]";
    }
    
    public RepairShopVO(String bsRgtNum) {
    super();
    this.bsRgtNum = bsRgtNum;
    }
    
    public RepairShopVO (String bsRgtNum, String rsNm, String rsPh, String rsAdrs) {
       super();
       this.bsRgtNum = bsRgtNum;
       this.rsNm = rsNm;
       this.rsPh = rsPh;
       this.rsAdrs = rsAdrs;
       
    }

    public RepairShopVO (String bsRgtNum, String rsNm, String rsPh, String rsAdrs,
    					 String updateDt, String deleteKey, String deleteDt) {
       super();
       this.bsRgtNum = bsRgtNum;
       this.rsNm = rsNm;
       this.rsPh = rsPh;
       this.rsAdrs = rsAdrs;
       this.updateDt = updateDt;
       this.deleteKey = deleteKey;
       this.deleteDt = deleteDt;
    }

	public String getBsRgtNum() {
		return bsRgtNum;
	}

	public void setBsRgtNum(String bsRgtNum) {
		this.bsRgtNum = bsRgtNum;
	}

	public String getRsNm() {
		return rsNm;
	}

	public void setRsNm(String rsNm) {
		this.rsNm = rsNm;
	}

	public String getRsPh() {
		return rsPh;
	}

	public void setRsPh(String rsPh) {
		this.rsPh = rsPh;
	}

	public String getRsAdrs() {
		return rsAdrs;
	}

	public void setRsAdrs(String rsAdrs) {
		this.rsAdrs = rsAdrs;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public String getDeleteKey() {
		return deleteKey;
	}

	public void setDeleteKey(String deleteKey) {
		this.deleteKey = deleteKey;
	}

	public String getDeleteDt() {
		return deleteDt;
	}

	public void setDeleteDt(String deleteDt) {
		this.deleteDt = deleteDt;
	}

}