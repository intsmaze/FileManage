package cn.intsmaze.user.dao;

import java.util.List;

import cn.intsmaze.core.dao.BaseDao;
import cn.intsmaze.user.entity.User;

public interface UserDao extends BaseDao<User>{

	List<User> getUserByAccountAndEmail(String account, String email);

	List<User> getUserByAccountAndPassword(String account, String password);

	List<User> getUserByAccount(String account);

	List<User> getUserByEmail(String email);
}
