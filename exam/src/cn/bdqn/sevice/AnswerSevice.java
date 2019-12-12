package cn.bdqn.sevice;

import cn.bdqn.entity.Answer;

public interface AnswerSevice {

	
	/**
	 * 根据id查询答案
	 * @param issuseId
	 * @return
	 */
	public Answer queryIssueIdAnswer(Integer id);
}
