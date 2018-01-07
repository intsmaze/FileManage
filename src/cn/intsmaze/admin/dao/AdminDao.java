package cn.intsmaze.admin.dao;

import java.util.List;

import cn.intsmaze.admin.entity.Admin;
import cn.intsmaze.core.dao.BaseDao;
import cn.intsmaze.user.entity.User;

public interface AdminDao extends BaseDao<Admin>{

	List<Admin> getAdminByAccountAndPassword(String account, String password);

}
