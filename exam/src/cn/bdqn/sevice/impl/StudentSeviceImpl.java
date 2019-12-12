package cn.bdqn.sevice.impl;

import cn.bdqn.dao.StudentDao;
import cn.bdqn.dao.impl.StudentDaoimpl;
import cn.bdqn.entity.Student;
import cn.bdqn.sevice.StudentSevice;

/**
 * ѧ��ҵ��ʵ����
 *
 */
public class StudentSeviceImpl implements StudentSevice {

	private StudentDao stuDao = new StudentDaoimpl();
	/**
	 * ��¼
	 */
	@Override
	public Student stuLogin(String stuName, String StuPwd) {
		//���÷��� �����ؽ��
		return stuDao.selectStu(stuName, StuPwd);
	}

	/**
	 * ע��
	 */
	@Override
	public void stuRegister(Student stu) {
		//���������Ϣ�ķ���
		stuDao.insertIntoStu(stu);
		
	}

	/**
	 * �ж�ע���û����Ƿ����
	 */
	@Override
	public Student queryName(String name) {
		
		return stuDao.selectName(name);
	}

	/**
	 * �޸�����
	 */
	@Override
	public void updatePwd(Student stu) {
		stuDao.updatePwd(stu);
		
	}

}
