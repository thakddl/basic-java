<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.BuildedSqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//framework-iBatis방식으로 JDBC를 대체하여 DB자원을 보다 편하게 가져온다
//iBatis는 sql문장을 별도로 분리하여 xml파일로 저장하고 연결해서 사용하는 방식으로 작동한다

//MVC1패턴
//iBatis활용해서 데이터 가져오기
SqlMapClient smc = BuildedSqlMapClient.getSqlMapClient();
List<BuyerVO> list = smc.queryForList("buyer.buyerNames");
%>
[
<%
for(int i=0; i<list.size(); i++){
	BuyerVO vo = list.get(i);
	if(i>0) out.print(",");
	//json Object 생성
%>
	{
		"id"	: "<%=vo.getBuyer_id()%>",
		"name"	: "<%=vo.getBuyer_name() %>"
	}
<%	
}//for end
%>
]