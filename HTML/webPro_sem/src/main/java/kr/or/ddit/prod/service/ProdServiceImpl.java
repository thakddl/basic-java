package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {
	
	private IProdDao dao;
	private static ProdServiceImpl service;
	
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getDao();
	}
	public static ProdServiceImpl getService() {
		if(service == null) service = new ProdServiceImpl();
		return service;
	}

	@Override
	public List<ProdVO> prodNames(String prod_lgu) {
		List<ProdVO> list = null;
		try {
			 list = dao.prodNames(prod_lgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public ProdVO prodDetails(String prod_id) {
		ProdVO vo = null;
		try {
			vo = dao.prodDetails(prod_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

}
