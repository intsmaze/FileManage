package cn.intsmaze.useremail.action;


import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import cn.intsmaze.core.action.BaseAction;
import cn.intsmaze.user.entity.User;
import cn.intsmaze.user.service.UserService;
import cn.intsmaze.useremail.entity.UserEmail;
import cn.intsmaze.useremail.service.UserEmailService;

@Controller("userEmailAction")
@Scope(value="prototype")
public class UserEmailAction extends BaseAction implements ModelDriven<UserEmail>{

	@Resource(name=UserService.SERVICE_NAME)
	private UserService userService;
	
	@Resource(name=UserEmailService.SERVICE_NAME)
	private UserEmailService userEmailService;
	
	private UserEmail userEmail;
		
	//提示信息
	private String tip;
	
	@Override
	public UserEmail getModel() {
		 if(userEmail == null){
			 userEmail = new UserEmail();
	       }
	       return userEmail;
	}
	
	
	/**  
	* @throws IOException 
	* @throws MessagingException 
	* @throws AddressException 
	* @Name: useAccount
	* @Description: 用户点击邮箱的链接激活注册,这里注册成功
	* @Author: 刘洋（作者）
	* @Version: V2.00 （版本号）
	* @Create Date: 2014-7-10（创建日期）
	* @Parameters: 无
	* @Return: String：注册成功跳转到home/home.jsp(系统首页)
	*/
	public String useAccount() throws IOException, AddressException, MessagingException
	{
		List<UserEmail> list=
				userEmailService.getuserEmailByEmail(userEmail.getEmail());	
		if(list.size()>0)
		{
			userEmail=list.get(0);
			User user=new User();
			user.setAccount(userEmail.getAccount());
			user.setEmail(userEmail.getEmail());
			user.setPassword(userEmail.getPassword());
			userService.save(user);
			userEmailService.deleteObjectByIds(userEmail.getUserEamilId());
			tip="邮箱激活成功，现在进入官网首页登录";
			return "success";
		}
		else
		{
			tip="无效的激活";
			return "error";
		}		
	}
	
	/**  
	* @throws IOException 
	* @throws MessagingException 
	* @throws AddressException 
	* @Name: useAccount
	* @Description: 用户注册,这里注册成功，验证用户账号是否已注册在提交前，通过ajax进行验证,进行加密
	* @Author: 刘洋（作者）
	* @Version: V2.00 （版本号）
	* @Create Date: 2014-6-24（创建日期）
	* @Parameters: 无
	* @Return: String：注册成功跳转到home/home.jsp(系统首页)
	*/
	public String useEmail() throws IOException, AddressException, MessagingException
	{
		List<User> list=
				userService.getUserByEmail(userEmail.getEmail());	
		if(list.size()>0)
		{
			User u=list.get(0);
			u.setPassword(userEmail.getPassword());
			userService.update(u);
			tip="密码修改成功，现在进入官网首页登录";
			return "success";
		}
		else
		{
			tip="无效的链接";
			return "error";
		}		
	}
		
	public UserEmail getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(UserEmail userEmail) {
		this.userEmail = userEmail;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}	
}
