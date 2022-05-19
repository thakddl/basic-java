package rentcar;

import rentcar.branch.BranchController;
import rentcar.car.CarController;
import rentcar.common.HomeMenu;
import rentcar.common.MenuNotFoundException;
import rentcar.join.JoinController;
import rentcar.model.ModelController;
import rentcar.sign.SignController;

public class Home {
	
	private JoinController joinController = JoinController.getInstance();
	private SignController signController = SignController.getInstance();
	private BranchController branchController = BranchController.getInstance();
	private CarController carController = CarController.getInstance();
	private ModelController modelController = ModelController.getInstance();
	
	private RentCarView view = RentCarView.getInstance();

	public void initialize() {
		home(view.init());
	}

	private void home(int number) {
		loop: while (true) {
			try {
				HomeMenu menu = HomeMenu.findMenu(number);
				System.out.print(menu.getMenuString());
				switch (menu) {
				case HOME:
				case MAIN_USER:
				case MAIN_ADM:
				case MEMBER:
				case MEMBER_ADM:
					/* case BRANCH: */
				case BRANCH_ADM:
				case MEMBER_MODIFY_INFO:
				case BRANCH_MODIFY_INFO:
				case CAR:
				case MODEL:
				case RENTAL_USER:
				case RENTAL_ADM:
				case REPAIR:
				case REPAIRSHOP:
				case DELETE:
					 number = view.getMenu();
                     break;
				case BRANCH_INFO:
					number = view.getBranchInfo();
					break;
				case MODIFY_BRANCHNM:
				case MODIFY_BRANCHADRS:
				case MODIFY_BRANCHPH:
					number = view.modifyBranchInfo(menu);
					break;
				case INSERT_BRANCH:
					number = view.insertBranch();
					break;
				case DELETE_BRANCH:
					number = view.withdrawlBranch();
					break;
					/* case JOIN: */
				case JOIN:
					number = view.join();
					break;
				case LOGIN:
					number = view.login();
					break;
				case LOGOUT:
					number = signController.signOut();
					break;
				case MEMBER_INFO:
					number = view.getMemberInfo();
					break;
				case MODIFY_NAME:				
				case MODIFY_ADDRESS:
				case MODIFY_PHONE:
					number = view.modifyInfo(menu);
					break;
				case MODIFY_MEMLV:
					number = view.admModifyMemLv();
					break;
				case MEMBER_MODIFY_PASSWORD:
					number = view.changePassWord();
					break;
				case GET_MEMBER_INFO:
					number = view.admGetMemInfo();
					break;
				case WITHDRAWL:
					number = view.withdrawl();
					break;
					/* case CAR: */
				case CAR_LIST:
					number = view.getCarList();
					break;
				case CAR_INFO:
					number = view.getCar();
					break;
				case CAR_INSERT:
					number = view.insertCar();
					break;
				case CAR_UPDATE:
					number = view.updateCar();
					break;
				case CAR_STATUS:
					number = view.updateCarStatus();
					break;
				case CAR_DELETE:
					number = view.deleteCar();
					break;
					/* case MODEL: */
				case MODEL_LIST:
					number = view.getModelList();
					break;
				case MODEL_INFO:
					number = view.getModel();
					break;
				case MODEL_INSERT:
					number = view.insertModel();
					break;
				case MODEL_UPDATE:
					number = view.updateModel();
					break;
				case MODEL_DELETE:
					number = view.deleteModel();
					break;
//-------------------------------------------------------					
				case REPAIR_REQUIRED_CAR:
					number = view.repairNeedList();
					break;
				case REPAIR_ING_CAR:
					number = view.repairingList();
					break;
				case REPAIR_RECORD:
					number = view.repairList();
					break;
				case REPAIR_DETAIL_RECORD:
					number = view.getRepair();
					break;
				case REPAIR_OUTPUT_CAR:
					number = view.insertRepair();
					break;
				case REPAIR_INCOME_CAR:
					number = view.outputCar();
					break;
				case REPAIR_CAR_DELETE:
					number = view.deleteRepair();
					break;
//-------------------------------------------------------
				case REPAIRSHOP_LIST:
					number = view.repairshopList();
					break;
				case REPAIRSHOP_DETAIL:
					number = view.getRepairShop();
					break;
				case REPAIRSHOP_INSERT:
					number = view.insertRepairShop();
					break;
				case REPAIRSHOP_UPDATE:
					number = view.updateRepairShop();
					break;
//-------------------------------------------------------
				case DELETE_SHOP:
					number = view.deleteRepairShop();
					break;
				case DELETE_LIST:
					number = view.repairshopDelList();
					break;
				case DELETE_RESTORE:
					number = view.ReDeleteRepairShop();
					break;
				case DELETE_SHOP_PERFECT:
					number = view.ComDeleteRepairShop();
					break;
//-------------------------------------------------------
				case RENTAL_RESERVE:
					number = view.rentApplication();
					break;
				case RENTAL_SELECT_USER:
					number = view.selectRent();
					break;
				case RENTAL_RESERVE_CANCLE:
					number = view.cencleRental();
					break;
				case RENTAL_RETURN:
					number = view.returnCar();
					break;
				case RENTAL_SELECT_ADM:
					number = view.selectRentalApplication();
					break;
				case RENTAL_APPROVAL_ADM:
					number = view.approvalRent();
					break;
				case RENTAL_CONFIRM:
					number = view.confirmCar();
					break;
//-------------------------------------------------------
				case QUIT:
					break loop;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.print(HomeMenu.HOME.getMenuString());
			}
			System.out.println();
		}
	}
}