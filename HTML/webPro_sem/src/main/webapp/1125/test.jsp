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
	<h3>JSP : Java Server Page</h3>
	&lt;% %> 기호 안쪽에 java코드를 작성할 수 있고, 
	html코드도 병행하여 작성할 수 있다
			
	주석 활용시 &lt;%-- --%> 형태의 주석만 사용해야 한다 
</pre>

<%
	//post방식으로 데이터가 넘어올 때 한글처리해야 함
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
%>

아이디는 <%=id %> <br>
비밀번호는 <%=pw %> 입니다~~~ 

</body>
</html>