package cn.bdqn.dao;
import cn.bdqn.entity.Admin;

/**
 * 管理员dao
 *
 */
public interface AdminDao {
	
	/**
	 * 查询管理员是否存在
	 * @param adminName  账号
	 * @param adminPwd  密码
	 * @return 返回查询到的结果
	 */
	public Admin selectAdmin(String adminName,String adminPwd);
	
	/**
	 * 添加管理员
	 * @param admin 管理员对象
	 */
	public void insertIntoAdmin(Admin admin);
	
	/**
	 * 查询用户名是否存在
	 * @param name
	 * @return
	 */
	public Admin selectAdminName(String name);
}
