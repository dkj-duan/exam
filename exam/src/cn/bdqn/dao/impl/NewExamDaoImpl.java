package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.NewExamDao;
import cn.bdqn.entity.NewExam;
import cn.bdqn.utils.JdbcUtil;

public class NewExamDaoImpl implements NewExamDao {

	/**
	 * �������
	 */
	@Override
	public void insertExam(NewExam exam) {
		//����sql���
		String sql = " INSERT INTO t_NewExam(issueText,issueType,score,paperId,answerA,answerB,answerC,answerD,answer) "
					  + "	 VALUES(?,?,?,?,?,?,?,?,?)";
		Object [] obj = {exam.getIssueText(),exam.getIssueType(),exam.getScore(),exam.getPaperId()
								,exam.getAnswerA()
								,exam.getAnswerB()
								,exam.getAnswerC()
								,exam.getAnswerD()
								,exam.getAnswer()};
		JdbcUtil.executeUpdate(sql, obj);
	}

	/**
	 * ��ѯȫ������
	 */
	@Override
	public List<NewExam> selectExam(Integer paperId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<NewExam> examList = new ArrayList<NewExam>();//���⼯��
		NewExam exam = null;//�����������
		try {
			//�������
			conn = JdbcUtil.getConection();
			//����sql���
			String sql = "   SELECT issueId,issueText,issueType,score,paperId,answerA,answerB,answerC,answerD,answer  "
					+ "  FROM t_NewExam  "
					+ "  WHERE  paperId = ?  "
					+ "   ORDER BY RAND()  "
					+ "   LIMIT 0,20 ";
			//���ps����
			ps = conn.prepareStatement(sql);
			//���ռλ��
			ps.setInt(1, paperId);
			//ִ�в����ؽ��
			rs = ps.executeQuery();
			//ѭ������
			while (rs.next()) {
				exam = new NewExam();
				exam.setIssueId(rs.getInt("issueId"));
				exam.setIssueText(rs.getString("issueText"));
				exam.setIssueType(rs.getInt("issueType"));
				exam.setScore(rs.getInt("score"));
				exam.setPaperId(rs.getInt("paperId"));
				exam.setAnswerA(rs.getString("answerA"));
				exam.setAnswerB(rs.getString("answerB"));
				exam.setAnswerC(rs.getString("answerC"));
				exam.setAnswerD(rs.getString("answerD"));
				exam.setAnswer(rs.getString("answer"));
				examList.add(exam);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		return examList;
	}

	@Override
	public NewExam selectSingleExam(Integer issueId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		NewExam exam = null;//�����������
		try {
			//�������
			conn = JdbcUtil.getConection();
			//����sql���
			String sql = "   SELECT issueId,issueText,issueType,score,paperId,answerA,answerB,answerC,answerD,answer  "
					+ "  FROM t_NewExam  "
					+ "  WHERE  issueId = ?  ";
			//���ps����
			ps = conn.prepareStatement(sql);
			//���ռλ��
			ps.setInt(1, issueId);
			//ִ�в����ؽ��
			rs = ps.executeQuery();
			//ѭ������
			while (rs.next()) {
				exam = new NewExam();
				exam.setIssueId(rs.getInt("issueId"));
				exam.setIssueText(rs.getString("issueText"));
				exam.setIssueType(rs.getInt("issueType"));
				exam.setScore(rs.getInt("score"));
				exam.setPaperId(rs.getInt("paperId"));
				exam.setAnswerA(rs.getString("answerA"));
				exam.setAnswerB(rs.getString("answerB"));
				exam.setAnswerC(rs.getString("answerC"));
				exam.setAnswerD(rs.getString("answerD"));
				exam.setAnswer(rs.getString("answer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		return exam;
	}

	@Override
	public List<NewExam> selectPaperId(Integer paperId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<NewExam> examList = new ArrayList<NewExam>();//���⼯��
		NewExam exam = null;//�����������
		try {
			//�������
			conn = JdbcUtil.getConection();
			//����sql���
			String sql = "   SELECT  issueId,issueText,issueType,score,paperId,answerA,answerB,answerC,answerD,answer  "
					+ "  FROM t_NewExam  "
					+ "  WHERE  paperId = ?  ";
			//���ps����
			ps = conn.prepareStatement(sql);
			//���ռλ��
			ps.setInt(1, paperId);
			//ִ�в����ؽ��
			rs = ps.executeQuery();
			//ѭ������
			while (rs.next()) {
				exam = new NewExam();
				exam.setIssueId(rs.getInt("issueId"));
				exam.setIssueText(rs.getString("issueText"));
				exam.setIssueType(rs.getInt("issueType"));
				exam.setScore(rs.getInt("score"));
				exam.setPaperId(rs.getInt("paperId"));
				exam.setAnswerA(rs.getString("answerA"));
				exam.setAnswerB(rs.getString("answerB"));
				exam.setAnswerC(rs.getString("answerC"));
				exam.setAnswerD(rs.getString("answerD"));
				exam.setAnswer(rs.getString("answer"));
				examList.add(exam);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		return examList;
	}

	/**
	 * ɾ��
	 */
	@Override
	public void delNewExam(Integer paperId) {
		//����sql
		String sql = "DELETE FROM t_NewExam WHERE paperId=?";
		//���÷���
		JdbcUtil.executeUpdate(sql, paperId);
	}

}
