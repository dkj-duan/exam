package cn.bdqn.dao;
import cn.bdqn.entity.Admin;

/**
 * ����Աdao
 *
 */
public interface AdminDao {
	
	/**
	 * ��ѯ����Ա�Ƿ����
	 * @param adminName  �˺�
	 * @param adminPwd  ����
	 * @return ���ز�ѯ���Ľ��
	 */
	public Admin selectAdmin(String adminName,String adminPwd);
	
	/**
	 * ��ӹ���Ա
	 * @param admin ����Ա����
	 */
	public void insertIntoAdmin(Admin admin);
	
	/**
	 * ��ѯ�û����Ƿ����
	 * @param name
	 * @return
	 */
	public Admin selectAdminName(String name);
}
