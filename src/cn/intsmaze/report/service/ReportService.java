package cn.intsmaze.report.service;

import java.util.List;

import cn.intsmaze.core.page.PageResult;
import cn.intsmaze.core.service.BaseService;
import cn.intsmaze.core.util.QueryHelper;
import cn.intsmaze.report.entity.Report;

public interface ReportService extends BaseService<Report>{
	
	public final static String SERVICE_NAME=
			"cn.intsmaze.report.service.ReportServiceImpl";

	List<Report> getIsReportByUseridAndFileid(String fileid, String userid);

    public PageResult getPageResult(PageResult pageResult,QueryHelper queryHelper, int pageNo, int pageSize) ;

	void deleteByUserFileId(String userFileId);
}
