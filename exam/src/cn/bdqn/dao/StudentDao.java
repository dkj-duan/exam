package cn.bdqn.dao;

import cn.bdqn.entity.Student;

/**
 * 学生dao接口
 *
 */
public interface StudentDao {

	/**
	 * 查询学生是否存在
	 * @param stuName 学生账号
	 * @param StuPwd 学生密码
	 * @return 返回查询到的学生
	 */
	public Student selectStu(String stuName,String StuPwd);
	
	/**\
	 * 添加学生
	 * @param stu 学生对象
	 */
	public void insertIntoStu(Student stu);
	/**
	 *根据用户名查询
	 * @param name
	 * @return
	 */
	public Student selectName(String name);
	/**
	 * 更新密码
	 */
	public void updatePwd(Student stu);
	
}
