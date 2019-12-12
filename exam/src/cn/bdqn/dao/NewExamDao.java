package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.NewExam;

/**
 * 试卷dao
 * @author 段康家
 *
 */
public interface NewExamDao {

	/**
	 * 添加试题
	 * @param exam
	 */
	public void insertExam(NewExam exam);
	
	/**
	 * 查询全部试题 
	 * @return
	 */
	public List<NewExam> selectExam(Integer paperId);
	
	/**
	 * 查询单个题目
	 * @param issueId
	 * @return
	 */
	public NewExam selectSingleExam(Integer issueId);
	
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
