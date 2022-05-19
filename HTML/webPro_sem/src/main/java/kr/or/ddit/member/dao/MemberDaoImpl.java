package kr.or.ddit.member.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.BuildedSqlMapClient;
import kr.or.ddit.member.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	private SqlMapClient smc;
	private static MemberDaoImpl dao;
	
	//싱글톤 방식 특징 1.private 생성자 2.static 메소드
	private MemberDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	public static MemberDaoImpl getDao() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public void insertMember(MemberVO vo) throws SQLException {

		//sqlMapClient도움받아 sql에 접근하여 데이터 가져오기
		smc.insert("member.insertMember",vo);
	}

}
