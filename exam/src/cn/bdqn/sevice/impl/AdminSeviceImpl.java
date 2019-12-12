package cn.bdqn.sevice.impl;

import cn.bdqn.dao.AdminDao;
import cn.bdqn.dao.impl.AdminDaoImpl;
import cn.bdqn.entity.Admin;
import cn.bdqn.sevice.AdminSevice;

public class AdminSeviceImpl implements AdminSevice {

	private AdminDao adDao = new AdminDaoImpl();
	/**
	 * ����Ա��¼
	 */
	@Override
	public Admin adminLogin(String adminName, String adminPwd) {
		//���÷���
		return adDao.selectAdmin(adminName, adminPwd);
	}

	/**
	 * ע�����Ա
	 */
	@Override
	public void adminRegister(Admin admin) {
		//���������Ϣ�ķ���
		adDao.insertIntoAdmin(admin);
		
	}

	/**
	 * ��ѯ�û����Ƿ����
	 */
	@Override
	public Admin queryName(String name) {
		return adDao.selectAdminName(name);
	}

}
