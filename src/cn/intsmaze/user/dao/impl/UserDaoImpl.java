package cn.intsmaze.user.dao.impl;


import java.util.List;

import org.hibernate.Query;

import cn.intsmaze.core.dao.BaseDaoImpl;
import cn.intsmaze.user.dao.UserDao;
import cn.intsmaze.user.entity.User;



public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByAccountAndEmail(String account, String email) {	
		String hql = "FROM User WHERE account = ? and email =?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, account);	
		query.setParameter(1, email);	
		return query.list();
	}

	@Override
	public List<User> getUserByAccountAndPassword(String account,
			String password) {
		String hql = "FROM User WHERE account = ? and password =?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, account);	
		query.setParameter(1, password);	
		return query.list();
	}

	@Override
	public List<User> getUserByAccount(String account) {
		String hql = "FROM User WHERE account = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, account);	
		return query.list();
	}

	@Override
	public List<User> getUserByEmail(String email) {
		String hql = "FROM User WHERE email = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, email);	
		return query.list();
	}
}
