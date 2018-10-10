package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao implements UserDaoInf{

	private SqlSessionFactory factory;
	
	/**
	* Method : selectUserAll
	* 작성자 : pc02
	* 변경이력 :
	* @return 테이블 전체 list
	* Method 설명 : 테이블 데이터 전체 조회
	 */
	@Override
	public List<UserVo> selectUserAll(){
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		//selectOne : 데이터가 한 건일 때
		//selectList : 여러건의 데이터를 조회할 때
		//메소드 인자: 문자열 = 네임스페이스(모듈명).쿼리아이디
		return session.selectList("jspuser.selectUserAll");
	}
	
	// 회원정보 조회 
	@Override
	public UserVo selectUser(String userId){
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		return session.selectOne("jspuser.selectUser", userId);
	}
	
	@Override
	public UserVo selectUser(UserVo userVo){
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		return session.selectOne("jspuser.selectUserByVo", userVo);
	}

	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		return session.selectList("jspuser.selectUserPageList", pageVo);
	}
	
	
	
}











