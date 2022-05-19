package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdService {

	//메소드  선언 - 접근제한자 리턴타입 메소드명 (넘겨줄 값)
	
	//제품정보 이름-id 조회
	public List<ProdVO> prodNames(String prod_lgu);
	
	//제품정보 상세정보 조회
	public ProdVO prodDetails(String prod_id);
}
