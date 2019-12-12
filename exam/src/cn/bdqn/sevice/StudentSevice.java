package cn.bdqn.sevice;

import cn.bdqn.entity.Student;

/**
 * 学生业务类
 *
 */
public interface StudentSevice {

	/**
	 * 登录
	 * @param stuName 账号
	 * @param StuPwd 密码
	 * @return 返回值
	 */
	public Student stuLogin(String stuName,String StuPwd);
	
	
	/**
	 * 注册学生信息
	 * @param stu
	 */
	public void  stuRegister(Student stu);
	
	/**
	 * 根据姓名查询
	 * @param name
	 * @return
	 */
	public Student queryName(String name);
	
	/**
	 * 更新密码
	 */
	public void updatePwd(Student stu);
}
