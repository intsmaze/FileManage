package cn.intsmaze.useremail.dao;


import java.util.List;

import org.hibernate.Query;

import cn.intsmaze.core.dao.BaseDaoImpl;
import cn.intsmaze.user.dao.UserDao;
import cn.intsmaze.user.entity.User;
import cn.intsmaze.useremail.entity.UserEmail;



public class UserEmailDaoImpl extends BaseDaoImpl<UserEmail> implements UserEmailDao{

	@Override
	public List<UserEmail> getuserEmailByIdAndEmail(String userEamilId,
			String email) {
		String hql = "FROM UserEmail WHERE userEamilId = ? and email =?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, userEamilId);	
		query.setParameter(1, email);	
		return query.list();
	}

	
	@Override
	public List<UserEmail> getuserEmailByAccount(String account) {
		String hql = "FROM UserEmail WHERE account = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, account);	
		return query.list();
	}


	@Override
	public List<UserEmail> getuserEmailByEmail(String email) {
		String hql = "FROM UserEmail WHERE email = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, email);	
		return query.list();
	}
	
	
	@Override
	public List<UserEmail> getuserEmail() {
		String hql = "FROM UserEmail ";
		Query query = getSession().createQuery(hql);
		return query.list();
	}	
}
