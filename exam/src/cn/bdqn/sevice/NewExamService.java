package cn.bdqn.sevice;

import java.util.List;

import cn.bdqn.entity.NewExam;

public interface NewExamService {

	/**
	 * 添加考试题目
	 * @param exam
	 * @param answer
	 */
	public void addNewExam(NewExam exam);
	
	/**
	 * 查询全部考试题目
	 * @return
	 */
	public List<NewExam> allExam(Integer paperId);
	
	/**
	 * 查询单个题目
	 * @param issueId
	 * @return
	 */
	public NewExam querySingleExam(Integer issueId);
	
	/**
	 * 根据试卷id 查询内容
	 * @param paperId
	 * @return
	 */
	public List<NewExam> selectPaperId(Integer paperId);
	
	/**
	 * 根据试卷id删除试卷题目
	 * @param paperId
	 */
	public void delNewExam(Integer paperId);
}
