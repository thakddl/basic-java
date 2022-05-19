package kim.chopper.bookstore.join;

import kim.chopper.bookstore.BookstoreApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class JoinDAO {
    private static JoinDAO instance = new JoinDAO();
    public static JoinDAO getInstance() {
        return instance;
    }
    private JoinDAO() {}

    private JdbcTemplate template = BookstoreApplication.getTemplate();

    public CustomerVO findCustomer(int custId) {
        return template.queryForObject("SELECT CUST_ID, NAME, ADDRESS, PHONE FROM CUSTOMER WHERE CUST_ID = ?", new BeanPropertyRowMapper<>(CustomerVO.class), custId);
    }

    public int join(CustomerVO vo) {
        return template.update("INSERT INTO CUSTOMER (CUST_ID, NAME, ADDRESS, PHONE, PASSWORD) VALUES (?, ?, ?, ?, ?)", vo.getCustId(), vo.getName(), vo.getAddress(), vo.getPhone(), vo.getPassword());
    }

    public int modifyName(CustomerVO vo) {
        return template.update("UPDATE CUSTOMER SET NAME = ? WHERE CUST_ID = ?", vo.getName(), vo.getCustId());
    }

    public int modifyAddress(CustomerVO vo) {
        return template.update("UPDATE CUSTOMER SET ADDRESS = ? WHERE CUST_ID = ?", vo.getAddress(), vo.getCustId());
    }

    public int modifyPhone(CustomerVO vo) {
        return template.update("UPDATE CUSTOMER SET PHONE = ? WHERE CUST_ID = ?", vo.getPhone(), vo.getCustId());
    }

    public int modifyPassword(CustomerVO vo) {
        return template.update("UPDATE CUSTOMER SET PASSWORD = ? WHERE CUST_ID = ?", vo.getPassword(), vo.getCustId());
    }
}
