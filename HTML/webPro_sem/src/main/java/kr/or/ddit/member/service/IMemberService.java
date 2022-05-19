package kr.or.ddit.member.service;

import kr.or.ddit.member.vo.MemberVO;

public interface IMemberService {

	//회원정보 저장
	public String insertMember(MemberVO vo);
}
