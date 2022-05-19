package rentcar;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import oracle.jdbc.pool.OracleDataSource;
import rentcar.join.MemberVO;

public class RentCarApplication {
    private static MemberVO session = new MemberVO();
    private static JdbcTemplate template = new JdbcTemplate();

    public static void main(String[] args) {
        new Home().initialize();
    }
    

    public static MemberVO getSession() {
        return session;
    }
    public static JdbcTemplate getTemplate() {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL("jdbc:oracle:thin:@192.168.44.15:1521:xe");
            dataSource.setUser("BASIC");
            dataSource.setPassword("java");
            template.setDataSource(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return template;
    }
}
