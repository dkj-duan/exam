package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.StuAnswer;

public interface StuAnswerDao {

	/**
	 * ���ѧ������Ϣ
	 * @param sAns
	 */
	public void insertStuAnswer(StuAnswer sAns);
	
	/**
	 * ��ѯѧ����
	 * @return
	 */
	public List<StuAnswer> selectAnswer();
}
