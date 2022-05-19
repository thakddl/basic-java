<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
	<h4>JSP : Java Server Page</h4>
	클라이언트 요청 데이터를 받아서 처리하고 결과 값을 출력하는 페이지
	post로 요청 받았을 경우 한글처리를 꼭 해야 한다 request.setCharacterEncoding("utf-8");
	서버 내에서 실행(back-end)되며, 결과만 클라이언트로 전송된다
</pre>

<%
	request.setCharacterEncoding("utf-8");
	String nm = request.getParameter("name");
	String gd = request.getParameter("gender");
	String hd = request.getParameter("hd");
	//checkbox로 여러개의 데이터를 받았을 경우 - food
	String[] fd = request.getParameterValues("food");
	String fl = request.getParameter("file");
	
	String food = "";
	for(int i=0; i<fd.length; i++){
		food += fd[i] + " "; 
	}
%>

<%=nm %>님 환영합니다~~~ <br>
당신의 성별은 <%=gd %>이군요!! <br>
<%=hd %> <br>
당신이 좋아하는 것은 <%=food %> <br><br>
**<%=fl %>을 전송하였습니다**
</body>
</html>





