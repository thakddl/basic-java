package rentcar.repairshop;

import java.util.List;

public class RepairShopService {
	private static RepairShopService instance = new RepairShopService();	
	public static RepairShopService getInstance() {
		return instance;
	}
	private RepairShopService() {}
	
	private RepairShopDAO dao = RepairShopDAO.getInstance();
	public List<RepairShopVO> repairshopList() throws Exception {
		return dao.repairshopList();
	}
	
	public RepairShopVO getRepairShop(String searchRgtNum) throws Exception {
		return dao.getRepairShop(searchRgtNum);
	}
	
	public int insertRepairShop(RepairShopVO vo) throws Exception {
		return dao.insertRepairShop(vo);
	}
	
	public int updateRepairShop(RepairShopVO vo) throws Exception {
		return dao.updateRepairShop(vo);
	}
	
	public int deleteRepairShop(RepairShopVO vo) throws Exception {
		return dao.deleteRepairShop(vo);
	}
	
	public List<RepairShopVO> repairshopDelList() throws Exception {
		return dao.repairshopDelList();
	}
	
	public int ReDeleteRepairShop(RepairShopVO vo) throws Exception {
		return dao.ReDeleteRepairShop(vo);
	}
	
	public int ComDeleteRepairShop(RepairShopVO vo) throws Exception {
		return dao.ComDeleteRepairShop(vo);
	}
	
}