package cn.bdqn.sevice;

import cn.bdqn.entity.Answer;

public interface AnswerSevice {

	
	/**
	 * ����id��ѯ��
	 * @param issuseId
	 * @return
	 */
	public Answer queryIssueIdAnswer(Integer id);
}
