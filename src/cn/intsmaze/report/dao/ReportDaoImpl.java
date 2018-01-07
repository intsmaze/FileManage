package cn.intsmaze.report.dao;

import java.util.List;

import org.hibernate.Query;

import cn.intsmaze.core.dao.BaseDaoImpl;
import cn.intsmaze.report.entity.Report;

public class ReportDaoImpl extends BaseDaoImpl<Report> implements ReportDao{

	@Override
	public List<Report> getIsReportByUseridAndFileid(String fileid,
			String userid) {
		String hql = "FROM Report WHERE userId = ? and userFileId =?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, userid);	
		query.setParameter(1, fileid);	
		return query.list();
	}

	@Override
	public void deleteByUserFileId(String userFileId) {
		String hql = "delete FROM Report WHERE  userFileId =?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, userFileId);	
		query.executeUpdate();	
	}
	
}
