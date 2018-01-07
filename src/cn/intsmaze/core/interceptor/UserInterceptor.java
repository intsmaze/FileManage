package cn.intsmaze.core.interceptor;

import org.apache.struts2.ServletActionContext;

import cn.intsmaze.core.constant.Constant;
import cn.intsmaze.user.entity.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;


public class UserInterceptor extends MethodFilterInterceptor {

	/**  
	* @Description: 对特定方法进行拦截，判断用户在上传，下载文件，评论文件时是否登录，来决定是否可以执行操作
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-10-26（创建日期）
	* @Parameters: 无
	* @Return: String：
	*/
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User u=(User) ServletActionContext.getContext().getSession().get(Constant.USER);
		if(u!=null)
		{
			return invocation.invoke();
		}
		return "loginUI";
	}

}
