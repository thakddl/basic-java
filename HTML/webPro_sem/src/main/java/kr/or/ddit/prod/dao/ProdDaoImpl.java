package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.BuildedSqlMapClient;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdDaoImpl implements IProdDao {

	private SqlMapClient smc;
	private static ProdDaoImpl dao;
	//싱글톤 방식 2가지 특징
	//1. private Constructor 
	//2. static method
	
	private ProdDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	public static ProdDaoImpl getDao() {
		if(dao == null) dao = new ProdDaoImpl();
		return dao;
	}
	
	@Override
	public List<ProdVO> prodNames(String prod_lgu) throws SQLException {
		List<ProdVO> list = smc.queryForList("prod.prodNames", prod_lgu);
		return list;
	}
	@Override
	public ProdVO prodDetails(String prod_id) throws SQLException {
		// TODO Auto-generated method stub
		ProdVO vo = (ProdVO) smc.queryForObject("prod.prodDetails", prod_id);
		return vo;
	}

}
