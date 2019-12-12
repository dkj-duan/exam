package cn.bdqn.sevice;

import cn.bdqn.entity.Admin;

/**
 * 管理员业务操作接口
 */
public interface AdminSevice {

	
	/**
	 * 管理员登录
	 * @param adminName 账号
	 * @param adminPwd  密码
	 * @return
	 */
	public Admin adminLogin(String adminName,String adminPwd);
	
	/**
	 * 注册管理员
	 * @param admin
	 */
	public void adminRegister(Admin admin);
	
	/**
	 * 查询用户名是否存在
	 * @param name
	 * @return
	 */
	public Admin queryName(String name);
}
