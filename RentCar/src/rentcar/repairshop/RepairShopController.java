package rentcar.repairshop;

import java.util.List;

public class RepairShopController {
	private static RepairShopController instance = new RepairShopController();	
	public static RepairShopController getInstance() {
		return instance;
	}
	
	private RepairShopController() {}
	
	private RepairShopService repairShopService = RepairShopService.getInstance();	

	public List<RepairShopVO> repairshopList() throws Exception {
		return repairShopService.repairshopList();
	}
	
	public RepairShopVO getRepairShop(String searchRgtNum) throws Exception {
		return repairShopService.getRepairShop(searchRgtNum);
	}
	
	public int insertRepairShop(RepairShopVO vo) throws Exception {
		return repairShopService.insertRepairShop(vo);
	}
	
	public int updateRepairShop(RepairShopVO vo) throws Exception {
		return repairShopService.updateRepairShop(vo);
	}
	
	public int deleteRepairShop(RepairShopVO vo) throws Exception {
		return repairShopService.deleteRepairShop(vo);
	}
	
	public List<RepairShopVO> repairshopDelList() throws Exception {
		return repairShopService.repairshopDelList();
	}
	
	public int ReDeleteRepairShop(RepairShopVO vo) throws Exception {
		return repairShopService.ReDeleteRepairShop(vo);
	}
	
	public int ComDeleteRepairShop(RepairShopVO vo) throws Exception {
		return repairShopService.ComDeleteRepairShop(vo);
	}
	
}
