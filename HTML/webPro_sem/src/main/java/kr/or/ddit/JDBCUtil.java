package kr.or.ddit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DB에 접근하기 위한 Connection객체를 생성하기 위해 정보를 등록
//1. Java와의 연결을 위한 DataBase가 설치되어 있어야 한다
//2. Java에서 DB를 사용하려면 JDBC드라이버(=연결을 위한 라이브러리, ojdbc.jar)가 필요
public class JDBCUtil {
	
	public static Connection conn;

	//생성자를 만들지 않고 static영역에 최초 한번만 드라이버를 생성하고 공유하여 사용
	//public JDBCUtil() {
	//static {} : 클래스 초기화 블록. 클래스가 로딩될 때 처음 한번만 실행
	static {
		//3. 드라이버 로딩을 위한 코드 Class.forName() 메소드로 DriverManager생성
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//DB Connection 연결 메소드 생성
	public static Connection getConn() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			//4. DriverManager클래스는 JDBC드라이버를 통해 Connection 객체를 만든다
			//5. Dao에서 getConn()메소드를 호출해서 sql을 실행할 수 있다
			conn = DriverManager.getConnection(url, "sem", "java");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//생성된 Connection객체 닫기
	/*
	 * -생성 후 반환(close)하지 않으면 자원의 낭비가 발생하고,
	 *  일정 수 이상 발생시 더이상 생성이 불가하다.
	 * -Connection만 close하더라도 나머지 객체들이 자동 반환되지만,
	 *  각 드라이버마다 다른 동작이 발생할 수 있으므로 역순 반환하도록 한다
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}







}
