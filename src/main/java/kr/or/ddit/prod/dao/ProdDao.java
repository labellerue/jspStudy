package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

public class ProdDao implements ProdDaoInf {

	private SqlSessionFactory factory;
	
	
	@Override
	public int getProdCnt() {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totalProdCnt = session.selectOne("prod.getProdCnt");
		session.close();
		
		return totalProdCnt;
	}

	@Override
	public List<ProdVo> selectProdPageList(PageVo pageVo) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<ProdVo> prodList = session.selectList("prod.selectProdPageList", pageVo);
		session.close();
		
		return prodList;
	}

	@Override
	public ProdVo selectProd(String prod_id) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		ProdVo prodVo = session.selectOne("prod.selectProd", prod_id);
		session.close();
		
		return prodVo;
	}

	
}
