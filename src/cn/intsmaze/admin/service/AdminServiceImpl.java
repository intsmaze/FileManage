package cn.intsmaze.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.intsmaze.admin.dao.AdminDao;
import cn.intsmaze.admin.entity.Admin;
import cn.intsmaze.core.service.BaseServiceImpl;
import cn.intsmaze.user.dao.UserDao;
import cn.intsmaze.user.entity.User;

@Service(AdminService.SERVICE_NAME)
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService{

	private AdminDao adminDao;
	
	
	@Resource (name="adminDaoImpl")
	public void setAdminDao(AdminDao adminDao) {
		super.setBaseDao(adminDao);
		this.adminDao = adminDao;
	}

	public List<Admin> getAdminByAccountAndPassword(String account,String password) {		
		return adminDao.getAdminByAccountAndPassword(account,password);
	}



}
