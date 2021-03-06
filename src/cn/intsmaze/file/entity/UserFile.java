package cn.intsmaze.file.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.sql.HSQLCaseFragment;

import cn.intsmaze.comment.entity.Comment;
import cn.intsmaze.user.entity.User;

public class UserFile implements Serializable{
	
	private String fileId;
	private String title;//文件标题
	private String introduce;//介绍
	private long downcount;//下载次数
	
	private long goodcomment;
	private long badcomment;
	private Date date;//上传时间
	private String totalSize;//文件总大小
	
	private boolean isUse;//该文件是否被封，0是可见，1是不可见
	
	
	
	//文件作者
	private User user;
	
	//这个文件实际对应的多个资源文件位置
	private Set<FileResource> fileResource=new HashSet<>();

	private Set<Comment> comments=new HashSet<>();

	
	/**
	 * 非实体属性，用来封装返回页面显示的值
	 * */
	private long totalComment;//总评论数
	private String rate;//好评比例
	

	
	
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public long getTotalComment() {
		return totalComment;
	}
	public void setTotalComment(long totalComment) {
		this.totalComment = totalComment;
	}

	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	public long getGoodcomment() {
		return goodcomment;
	}
	public void setGoodcomment(long goodcomment) {
		this.goodcomment = goodcomment;
	}
	public long getBadcomment() {
		return badcomment;
	}
	public void setBadcomment(long badcomment) {
		this.badcomment = badcomment;
	}
	public Set<FileResource> getFileResource() {
		return fileResource;
	}
	public void setFileResource(Set<FileResource> fileResource) {
		this.fileResource = fileResource;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public long getDowncount() {
		return downcount;
	}
	public void setDowncount(long downcount) {
		this.downcount = downcount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(String totalSize) {
		this.totalSize = totalSize;
	}
	
	
	public boolean isUse() {
		return isUse;
	}
	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}
	@Override
	public String toString() {
		return "UserFile [fileId=" + fileId + ", title=" + title
				+ ", introduce=" + introduce + ", downcount=" + downcount
				+ ", goodcomment=" + goodcomment + ", badcomment=" + badcomment
				+ ", date=" + date + ", totalSize=" + totalSize + ", user="
				+ user + ", fileResource=" + fileResource + ", comments="
				+ comments + ", totalComment=" + totalComment + ", rate="
				+ rate + "]";
	}
	
}
