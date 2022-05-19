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
	//post로 데이터를 넘길 때 언어 셋팅을 꼭 해줘야 합니다
	request.setCharacterEncoding("utf-8");

	String[] hobby = request.getParameterValues("hobby");
	String str = "";
	for(int i=0; i<hobby.length; i++){
		str += hobby[i] + " ";
	}
%>
<%=str %>
</body>
</html>