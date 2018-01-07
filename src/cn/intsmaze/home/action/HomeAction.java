package cn.intsmaze.home.action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;


@Controller("homeAction")
@Scope(value="prototype")
public class HomeAction extends ActionSupport {
	
	
	//跳转到主页面
	public String home(){
		return "home";
	}
	
	//跳转到主页面
	public String main(){
		return "main";
	}
	
	//跳转到标题页面
	public String title(){
		return "title";
	}
	
}
