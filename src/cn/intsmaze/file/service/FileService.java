package cn.intsmaze.file.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.lucene.document.Document;

import cn.intsmaze.core.page.PageResult;
import cn.intsmaze.core.service.BaseService;
import cn.intsmaze.file.entity.FileResource;
import cn.intsmaze.file.entity.UserFile;

public interface FileService extends BaseService<UserFile>{
	public final static String SERVICE_NAME=
			"cn.intsmaze.file.service.impl.FileServiceImpl";

	public List<UserFile> getFileByUserid(String user);

	UserFile getFileByid(String fileid);
	 /**
	 * @throws Exception
	 * @Name: saveAndIndex
	 * @Description: 存储该上传文件信息到数据库，同时把文件的某些字段转换为lucene中的document中，存储到索引库中
	 * @Author: 刘洋（作者）
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2015-10-23（创建日期）
	 * @Parameters: 无
	 */
	public void saveAndIndex(UserFile userFile) throws IOException;
	
	
	public PageResult highLighter(String selectname,int pageNo, int pageSize) throws Exception ;
}
