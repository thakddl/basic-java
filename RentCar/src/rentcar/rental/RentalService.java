package rentcar.rental;

import java.util.List;


public class RentalService {
    
	private static RentalService instance = new RentalService();
    public static RentalService getInstance() {
        return instance;
    }

    private RentalService() {}

    private RentalDAO dao = RentalDAO.getInstance();
    
    public List<RentalVO> selectList(String branchId, String startDate, int days) throws Exception {
    	return dao.selectList(branchId, startDate, days);
    }

    public List<RentalVO> selectRent(String searchId) throws Exception {
    	return dao.selectRent(searchId);
    }
	
    public int rentReservation(RentalVO vo) throws Exception {
    	return dao.rentReservation(vo);
    }
    
    public int cencleRental(RentalVO vo) throws Exception {
    	return dao.cencleRental(vo);
    }
    
    public int returnCar(RentalVO vo) throws Exception {
    	return dao.returnCar(vo);
    }
    
    public RentalVO selectRentalApplication(String selectId) throws Exception {
    	return dao.selectRentalApplication(selectId);
    }
    
    public int confirmCar(RentalVO vo) throws Exception {
    	int result = dao.confirmCar(vo);
    	if(result > 0) {
    		result = dao.updateCar(vo);   		
    	} else {
    		result = 0;
    	}
    	return result;
    	
    }

	public int approvalRent(RentalVO vo) throws Exception {
		return dao.approvalRent(vo);
	}
	public int updateCar(RentalVO vo) throws Exception {
		return dao.updateCar(vo);
	}
    
    }
