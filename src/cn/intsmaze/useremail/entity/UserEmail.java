package cn.intsmaze.useremail.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户注册表单提交后，把该表的userEamilId和email作为邮件信息发给用户邮箱，用户点击邮件中的连接，服务器接收连接中的userEamilId和email数据验证是否和
 * 表中一样，一样则激活成功，这时候把该信息转存到user表，同时删除该记录。
 * */
public class UserEmail implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userEamilId;
	private String account;
	private String password;
	private String email;		
	private Date date;//创建时间，调度器每一个小时扫描该表一次，发现距创建时间有24小时的字段就删除包含该字段的记录。

	public String getUserEamilId() {
		return userEamilId;
	}
	public void setUserEamilId(String userEamilId) {
		this.userEamilId = userEamilId;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "User [ " + account
				+ ", password=" + password + ", image="
				+ email + ", birthday=";
	}
	
	
}
