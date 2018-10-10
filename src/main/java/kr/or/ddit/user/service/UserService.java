package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public class UserService implements UserServiceInf {

	private UserDaoInf userDao = new UserDao();
	
	public List<UserVo> selectUserAll() {
		return userDao.selectUserAll();
	}

	@Override
	public UserVo selectUser(String userId) {
		return userDao.selectUser(userId);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		return userDao.selectUser(userVo);
	}

	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		return userDao.selectUserPageList(pageVo);
	}
	
	

}
