package cn.bdqn.sevice.impl;


import cn.bdqn.dao.AnswerDao;
import cn.bdqn.dao.impl.AnswerDaoImpl;
import cn.bdqn.entity.Answer;
import cn.bdqn.sevice.AnswerSevice;

public class AnswerSeviceImpl implements AnswerSevice {

	private AnswerDao ad = new AnswerDaoImpl();
	
	
	/**
	 * ²éÑ¯´ð°¸
	 */
	@Override
	public Answer queryIssueIdAnswer(Integer id) {
		return ad.selectIssueIdAnswer(id);
	}

}
