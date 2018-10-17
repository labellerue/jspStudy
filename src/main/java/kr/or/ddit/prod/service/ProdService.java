package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

public class ProdService implements ProdServiceInf {
	private ProdDaoInf prodDao = new ProdDao();

	@Override
	public int getProdCnt() {
		return prodDao.getProdCnt();
	}
	
	@Override
	public Map<String, Object> selectProdPageList(PageVo pageVo) {
		// 페이지에 해당하는 제품 리스트(1~10건 사이)
		List<ProdVo> prodPageList = prodDao.selectProdPageList(pageVo);

		// 페이지 네비게이션을 위한 전체 제품 리스트 조회
		int totalProdCnt = prodDao.getProdCnt();

		// 결과를 담는 map 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("prodPageList", prodPageList);
		resultMap.put("prodPageCnt",
				(int) Math.ceil((double) totalProdCnt / pageVo.getPageSize()));

		return resultMap;
	}

	@Override
	public ProdVo selectProd(String prod_id) {
		return prodDao.selectProd(prod_id);
	}

	

}
