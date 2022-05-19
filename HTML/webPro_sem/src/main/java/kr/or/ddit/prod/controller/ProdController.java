package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ProdController
 */
@WebServlet("/Prod")
public class ProdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 요청데이터 가져오기
		String gu = request.getParameter("gu");
		// 1. service 객체 얻어오기
		IProdService service = ProdServiceImpl.getService();
		// 2. service 메소드를 호출하여 결과 값 받기
		List<ProdVO> list = service.prodNames(gu);
		
		// 요청에 대한 처리(controller)만 servlet이 담당하고,
		// 결과에 대한 표현(view)은 jsp에 위임한다
		
		//포워딩을 위해 request에 저장
		request.setAttribute("listView", list);
		//결과 값을 jsp로 포워딩 - servlet의 request객체 변수를 jsp에서 공유해서 사용
		RequestDispatcher disp = 
			request.getRequestDispatcher("1230/prodNames.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. 요청데이터 가져오기
		String prodId = request.getParameter("id");
		// 1. service 객체 얻어오기
		IProdService service = ProdServiceImpl.getService();
		// 2. service 메소드를 호출하여 결과 값 받기
		ProdVO vo = service.prodDetails(prodId);
		// 3. request에 저장
		request.setAttribute("voValue", vo);
		// 4. 결과 값을 jsp로 포워딩 >> 오늘 날짜 폴더/prodDetails.jsp
		request.getRequestDispatcher("WEB-INF/1231/prodDetails.jsp")
			.forward(request, response);
	}

}
