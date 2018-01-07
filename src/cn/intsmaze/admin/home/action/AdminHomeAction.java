package cn.intsmaze.admin.home.action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;


@Controller("adminHomeAction")
@Scope(value="prototype")
public class AdminHomeAction extends ActionSupport {
	
	
	//跳转到纳税访问系统首页
	public String frame(){
		return "home";
	}
		
	//跳转到纳税访问系统首页-顶部
	public String top(){
		return "top";
	}
	
	
	//跳转到纳税访问系统首页-左边菜单
	public String left(){
		
		return "left";
	}

}
