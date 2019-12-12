package cn.bdqn.sevice.impl;

import cn.bdqn.dao.AdminDao;
import cn.bdqn.dao.impl.AdminDaoImpl;
import cn.bdqn.entity.Admin;
import cn.bdqn.sevice.AdminSevice;

public class AdminSeviceImpl implements AdminSevice {

	private AdminDao adDao = new AdminDaoImpl();
	/**
	 * 管理员登录
	 */
	@Override
	public Admin adminLogin(String adminName, String adminPwd) {
		//调用方法
		return adDao.selectAdmin(adminName, adminPwd);
	}

	/**
	 * 注册管理员
	 */
	@Override
	public void adminRegister(Admin admin) {
		//调用添加信息的方法
		adDao.insertIntoAdmin(admin);
		
	}

	/**
	 * 查询用户名是否存在
	 */
	@Override
	public Admin queryName(String name) {
		return adDao.selectAdminName(name);
	}

}
