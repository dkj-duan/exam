package cn.bdqn.sevice;

import java.util.List;

import cn.bdqn.entity.Answer;
import cn.bdqn.entity.Exam;

/**
 * �������ҵ��
 */
public interface ExamSevice {

	/**
	 * ��ӿ�����Ŀ
	 * @param exam
	 * @param answer
	 */
	public void addExam(Exam exam,Answer answer);
	
	/**
	 * ��ѯȫ��������Ŀ
	 * @return
	 */
	public List<Exam> allExam();
	
	/**
	 * ��ѯ������Ŀ
	 * @param issueId
	 * @return
	 */
	public Exam selectSingleExam(Integer issueId);
	
}
