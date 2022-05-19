package kim.chopper.bookstore.order;

import java.util.List;

public class OrderService {
    private static OrderService instance = new OrderService();
    public static OrderService getInstance() {
        return instance;
    }
    private OrderService() {}

    private OrderDAO dao = OrderDAO.getInstance();

    public List<OrderVO> findAll(int custId) {
        return dao.findAll(custId);
    }
}
