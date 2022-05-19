package rentcar.rental;

import java.util.List;

public class RentalController {
    
	private static RentalController instance = new RentalController();
    public static RentalController getInstance() {
        return instance;
    }
    private RentalController() {}

    private RentalService service = RentalService.getInstance();
	
    public List<RentalVO> selectList(String branchId, String rentStartDt, int days) throws Exception{
        return service.selectList(branchId,rentStartDt,days);
    }

    public List<RentalVO> selectRent(String searchId) throws Exception {
    	return service.selectRent(searchId);
    }
	
    public int rentReservation(RentalVO vo) throws Exception {
    	return service.rentReservation(vo);
    }
    
    public int cencleRental(RentalVO vo) throws Exception {
    	return service.cencleRental(vo);
    }
    
    public int returnCar(RentalVO vo) throws Exception {
    	return service.returnCar(vo);
    }
    
    public RentalVO selectRentalApplication(String selectId) throws Exception {
    	return service.selectRentalApplication(selectId);
    }
    
    public int confirmCar(RentalVO vo) throws Exception {
    	return service.confirmCar(vo);
    	
    }
	public int approvalRent(RentalVO vo) throws Exception {
		return service.approvalRent(vo);
	}
	public int updateCar(RentalVO vo) throws Exception {
		return service.updateCar(vo);
	}
}
