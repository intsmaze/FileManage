package cn.intsmaze.useremail.dao;

import java.util.List;

import cn.intsmaze.core.dao.BaseDao;
import cn.intsmaze.user.entity.User;
import cn.intsmaze.useremail.entity.UserEmail;

public interface UserEmailDao extends BaseDao<UserEmail>{

	List<UserEmail> getuserEmailByIdAndEmail(String userEamilId, String email);

	List<UserEmail> getuserEmailByAccount(String account);

	List<UserEmail> getuserEmailByEmail(String email);


	List<UserEmail> getuserEmail();

}
