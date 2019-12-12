package cn.bdqn.sevice;

import java.util.List;

import cn.bdqn.entity.NewExam;

public interface NewExamService {

	/**
	 * ��ӿ�����Ŀ
	 * @param exam
	 * @param answer
	 */
	public void addNewExam(NewExam exam);
	
	/**
	 * ��ѯȫ��������Ŀ
	 * @return
	 */
	public List<NewExam> allExam(Integer paperId);
	
	/**
	 * ��ѯ������Ŀ
	 * @param issueId
	 * @return
	 */
	public NewExam querySingleExam(Integer issueId);
	
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
