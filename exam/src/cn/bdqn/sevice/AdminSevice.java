package cn.bdqn.sevice;

import cn.bdqn.entity.Admin;

/**
 * ����Աҵ������ӿ�
 */
public interface AdminSevice {

	
	/**
	 * ����Ա��¼
	 * @param adminName �˺�
	 * @param adminPwd  ����
	 * @return
	 */
	public Admin adminLogin(String adminName,String adminPwd);
	
	/**
	 * ע�����Ա
	 * @param admin
	 */
	public void adminRegister(Admin admin);
	
	/**
	 * ��ѯ�û����Ƿ����
	 * @param name
	 * @return
	 */
	public Admin queryName(String name);
}
