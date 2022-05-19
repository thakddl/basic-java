<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	//요청데이터 받기	
	String buyerId = request.getParameter("id");
	//객체 생성
	SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();
	//sql실행
	BuyerVO vo = (BuyerVO)smc.queryForObject("buyer.buyerDetails", buyerId);

	//json Object 생성
%>
	{
		"id" : "<%=vo.getBuyer_id() %>",
		"name" : "<%=vo.getBuyer_name() %>",
		"lgu" : "<%=vo.getBuyer_lgu() %>",
		"bank" : "<%=vo.getBuyer_bank() %>",
		"bankNo" : "<%=vo.getBuyer_bankno() %>",
		"bankNm" : "<%=vo.getBuyer_bankname() %>",
		"zip" : "<%=vo.getBuyer_zip() %>",
		"add1" : "<%=vo.getBuyer_add1() %>",
		"add2" : "<%=vo.getBuyer_add2() %>",
		"mail" : "<%=vo.getBuyer_mail() %>"
	}