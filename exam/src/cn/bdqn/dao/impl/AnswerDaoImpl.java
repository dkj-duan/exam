package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.AnswerDao;
import cn.bdqn.entity.Answer;
import cn.bdqn.utils.JdbcUtil;

public class AnswerDaoImpl implements AnswerDao {

	/**
	 * ��ӱ�׼��
	 */
	@Override
	public void insertAnswer(Answer answer) {

		// ����sql���
		String sql = "INSERT INTO t_answer(issueId,answer) " + " 	VALUES(?,?)";
		// �������
		Object[] obj = { answer.getIssueId(), answer.getAnswer() };

		// ���÷���
		JdbcUtil.executeUpdate(sql, obj);

	}

	/**
	 * ��ѯ��׼��
	 */
	@Override
	public List<Answer> seletAnswer() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// ��׼�𰸼���
		List<Answer> answerList = new ArrayList<Answer>();
		// ��׼�𰸶���
		Answer ans = null;
		try {
			// �������
			conn = JdbcUtil.getConection();
			// ����sql
			String sql = "";
			// ���ps ����
			ps = conn.prepareStatement(sql);
			// ִ�в����ս��
			rs = ps.executeQuery();
			// ѭ��������ӵ�������
			while (rs.next()) {
				// ʵ������׼�𰸶���
				ans = new Answer();
				ans.setAnswerId(rs.getInt("answerId"));
				ans.setIssueId(rs.getInt("issueId"));
				ans.setAnswer(rs.getString("answer"));
				answerList.add(ans);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		
		//��������
		return answerList;
	}

	/**
	 * ����id��ѯ��
	 */
	@Override
	public Answer selectIssueIdAnswer(Integer id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// ��׼�𰸶���
		Answer ans = null;
		try {
			// �������
			conn = JdbcUtil.getConection();
			// ����sql
			String sql = " SELECT answerId,issueId,answer FROM t_answer WHERE issueId = ?";
			
			// ���ps ����
			ps = conn.prepareStatement(sql);
			//���psֵ
				ps.setObject(1, id);
			
			// ִ�в����ս��
			rs = ps.executeQuery();
			// ѭ��������ӵ�������
			if(rs.next()) {
				// ʵ������׼�𰸶���
				ans = new Answer();
				ans.setAnswerId(rs.getInt("answerId"));
				ans.setIssueId(rs.getInt("issueId"));
				ans.setAnswer(rs.getString("answer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		
		//��������
		return ans;
	}
}
