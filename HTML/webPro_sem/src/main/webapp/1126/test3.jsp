<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String txtarea = request.getParameter("ta");
	String[] car = request.getParameterValues("cars");
	
	//개행문자(\r\n)을 <br>태그로 변경하여 줄바꿈 처리
	txtarea = txtarea.replace("\r","").replace("\n","<br>");
	
	String cars = "";
	for(int i=0; i<car.length; i++){
		cars += car[i] + " ";
	}
%>

<%=txtarea %> <br>
<%=cars %>
</body>
</html>