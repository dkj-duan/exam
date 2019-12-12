package cn.bdqn.sevice;

import java.util.List;

import cn.bdqn.entity.Grade;

/**
 * �ɼ�ҵ����
 * @author �ο���
 *
 */
public interface GradeService {

	/**
	 * ���
	 */
	public void addGrade(Grade grade);
	
	/**
	 * ����ѧ��id��ѯ
	 * @param stuId
	 * @return
	 */
	public List<Grade> queryGrade(Integer stuId);
	
	/**
	 * �������Ծ�
	 */
	public void insterGrade(Grade grade);
	
	
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
