package cn.intsmaze.file.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import cn.intsmaze.core.dao.BaseDaoImpl;
import cn.intsmaze.file.dao.FileDao;
import cn.intsmaze.file.entity.FileResource;
import cn.intsmaze.file.entity.UserFile;

public class FileDaoImpl extends BaseDaoImpl<UserFile> implements FileDao{

	
	@SuppressWarnings("unchecked")
	public List<UserFile> getFileByUserid(String user) {
		String hql = "FROM UserFile WHERE user = " +" '"+user+"' ";
		Query query = getSession().createQuery(hql);		
		return query.list();
	}
}
