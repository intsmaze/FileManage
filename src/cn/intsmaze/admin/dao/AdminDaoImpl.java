package cn.intsmaze.admin.dao;

import java.util.List;

import org.hibernate.Query;

import cn.intsmaze.admin.entity.Admin;
import cn.intsmaze.core.dao.BaseDaoImpl;
import cn.intsmaze.user.entity.User;

public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{

	public List<Admin> getAdminByAccountAndPassword(String account,
			String password) {
		String hql = "FROM Admin WHERE account = ? and password =?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, account);	
		query.setParameter(1, password);	
		return query.list();
	}

}
