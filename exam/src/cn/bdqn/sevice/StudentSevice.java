package cn.bdqn.sevice;

import cn.bdqn.entity.Student;

/**
 * ѧ��ҵ����
 *
 */
public interface StudentSevice {

	/**
	 * ��¼
	 * @param stuName �˺�
	 * @param StuPwd ����
	 * @return ����ֵ
	 */
	public Student stuLogin(String stuName,String StuPwd);
	
	
	/**
	 * ע��ѧ����Ϣ
	 * @param stu
	 */
	public void  stuRegister(Student stu);
	
	/**
	 * ����������ѯ
	 * @param name
	 * @return
	 */
	public Student queryName(String name);
	
	/**
	 * ��������
	 */
	public void updatePwd(Student stu);
}
