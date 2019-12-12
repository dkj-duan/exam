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
	 * ��������ӿڶ���
	 */
	private ExamDao ed = new ExamDaoImpl();
	/**
	 * ������׼�𰸽ӿڶ���
	 */
	private AnswerDao ad = new AnswerDaoImpl();
	/**
	 * ��ӿ�������
	 */
	@Override
	public void addExam(Exam exam, Answer answer) {
		//�����������ķ����������������id
		 int issueId = ed.insertExam(exam);
		 //��������id
		 answer.setIssueId(issueId);
		 //��ӱ�׼��
		 ad.insertAnswer(answer);
	}
	/**
	 * ��ѯȫ��������Ŀ
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
