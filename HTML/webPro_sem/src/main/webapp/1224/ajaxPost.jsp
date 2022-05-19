<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String userId = request.getParameter("id");
	String userPw = request.getParameter("pw");
	
	//요청 데이터로 id와 pw를 전달 받음
	//요청 데이터로 데이터베이스에 접근해 회원로그인 여부에 대한 결과를 받아와야 하지만
	//처리부분을 생략하고 임의의 데이터를 생성해서 활용한다
	
	String ss = "0";	//회원정보 일치시 상태코드를 만듦

	if(ss.equals("1")){
		//성공 응답 데이터 생성
%>
		{
<%-- 			"rst" : "로그인 성공" --%>
				"code" : "ok"
		}
<%
	}else{
		//실패 응답 데이터 생성
%>
		{
<%-- 			"rst" : "로그인 실패" --%>
				"code" : "no"
		}
<%		
	}//else end
%>



