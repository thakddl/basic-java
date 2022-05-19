<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = (String)request.getAttribute("uId");
	if(result != null){
%>
		{
			"cd" : "ok",
			"id" : "<%=result%>"
		}
<%
	}else{
%>
		{
			"cd" : "no"
		}	
<%
	} //if-else end
%>