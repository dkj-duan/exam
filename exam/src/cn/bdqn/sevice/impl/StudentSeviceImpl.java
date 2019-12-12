package cn.bdqn.sevice.impl;

import cn.bdqn.dao.StudentDao;
import cn.bdqn.dao.impl.StudentDaoimpl;
import cn.bdqn.entity.Student;
import cn.bdqn.sevice.StudentSevice;

/**
 * 学生业务实现类
 *
 */
public class StudentSeviceImpl implements StudentSevice {

	private StudentDao stuDao = new StudentDaoimpl();
	/**
	 * 登录
	 */
	@Override
	public Student stuLogin(String stuName, String StuPwd) {
		//调用方法 并返回结果
		return stuDao.selectStu(stuName, StuPwd);
	}

	/**
	 * 注册
	 */
	@Override
	public void stuRegister(Student stu) {
		//调用添加信息的方法
		stuDao.insertIntoStu(stu);
		
	}

	/**
	 * 判断注册用户名是否可用
	 */
	@Override
	public Student queryName(String name) {
		
		return stuDao.selectName(name);
	}

	/**
	 * 修改密码
	 */
	@Override
	public void updatePwd(Student stu) {
		stuDao.updatePwd(stu);
		
	}

}
