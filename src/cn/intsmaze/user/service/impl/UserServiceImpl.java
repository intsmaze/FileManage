package cn.intsmaze.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import cn.intsmaze.core.service.BaseServiceImpl;
import cn.intsmaze.user.dao.UserDao;
import cn.intsmaze.user.entity.User;
import cn.intsmaze.user.service.UserService;
import cn.intsmaze.useremail.dao.UserEmailDao;

@Service(UserService.SERVICE_NAME)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	private UserDao userDao;
	
	@Resource (name="userDaoImpl")
	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}

	@Override
	public List<User> getUserByAccountAndEmail(String account, String email) {		
		return userDao.getUserByAccountAndEmail(account,email);
	}

	@Override
	public List<User> getUserByAccountAndPassword(String account,
			String password) {
		return userDao.getUserByAccountAndPassword(account,password);
	}

	
	@Override
	public List<User> getUserByAccount(String account) {		
		
		//查询获取用户信息
		List<User> list =userDao.getUserByAccount(account);

		return list;
	}

	@Override
	public List<User> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.getUserByEmail(email);
	}
}
