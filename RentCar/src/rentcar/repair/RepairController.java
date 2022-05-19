package rentcar.repair;

import java.util.List;

public class RepairController {
	private static RepairController instance = new RepairController();
	public static RepairController getInstance() {
		return instance;
	}
	private RepairController() {};
		
	private RepairService repairService = RepairService.getInstance();

	public List<RepairVO> repairNeedList() throws Exception {
		return repairService.repairNeedList();
	}

	public List<RepairVO> repairingList() throws Exception {
		return repairService.repairingList();
	}

	public List<RepairVO> repairList() throws Exception {
		return repairService.repairList();
	}

	public RepairVO getRepair(String searchRepairNum) throws Exception {
		return repairService.getRepair(searchRepairNum);
	}

	public List<RepairVO> selectShopList(String carNum) throws Exception {
		return repairService.selectShopList(carNum);
	}

	public int insertRepair(RepairVO vo) throws Exception {
		return repairService.insertRepair(vo);
	}

	public int insertRepair2(RepairVO vo) throws Exception {
		return repairService.insertRepair2(vo);
	}

	public int inputCar(RepairVO vo) throws Exception {
		return repairService.inputCar(vo);
	}

	public int inputCar2(RepairVO vo) throws Exception {
		return repairService.inputCar2(vo);
	}

	public RepairVO DeleteRepair(String repairNum) throws Exception {
		return repairService.DeleteRepair(repairNum);
	}

}