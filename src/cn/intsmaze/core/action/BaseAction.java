package cn.intsmaze.core.action;
import java.util.List;

import cn.intsmaze.core.page.PageResult;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public abstract class BaseAction extends ActionSupport {
	
	
	
	//该对象封装了总记录数，当前页号，总页数，页大小，以及那一页显示的列表记录集合
	//计算总页数public PageResult(long totalCount, int pageNo, 
	//int pageSize, List items)
	protected PageResult pageResult;
	
	private int pageNo;
	private int pageSize;
	
	//默认页大小
	public static int DEFAULT_PAGE_SIZE = 2;
	
	public int getPageSize() {
		if(pageSize < 1) 
			pageSize = DEFAULT_PAGE_SIZE;
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public PageResult getPageResult() {
		return pageResult;
	}
	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}	
}
