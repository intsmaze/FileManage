package cn.intsmaze.user.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.intsmaze.file.entity.FileResource;
import cn.intsmaze.file.entity.UserFile;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userid;
	private String account;
	private String password;
	private String image;
	private String email;
	private int state;//不能通过注册添加，注册默认为0,（普通用户），如果设置为1，则说明该账号被冻结
	private int badBehavior;//该用户的恶意行为，记录大于2次，把该用户state设置为1，冻结他
		
	private Date birthday;//生日
	private String name ;//昵称

	
	//用户和文件的级联和加载策略：不存在用户删除情况，存在查询用户时，需要得到它的文件，这里用懒加载（用户登录时查询，不需要知道他的文件）。
	//只在查看用户文件特定功能时才加载文件列表。
	//查询文件时，立刻加载它的作者。
	private Set<UserFile> userfiles=new HashSet<>();
	
	public Set<UserFile> getUserfiles() {
		return userfiles;
	}
	public void setUserfiles(Set<UserFile> userfiles) {
		this.userfiles = userfiles;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	public int getBadBehavior() {
		return badBehavior;
	}
	public void setBadBehavior(int badBehavior) {
		this.badBehavior = badBehavior;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", account=" + account
				+ ", password=" + password + ", image=" + image + ", email="
				+ email + ", state=" + state + ", badBehavior=" + badBehavior
				+ ", birthday=" + birthday + ", name=" + name + "]";
	}
	
	
	
	
}
