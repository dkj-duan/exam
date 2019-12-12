package cn.bdqn.dao;
import java.util.List;

import cn.bdqn.entity.Exam;
public interface ExamDao {

	/**
	 * �������
	 * @param exam
	 */
	public int insertExam(Exam exam);
	
	/**
	 * ��ѯȫ������ 
	 * @return
	 */
	public List<Exam> selectExam();
	/**
	 * ��ѯ������Ŀ
	 * @param issueId
	 * @return
	 */
	public Exam selectSingleExam(Integer issueId);
}
