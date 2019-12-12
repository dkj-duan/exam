package cn.bdqn.dao;

import cn.bdqn.entity.Student;

/**
 * ѧ��dao�ӿ�
 *
 */
public interface StudentDao {

	/**
	 * ��ѯѧ���Ƿ����
	 * @param stuName ѧ���˺�
	 * @param StuPwd ѧ������
	 * @return ���ز�ѯ����ѧ��
	 */
	public Student selectStu(String stuName,String StuPwd);
	
	/**\
	 * ���ѧ��
	 * @param stu ѧ������
	 */
	public void insertIntoStu(Student stu);
	/**
	 *�����û�����ѯ
	 * @param name
	 * @return
	 */
	public Student selectName(String name);
	/**
	 * ��������
	 */
	public void updatePwd(Student stu);
	
}
