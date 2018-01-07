package cn.intsmaze.file.dao;

import java.util.List;
import java.util.Set;

import cn.intsmaze.core.dao.BaseDao;
import cn.intsmaze.file.entity.FileResource;
import cn.intsmaze.file.entity.UserFile;

public interface FileDao extends BaseDao<UserFile>{

	public List<UserFile> getFileByUserid(String user);

}
