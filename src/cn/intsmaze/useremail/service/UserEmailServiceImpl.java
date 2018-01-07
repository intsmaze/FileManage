package cn.intsmaze.useremail.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import cn.intsmaze.core.service.BaseServiceImpl;
import cn.intsmaze.user.dao.UserDao;
import cn.intsmaze.user.entity.User;
import cn.intsmaze.user.service.UserService;
import cn.intsmaze.useremail.dao.UserEmailDao;
import cn.intsmaze.useremail.entity.UserEmail;

@Service(UserEmailService.SERVICE_NAME)
public class UserEmailServiceImpl extends BaseServiceImpl<UserEmail> implements UserEmailService{

	
	private UserEmailDao userEmailDao;
	
	@Resource (name="userEmailDaoImpl")
	public void setUserDao(UserEmailDao userEmailDao) {
		super.setBaseDao(userEmailDao);
		this.userEmailDao = userEmailDao;
	}

	@Override
	public List<UserEmail> getuserEmailByIdAndEmail(String userEamilId,
			String email) {	
		return userEmailDao.getuserEmailByIdAndEmail(userEamilId,email);
	}

	@Override
	public List<UserEmail> getuserEmailByAccount(String account) {
		List<UserEmail> list =userEmailDao.getuserEmailByAccount(account);
		return list;
	}

	@Override
	public List<UserEmail> getuserEmailByEmail(String email) {
		// TODO Auto-generated method stub
		return userEmailDao.getuserEmailByEmail(email);
	}

	@Override
	public void deletePastRecord() {	
		List<UserEmail> list=userEmailDao.getuserEmail();
		Date date=new Date();
		for(UserEmail u:list)
		{
			float  nDay=((date.getTime()-u.getDate().getTime())/(float)(24*60*60*1000)); 
			if(nDay>1)
			{
				System.out.println(u.getEmail());
				userEmailDao.deleteObjectByIds(u.getUserEamilId());
	    	}
		}
	}

	
	
//	@Override
//	public List<UserEmail> getUserByAccountAndEmail(String account, String email) {
//		
//		return userDao.getUserByAccountAndEmail(account,email);
//	}
//
//	@Override
//	public List<UserEmail> getUserByAccountAndPassword(String account,
//			String password) {
//		// TODO Auto-generated method stub
//		return userDao.getUserByAccountAndPassword(account,password);
//	}
//
//	
//	@Override
//	public String getUserByAccount(String account) {		
//		String message = "";
//		if(StringUtils.isNotBlank(account)){
//			//查询获取用户信息
//			List<User> list =userDao.getUserByAccount(account);;
//			if(list!=null && list.size()>0){ 
//				message = "2";
//			}
//			else{
//				message = "3";
//			}
//		}
//		else{
//			message = "1";
//		}
//		return message;
//	}
}
