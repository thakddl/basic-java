package rentcar;

import java.util.List;
import java.util.Scanner;

import rentcar.branch.BranchController;
import rentcar.branch.BranchVO;
import rentcar.car.CarController;
import rentcar.car.CarVO;
import rentcar.common.HomeMenu;
import rentcar.common.ScannerUtil;
import rentcar.join.JoinController;
import rentcar.join.MemberVO;
import rentcar.model.ModelController;
import rentcar.model.ModelVO;
import rentcar.rental.RentalController;
import rentcar.rental.RentalVO;
import rentcar.repair.RepairController;
import rentcar.repair.RepairVO;
import rentcar.repairshop.RepairShopController;
import rentcar.repairshop.RepairShopVO;
import rentcar.sign.SignController;

public class RentCarView {
	private static RentCarView instance = new RentCarView();

	public static RentCarView getInstance() {
		return instance;
	}

	MemberVO session = RentCarApplication.getSession();
	
	private Scanner scanner = ScannerUtil.scanner();

	BranchController branchController = BranchController.getInstance();
	JoinController joinController = JoinController.getInstance();
	SignController signController = SignController.getInstance();
	CarController carController = CarController.getInstance();
	ModelController modelController = ModelController.getInstance();
	RepairController repairController = RepairController.getInstance();
	RepairShopController repairShopController = RepairShopController.getInstance();
	RentalController rentalController = RentalController.getInstance();
	
	public int init() {
		System.out.println("렌트카에 오신 것을 환영합니다!");
		System.out.print(HomeMenu.HOME.getMenuString());
		return Integer.parseInt(scanner.nextLine());
	}

	public int getMenu() {
		return Integer.parseInt(scanner.nextLine());
	}

	public int join() {
		int number;
		System.out.print("아이디: ");
		String memId = scanner.nextLine();
		System.out.print("패스워드: ");
		String memPw = scanner.nextLine();
		System.out.print("이름: ");
		String memNm = scanner.nextLine();
		System.out.print("전화번호: ");
		String memPh = scanner.nextLine();
		System.out.print("주소: ");
		String memAdrs = scanner.nextLine();
		System.out.print("운전면허 종류: ");
		String licenseType = scanner.nextLine();
		number = joinController.join(new MemberVO(memId, memPw, memNm, memPh, memAdrs, licenseType));
		if (number == HomeMenu.HOME.getMenu()) {
			System.out.print("회원가입이 완료되었습니다. 로그인해주세요.");
		} else {
			System.out.print("회원가입 실패! 다시 회원가입을 하시겠습니까?(y 또는 n을 입력): ");
			String inputFlag = scanner.nextLine();
			if (inputFlag.equalsIgnoreCase("y")) {
				number = HomeMenu.JOIN.getMenu();
			} else {
				number = HomeMenu.HOME.getMenu();
			}
		}
		return number;
	}

	public int login() {
		int number;
		System.out.print("아이디: ");
		String memId = scanner.nextLine();
		System.out.print("패스워드: ");
		String memPw = scanner.nextLine();
		MemberVO vo = signController.signIn(new MemberVO(memId, memPw));
		
		if (vo != null && (vo.getMemLv() != 0)) {
			System.out.println(vo.getMemNm() + "님 로그인되었습니다.");
			number = HomeMenu.MAIN_USER.getMenu();
		} else if (vo != null && (vo.getMemLv() == 0)) {
			System.out.println(vo.getMemNm() + "님 로그인되었습니다.");
			System.out.println("지점번호: " + RentCarApplication.getSession().getBranchId());
			number = HomeMenu.MAIN_ADM.getMenu();
		} else {
			System.out.println("로그인 정보가 일치하지 않습니다. 아이디와 비밀번호를 확인하세요.");
			number = HomeMenu.HOME.getMenu();
		}
		return number;
	}

	public int getMemberInfo() {
		MemberVO member = joinController.findMember();
		System.out.printf("아이디: %s\n", member.getMemId());
		System.out.printf("이름: %s\n", member.getMemNm());
		System.out.printf("주소: %s\n", member.getMemAdrs());
		System.out.printf("전화번호: %s\n", member.getMemPh());
		return HomeMenu.MEMBER.getMenu();
	}

	public int modifyInfo(HomeMenu menu) {
		int resultName = joinController.modifyInfo(scanner.nextLine(), menu);
		if (resultName == 1) {
			System.out.println("정상적으로 수정되었습니다.");
		}
		return HomeMenu.MEMBER.getMenu();
	}

	public int changePassWord() {
		String newPassword = scanner.nextLine();
		System.out.println("비밀번호 확인을 위해 다시 한번 입력해주세요.");
		String confirmPassword = scanner.nextLine();
		if (newPassword.equals(confirmPassword)) {
			joinController.modifyPassword(confirmPassword);
			System.out.println("비밀번호가 변경되었습니다.");
		} else {
			System.out.println("비밀번호가 일치하지 않습니다. 비밀번호 변경을 취소합니다.");
		}
		return HomeMenu.MEMBER.getMenu();
	}

	public int admModifyMemLv() {
		String oldMemId = scanner.nextLine();
		System.out.print("변경할 권한을 입력하세요.(관리자: 0, 일반사원: 2, 일반회원: 4, 비회원: 0): ");
		int newMemLv = Integer.parseInt(scanner.nextLine());
		joinController.modifyMemLv(oldMemId, newMemLv);
		System.out.println("정상적으로 수정되었습니다.");
		return HomeMenu.MEMBER.getMenu();
	}

	public int admGetMemInfo() {
		String searchMemId = scanner.nextLine();
		MemberVO member = joinController.admFindMember(searchMemId);
		System.out.printf("아이디: %s\n", member.getMemId());
		System.out.printf("이름: %s\n", member.getMemNm());
		System.out.printf("주소: %s\n", member.getMemAdrs());
		System.out.printf("전화번호: %s\n", member.getMemPh());
		System.out.printf("면허종류: %s\n", member.getLicenseType());
		System.out.printf("회원권한: %s\n", member.getMemLv());
		return HomeMenu.MEMBER.getMenu();
	}

	public int withdrawl() {
		int number;
		System.out.print("정말로 회원탈퇴를 진행하시겠습니까?(y 또는 n을 입력): ");
		String inputFlag = scanner.nextLine();
		if (inputFlag.equalsIgnoreCase("y")) {
			joinController.withdrawl();
			number = HomeMenu.QUIT.getMenu();
		} else {
			number = HomeMenu.MAIN_USER.getMenu();
		}
		return number;
	}

	public int insertBranch() {
		System.out.print("지점명: ");
		String branchNm = scanner.nextLine();
		System.out.print("지점전화번호: ");
		String branchPh = scanner.nextLine();
		System.out.print("지점주소: ");
		String branchAdrs = scanner.nextLine();
		BranchVO vo = new BranchVO();
		vo.setBranchNm(branchNm);
		vo.setBranchPh(branchPh);
		vo.setBranchAdrs(branchAdrs);
		int result = branchController.insertBranch(vo);
		if (result > 0) {
			System.out.print("지점등록이 완료되었습니다.");
		}
		return HomeMenu.BRANCH_ADM.getMenu();
	}

	public int getBranchInfo() {
		String searchbranchId = scanner.nextLine();
		BranchVO branch = branchController.findBranch(searchbranchId);
		System.out.printf("지점명: %s\n", branch.getBranchNm());
		System.out.printf("지점주소: %s\n", branch.getBranchAdrs());
		System.out.printf("지점전화번호: %s\n", branch.getBranchPh());
		return HomeMenu.BRANCH_ADM.getMenu();
	}

	public int modifyBranchInfo(HomeMenu menu) throws Exception {
		List<BranchVO> list = branchController.getBranchList();

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				BranchVO vo = list.get(i);
				System.out.printf("%d.%s ", i + 1, vo.getBranchNm());
			}
			System.out.print("\n>>");
		} else {
			System.out.print("실패");
		}

		String inputNum = scanner.nextLine();
		String branchId = list.get(Integer.parseInt(inputNum) - 1).getBranchId();
		System.out.println("변경하고자 하는 내용을 입력하세요.");
		String modifyData = scanner.nextLine();

		int resultName = branchController.modifyBranchInfo(branchId, modifyData, menu);
		if (resultName == 1) {
			System.out.println("정상적으로 수정되었습니다.");
		}
		return HomeMenu.BRANCH_ADM.getMenu();
	}

	public int withdrawlBranch() {
		int number;
		System.out.print("삭제할 지점코드를 입력하세요: ");
		String branchId = scanner.nextLine();
		branchController.withdrawlBranch(branchId);
		System.out.println("정상적으로 삭제되었습니다.");
		number = HomeMenu.BRANCH_ADM.getMenu();
		return number;
	}

	/* ----------------------------------------------------------------------- */

	public int getCarList() throws Exception {
		System.out.println("차량의 리스트를 조회합니다.");
		List<CarVO> list = carController.getCarList();

		for (CarVO vo : list) {
			System.out.printf("차량번호: %s, 모델 이름: %s, 차량 상태: %s, 누적운행거리: %s, 마지막 수정일자: %s\n", vo.getCarNum(),
					vo.getMdNm(), vo.getCarStatus(), vo.getCarTotalKm(), vo.getUpdateDt());
		}
		return HomeMenu.CAR.getMenu();
	}

	public int getCar() throws Exception {
		System.out.println("차량의 정보를 조회합니다.");
		System.out.print("자동차 차량번호를 입력해주세요.");
		String carNum = scanner.nextLine();
		CarVO vo = carController.getCar(carNum);
		if (vo != null) {
			System.out.printf("차량번호: %s, 모델 이름: %s, 지점 이름: %s, 차량 상태: %s, 누적운행거리: %s, 마지막 수정일자: %s\n", vo.getCarNum(),
					vo.getMdNm(), vo.getBranchNm(), vo.getCarStatus(), vo.getCarTotalKm(), vo.getUpdateDt());
		} else {
			System.out.println("자동차 정보가 없습니다.");
		}
		return HomeMenu.CAR.getMenu();
	}

	public int insertCar() throws Exception {
		System.out.println("신규 차량을 등록합니다.");
		System.out.print("자동차 차량번호를 입력해주세요.");
		String carNum = scanner.nextLine();
		System.out.println("자동차 모델을 선택해주세요.");
		List<ModelVO> list = modelController.getModelList();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				ModelVO vo1 = list.get(i);
				System.out.printf(i + 1 + " %10s %10s원 %10s\n", vo1.getMdNm(), vo1.getMdRentFee(), vo1.getMdFuel());
			}
			System.out.println("이용하실 차량 모델의 번호를 선택해 주세요.");
		} else {
			System.out.println("이용 가능한 모델이 없습니다.");
		}

		String inputNum = scanner.nextLine();
		String selectMd = list.get(Integer.parseInt(inputNum) - 1).getMdId();
		CarVO vo = new CarVO();
		vo.setCarNum(carNum);
		vo.setBranchId(session.getBranchId());
		vo.setMdId(selectMd);
		carController.insertCar(vo);
		System.out.println("다음의 정보가 입력되었습니다.");
		CarVO vo2 = carController.getCar(carNum);
		if (vo2 != null) {
			System.out.printf("차량번호: %s, 모델 이름: %s, 차량 상태: %s, 누적운행거리: %s, 마지막 수정일자: %s\n", vo2.getCarNum(),
					vo2.getMdNm(), vo2.getCarStatus(), vo2.getCarTotalKm(), vo2.getUpdateDt());
		} else {
			System.out.println("자동차 정보가 없습니다.");
		}
		return HomeMenu.CAR.getMenu();
	}

	public int updateCar() throws Exception {
		System.out.println("차량 정보를 수정합니다.");
		System.out.print("자동차 차량번호를 입력해주세요.");
		String carNum = scanner.nextLine();
		System.out.print("자동차 누적운행거리를 입력해주세요.");
		String carTotalKm = scanner.nextLine();
		CarVO vo = new CarVO();
		vo.setCarNum(carNum);
		vo.setCarTotalKm(Integer.parseInt(carTotalKm));
		int result = carController.updateCar(vo);
		if (result > 0) {
			System.out.println("자동차 정보가 삭제되었습니다.");
		} else {
			System.out.println("자동차 정보가 없습니다.");
		}
		System.out.println("업데이트가 완료 되었습니다.");
		return HomeMenu.CAR.getMenu();
	}

	public int updateCarStatus() throws Exception {
		System.out.println("차량의 상태정보를 수정합니다.");
		System.out.print("자동차 차량번호를 입력해주세요.");
		String carNum = scanner.nextLine();
		System.out.print("자동차 상태를 입력해주세요.(0:렌트 가능, 2:렌트중, 3:수리필요, 4:수리중, 6:폐차 대기, 9999:폐차 완료)");
		String carStatus = scanner.nextLine();
		CarVO vo = new CarVO();
		vo.setCarNum(carNum);
		vo.setCarStatus(Integer.parseInt(carStatus));
		int result = carController.updateCarStatus(vo);
		if (result > 0) {
			System.out.println("업데이트가 완료 되었습니다.");
		} else {
			System.out.println("자동차 정보가 없습니다.");
		}
		return HomeMenu.CAR.getMenu();
	}

	public int deleteCar() throws Exception {
		System.out.print("삭제하실 차량의 번호를 입력해주세요.");
		String deleteId = scanner.nextLine();
		int result = carController.deleteCar(deleteId);
		if (result > 0) {
			System.out.println("삭제가 완료 되었습니다.");
		} else {
			System.out.println("자동차 정보가 없습니다.");
		}
		return HomeMenu.CAR.getMenu();
	}

	/* ----------------------------------------------------------------------- */

	public int getModelList() throws Exception {
		List<ModelVO> list = modelController.getModelList();
		for (ModelVO vo : list) {
			System.out.print("모델 아이디: " + vo.getMdId());
			System.out.print(", 모델 이름: " + vo.getMdNm());
			System.out.print(", 모델 일일 렌트비: " + vo.getMdRentFee());
			System.out.print(", 차급: " + vo.getMdSize());
			System.out.print(", 연료의 종류: " + vo.getMdFuel());
			System.out.println(", 마지막 수정일: " + vo.getUpdateDt());
		}
		return HomeMenu.MODEL.getMenu();
	}

	public int getModel() throws Exception {
		List<ModelVO> list = modelController.getModelList();
		System.out.println("모델 정보를 열람하시려면 아래의 번호를 선택하세요.");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				ModelVO vo1 = list.get(i);
				System.out.printf("%d.%s ", i + 1, vo1.getMdNm());
			}
			System.out.print("\n>>");
		}
		String inputNum = scanner.nextLine();
		String selectMd = list.get(Integer.parseInt(inputNum) - 1).getMdId();

		ModelVO vo = modelController.getModel(selectMd);
		if (vo != null) {
			System.out.print("모델 아이디: " + vo.getMdId());
			System.out.print(", 모델 이름: " + vo.getMdNm());
			System.out.print(", 모델 일일 렌트비: " + vo.getMdRentFee());
			System.out.print(", 차급: " + vo.getMdSize());
			System.out.print(", 연료의 종류: " + vo.getMdFuel());
			System.out.println(", 마지막 수정일: " + vo.getUpdateDt());
		} else {
			System.out.println("모델 정보가 없습니다.");
		}
		return HomeMenu.MODEL.getMenu();
	}

	public int insertModel() throws Exception {
		ModelVO vo = new ModelVO();
		System.out.println("새로운 모델의 정보를 입력하세요.");
		System.out.print("모델 이름: ");
		String mdNm = scanner.nextLine();
		System.out.print("모델 일일 렌트비: ");
		int mdRentFee = Integer.parseInt(scanner.nextLine());
		System.out.print("차급: ");
		String mdSize = scanner.nextLine();
		System.out.print("연료의 종류: ");
		String mdFuel = scanner.nextLine();
		vo.setMdNm(mdNm);
		vo.setMdRentFee(mdRentFee);
		vo.setMdSize(mdSize);
		vo.setMdFuel(mdFuel);
		int result = modelController.insertModel(vo);
		if (result > 0) {
			System.out.println("새로운 모델 정보가 입력되었습니다.");
		} else {
			System.out.println("새로운 모델 정보 입력을 실패하였습니다.");
		}
		return HomeMenu.MODEL.getMenu();
	}

	public int updateModel() throws Exception {
		System.out.println("모델의 정보를 업데이트 합니다.");
		List<ModelVO> list = modelController.getModelList();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				ModelVO vo1 = list.get(i);
				System.out.printf(i + 1 + " %10s %10s원 %10s %10s \n", vo1.getMdNm(), vo1.getMdRentFee(),
						vo1.getMdFuel(), vo1.getMdId());
			}
			System.out.println("수정하실 차량 모델의 번호를 선택해 주세요.");
		} else {
			System.out.println("수정 가능한 모델이 없습니다. 모델 정보를 추가해주세요.");
		}
		String inputNum = scanner.nextLine();
		String mdId = list.get(Integer.parseInt(inputNum) - 1).getMdId();
		System.out.print("수정하실 렌트비용을 입력해 주세요.");
		String mdRentFee = scanner.nextLine();
		System.out.print("수정하실 차량 크기를 입력해 주세요.");
		String mdSize = scanner.nextLine();
		System.out.print("수정하실 연료 타입을 입력해 주세요.");
		String mdFuel = scanner.nextLine();
		ModelVO vo = new ModelVO();
		vo.setMdId(mdId);
		vo.setMdRentFee(Integer.parseInt(mdRentFee));
		vo.setMdSize(mdSize);
		vo.setMdFuel(mdFuel);
		int result = modelController.updateModel(vo);
		if (result > 0) {
			System.out.println("업데이트가 완료되었습니다.");
		} else {
			System.out.println("업데이트를 완료할 수 없습니다. 다시 시도해주세요.");
		}
		return HomeMenu.MODEL.getMenu();
	}

	public int deleteModel() throws Exception {
		System.out.println("자동차 모델을 삭제합니다.");
		List<ModelVO> list = modelController.getModelList();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				ModelVO vo1 = list.get(i);
				System.out.printf(i + 1 + " %10s %10s %10s %10s \n", vo1.getMdNm(), vo1.getMdRentFee(), vo1.getMdFuel(),
						vo1.getMdId());
			}
			System.out.println("이용하실 차량 모델의 번호를 선택해 주세요.");
		} else {
			System.out.println("이용 가능한 모델이 없습니다.");
		}
		String inputNum = scanner.nextLine();
		String selectMd = list.get(Integer.parseInt(inputNum) - 1).getMdId();
		int result = modelController.deleteModel(selectMd);
		if (result > 0) {
			System.out.println("삭제가 완료 되었습니다.");
		} else {
			System.out.println("삭제할 수 없습니다. 다시 시도해주세요.");
		}
		return HomeMenu.MODEL.getMenu();
	}

	/*--------------------------------------------------------------------------------*/

	// 메뉴 포맷
	// "===================================================================================================================================================================");
	// " 1.정비필요차량 조회 | 2. 정비중 차량 조회 | 3. 정비내역 조회 | 4. 정비차량 상세조회 | 5. 차량 출고(정비소 보내기)
	// | 6. 차량 입고(차량 가져오기) | 7.정비기록 삭제");

	// 1. 정비필요차량 조회
	public int repairNeedList() throws Exception {
		List<RepairVO> repairNeedList = repairController.repairNeedList();
		if (repairNeedList != null) {
			System.out.println("   차량번호  \t      지점명  \t            모델명");
			for (int i = 0; i < repairNeedList.size(); i++) {
				RepairVO vo1 = repairNeedList.get(i);
				System.out.printf(" %10s \t %10s \t %10s \n", vo1.getCarNum(), vo1.getBranchId(), vo1.getMdId());
			}
		} else {
			System.out.println("정비필요차량이 없습니다.");
		}
		return HomeMenu.REPAIR.getMenu();
	}

	// 2. 정비중 차량 조회
	// 출력되는 값 : 정비번호 | 자동차번호 | 정비소 | 출고일자
	public int repairingList() throws Exception {
		List<RepairVO> repairingList = repairController.repairingList();
		for (RepairVO vo : repairingList) {
			System.out.printf("\t %10s \t %10s \t \t %10s \t %10s \n", vo.getRepairNum(), vo.getCarNum(),
					vo.getBsRgtNum(), vo.getOutputDt());
		}
		return HomeMenu.REPAIR.getMenu();
}

	// 3. 정비내역 조회
	// 출력되는 값 : 정비번호 | 자동차번호 | 정비소 | 수리사유 | 출고일자 | 입고일자
	public int repairList() throws Exception {
		List<RepairVO> repairList = repairController.repairList();
		for (RepairVO vo : repairList) {
			System.out.printf("%10s\t %10s \t  %10s \t  %10s \t \t %10s\t \t \t %10s \n", vo.getRepairNum(),
					vo.getCarNum(), vo.getBsRgtNum(), vo.getRepairCause(), vo.getOutputDt(), vo.getInputDt());
		}
		return HomeMenu.REPAIR.getMenu();
	}

	// 4. 세부 정비내역 조회
	// 조건 : 정비번호 입력시 해당 정비번호 세부내역 출력
	public int getRepair() throws Exception {
		System.out.println("조회할 정비번호를 입력하세요> ");
		String searchRepairNum = scanner.nextLine();

		RepairVO vo = repairController.getRepair(searchRepairNum);
		if (vo != null) {
			System.out.println("정비번호: " + vo.getRepairNum());
			System.out.println("출고일자: " + vo.getOutputDt());
			System.out.println("입고일자: " + vo.getInputDt());
			System.out.println("수리사유: " + vo.getRepairCause());
			System.out.println("정비소 사업자등록번호 : " + vo.getBsRgtNum());
			System.out.println("자동차번호: " + vo.getCarNum());
			System.out.println("지점번호: " + vo.getBranchId());
			System.out.println("업데이트일: " + vo.getUpdateDt());
			System.out.println("수리비용: " + vo.getRcost());
			System.out.println("수리비용 납부상태: " + vo.getRcostStatus());
			System.out.println("수리비용 납부일자: " + vo.getRcostPaidDt());
			System.out.println("차량 담당매니저: " + vo.getManagerId());

		} else {
			System.out.println("존재하지 않는 정비번호입니다.");
		}
		return HomeMenu.REPAIR.getMenu();
	}

	// 5. 차량 출고(정비소 보내기)
	public int insertRepair() throws Exception {
		System.out.println("정비할 차량번호를 입력하세요.");
		String carNum = scanner.nextLine();

		System.out.println("해당 차량의 관할 정비소 목록에서 차량을 보낼 정비소를 선택하세요.");
		List<RepairVO> ShopList = repairController.selectShopList(carNum);
		if (ShopList != null) {
			for (int i = 0; i < ShopList.size(); i++) {
				RepairVO vo1 = ShopList.get(i);
				System.out.printf(i + " %10s %10s %10s \n", vo1.getRsAdrs(), vo1.getBsRgtNum(), vo1.getRsNm());
			}

		} else {
			System.out.println("이용 가능한 정비소가 없습니다.");
		}
		String inputNum = scanner.nextLine();
		String bsRgtNum = ShopList.get(Integer.parseInt(inputNum) - 0).getBsRgtNum();

		System.out.println("차량 정비사유를 선택하세요.");
		String repairCause = scanner.nextLine();

		System.out.println("출고일을 선택하세요.( - 없이 8자리");
		String outputDt = scanner.nextLine();

		int insertRepair = repairController.insertRepair(new RepairVO(null, outputDt, repairCause, bsRgtNum, carNum));
		int insertRepair2 = repairController.insertRepair2(new RepairVO(carNum, null));

		if (insertRepair > 0) {
			System.out.println("정보가 입력되었습니다.");
		} else {
			System.out.println("정보가 입력되지 않았습니다.");
		}
		return HomeMenu.REPAIR.getMenu();
	}

	// 6. 정비중 차량 입고(차량 가져오기)
	public int outputCar() throws Exception {
		System.out.println("정비중 차량 목록에서 입고할 차량의 정비번호를 선택하세요");
		System.out.println("\t 정비번호 \t 차량번호 \t 정비소 \t \t 출고일자 \t");
		System.out.println("==============================================================================");
		List<RepairVO> repairingList1 = repairController.repairingList();
		if (repairingList1 != null) {
			for (int i = 0; i < repairingList1.size(); i++) {
				RepairVO vo1 = repairingList1.get(i);
				System.out.printf("%10s \t %10s \t \t %10s \t %10s \n", vo1.getRepairNum(), vo1.getCarNum(),
						vo1.getBsRgtNum(), vo1.getOutputDt());
			}
		} else {
			System.out.println("정비중인 차량이 없습니다.");
		}

		String repairNum = scanner.nextLine();
		System.out.println("차량을 입고할 날짜를 입력하세요.('-'없이 8자리)");
		String inputDt = scanner.nextLine();
		System.out.println("청구된 정비금액을 입력하세요");
		String rcost = scanner.nextLine();
		RepairVO vo = new RepairVO(repairNum, inputDt, rcost, null, null, null, null);
		int inputCar = repairController.inputCar(vo);

		if (inputCar > 0) {
			System.out.println("차량이 입고되었습니다.");
		} else {
			System.out.println("차량이 입고되지 않았습니다.");
		}
		return HomeMenu.REPAIR.getMenu();
	}

	// 7. 정비차량리스트 삭제
	public int deleteRepair() throws Exception {
		System.out.println("정비기록을 삭제할 정비번호를 입력해 주세요.");
		String repairNum = scanner.nextLine();
		RepairVO vo3 = repairController.DeleteRepair(repairNum);
		System.out.println("정비기록이 삭제 되었습니다..");
		return HomeMenu.REPAIR.getMenu();
	}

	// 목록 포맷
	// 1. 정비소 목록 | 2. 정비소 상세 | 3. 새 정비소 등록 | 4. 정비소 정보수정 | 5. 정비소 삭제/복원

	// 1. 정비소 목록
	public int repairshopList() throws Exception {
		List<RepairShopVO> list = repairShopController.repairshopList();
		if(list != null) {		
			for (RepairShopVO vo : list) {
				System.out.printf("%10s \t %10s \t \t %10s \t \t %10s \t \n", vo.getBsRgtNum(), vo.getRsNm(), vo.getRsPh(),vo.getRsAdrs());
			}
		} else {
			System.out.println("정비소 목록이 없습니다.");
		}
		return HomeMenu.REPAIRSHOP.getMenu();
	}

	// 2. 정비소 상세 정보
	public int getRepairShop() throws Exception {
		System.out.println("조회할 사업자 등록번호를 입력하세요> ");
		String searchRgtNum = scanner.nextLine();
		RepairShopVO vo = repairShopController.getRepairShop(searchRgtNum);

		if (vo != null) {
			System.out.println("사업자등록번호: " + vo.getBsRgtNum());
			System.out.println("정비소명: " + vo.getRsNm());
			System.out.println("전화번호: " + vo.getRsPh());
			System.out.println("주소: " + vo.getRsAdrs());
			System.out.println("업데이트일: " + vo.getUpdateDt());
			System.out.println("삭제여부: " + vo.getDeleteKey());
			System.out.println("삭제일: " + vo.getDeleteDt());

		} else {
			System.out.println("조회한 사업자등록번호의 정보가 없습니다.");
		}
		return HomeMenu.REPAIRSHOP.getMenu();
		}

	// 3. 새 정비소 등록
	public int insertRepairShop() throws Exception {
		System.out.println("신규 정비소의 사업자 등록번호를 입력하세요.");
		String bsRgtNum = scanner.nextLine();
		System.out.println("신규 정비소의 명칭을 입력하세요.");
		String rsNm = scanner.nextLine();
		System.out.println("신규 정비소의 전화번호를 입력하세요.");
		String rsPh = scanner.nextLine();
		System.out.println("신규 정비소의 주소를 입력하세요.");
		String rsAdrs = scanner.nextLine();
		int insertRepairShop = repairShopController.insertRepairShop(new RepairShopVO(bsRgtNum, rsNm, rsPh, rsAdrs));

		if (insertRepairShop > 0) {
			System.out.println("정보가 입력되었습니다.");
		} else {
			System.out.println("정보가 입력되지 않았습니다.");
		}
		return HomeMenu.REPAIRSHOP.getMenu();
	}

	// 4. 정비소 정보 수정
	public int updateRepairShop() throws Exception {
		System.out.println("수정할 정비소의 사업자등록번호를 입력하세요");
		String bsRgtNum1 = scanner.nextLine();
		System.out.println("해당 정비소의 새로운 명칭을 입력하세요.");
		String rsNm1 = scanner.nextLine();
		System.out.println("해당 정비소의 새로운 전화번호를 입력하세요.");
		String rsPh1 = scanner.nextLine();
		System.out.println("해당 정비소의 새로운 주소를 입력하세요.");
		String rsAdrs1 = scanner.nextLine();
		int updateRepairShop = repairShopController
				.updateRepairShop(new RepairShopVO(bsRgtNum1, rsNm1, rsPh1, rsAdrs1));
		if (updateRepairShop > 0) {
			System.out.println("정보가 변경되었습니다.");
			repairShopController.getRepairShop(bsRgtNum1);
		} else {
			System.out.println("변경되지 않았습니다.");
		}
		return HomeMenu.REPAIRSHOP.getMenu();
	}

	// 5. 삭제관련 메뉴
	// 삭제관련 메뉴 포맷: 1. 정비소 삭제 | 2. 삭제된 정비소 목록 | 3. 삭제된 정비소 복원 | 4. 정비소 완전삭제");

	// 5-1 정비소 삭제

	public int deleteRepairShop() throws Exception {
		System.out.println("삭제할 정비소의 사업자등록번호를 입력하세요");
		String bsRgtNum2 = scanner.nextLine();
		int deleteRepairShop = repairShopController.deleteRepairShop(new RepairShopVO(bsRgtNum2));
		if (deleteRepairShop > 0) {
			System.out.println("정비소가 삭제되었습니다.");
			repairShopController.getRepairShop(bsRgtNum2);
		} else {
			System.out.println("정비소가 삭제되지 않았습니다.");
		}
		return HomeMenu.DELETE.getMenu();
		}

	// 5-2 삭제된 정비소 목록
	public int repairshopDelList() throws Exception {
		List<RepairShopVO> delList = repairShopController.repairshopDelList();
		for (RepairShopVO delVo : delList) {
			System.out.printf("%20s %20s %20s %20s \n", delVo.getBsRgtNum(), delVo.getRsNm(),
					delVo.getRsPh(), delVo.getRsAdrs());
		}
		return HomeMenu.DELETE.getMenu();
		}

	// 5-3 삭제된 정비소 복원
	public int ReDeleteRepairShop() throws Exception {
		System.out.println("복원할 정비소의 사업자등록번호를 입력하세요");
		String bsRgtNum2 = scanner.nextLine();
		int ReDeleteRepairShop = repairShopController.ReDeleteRepairShop(new RepairShopVO(bsRgtNum2));
		if (ReDeleteRepairShop > 0) {
			System.out.println("정비소가 복원되었습니다.");
			repairShopController.getRepairShop(bsRgtNum2);
		} else {
			System.out.println("정비소가 복원되지 않았습니다.");
		}
		return HomeMenu.DELETE.getMenu();
		}

	// 5-4 정비소 완전 삭제(데이터 딜리트)
	public int ComDeleteRepairShop() throws Exception {
		System.out.println("완전 삭제할 정비소의 사업자등록번호를 입력하세요");
		String bsRgtNum2 = scanner.nextLine();
		int ComdeleteRepairShop = repairShopController.ComDeleteRepairShop(new RepairShopVO(bsRgtNum2));
		if (ComdeleteRepairShop > 0) {
			System.out.println("정비소가 완전삭제되었습니다.");
			repairShopController.getRepairShop(bsRgtNum2);
		} else {
			System.out.println("정비소가 삭제되지 않았습니다.");
		}
		return HomeMenu.DELETE.getMenu();
	}
	/* ============================================================================ */
	
	public int rentApplication() throws Exception {
		System.out.println("====================================================================");
		System.out.println("1. 서울 2. 대전 3. 부산 4. 광주 5. 울산");
		System.out.println("이용하실 지점을 선택해 주세요.(1~5) ");
		String branchId = scanner.nextLine();
		switch (branchId) {
			case "1":
				branchId = "BRANCH_S";
				break;
			case "2":
				branchId = "BRANCH_D";
				break;
			case "3":
				branchId = "BRANCH_B";
				break;
			case "4":
				branchId = "BRANCH_G";
				break;
			case "5":
				branchId = "BRANCH_U";
				break;
		}
		System.out.println("시작날짜를 선택해 주세요.(yyyymmdd 8자리 숫자)");
		String rentStartDt = scanner.nextLine();
		System.out.println("이용하실 기간을 정해주세요.(단위: 일) ");
		int days = Integer.parseInt(scanner.nextLine());
		List<RentalVO> list = rentalController.selectList(branchId, rentStartDt, days);
		if(list != null) {
			for (int i = 0; i < list.size(); i++) {
				RentalVO vo1 = list.get(i);
				System.out.printf(i+1 +" %10s %10s %,10d원 %10s %10s \n", vo1.getMdNm(), vo1.getMdSize(), vo1.getMdRentFee(), vo1.getMdFuel(), vo1.getMdId());
			}
		} else {
			System.out.println("이용 가능한 차량이 없습니다.");
		}
		System.out.println("이용하실 차량 모델을 선택해 주세요.(숫자)");
		String inputNum = scanner.nextLine();
		String mdId = list.get(Integer.parseInt(inputNum) - 1).getMdId();
		System.out.println("보험 여부를 선택해 주세요");
		System.out.println("1: 보험 선택 2: 보험 미선택");
		int rentInsurance = Integer.parseInt(scanner.nextLine());
		System.out.println(branchId);
		System.out.println(rentStartDt);
		System.out.println(days);
		System.out.println(mdId);
		System.out.println(rentInsurance);
		RentalVO vo = new RentalVO();
		vo.setMdId(mdId);
		vo.setRentInsurance(rentInsurance);
		vo.setBranchId(branchId);
		vo.setRentStartDt(rentStartDt);
		vo.setDays(days);
		int result = rentalController.rentReservation(vo);
		if (result > 0) {
			System.out.println("신청이 완료되었습니다.");
		} else {
			System.out.println("입력이 잘못되었습니다. 다시 입력해 주세요");
		}
		
		if(session.getMemLv() == 0) {			
			return HomeMenu.RENTAL_ADM.getMenu();		
		} else {
			return HomeMenu.RENTAL_USER.getMenu();
		}
	}
	
	public int selectRent() throws Exception {
		System.out.println("조회할 아이디를 입력하세요> ");
        String searchId = scanner.nextLine();
        List<RentalVO> list1 = rentalController.selectRent(searchId);
        if(list1 != null) {
        	for (int i = 0; i < list1.size(); i++) {
        		RentalVO vo = list1.get(i);
        		System.out.println("==================================");
			   	System.out.println("아이디: "+vo.getMemId());
			   	System.out.println("대여시작일: "+vo.getRentStartDt());
			   	System.out.println("반납일: "+vo.getRentEndDt());
			   	System.out.println("(1: 보험 선택 2: 보험 미선택)\n보험 여부: "+vo.getRentInsurance());
			   	System.out.println("차량 번호: "+vo.getCarNum());
			   	System.out.println("매니저 ID: "+vo.getManagerId());
			   	System.out.println("렌트비: "+vo.getRentFee());
			   	System.out.println("지점: "+vo.getBranchId());
			   	System.out.println("모델: "+vo.getMdNm());
			   	System.out.println("==================================");
        	} 
        } else {
 	   		System.out.println("예약 내역이 없습니다.");
 	   	}
        if(session.getMemLv() == 0) {			
			return HomeMenu.RENTAL_ADM.getMenu();		
		} else {
			return HomeMenu.RENTAL_USER.getMenu();
		}
	}
	
	public int cencleRental() throws Exception {
		System.out.println("예약취소할 아이디를 입력하세요.");
		String memId = scanner.nextLine();
		System.out.println("예약취소할 차량 번호를 입력하세요.");
		String carNum = scanner.nextLine();
		RentalVO vo = new RentalVO();
		vo.setMemId(memId);
		vo.setCarNum(carNum);
		int result = rentalController.cencleRental(vo);
		if (result > 0) {
			System.out.println("예약이 취소 되었습니다.");
		}
		if(session.getMemLv() == 0) {			
			return HomeMenu.RENTAL_ADM.getMenu();		
		} else {
			return HomeMenu.RENTAL_USER.getMenu();
		}
	}
	
	public int returnCar() throws Exception {
		System.out.println("반납할 아이디를 입력하세요.");
		String memId = scanner.nextLine();
		System.out.println("반납할 차량 번호를 입력하세요.");
		String CarNum = scanner.nextLine();
		RentalVO vo = new RentalVO();
		vo.setMemId(memId);
		vo.setCarNum(CarNum);
		int result = rentalController.returnCar(vo);
		if (result > 0) {
			System.out.println("반납이 완료되었습니다.");
		} 
		if(session.getMemLv() == 0) {			
			return HomeMenu.RENTAL_ADM.getMenu();		
		} else {
			return HomeMenu.RENTAL_USER.getMenu();
		}
	}
	
	public int selectRentalApplication() throws Exception {
		System.out.println("조회할 아이디를 입력하세요> ");
		String selectId = scanner.nextLine();
    
		RentalVO vo = rentalController.selectRentalApplication(selectId);
		
		if (vo != null) {
			System.out.println("아이디: " + vo.getMemId());
			System.out.println("대여시작일 : " + vo.getRentStartDt());
			System.out.println("반납일 : " + vo.getRentEndDt());
			System.out.println("보험 여부: " + vo.getRentInsurance());
			System.out.println("차량 모델: " + vo.getMdNm());
			System.out.println("렌트비: " + vo.getRentFee());
			System.out.println("지점: " + vo.getBranchId());
		} else {
			System.out.println("조회한 아이디 정보가 없습니다.");
		}
		if(session.getMemLv() == 0) {			
			return HomeMenu.RENTAL_ADM.getMenu();		
		} else {
			return HomeMenu.RENTAL_USER.getMenu();
		}
	}
	
	public int approvalRent() throws Exception {
		System.out.println("승인할 아이디를 입력하세요> ");
		String memId = scanner.nextLine();
		System.out.println("배정할 차량 번호를 입력하세요.");
		String carNum = scanner.nextLine();
		System.out.println("배정할 매니저 ID를 입력하세요.");
		String managerId = scanner.nextLine();
		RentalVO vo = new RentalVO();
		System.out.println("확인");
		vo.setMemId(memId);
		vo.setCarNum(carNum);
		vo.setManagerId(managerId);
		int result = rentalController.approvalRent(vo);
		if(result > 0) {			
			System.out.println("렌트가 승인 되었습니다.");
		} else {
			System.out.println("렌트 승인이 실패하였습니다.");
		}
		if(session.getMemLv() == 0) {			
			return HomeMenu.RENTAL_ADM.getMenu();		
		} else {
			return HomeMenu.RENTAL_USER.getMenu();
		}
	}
	
	public int confirmCar() throws Exception {
		System.out.println("반납확인할 고객아이디를 입력하세요.");
		String memId = scanner.nextLine();
		System.out.println("반납확인할 차량 번호를 입력하세요.");
		String carNum = scanner.nextLine();
		System.out.println("반납후 누적주행거리를 입력하세요.");
		int carTotalKm = Integer.parseInt(scanner.nextLine());
		System.out.println("파손이 있습니까? (3:있다 0:없다)");
		int carStatus = Integer.parseInt(scanner.nextLine());
		
		RentalVO vo = new RentalVO();
		vo.setMemId(memId);
		vo.setCarNum(carNum);
		vo.setCarTotalKm(carTotalKm);
		vo.setCarStatus(carStatus);
		int result = rentalController.confirmCar(vo); 
		if(result > 0) {			
			System.out.println("반납확인이 완료 되었습니다.");
		} else {
			System.out.println("반납을 실패하었습니다. 다시 시도해주세요.");
		}
		if(session.getMemLv() == 0) {			
			return HomeMenu.RENTAL_ADM.getMenu();		
		} else {
			return HomeMenu.RENTAL_USER.getMenu();
		}
	}
	
}
