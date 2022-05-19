package kr.or.ddit;

import java.util.Map;

public class Service {
	
	private Dao dao;
	private static Service service;
	
	private Service() {
		dao = dao.getInstance();
	}
	
	public static Service getInstance() {
		if(service == null) {
			service = new Service();
		}
		return service;
	}

	public Map<String, Object> selectMemberOne(String name){

		Map<String, Object> map = dao.selectMemberOne(name);
		return map;
	}
	
}

