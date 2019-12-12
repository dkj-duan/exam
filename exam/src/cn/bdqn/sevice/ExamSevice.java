package cn.bdqn.sevice;

import java.util.List;

import cn.bdqn.entity.Answer;
import cn.bdqn.entity.Exam;

/**
 * 添加试题业务
 */
public interface ExamSevice {

	/**
	 * 添加考试题目
	 * @param exam
	 * @param answer
	 */
	public void addExam(Exam exam,Answer answer);
	
	/**
	 * 查询全部考试题目
	 * @return
	 */
	public List<Exam> allExam();
	
	/**
	 * 查询单个题目
	 * @param issueId
	 * @return
	 */
	public Exam selectSingleExam(Integer issueId);
	
}
