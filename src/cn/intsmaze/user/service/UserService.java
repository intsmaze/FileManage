package cn.intsmaze.user.service;

import java.util.List;

import cn.intsmaze.core.service.BaseService;
import cn.intsmaze.user.entity.User;

public interface UserService extends BaseService<User>{
	
	public final static String SERVICE_NAME=
			"cn.intsmaze.user.service.impl.UserServiceImpl";

	List<User> getUserByAccountAndEmail(String account, String email);

	List<User> getUserByAccountAndPassword(String account, String password);

	List<User> getUserByAccount(String account);

	List<User> getUserByEmail(String email);




	
	
	
}
