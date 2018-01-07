package cn.intsmaze.admin.service;

import java.util.List;

import cn.intsmaze.admin.entity.Admin;
import cn.intsmaze.core.service.BaseService;
import cn.intsmaze.user.entity.User;

public interface AdminService extends BaseService<Admin>{
	
	public final static String SERVICE_NAME=
			"cn.intsmaze.admin.service.AdminServiceImpl";

	List<Admin> getAdminByAccountAndPassword(String account, String password);

}
