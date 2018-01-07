package cn.itcast.core.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

public class SysResultAction extends StrutsResultSupport {

	@Override
	protected void doExecute(String arg0, ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		BaseAction action = (BaseAction)invocation.getAction();
		
		//do something
		System.out.println("进入了 SysResultAction ...");
	}

}
