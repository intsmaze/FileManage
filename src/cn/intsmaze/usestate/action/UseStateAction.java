package cn.intsmaze.usestate.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.intsmaze.comment.entity.Comment;
import cn.intsmaze.core.constant.Constant;
import cn.intsmaze.file.entity.UserFile;
import cn.intsmaze.file.service.FileService;
import cn.intsmaze.user.entity.User;
import cn.intsmaze.usestate.entity.UseState;
import cn.intsmaze.usestate.service.UseStateService;


@Controller("useStateAction")
@Scope(value="prototype")
public class UseStateAction {
	
	@Resource(name=UseStateService.SERVICE_NAME)
	private UseStateService useStateService;
	
	private String fileid;
	
	
	private UseState useState;
	
	
	private Comment comment;//接收用户评论

	
	/**  
	* @Name: isDown
	* @Description: 判断用户是否已经下载过该文件，然后转到处理文件实体的action
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-6-26（创建日期）
	* @Parameters: 无
	* @Return: String：跳转到file/file_downUI
	*/
	public String isDown() throws IOException
	{
		User user=(User) ServletActionContext.getContext().getSession().get(Constant.USER);
		List<UseState> useStates=useStateService.getIsDownByUseridAndFileid(fileid,user.getUserid());
		ActionContext.getContext().put("fileid", fileid);
		if(useStates.size()>0)
		{
			ActionContext.getContext().put("isDown", "1");
			return "fileDown";
		}	
		
		UseState useState=new UseState();
		//增加一条下载记录
		useState.setUserId(user.getUserid());
		useState.setUserFileId(fileid);	
		useStateService.save(useState);
		return "chain";
	}
	
	
	
	/**  
	* @Name: isComment
	* @Description: 先判断该用户是否已经下载过该文件，没有下载，提示无法评论，下载过，再判断是否已经评论过，评论过，就提示无法再评论
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-6-26（创建日期）
	* @Parameters: 无
	* @Return: String：跳转到file/file_downUI
	*/
	public String isComment() throws IOException
	{	
		User user=(User) ServletActionContext.getContext().getSession().get(Constant.USER);
		List<UseState> useStates=useStateService.getIsDownByUseridAndFileid(fileid,user.getUserid());
	
		ActionContext.getContext().put("fileid", fileid);
		//判断是否下载过
		if(useStates.size()>0)
		{
			
			useState=useStates.get(0);
			System.out.println(useState.getState());
			if(useState.getState()==0)//可以评论
			{
				ActionContext.getContext().put("comment", comment);
				System.out.println("可以评论");
				useState.setState(1);
				useStateService.update(useState);
				return "comment";
			}
			else//评论过
			{
				System.out.println("评论过");
				return "fileLookId";
			}		
		}
		else//没有下载，无法评论
		{
			System.out.println("没有下载，无法评论");
			return "fileLookId";
		}
	}
	
	/**  
	* @Name: isComment
	* @Description: 先判断该用户是否已经下载过该文件，没有下载，提示无法评论，下载过，再判断是否已经举报过，举报过，就提示无法再举报
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-7-13（创建日期）
	* @Parameters: 无
	* @Return: String：跳转到file/file_downUI
	*/
	public String isReport() throws IOException
	{	
		User user=(User) ServletActionContext.getContext().getSession().get(Constant.USER);
		List<UseState> useStates=useStateService.getIsDownByUseridAndFileid(fileid,user.getUserid());

		
		ActionContext.getContext().put("fileid", fileid);
		//判断是否下载过
		if(useStates.size()>0)
		{
			
			useState=useStates.get(0);
			if(useState.getReport()==0)//可以评论
			{
				System.out.println("可以举报");
//				useState.setState(1);
//				useStateService.update(useState);
				return "reportUI";
			}
			else//举报过
			{
				System.out.println("举报过");
				return "fileLookId";
			}		
		}
		else//没有下载，无法举报
		{
			System.out.println("没有下载，无法举报");
			return "fileLookId";
		}
	}


	public String getFileid() {
		return fileid;
	}


	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public UseState getUseState() {
		return useState;
	}

	public void setUseState(UseState useState) {
		this.useState = useState;
	}



	public Comment getComment() {
		return comment;
	}



	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
