<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//servlet에서 결과 데이터를 전달받고 json형태로 가공
List<ProdVO> list = (List<ProdVO>)request.getAttribute("listView");

if(list != null && list.size() > 0){
%>	
	{
		"code"	: "ok",
		"value" :  [
<% 
		for(int i=0; i<list.size(); i++){
			ProdVO vo = list.get(i);
			if(i>0) out.print(",");
%>			
			{
				"id" : "<%=vo.getProd_id() %>",
				"nm" : "<%=vo.getProd_name() %>"
			}
<%
		}//for end
%>
		]
	}
<%	
}else { //데이터가 없을 때
%>
	{
		"code" : "no"
	}
<%
}//end if-else
%>