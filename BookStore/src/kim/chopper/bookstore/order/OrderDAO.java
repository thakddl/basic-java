package kim.chopper.bookstore.order;

import kim.chopper.bookstore.BookstoreApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderDAO {
    private static OrderDAO instance = new OrderDAO();
    public static OrderDAO getInstance() {
        return instance;
    }
    private OrderDAO() {}

    private JdbcTemplate template = BookstoreApplication.getTemplate();

    public List<OrderVO> findAll(int custId) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT A.ORDER_ID, A.BOOK_ID, B.BOOK_NAME, A.SALE_PRICE, A.ORDER_DATE\n");
        builder.append("FROM ORDERS A\n");
        builder.append("         INNER JOIN BOOK B\n");
        builder.append("                    ON (A.BOOK_ID = B.BOOK_ID)\n");
        builder.append("WHERE A.CUST_ID = ?\n");
        builder.append("ORDER BY A.ORDER_DATE");
        return template.query(builder.toString(), new BeanPropertyRowMapper<>(OrderVO.class), custId);
    }
}
