package rentcar.car;

import java.util.List;

public class CarService {
    private static CarService instance = new CarService();
    public static CarService getInstance() {
        return instance;
    }
    private CarService() {}

    private CarDAO dao = CarDAO.getInstance();
	public List<CarVO> getCarList() throws Exception {
		List<CarVO> list = dao.getList();
		return list;
	}
	public CarVO getCar(String carNum) throws Exception {
		CarVO vo = dao.getCar(carNum);
		return vo;
	}
	public int insertCar(CarVO vo) throws Exception {
		int result = dao.insertCar(vo);
		return result;
	}
	public int updateCar(CarVO vo) throws Exception {
		int result = dao.updateCar(vo);
		return result;
	}
	public int updateCarStatus(CarVO vo) throws Exception {
		int result = dao.updateCarStatus(vo);
		return result;
	}
	public int deleteCar(String deleteId) throws Exception {
		int result = dao.deleteCar(deleteId);
		return result;
	}


}
