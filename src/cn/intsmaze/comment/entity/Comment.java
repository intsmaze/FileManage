package cn.intsmaze.comment.entity;

import java.util.Date;

import cn.intsmaze.file.entity.UserFile;
import cn.intsmaze.user.entity.User;

public class Comment {
	
	private String commentId;
	private String text;
	private int rate;
	private Date date;//评论时间
	
	private User user;

	
	
	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
