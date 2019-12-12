package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Answer;

public interface AnswerDao {

	/**
	 * 添加标准答案
	 * @param answer
	 */
	public void insertAnswer(Answer answer);
	
	/**
	 * 查询全部标准答案
	 * @return
	 */
	public List<Answer> seletAnswer();
	
	/**
	 * 根据id查询答案
	 * @param issuseId
	 * @return
	 */
	public Answer selectIssueIdAnswer(Integer id);
}
