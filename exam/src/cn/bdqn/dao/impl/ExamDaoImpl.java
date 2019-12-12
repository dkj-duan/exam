package cn.bdqn.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.ExamDao;
import cn.bdqn.entity.Exam;
import cn.bdqn.utils.JdbcUtil;

public class ExamDaoImpl implements ExamDao {

	/**
	 * ������Ⲣ��������id
	 */
	@Override
	public int insertExam(Exam exam) {
		//����sql���
		String sql = " INSERT INTO t_exam(issueText,issueType,score,answerA,answerB,answerC,answerD) "
					  + "	 VALUES(?,?,?,?,?,?,?)";
		Object [] obj = {exam.getIssueText(),exam.getIssueType(),exam.getScore(),exam.getAnswerA()
							,exam.getAnswerB(),exam.getAnswerC(),exam.getAnswerD()};
		int id = JdbcUtil.executeUpdate(sql, obj);
		return id;
	}

	/**
	 * ��ѯȫ������
	 */
	@Override
	public List<Exam> selectExam() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Exam> examList = new ArrayList<Exam>();//���⼯��
		Exam exam = null;//�����������
		try {
			//�������
			conn = JdbcUtil.getConection();
			//����sql���
			String sql = "  SELECT issueId,issueText,issueType,score,answerA,answerB,answerC,answerD"
					+ " FROM t_exam"
					+ " ORDER BY RAND()  "
					+ "LIMIT 0,20";
			//���ps����
			ps = conn.prepareStatement(sql);
			//ִ�в����ؽ��
			rs = ps.executeQuery();
			//ѭ������
			while (rs.next()) {
				exam = new Exam();
				exam.setIssueId(rs.getInt("issueId"));
				exam.setIssueText(rs.getString("issueText"));
				exam.setIssueType(rs.getInt("issueType"));
				exam.setScore(rs.getInt("score"));
				exam.setAnswerA(rs.getString("answerA"));
				exam.setAnswerB(rs.getString("answerB"));
				exam.setAnswerC(rs.getString("answerC"));
				exam.setAnswerD(rs.getString("answerD"));
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
	public Exam selectSingleExam(Integer issueId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Exam exam = null;//�����������
		try {
			//�������
			conn = JdbcUtil.getConection();
			//����sql���
			String sql = "   SELECT issueId,issueText,issueType,score,answerA,answerB,answerC,answerD  "
					+ "  FROM t_exam  "
					+ "  WHERE  issueId = ?  ";
			//���ps����
			ps = conn.prepareStatement(sql);
			//���ռλ��
			ps.setInt(1, issueId);
			//ִ�в����ؽ��
			rs = ps.executeQuery();
			//ѭ������
			while (rs.next()) {
				exam = new Exam();
				exam.setIssueId(rs.getInt("issueId"));
				exam.setIssueText(rs.getString("issueText"));
				exam.setIssueType(rs.getInt("issueType"));
				exam.setScore(rs.getInt("score"));
				exam.setAnswerA(rs.getString("answerA"));
				exam.setAnswerB(rs.getString("answerB"));
				exam.setAnswerC(rs.getString("answerC"));
				exam.setAnswerD(rs.getString("answerD"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		return exam;
	}

}
