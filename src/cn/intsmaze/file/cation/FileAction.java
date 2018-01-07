package cn.intsmaze.file.cation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.intsmaze.comment.entity.Comment;
import cn.intsmaze.core.action.BaseAction;
import cn.intsmaze.core.constant.Constant;
import cn.intsmaze.core.util.FileNameToUUID;
import cn.intsmaze.core.util.QueryHelper;
import cn.intsmaze.core.util.RateUtil;
import cn.intsmaze.core.util.SensitivewordFilter;
import cn.intsmaze.core.util.computeFile;
import cn.intsmaze.file.entity.FileResource;
import cn.intsmaze.file.entity.UserFile;
import cn.intsmaze.file.service.FileService;
import cn.intsmaze.file.util.UserFileUtils;
import cn.intsmaze.user.entity.User;



@Controller("fileAction")
@Scope(value="prototype")
public class FileAction extends BaseAction{
	

	@Resource(name=FileService.SERVICE_NAME)
	private FileService fileService;
	
	@Resource(name="sensitivewordFilter")
	private SensitivewordFilter sensitivewordFilter;
	
	//单个文件的资源链接
	private String filesrc;
	
	private String filename;
	
	//文件下载的输入流，名称不能为in
	private InputStream inputStream;
	
	private UserFile userFile;
	
	private List<UserFile> userFiles;
	
	
	private File[] office;
	private String[] officeContentType;
	private String[] officeFileName;
	
	//上传操作提示信息
	private String tip;
	
	
	//搜索框输入的查询字符串
	private String selectname;
	
	//文件id得到文件关联的实体对象
	private String fileid;
	
	
	private Comment comment;//接收用户评论
	
	private String swfsrc;
	
	
	/**  
	* @Name: uploadUI
	* @Description: 跳转到文件上传页面
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-6-23（创建日期）
	* @Parameters: 无
	* @Return: String：跳转到file/uploadUI.jsp
	*/
	public String uploadUI()
	{
		return "uploadUI";
	}
	
	
	/**  
	* @throws IOException 
	* @Name: uploadFile
	* @Description:文件上传，成功后跳转到文件信息页面,只能上传office文件类型，对敏感词进行过滤
	* @Author: 刘洋（作者）
	* @Version: V3.00 （版本号）
	* @Create Date: 2014-7-11（创建日期）
	* @Parameters: 无
	* @Return: String：跳转到file/fileInfo.jsp,文件上传失败，拦截器返回input结果，跳转到file/uploadUI.jsp进行回显提示
	*/
	public String uploadFile() throws IOException
	{	
//		//判断文件是否上传了
//		if(office!=null&&office.length>0){				
			long totalSize=0;
			String size=null;
			//获取文件总大小，进行判断是否超标准
			for(int i=0;i<office.length;i++)
			{
				totalSize+=office[i].length();		
			}
			//1M=1024k=1048576字节，文件上传单位是字节，总大小不能超过10M
			if(totalSize<=10485760)
			{
				Set<FileResource> fileResources=new HashSet<>();
				for(int i=0;i<office.length;i++){			
					//返回该文件链接地址
					String name=FileNameToUUID.getUUID(office[i], officeFileName[i]);
					FileResource fileResource=new FileResource();
					
					size=computeFile.getFileSize(office[i].length());	
					fileResource.setSize(size);
					fileResource.setName(officeFileName[i]);
					fileResource.setFilesrc(name);	
					fileResource.setSwfsrc(name.substring(0,name.lastIndexOf("."))+".swf");
					fileResources.add(fileResource);		
				}
				
				User user=(User) ServletActionContext.getRequest().getSession().getAttribute(Constant.USER);			
				userFile.setFileResource(fileResources);
				userFile.setDate(new Date());
				userFile.setUser(user);
				userFile.setTotalSize(computeFile.getFileSize(totalSize));	
				
				userFile.setTitle(sensitivewordFilter.replaceSensitiveWord(userFile.getTitle(), 1, "*"));
				userFile.setIntroduce(sensitivewordFilter.replaceSensitiveWord(userFile.getIntroduce(), 1, "*"));
				
				fileService.saveAndIndex(userFile);			
				return "fileInfor";
			}
			else
			{
				tip="总文件过大";
				System.out.println(tip);
				return "input";
			}
//		}
//		else
//		{
//			tip="请上传文件";
//			System.out.println(tip);
//			return "input";
//		}	
	}

	/**  
	* @Name: view
	* @Description: 根据文件的swf文件的路径在线预览该文件。
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-6-28（创建日期）
	* @Parameters: 无
	* @Return: String：跳转到file/file_flash.jsp
	*/
	public String view()
	{
		return "documentView";
	}
	
	
	/**  
	* @throws Exception 
	* @Name: fileLookId
	* @Description: 根据文件id查看文件详细信息
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-6-28（创建日期）
	* @Parameters: 无
	* @Return: String：跳转到file/fileInfo.jsp
	*/
	public String fileLookId()
	{
		//这个时不可以的，虽然获取了userFile，指定的是懒加载，jsp页面调用userFile的其他实体属性时，session已经关闭了
		//userFile=fileService.findObjectById(fileid);
		//判断fileid是页面中url传来的，还是action链传来的
		if(fileid==null||fileid=="")
		{
			userFile=fileService.getFileByid((String) ActionContext.getContext().get("fileid"));
		}
		userFile=fileService.getFileByid(fileid);
		
		long totalComment=userFile.getGoodcomment()+userFile.getBadcomment();
		userFile.setTotalComment(totalComment);
		
		userFile.setRate(RateUtil.getGoodCommentRate(userFile.getGoodcomment(), userFile.getBadcomment()));
				
		return "fileInfor";
	}
	
	
	/**  
	* @throws Exception 
	 * @Name: fileLook
	* @Description: 文件查询，这里要进行处理，如果输入**或+这样的全部是特殊字符会报异常的，lucene无法解析。1+1这样是可以的，所以前端jquery进行校验
	* @Author: 刘洋（作者）
	* @Version: V2.00 （版本号）
	* @Create Date: 2014-6-23（创建日期）
	* @Parameters: 无
	* @Return: String：跳转到file/listFile.jsp
	*/
	public String fileLook() throws Exception
	{	
		if (selectname != null) {
			if (StringUtils.isNotBlank(selectname)) {
				pageResult=fileService.highLighter(selectname,this.getPageNo(),this.getPageSize());
			}
		}
//		QueryHelper queryHelper = new QueryHelper(UserFile.class, "uf");
//		try {
//			if (selectname != null) {
//				if (StringUtils.isNotBlank(selectname)) {
//					//user.setName(URLDecoder.decode(user.getName(), "utf-8"));
//					queryHelper.addCondition("uf.title like ?", "%" + selectname + "%");
//					pageResult = fileService.getPageResult(queryHelper, getPageNo(), getPageSize());
//				}
//			}
//		} catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}		
		return "listFile";
	}
	
	
	
	
	/**  
	* @Name: downUI
	* @Description: 跳转到文件下载页面,并对该文件的下载次数加1
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-6-26（创建日期）
	* @Parameters: 无
	* @Return: String：跳转到file/downUI.jsp
	*/
	public String downUI()
	{
		fileid=(String) ActionContext.getContext().get("fileid");
		userFile=fileService.getFileByid(fileid);
		//这两个字段没有必要放到数据库中，增加内存消耗
		long totalComment=userFile.getGoodcomment()+userFile.getBadcomment();
		userFile.setTotalComment(totalComment);
		
		userFile.setRate(RateUtil.getGoodCommentRate(userFile.getGoodcomment(), userFile.getBadcomment()));
		String isDown=(String) ActionContext.getContext().get("isDown");
		//根据上一个action传来的参数，判断是否增加一次下载量
		if(isDown==null)
		{
			userFile.setDowncount(userFile.getDowncount()+1);
			fileService.update(userFile);
		}
		return "fileDown";
	}
	
	

	/**  
	* @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 * @Name: down
	* @Description: 文件下载（struts2的方式）
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-6-24（创建日期）
	* @Parameters: 无
	* @Return: struts2的结果类型,下载操作完成还是原界面，不跳转到其他界面
	*/
	public String down() throws UnsupportedEncodingException, FileNotFoundException{	
			
		String pathReall = ServletActionContext.getServletContext().getRealPath("")+"/upload/"+filesrc;
		System.out.println(pathReall);
		inputStream=new FileInputStream(pathReall);
		//获取到正确中文
		filename =  new String (filename.getBytes("iso-8859-1"), "UTF-8") ;
		//将中文转换为gbk进行传输
		filename = new String(filename.getBytes("gbk"),"iso-8859-1");
		
		return "download";	
	}

	
	
	/**  
	* @Name: userFileListUI
	* @Description: 跳转到用户文件列表显示页面
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-6-25（创建日期）
	* @Parameters: 无
	* @Return: String：跳转到file/uploadUI.jsp
	*/
	public String userFileListUI()
	{
		User user=(User) ServletActionContext.getContext().getSession().get(Constant.USER);
		
		
		userFiles=fileService.getFileByUserid(user.getUserid());
		List<UserFile> list=new ArrayList<UserFile>();
		for(UserFile userFile:userFiles)
		{
			if(!userFile.isUse())
			{
				list.add(userFile);
			}
		}
		userFiles=list;
		return "userFileListUI";
	}
	
	
	
	/**  
	* @throws IOException 
	* @Name: commment
	* @Description: 文件评论 ,得到上一个actin传来的属性
	* @Author: 刘洋（作者）
	* @Version: V2.00 （版本号）
	* @Create Date: 2014-6-28（创建日期）
	* @Parameters: 无
	* @Return: String：跳转到file/fileInfor.jsp
	*/
	public String comment() throws IOException
	{		
		userFile=fileService.getFileByid((String) ActionContext.getContext().get("fileid"));	
		comment=(Comment) ActionContext.getContext().get("comment");
		if(comment.getRate()==1)
		{
			userFile.setBadcomment(userFile.getBadcomment()+1);
		}
		else
		{
			userFile.setGoodcomment(userFile.getGoodcomment()+1);
		}
		long totalComment=userFile.getGoodcomment()+userFile.getBadcomment();
		userFile.setTotalComment(totalComment);
		
		//调用工具类，计算好评率
		userFile.setRate(RateUtil.getGoodCommentRate(userFile.getGoodcomment(), userFile.getBadcomment()));
		
		User user=(User) ServletActionContext.getContext().getSession().get(Constant.USER);
		comment.setDate(new Date());
		comment.setUser(user);
		comment.setText(sensitivewordFilter.replaceSensitiveWord(comment.getText(), 1, "*"));
		userFile.getComments().add(comment);
		fileService.update(userFile);
		return "fileInfor";
	}
	
	
	public String getSelectname() {
		return selectname;
	}

	public void setSelectname(String selectname) {
		this.selectname = selectname;
	}

	

	public File[] getOffice() {
		return office;
	}

	public void setOffice(File[] office) {
		this.office = office;
	}

	public String[] getOfficeContentType() {
		return officeContentType;
	}

	public void setOfficeContentType(String[] officeContentType) {
		this.officeContentType = officeContentType;
	}

	public String[] getOfficeFileName() {
		return officeFileName;
	}

	public void setOfficeFileName(String[] officeFileName) {
		this.officeFileName = officeFileName;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}


	public List<UserFile> getUserFiles() {
		return userFiles;
	}


	public void setUserFiles(List<UserFile> userFiles) {
		this.userFiles = userFiles;
	}


//	public FileResource getFileResource() {
//		return fileResource;
//	}
//
//
//	public void setFileResource(FileResource fileResource) {
//		this.fileResource = fileResource;
//	}

	public UserFile getUserFile() {
		return userFile;
	}
	public void setUserFile(UserFile userFile) {
		this.userFile = userFile;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public FileService getFileService() {
		return fileService;
	}


	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}


	public String getFilesrc() {
		return filesrc;
	}


	public void setFilesrc(String filesrc) {
		this.filesrc = filesrc;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getFileid() {
		return fileid;
	}


	public void setFileid(String fileid) {
		this.fileid = fileid;
	}


	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getSwfsrc() {
		return swfsrc;
	}

	public void setSwfsrc(String swfsrc) {
		this.swfsrc = swfsrc;
	}
	
}
