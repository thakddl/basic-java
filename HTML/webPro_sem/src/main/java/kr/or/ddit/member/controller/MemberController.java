package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/Member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//요청데이터 받기
		/*
		String mId = request.getParameter("mem_id");
		String mName = request.getParameter("mem_name");
		String mBir = request.getParameter("mem_bir");
		String mPass = request.getParameter("mem_pass");
		....
		vo.setMemId(mId);
		vo.setMemName(mName);
		vo.setMemBir(mBir);
		....*/
		
		MemberVO vo = new MemberVO();
		
		try {
			//BeanUtils : Map을 Bean객체로 바꿔주는 클래스
			//			>> java Bean(vo)객체에 맞추어 값을 자동으로 넣어준다
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//서비스객체 얻어오기
		MemberServiceImpl service = MemberServiceImpl.getService();
		//메소드 호출하기 - insert 실행시 반환받는 값은 없고 insert 실패 시 에러 표시
		//원래 반환받는 값은 없지만 성공,실패에 대한 내용을 출력하기 위해 리턴타입을 string으로 지정
		String insert = service.insertMember(vo);
		if(insert == "success") {
			//insert 성공시 request에 값 저장
			request.setAttribute("uId", vo.getMem_id());
		}else {
			//insert 실패시 request에 값 저장
			request.setAttribute("uId", null);
		}
		//jsp로 포워딩
		request.getRequestDispatcher("0104/join.jsp").forward(request, response);
		
	}

}
