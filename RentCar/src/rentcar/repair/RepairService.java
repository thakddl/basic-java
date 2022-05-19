package rentcar.repair;

import java.util.List;

public class RepairService {
	private static RepairService instance = new RepairService();

	public static RepairService getInstance() {
		return instance;
	}

	private RepairService() {
	}

	private RepairDAO dao = RepairDAO.getInstance();

	public List<RepairVO> repairNeedList() throws Exception {
		return dao.repairNeedList();
	}

	public List<RepairVO> repairingList() throws Exception {
		return dao.repairingList();
	}

	public List<RepairVO> repairList() throws Exception {
		return dao.repairList();
	}

	public RepairVO getRepair(String searchRepairNum) throws Exception {
		return dao.getRepair(searchRepairNum);
	}

	public List<RepairVO> selectShopList(String carNum) throws Exception {
		return dao.selectShopList(carNum);
	}

	public int insertRepair(RepairVO vo) throws Exception {
		return dao.insertRepair(vo);
	}

	public int insertRepair2(RepairVO vo) throws Exception {
		return dao.insertRepair2(vo);
	}

	public int inputCar(RepairVO vo) throws Exception {
		int result = dao.inputCar(vo);
		if (result > 0) {
			result = dao.inputCar2(vo);
		} else {
			result = 0;
		}
		return result;
	}

	public int inputCar2(RepairVO vo) throws Exception {
		return dao.inputCar2(vo);
	}

	public RepairVO DeleteRepair(String repairNum) throws Exception {
		return dao.DeleteRepair(repairNum);
	}

}