package cn.intsmaze.usestate.entity;

import cn.intsmaze.file.entity.UserFile;
import cn.intsmaze.user.entity.User;

public class UseState {

	private String useStateId;
	//这两个字段判断用户是否已经下载了该文件，那么就不能在执行下载加1记录
	private String userId;
	private String userFileId;
	
	//评论了就不能评论
	private int state;//记录用户是否对该文件进行过评论
	
	//举报了就不能再举报
	private int report;//记录用户是否对该文件进行过举报
	
	public String getUseStateId() {
		return useStateId;
	}
	public void setUseStateId(String useStateId) {
		this.useStateId = useStateId;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	
	
	
}
