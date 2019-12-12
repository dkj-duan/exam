package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Grade;

public interface GradeDao {

	/**
	 * ��Ӵ��Ծ��
	 */
	public void insterGradePaer(Grade grade);
	
	/**
	 * �������Ծ�
	 */
	public void insterGrade(Grade grade);
	
	/**
	 * ����ѧ��id��ѯ
	 * @param stuId
	 * @return
	 */
	public List<Grade> selectGrade(Integer stuId);
	
	/**
	 * ����ѧ��id���Ծ����ֲ�ѯ
	 * @param stuId
	 * @param paperName
	 * @return
	 */
	public int select(Integer stuId,String paperName);
	
	/**
	 * ����ѧ��id���Ծ��ѯ�Ծ�����
	 * @param stuId
	 * @param paperName
	 * @return
	 */
	public int selectcount(Integer stuId,String paperName);
}
