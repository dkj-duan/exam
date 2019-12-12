package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.NewExam;

/**
 * �Ծ�dao
 * @author �ο���
 *
 */
public interface NewExamDao {

	/**
	 * �������
	 * @param exam
	 */
	public void insertExam(NewExam exam);
	
	/**
	 * ��ѯȫ������ 
	 * @return
	 */
	public List<NewExam> selectExam(Integer paperId);
	
	/**
	 * ��ѯ������Ŀ
	 * @param issueId
	 * @return
	 */
	public NewExam selectSingleExam(Integer issueId);
	
	/**
	 * �����Ծ�id ��ѯ����
	 * @param paperId
	 * @return
	 */
	public List<NewExam> selectPaperId(Integer paperId);
	
	/**
	 * �����Ծ�idɾ���Ծ���Ŀ
	 * @param paperId
	 */
	public void delNewExam(Integer paperId);
}
