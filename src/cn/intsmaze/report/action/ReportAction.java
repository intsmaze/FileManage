package cn.intsmaze.report.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.intsmaze.core.action.BaseAction;
import cn.intsmaze.core.constant.Constant;
import cn.intsmaze.core.util.QueryHelper;
import cn.intsmaze.file.entity.UserFile;
import cn.intsmaze.file.service.FileService;
import cn.intsmaze.report.entity.Report;
import cn.intsmaze.report.service.ReportService;
import cn.intsmaze.user.entity.User;
import cn.intsmaze.usestate.entity.UseState;
import cn.intsmaze.usestate.service.UseStateService;

import com.opensymphony.xwork2.ActionContext;

@Controller("reportAction")
@Scope(value="prototype")
public class ReportAction extends BaseAction{
	
	@Resource(name=ReportService.SERVICE_NAME)
	private ReportService reportService;
	
	@Resource(name=FileService.SERVICE_NAME)
	private FileService fileService;
	
	@Resource(name=UseStateService.SERVICE_NAME)
	private UseStateService useStateService;
	
	private String fileid;
	private String reason;
	
	
	public String isReport() throws IOException
	{
		
//		User user=(User) ServletActionContext.getContext().getSession().get(Constant.USER);
//		List<Report> reports=reportService.getIsReportByUseridAndFileid(fileid,user.getUserid());
//		ActionContext.getContext().put("fileid", fileid);
//		//已经举报过,回到文件信息页面
//		if(reports.size()>0)
//		{
//			return "fileLookId";
//		}	
//		
		fileid=(String)ActionContext.getContext().get("fileid");
		//跳转到举报页面
		return "reportUI";
	}
	
	
	public String saveReport() throws IOException 
	{
		User user=(User) ServletActionContext.getContext().getSession().get(Constant.USER);
		
		Report report=new Report();
		
		UserFile userFile=fileService.findObjectById(fileid);
		
		report.setUser(user);
		report.setUserFile(userFile);	
		report.setReason(reason);
		reportService.save(report);
		
		List<UseState> useStates=useStateService.getIsDownByUseridAndFileid(fileid,user.getUserid());
		UseState useState=useStates.get(0);
		useState.setReport(1);
		useStateService.update(useState);
		
		return "sucess";
	}

	public String findAll() throws IOException
	{		
		QueryHelper queryHelper = new QueryHelper(Report.class, "r");		
		//根据创建时间降序排序
		//queryHelper.addOrderByProperty("i.createTime", QueryHelper.ORDER_BY_DESC);
		
		//pageResult继承父类，父类权限为protected
		pageResult = reportService.getPageResult(pageResult,queryHelper, getPageNo(), getPageSize());
		
//		Report report=(Report) pageResult.getItems().get(0);
//		System.out.println(report.getReason());
//		System.out.println(report.getUser().getAccount());
//		System.out.println(report.getUserFile().getTitle());
		//跳转到举报页面
		return "reportList";
	}
	
	
	
	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
