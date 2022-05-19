package kr.or.ddit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Dao {
	
	private Connection conn;
	//싱글톤패턴 특징1. private Constructor
	private static Dao dao;
	
	private Dao() {} //생성자를 private하게 

	//싱글톤 패턴을 활용해서 객체를 1회만 생성하고 공유하여 사용
	//싱글톤 패턴 : 시스템에 객체를 단 한번만 생성하고 그 객체를 어디서든 접근해 사용하는 패턴
	//싱글톤패턴 특징2. static method
	public static Dao getInstance() {
		if(dao == null) {
			dao = new Dao();  //최초 1회만 new연산자를 통해 객체를 메모리에 할당
		}
		return dao;
	}
	
	//요청데이터를 이용해 상세정보를 조회하는 메소드
	//접근제한자 리턴타입 메소드명(매개변수)
	public Map<String, Object> selectMemberOne(String name){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String sql = "select * from member where mem_name = '" + name + "'";
		
		conn = JDBCUtil.getConn();
		//statement : sql에 접근하여 구문을 실행하는 역할
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				map.put("id", rs.getString("mem_id"));
				map.put("name", rs.getString("mem_name"));
				map.put("hp", rs.getString("mem_hp"));
				map.put("mail", rs.getString("mem_mail"));
			}
			JDBCUtil.close(conn, stmt, rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	
	
	
	
	
	
}
