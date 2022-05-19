package rentcar.car;

import java.util.List;

public class CarController {
    private static CarController instance = new CarController();
    public static CarController getInstance() {
        return instance;
    }
    private CarController() {}

    private CarService service = CarService.getInstance();

	public List<CarVO> getCarList() throws Exception { 
		return service.getCarList(); 
	}
	public CarVO getCar(String carNum) throws Exception {
		return service.getCar(carNum);
	}
	public int insertCar(CarVO vo) throws Exception {
		return service.insertCar(vo);
	}
	public int updateCar(CarVO vo) throws Exception {
		return service.updateCar(vo);
	}
	public int updateCarStatus(CarVO vo) throws Exception {
		return service.updateCarStatus(vo);
	}
	public int deleteCar(String deleteId) throws Exception {
		return service.deleteCar(deleteId);
		
	}
	 
}
