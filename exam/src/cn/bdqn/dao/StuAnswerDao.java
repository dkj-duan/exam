package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.StuAnswer;

public interface StuAnswerDao {

	/**
	 * 添加学生答案信息
	 * @param sAns
	 */
	public void insertStuAnswer(StuAnswer sAns);
	
	/**
	 * 查询学生答案
	 * @return
	 */
	public List<StuAnswer> selectAnswer();
}
