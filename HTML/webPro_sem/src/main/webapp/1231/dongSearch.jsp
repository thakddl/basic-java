<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String vdong = request.getParameter("dong");

  Class.forName("oracle.jdbc.driver.OracleDriver");
  String url = "jdbc:oracle:thin:@localhost:1521:xe";
  Connection con = DriverManager.getConnection(url, "shin", "java");
  Statement stmt = con.createStatement();
  String sql = "select * from ziptb where dong like '" + vdong + "%'";
  ResultSet rs = stmt.executeQuery(sql);
%>  
[
<% 
	int i = 0;
	while(rs.next()){
		String zip = rs.getString("zipcode");
		String sido = rs.getString("sido");
		String gugun = rs.getString("gugun");
		String dong = rs.getString("dong");
		String bunji = rs.getString("bunji");
		
		//bunji 데이터 값이 null일때 공백처리
		if(bunji == null) bunji = "";
		if(i>0) out.print(",");
%>
		{
			"code"	: "<%=zip %>",
			"addr"	: "<%=sido %><%=gugun %><%=dong %>",
			"bunji" : "<%=bunji %>"
		}
<%
		i++;
	}//while end
%>
]