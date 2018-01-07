package cn.intsmaze.admin.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wltea.analyzer.lucene.IKAnalyzer;

import cn.intsmaze.admin.entity.Admin;
import cn.intsmaze.admin.service.AdminService;
import cn.intsmaze.core.action.BaseAction;
import cn.intsmaze.core.constant.Constant;
import cn.intsmaze.core.util.MD5keyBean;
import cn.intsmaze.core.util.QueryHelper;
import cn.intsmaze.file.entity.UserFile;
import cn.intsmaze.file.service.FileService;
import cn.intsmaze.file.util.LuceneUtils;
import cn.intsmaze.file.util.UserFileUtils;
import cn.intsmaze.report.entity.Report;
import cn.intsmaze.report.service.ReportService;
import cn.intsmaze.user.entity.User;
import cn.intsmaze.user.service.UserService;

@Controller(value="adminAction")
@Scope(value="prototype")
public class AdminAction extends BaseAction{

	@Resource(name=AdminService.SERVICE_NAME)
	private AdminService adminService;
	
	@Resource(name=FileService.SERVICE_NAME)
	private FileService fileService;
	
	@Resource(name=UserService.SERVICE_NAME)
	private UserService userService;
	
	@Resource(name=ReportService.SERVICE_NAME)
	private ReportService reportService;
	
	private Admin admin;
	
	private String userId;
	private String userFileId;
		
	/**  
	* @Name: loginAdmin
	* @Description: 管理员登录进行验证,成功用户信息存入session中
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-6-29（创建日期）
	* @Parameters: 无
	* @Return: String：
	*/
	public String loginAdmin()
	{
		//加密前
		String logonPwd = admin.getPassword();
		//加密后
		String md5LogonPwd = "";
		//使用MD5进行密码加密
		MD5keyBean md5keyBean = new MD5keyBean();
		md5LogonPwd = md5keyBean.getkeyBeanofStr(logonPwd);
		List<Admin> list=
				adminService.getAdminByAccountAndPassword(admin.getAccount(),md5LogonPwd);	
		if(list.size()>0)
		{
			ServletActionContext.getRequest().getSession().setAttribute(Constant.ADMIN, list.get(0));
			return "home";
		}
		return "loginUI";
	}
	
	
	/**  
	* @throws IOException 
	* @Name: dealFile
	* @Description: 管理员受理文件，就是查封文件，使得该文件不可见，同时增加被投诉用户一次恶意行为，同时情况投诉表中含有该文件id的记录（避免重复查看已经受理的文件）
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-7-04（创建日期）
	* @Parameters: 无
	* @Return: String：
	*/
	public String dealFile() throws IOException
	{		
		UserFile userFile=fileService.findObjectById(userFileId);
		//该文件不可用
		userFile.setUse(true);	
		
		Analyzer standardAnalyzer =  new IKAnalyzer();
		// 指定索引存储目录
		Directory directory = FSDirectory.open(new File(Constant.INDEXFOLDER));

		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				Version.LUCENE_4_10_3, standardAnalyzer);
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

		//创建一个查询
		Query query = new TermQuery(new Term("fileId", userFileId));
		indexWriter.deleteDocuments(query);
		indexWriter.commit();
		indexWriter.close();
		
		User user=userFile.getUser();
		if((user.getBadBehavior()+1)>1)
		{
			//文件作者账号冻结，该用户的所有文件软删除
			user.setState(1);
			List<UserFile> userFiles=fileService.getFileByUserid(user.getUserid());
			for(UserFile u:userFiles)
			{
				u.setUse(true);
				fileService.update(u);
			}
		}
		else
		{
			//文件作者恶意行为加1
			user.setBadBehavior(user.getBadBehavior()+1);
		}		
		fileService.update(userFile);
			
		
		reportService.deleteByUserFileId(userFileId);
		
		QueryHelper queryHelper = new QueryHelper(Report.class, "r");		
	
		//pageResult继承父类，父类权限为protected
		pageResult = reportService.getPageResult(pageResult,queryHelper, getPageNo(), getPageSize());
		
		return "dealFile";
	}
	
	
	/**  
	* @Name: refuse
	* @Description: 
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-7-04（创建日期）
	* @Parameters: 无
	* @Return: String：
	*/
	public String refuse()
	{	
		
		User user=userService.findObjectById(userId);
		
		if((user.getBadBehavior()+1)>1)
		{
			user.setState(1);
		}
		else
		{
			user.setBadBehavior(user.getBadBehavior()+1);
		}
		
		userService.update(user);
		
		reportService.deleteByUserFileId(userFileId);
		QueryHelper queryHelper = new QueryHelper(Report.class, "r");		
	
		//pageResult继承父类，父类权限为protected
		pageResult = reportService.getPageResult(pageResult,queryHelper, getPageNo(), getPageSize());
		
		return "dealFile";
	}
	
	
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserFileId() {
		return userFileId;
	}
	public void setUserFileId(String userFileId) {
		this.userFileId = userFileId;
	}
}
