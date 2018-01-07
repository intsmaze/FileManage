package cn.intsmaze.report.dao;

import java.util.List;

import cn.intsmaze.core.dao.BaseDao;
import cn.intsmaze.report.entity.Report;

public interface ReportDao extends BaseDao<Report>{

	List<Report> getIsReportByUseridAndFileid(String fileid, String userid);

	void deleteByUserFileId(String userFileId);

}
