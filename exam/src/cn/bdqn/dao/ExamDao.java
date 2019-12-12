package cn.bdqn.dao;
import java.util.List;

import cn.bdqn.entity.Exam;
public interface ExamDao {

	/**
	 * 添加试题
	 * @param exam
	 */
	public int insertExam(Exam exam);
	
	/**
	 * 查询全部试题 
	 * @return
	 */
	public List<Exam> selectExam();
	/**
	 * 查询单个题目
	 * @param issueId
	 * @return
	 */
	public Exam selectSingleExam(Integer issueId);
}
