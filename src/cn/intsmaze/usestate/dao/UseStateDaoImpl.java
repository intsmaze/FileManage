package cn.intsmaze.usestate.dao;

import java.util.List;

import org.hibernate.Query;

import cn.intsmaze.core.dao.BaseDaoImpl;
import cn.intsmaze.usestate.entity.UseState;

public class UseStateDaoImpl extends BaseDaoImpl<UseState>
			implements UseStateDao
{

	@Override
	public List<UseState> getIsDownByUseridAndFileid(String fileid,
			String userid) {
		String hql = "FROM UseState WHERE userId = ? and userFileId =?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, userid);	
		query.setParameter(1, fileid);	
		return query.list();
	}

}
