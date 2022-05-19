package kim.chopper.bookstore.common;

import java.util.Scanner;

public enum HomeMenu {
    HOME(-1, "8.로그인\t2.회원가입\t0.프로그램 종료\n메뉴를 선택하세요: "),
    QUIT(0, "프로그램을 종료합니다!\n이용해주셔서 감사합니다~\n"),
    MAIN(1, "3.책 정보\t4.주문내역\t5.고객정보\t9.로그아웃\t0.프로그램 종료\n메뉴를 선택하세요: "),
    JOIN(2, "회원가입에 필요한 정보를 입력합니다.\n"),
    BOOK(3, "31.책 목록\t32.책 검색\t1.이전메뉴\t9.로그아웃\t0.프로그램 종료\n메뉴를 선택하세요: "),
    ORDER(4, "주문 내역\n"),
    CUSTOMER(5, "51.개인정보확인\t52.개인정보수정\t53.패스워드변경\t1.이전메뉴\t9.로그아웃\t0.프로그램 종료\n메뉴를 선택하세요: "),
    LOGIN(8, "아이디와 비밀번호를 입력하세요.\n"),
    LOGOUT(9, "로그아웃 되었습니다!\n"),
    BOOK_LIST(31, "전체 책 목록\n"),
    BOOK_SEARCH(32, "검색할 책 제목을 입력하세요: "),
    CUSTOMER_INFO(51, "개인정보 확인\n"),
    CUSTOMER_MODIFY_INFO(52, "521.이름\t522.주소\t523.휴대전화번호\t5.이전메뉴\n수정할 항목을 선택하세요: "),
    MODIFY_NAME(521, "이름 수정\n변경할 이름을 입력하세요: "),
    MODIFY_ADDRESS(522, "주소 수정\n변경할 주소를 입력하세요: "),
    MODIFY_PHONE(523, "휴대전화번호 수정\n변경할 휴대전화번호를 입력하세요: "),
    CUSTOMER_MODIFY_PASSWORD(53, "패스워드 변경\n변경할 패스워드를 입력하세요: ");

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
        for (HomeMenu menu: values()) {
            if (menu.getMenu() == number) {
                return menu;
            }
        }
        throw new MenuNotFoundException("선택하신 메뉴가 없습니다.");
    }
    public void display(Scanner scanner) {

    }
}
