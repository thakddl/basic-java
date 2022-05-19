<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String memId = request.getParameter("mId");

  Class.forName("oracle.jdbc.driver.OracleDriver");
  String url = "jdbc:oracle:thin:@localhost:1521:xe";
  Connection con = DriverManager.getConnection(url, "shin", "java");
  Statement stmt = con.createStatement();
  String sql = "select mem_id from member where mem_id = '" + memId + "'";
  ResultSet rs = stmt.executeQuery(sql);
  if(rs.next()){
%>	  {
	  	"cd"  : "no",
	  	"str" : "사용불가"
	  }
<%  }else{//조회하는 id 없음 %>
	  {
	  	"cd"  : "ok",
	  	"str" : "사용가능"
	  }
<%  }//if-else end %>