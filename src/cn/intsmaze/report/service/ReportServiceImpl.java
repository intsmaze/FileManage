package cn.intsmaze.report.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.intsmaze.core.page.PageResult;
import cn.intsmaze.core.service.BaseServiceImpl;
import cn.intsmaze.core.util.QueryHelper;
import cn.intsmaze.report.dao.ReportDao;
import cn.intsmaze.report.entity.Report;
import cn.intsmaze.usestate.dao.UseStateDao;

@Service(ReportService.SERVICE_NAME)
public class ReportServiceImpl extends BaseServiceImpl<Report> implements ReportService{

	private ReportDao reportDao;
	
	@Resource(name="reportDaoImpl")
	public void setReportDao(ReportDao reportDao) {
		super.setBaseDao(reportDao);
		this.reportDao = reportDao;
	}
	
	
	public ReportDao getReportDao() {
		return reportDao;
	}


	@Override
	public List<Report> getIsReportByUseridAndFileid(String fileid,
			String userid) {
		
		return reportDao.getIsReportByUseridAndFileid(fileid,userid);
	}

	
	public PageResult getPageResult(PageResult pageResult,QueryHelper queryHelper, int pageNo, int pageSize) {		
		 pageResult=reportDao.getPageResult(queryHelper, pageNo, pageSize);
		 System.out.println( pageResult.getItems());
		return pageResult;
	}


	@Override
	public void deleteByUserFileId(String userFileId) {
		reportDao.deleteByUserFileId(userFileId);
	}
}
