package cn.bdqn.sevice.impl;

import java.util.List;

import cn.bdqn.dao.AnswerDao;
import cn.bdqn.dao.ExamDao;
import cn.bdqn.dao.impl.AnswerDaoImpl;
import cn.bdqn.dao.impl.ExamDaoImpl;
import cn.bdqn.entity.Answer;
import cn.bdqn.entity.Exam;
import cn.bdqn.sevice.ExamSevice;

public class ExamSeviceImpl implements ExamSevice {

	/**
	 * 创建试题接口对象
	 */
	private ExamDao ed = new ExamDaoImpl();
	/**
	 * 创建标准答案接口对象
	 */
	private AnswerDao ad = new AnswerDaoImpl();
	/**
	 * 添加考试试题
	 */
	@Override
	public void addExam(Exam exam, Answer answer) {
		//调用添加试题的方法并获得添加试题的id
		 int issueId = ed.insertExam(exam);
		 //传入试题id
		 answer.setIssueId(issueId);
		 //添加标准答案
		 ad.insertAnswer(answer);
	}
	/**
	 * 查询全部考试题目
	 */
	@Override
	public List<Exam> allExam() {
		return ed.selectExam();
	}
	@Override
	public Exam selectSingleExam(Integer issueId) {
		
		return ed.selectSingleExam(issueId);
	}


}
