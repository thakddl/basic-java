package kim.chopper.bookstore.sign;

import kim.chopper.bookstore.BookstoreApplication;
import kim.chopper.bookstore.join.CustomerVO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SignDAO {
    private static SignDAO instance = new SignDAO();
    public static SignDAO getInstance() {
        return instance;
    }
    private SignDAO() {}

    private JdbcTemplate template = BookstoreApplication.getTemplate();

    public CustomerVO findUser(CustomerVO vo) {
        try {
            return template.queryForObject("SELECT CUST_ID, PASSWORD, NAME, ADDRESS, PHONE FROM CUSTOMER WHERE CUST_ID = ? AND PASSWORD = ?", new BeanPropertyRowMapper<>(CustomerVO.class), vo.getCustId(), vo.getPassword());
        } catch (DataAccessException e) {
            return null;
        }
    }
}
