package kr.or.ddit.member.service;

import java.sql.SQLException;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
	private IMemberDao dao;
	private static MemberServiceImpl service;
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getDao();
	}
	public static MemberServiceImpl getService() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}

	@Override
	public String insertMember(MemberVO vo) {
		// dao에 접근하여 메소드 호출하기
		String a = null;
		try {
			dao.insertMember(vo);
			a = "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
