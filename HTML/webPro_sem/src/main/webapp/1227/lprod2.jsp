<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 1. 드라이버 등록하기 - Class.forName() 메소드로 DriveManager에 오라클 드라이버 등록
Class.forName("oracle.jdbc.driver.OracleDriver");

// 2. DriverManager를 통해 Connection객체 생성하고 정보 설정
String url = "jdbc:oracle:thin:@localhost:1521:xe";
Connection conn = DriverManager.getConnection(url, "shin", "java");

// 3. sql문장 실행을 위한 객체 생성 - statement - DB에 쿼리를 보내기 위해 필요
// statement객체를 사용하기 위해 Connection객체가 먼저 존재해야 한다
Statement stmt = conn.createStatement();

// 4. sql작성
String sql = "select * from lprod";

// 5. 실행 - executeQuery를 통해 실행하고 ResultSet 타입으로 결과를 반환받음
ResultSet rs = stmt.executeQuery(sql);

// 6. 결과 처리
// html 형태로 데이터 생성 후 전달
%>
<table border="1">
  <tr class="tr">
    <td>아이디</td>
    <td>지유</td>
    <td>앤엠</td>
  </tr>
<%
while(true){
	if(!rs.next()) break;
	String id = rs.getString("lprod_id");
	String gu = rs.getString("lprod_gu");
	String nm = rs.getString("lprod_nm");
%>
  <tr>
    <td><%=id %></td>
    <td><%=gu %></td>
    <td><%=nm %></td>
  </tr>
<%
} //while end
%>
</table>
