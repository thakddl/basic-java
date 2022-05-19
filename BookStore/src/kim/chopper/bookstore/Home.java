package kim.chopper.bookstore;

import kim.chopper.bookstore.book.BookController;
import kim.chopper.bookstore.common.HomeMenu;
import kim.chopper.bookstore.common.MenuNotFoundException;
import kim.chopper.bookstore.join.JoinController;
import kim.chopper.bookstore.order.OrderController;
import kim.chopper.bookstore.sign.SignController;

public class Home {
    private JoinController joinController = JoinController.getInstance();
    private BookController bookController = BookController.getInstance();
    private SignController signController = SignController.getInstance();
    private OrderController orderController = OrderController.getInstance();

    private BookStoreView view = BookStoreView.getInstance();

    public void initialize() {
        home(view.init());
    }
    private void home(int number) {
        loop:
        while (true) {
            try {
                HomeMenu menu = HomeMenu.findMenu(number);
                System.out.print(menu.getMenuString());
                switch (menu) {
                    case HOME:
                    case MAIN:
                    case BOOK:
                    case CUSTOMER:
                    case CUSTOMER_MODIFY_INFO:
                        number = view.getMenu();
                        break;
                    case JOIN:
                        number = view.join(joinController);
                        break;
                    case LOGIN:
                        number = view.login(signController);
                        break;
                    case LOGOUT:
                        number = signController.signOut();
                        break;
                    case BOOK_LIST:
                        number = view.getBookList(bookController);
                        break;
                    case BOOK_SEARCH:
                        number = view.searchBook(bookController);
                        break;
                    case ORDER:
                        number = view.order(orderController);
                        break;
                    case CUSTOMER_INFO:
                        number = view.getCustomerInfo(joinController);
                        break;
                    case MODIFY_NAME:
                    case MODIFY_ADDRESS:
                    case MODIFY_PHONE:
                        number = view.modifyInfo(joinController, menu);
                        break;
                    case CUSTOMER_MODIFY_PASSWORD:
                        number = view.changePassword(joinController);
                        break;
                    case QUIT:
                        break loop;
                }
            } catch (MenuNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.print(HomeMenu.HOME.getMenuString());
            }
            System.out.println();
        }
    }
}