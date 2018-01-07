package cn.intsmaze.useremail.service;

import java.util.List;

import cn.intsmaze.core.service.BaseService;
import cn.intsmaze.user.entity.User;
import cn.intsmaze.useremail.entity.UserEmail;

public interface UserEmailService extends BaseService<UserEmail>{
	
	public final static String SERVICE_NAME=
			"cn.intsmaze.useremail.service.UserEmailServiceImpl";

	List<UserEmail> getuserEmailByIdAndEmail(String userEamilId, String email);

	List<UserEmail> getuserEmailByAccount(String account);

	List<UserEmail> getuserEmailByEmail(String email);

	void deletePastRecord();




	
	
	
}
