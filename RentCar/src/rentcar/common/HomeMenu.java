package rentcar.common;

import java.util.Scanner;

public enum HomeMenu {
	HOME(-1, "8.로그인 2.회원가입 0.프로그램 종료\n메뉴를 선택하세요: "),
	QUIT(0, "프로그램을 종료합니다!\n이용해주셔서 감사합니다~\n"),
	MAIN_USER(1, "5.고객정보 801.렌트예약 9.로그아웃 0.프로그램 종료\n메뉴를 선택하세요: "),
	MAIN_ADM(6, "20.보유차량관리 30.모델정보 40.차량정비 60.정비소관리 70.정비소 제휴관리 80.렌트관리 7.고객정보 11.지점정보 9.로그아웃 0.프로그램 종료\n메뉴를 선택하세요: "),
	JOIN(2, "회원가입에 필요한 정보를 입력합니다.\n"),
	MEMBER(5, "51.개인정보확인 52.개인정보수정 53.패스워드변경 99.회원탈퇴 1.이전메뉴 9.로그아웃 0.프로그램 종료\n메뉴를 선택하세요: "),
	MEMBER_ADM(7, "51.개인정보확인 52.개인정보수정 53.패스워드변경 54.회원정보조회 55.회원권한수정 6.이전메뉴 9.로그아웃 0.프로그램 종료\n메뉴를 선택하세요: "),
	WITHDRAWL(99, "회원탈퇴\n"),
	LOGIN(8, "아이디와 비밀번호를 입력하세요.\n"),
	LOGOUT(9, "로그아웃 되었습니다!\n"),
	MEMBER_INFO(51, "개인정보 확인\n"),
	MEMBER_MODIFY_INFO(52, "521.이름 522.주소 523.전화번호\t5.이전메뉴\n수정할 항목을 선택하세요: "),
	MODIFY_NAME(521, "이름 수정\n변경할 이름을 입력하세요: "),
	MODIFY_ADDRESS(522, "주소 수정\n변경할 주소를 입력하세요: "),
	MODIFY_PHONE(523, "전화번호 수정 \n변경할 전화번호를 입력하세요: "),
	MEMBER_MODIFY_PASSWORD(53, "패스워드 변경\n변경할 패스워드를 입력하세요: "),	
	GET_MEMBER_INFO(54, "회원정보 조회\n조회할 회원아이디를 입력하세요: "),
	MODIFY_MEMLV(55, "회원권한수정\n수정할 회원아이디를 입력하세요: "),
    BRANCH_ADM(11, "111.지점정보확인 112.지점정보수정 113.신규지점등록 114.지점정보삭제 6.이전메뉴\n메뉴를 선택하세요.: "),
    BRANCH_INFO(111, "지점정보를 확인합니다.\n확인할 지점명을 입력하세요.: "),
    BRANCH_MODIFY_INFO(112, "수정할 목록을 선택하세요\n1021.지점명 1022.지점주소 1023.지점전화번호 101.이전메뉴\n메뉴를 선택하세요.: "),
	MODIFY_BRANCHNM(1121, "지점명 수정\n변경할 지점명을 입력하세요: "),
	MODIFY_BRANCHADRS(1122, "지점주소 수정\n변경할 지점주소를 입력하세요.: "),
	MODIFY_BRANCHPH(1123, "지점전화번호 수정\n변경할 지점전화번호를 입력하세요.: "),
	INSERT_BRANCH(113, "신규지점을 등록합니다.\n신규지점 등록에 필요한 정보를 입력하세요.\n"),
	DELETE_BRANCH(114, "지점정보를 삭제합니다.\n삭제할 지점의 지점코드를 입력하세요.: "),
	//===============================================================================
	CAR(20, "21.보유차량조회 22.차량정보조회 23.신규차량등록 24.차량정보수정 25.차량상태정보수정 26.차량정보삭제 6.이전메뉴\n메뉴를 선택하세요.: "),
	CAR_LIST(21, "21.보유차량조회\n"),
	CAR_INFO(22, "22.차량정보조회\n"),
	CAR_INSERT(23, "23.신규차량등록\n"),
	CAR_UPDATE(24, "24.차량정보수정\n"),
	CAR_STATUS(25, "25.차량상태정보수정\n"),
	CAR_DELETE(26, "26.차량정보삭제\n"),
	MODEL(30, "31.모델종류조회 32.모델정보조회 33.신규모델등록 34.모델정보수정 35.모델정보삭제 6.이전메뉴\n메뉴를 선택하세요.: "),
	MODEL_LIST(31, "31.모델종류조회\n"),
	MODEL_INFO(32, "32.모델정보조회\n"),
	MODEL_INSERT(33, "33.신규모델등록\n"),
	MODEL_UPDATE(34, "34.모델정보수정\n"),
	MODEL_DELETE(35, "35.모델정보삭제\n"),
	//===============================================================================
	REPAIR(40, "41.정비필요차량 조회 42.정비중인 차량 조회 43.정비내역 조회 44.세부정비내역 조회 45.차량출고(지점->정비소) 47. 정비기록 삭제 6.이전메뉴\n메뉴를 선택하세요.: "),
	REPAIR_REQUIRED_CAR(41, "41.정비필요차량 조회\n"),
	REPAIR_ING_CAR(42, "42.정비중인 차량 조회\n"),
	REPAIR_RECORD(43, "43.정비내역 조회\n"),
	REPAIR_DETAIL_RECORD(44, "44.세부정비내역 조회\n"),
	REPAIR_OUTPUT_CAR(45, "45.차량 출고(지점->정비소)\n"),
	REPAIR_INCOME_CAR(46, "46.차량 입고(정비소->지점)\n"),
	REPAIR_CAR_DELETE(47, "47.정비기록 삭제\n"),
	REPAIRSHOP(60, "61.정비소 목록 62.정비소 상세 63. 새 정비소 등록 64.정비소 정보수정\n메뉴를 선택하세요: "),
	REPAIRSHOP_LIST(61, "61.정비소 목록\n"),
	REPAIRSHOP_DETAIL(62, "62.정비소 상세\n"),
	REPAIRSHOP_INSERT(63, "63.새 정비소 등록\n"),
	REPAIRSHOP_UPDATE(64, "64.정비소 정보수정\n"),
	DELETE(70, "71.정비소 삭제 72.삭제된 정비소 목록 73.삭제된 정비소 복원 74.정비소 이력 완전삭제\n메뉴를 선택하세요: "),
	DELETE_SHOP(71, "71.정비소 삭제\n"),
	DELETE_LIST(72, "72.삭제된 정비소 목록\n"),
	DELETE_RESTORE(73, "73.삭제된 정비소 복원\n"),
	DELETE_SHOP_PERFECT(74, "74.정비소 이력 완전삭제\n"),
	//===============================================================================
	RENTAL_ADM(80, "81. 렌트신청 83.예약취소 84.렌트카 반납 85.렌트신청조회(관리자) 86.렌트신청승인 87.반납여부확인\n메뉴를 선택하세요: "),
	RENTAL_USER(801, "81. 렌트신청 82.렌트신청조회(사용자) 83.예약취소 84.렌트카 반납\n"),
	RENTAL_RESERVE(81, "81. 렌트신청\n"),
	RENTAL_SELECT_USER(82, "82. 렌트신청조회(사용자)\n"),
	RENTAL_RESERVE_CANCLE(83, "83. 예약취소\n"),
	RENTAL_RETURN(84, "84. 렌트카 반납\n"),
	RENTAL_SELECT_ADM(85, "85. 렌트신청조회(관리자)\n"),
	RENTAL_APPROVAL_ADM(86, "86. 렌트신청승인\n"),
	RENTAL_CONFIRM(87, "87. 반납여부확인\n");
	
	private final int menu;
	private final String menuString;

	HomeMenu(int menu, String menuString) {
		this.menu = menu;
		this.menuString = menuString;
	}

	public int getMenu() {
		return menu;
	}

	public String getMenuString() {
		return menuString;
	}

	public static HomeMenu findMenu(int number) throws MenuNotFoundException {
		for (HomeMenu menu : values()) {
			if (menu.getMenu() == number) {
				return menu;
			}
		}
		throw new MenuNotFoundException("선택하신 메뉴가 없습니다.");
	}

	public void display(Scanner scanner) {}
}
