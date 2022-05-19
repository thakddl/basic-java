package kim.chopper.bookstore;

import kim.chopper.bookstore.join.CustomerVO;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

import java.sql.SQLException;

public class BookstoreApplication {
    private static CustomerVO session = new CustomerVO();
    private static JdbcTemplate template = new JdbcTemplate();

    public static void main(String[] args) {
        new Home().initialize();
    }

    public static CustomerVO getSession() {
        return session;
    }
    public static JdbcTemplate getTemplate() {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL("jdbc:oracle:thin:@chopper.kim:1521:xe");
            dataSource.setUser("c##madang");
            dataSource.setPassword("madang");
            template.setDataSource(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return template;
    }
}
