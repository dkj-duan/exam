package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Answer;

public interface AnswerDao {

	/**
	 * ��ӱ�׼��
	 * @param answer
	 */
	public void insertAnswer(Answer answer);
	
	/**
	 * ��ѯȫ����׼��
	 * @return
	 */
	public List<Answer> seletAnswer();
	
	/**
	 * ����id��ѯ��
	 * @param issuseId
	 * @return
	 */
	public Answer selectIssueIdAnswer(Integer id);
}
