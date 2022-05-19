package kim.chopper.bookstore;

import kim.chopper.bookstore.book.BookController;
import kim.chopper.bookstore.common.HomeMenu;
import kim.chopper.bookstore.common.ScannerUtil;
import kim.chopper.bookstore.join.CustomerVO;
import kim.chopper.bookstore.join.JoinController;
import kim.chopper.bookstore.order.OrderController;
import kim.chopper.bookstore.sign.SignController;

import java.util.Scanner;

public class BookStoreView {
    private static BookStoreView instance = new BookStoreView();
    private BookStoreView() {}
    public static BookStoreView getInstance() {
        return instance;
    }

    private Scanner scanner = ScannerUtil.scanner();

    public int init() {
        System.out.println("쵸파 북스토어에 오신 것을 환영합니다!");
        System.out.print(HomeMenu.HOME.getMenuString());
        return scanner.nextInt();
    }

    public int getMenu() {
        return scanner.nextInt();
    }

    public int join(JoinController controller) {
        int number;
        System.out.print("아이디: ");
        int custId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("주소: ");
        String address = scanner.nextLine();
        System.out.print("전화번호: ");
        String phone = scanner.nextLine();
        System.out.print("패스워드: ");
        String password = scanner.nextLine();
        number = controller.join(new CustomerVO(custId, name, address, phone, password));
        if (number == HomeMenu.HOME.getMenu()) {
            System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
        } else {
            System.out.print("회원 가입 실패! 다시 회원가입을 하시겠습니까?(y 또는 n을 입력): ");
            String inputFlag = scanner.nextLine();
            if (inputFlag.equalsIgnoreCase("y")) {
                number = HomeMenu.JOIN.getMenu();
            } else {
                number = HomeMenu.HOME.getMenu();
            }
        }
        return number;
    }
    public int login(SignController controller) {
        int number;
        System.out.print("아이디: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("패스워드: ");
        String userPw = scanner.nextLine();
        CustomerVO vo = controller.signIn(new CustomerVO(userId, userPw));
        if (vo != null) {
            System.out.println(vo.getName() + "님 로그인되었습니다.");
            number = HomeMenu.MAIN.getMenu();
        } else {
            System.out.println("로그인 정보가 일치하지 않습니다. 아이디와 비밀번호를 확인하세요.");
            number = HomeMenu.HOME.getMenu();
        }
        return number;
    }

    public int order(OrderController controller) {
        controller.findAll().forEach(orderVO -> {
            System.out.printf("%d\t%s\t%d\t%s\n", orderVO.getOrderId(), orderVO.getBookName(), orderVO.getSalePrice(), orderVO.getOrderDate());
        });
        return HomeMenu.MAIN.getMenu();
    }

    public int getBookList(BookController controller) {
        controller.selectBookList("").forEach(bookVO -> {
            System.out.printf("%d\t%s\t%s\t%d\n", bookVO.getBookId(), bookVO.getBookName(), bookVO.getPublisher(), bookVO.getPrice());
        });
        return HomeMenu.BOOK.getMenu();
    }

    public int searchBook(BookController controller) {
        // scanner의 nextInt()와 nextLine() 사이의 줄바꿈 특수문자 제거를 해줌
        scanner.nextLine();
        String searchWord = scanner.nextLine();
        controller.selectBookList(searchWord).forEach(bookVO -> {
            System.out.printf("%d\t%s\t%s\t%d\n", bookVO.getBookId(), bookVO.getBookName(), bookVO.getPublisher(), bookVO.getPrice());
        });
        return HomeMenu.BOOK.getMenu();
    }

    public int getCustomerInfo(JoinController controller) {
        CustomerVO customer = controller.findCustomer();
        System.out.printf("아이디: %d\n", customer.getCustId());
        System.out.printf("이름: %s\n", customer.getName());
        System.out.printf("주소: %s\n", customer.getAddress());
        System.out.printf("휴대전화번호: %s\n", customer.getPhone());
        return HomeMenu.CUSTOMER.getMenu();
    }

    public int modifyInfo(JoinController controller, HomeMenu menu) {
        scanner.nextLine();
        int resultName = controller.modifyInfo(scanner.nextLine(), menu);
        if (resultName == 1) {
            System.out.println("정상적으로 수정되었습니다.");
        }
        return HomeMenu.CUSTOMER.getMenu();
    }

    public int changePassword(JoinController controller) {
        scanner.nextLine();
        String newPassword = scanner.nextLine();
        System.out.print("비밀번호 확인을 위해 다시 한번 입력해주세요: ");
        String confirmPassword = scanner.nextLine();
        if (newPassword.equals(confirmPassword)) {
            controller.modifyPassword(confirmPassword);
            System.out.println("비밀번호가 변경되었습니다.");
        } else {
            System.out.println("비밀번호가 일치하지 않습니다. 비밀번호 변경을 취소합니다.");
        }
        return HomeMenu.CUSTOMER.getMenu();
    }

}
