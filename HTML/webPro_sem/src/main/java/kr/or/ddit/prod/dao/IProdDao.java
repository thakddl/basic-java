package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;
import kr.or.ddit.prod.vo.ProdVO;

public interface IProdDao {

	//제품정보 이름-id 조회
	//dao를 호출하는 service로 예외발생에 대한 책임을 전가시킨다(throws)
	public List<ProdVO> prodNames(String prod_lgu) throws SQLException;
	
	//제품정보 상세정보 조회
	public ProdVO prodDetails(String prod_id) throws SQLException;
}
