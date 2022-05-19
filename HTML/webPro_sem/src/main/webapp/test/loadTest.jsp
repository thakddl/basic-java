<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

load() : 서버에서 전송된 응답데이터를 셀렉터를 이용해 특정 노드에 붙일 수 있다 <br>

${param.d1} - ${param.d2}

<%=request.getMethod() %>

<% String d2 = request.getParameter("d2"); %>
<%= d2 %>