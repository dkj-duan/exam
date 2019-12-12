package cn.bdqn.sevice.impl;

import java.util.List;

import cn.bdqn.dao.NewExamDao;
import cn.bdqn.dao.impl.NewExamDaoImpl;
import cn.bdqn.entity.NewExam;
import cn.bdqn.sevice.NewExamService;

public class NewExamServiceImpl implements NewExamService {
	private NewExamDao examDao = new NewExamDaoImpl();
	
	@Override
	public void addNewExam(NewExam exam) {
		
		examDao.insertExam(exam);

	}

	@Override
	public List<NewExam> allExam(Integer paperId) {
		
		return examDao.selectExam(paperId);
	}

	@Override
	public NewExam querySingleExam(Integer issueId) {
		
		return examDao.selectSingleExam(issueId);
	}

	@Override
	public List<NewExam> selectPaperId(Integer paperId) {
		return examDao.selectPaperId(paperId);
	}

	/**
	 * É¾³ý
	 */
	@Override
	public void delNewExam(Integer paperId) {
		examDao.delNewExam(paperId);
		
	}

}
