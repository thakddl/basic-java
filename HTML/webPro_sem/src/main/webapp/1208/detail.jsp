<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td {
  width: 120px;
  height: 40px;
  text-align: center;
  padding: 10px
}
#t1 {
  background: gold;
}
</style>
</head>
<body>
<pre>
	JDBC를 이용한 DB Connection
	JDBC(Java Database Connectivity)
	: 자바에서 디비에 접속할 수 있도록 하는 JAVA API
	>> DB에서 정보를 가져오기 위해 객체를 만들어 연결하는 방식
</pre>
<%
	//요청데이터를 받음
	String nm = request.getParameter("name");
	
	//처리과정
	//service객체를 얻어와서 메소드를 호출해 결과값을 전달받는것
	//1. Service에서 Dao를 호출
	//2. Dao에서 sql조회
	//3. Dao에서 Service로 값을 반환
	//4. Service에서 jsp로 값 전달
	Service service = Service.getInstance();
	Map<String, Object> map = service.selectMemberOne(nm);
	String id = (String)map.get("id");
	String name = (String)map.get("name");
	String hp = (String)map.get("hp");
	String mail = (String)map.get("mail");
%>
넘어온 이름 정보 : <%=nm %>

  <table border="1">
    <tr id="t1">
      <td>아이디</td>
      <td>이름</td>
      <td>전화</td>
      <td>메일</td>
    </tr>
    <tr>
      <td><%=id %></td>
      <td><%=name %></td>
      <td><%=hp %></td>
      <td><%=mail %></td>
    </tr>
  </table>

</body>
</html>