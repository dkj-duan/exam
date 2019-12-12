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
	 * 添加试题
	 */
	@Override
	public void insertExam(NewExam exam) {
		//定义sql语句
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
	 * 查询全部试题
	 */
	@Override
	public List<NewExam> selectExam(Integer paperId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<NewExam> examList = new ArrayList<NewExam>();//试题集合
		NewExam exam = null;//创建试题对象
		try {
			//获得连接
			conn = JdbcUtil.getConection();
			//定义sql语句
			String sql = "   SELECT issueId,issueText,issueType,score,paperId,answerA,answerB,answerC,answerD,answer  "
					+ "  FROM t_NewExam  "
					+ "  WHERE  paperId = ?  "
					+ "   ORDER BY RAND()  "
					+ "   LIMIT 0,20 ";
			//获得ps对象
			ps = conn.prepareStatement(sql);
			//填充占位符
			ps.setInt(1, paperId);
			//执行并返回结果
			rs = ps.executeQuery();
			//循环遍历
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
			//关闭连接
			JdbcUtil.close(conn, ps, rs);
		}
		return examList;
	}

	@Override
	public NewExam selectSingleExam(Integer issueId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		NewExam exam = null;//创建试题对象
		try {
			//获得连接
			conn = JdbcUtil.getConection();
			//定义sql语句
			String sql = "   SELECT issueId,issueText,issueType,score,paperId,answerA,answerB,answerC,answerD,answer  "
					+ "  FROM t_NewExam  "
					+ "  WHERE  issueId = ?  ";
			//获得ps对象
			ps = conn.prepareStatement(sql);
			//填充占位符
			ps.setInt(1, issueId);
			//执行并返回结果
			rs = ps.executeQuery();
			//循环遍历
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
			//关闭连接
			JdbcUtil.close(conn, ps, rs);
		}
		return exam;
	}

	@Override
	public List<NewExam> selectPaperId(Integer paperId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<NewExam> examList = new ArrayList<NewExam>();//试题集合
		NewExam exam = null;//创建试题对象
		try {
			//获得连接
			conn = JdbcUtil.getConection();
			//定义sql语句
			String sql = "   SELECT  issueId,issueText,issueType,score,paperId,answerA,answerB,answerC,answerD,answer  "
					+ "  FROM t_NewExam  "
					+ "  WHERE  paperId = ?  ";
			//获得ps对象
			ps = conn.prepareStatement(sql);
			//填充占位符
			ps.setInt(1, paperId);
			//执行并返回结果
			rs = ps.executeQuery();
			//循环遍历
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
			//关闭连接
			JdbcUtil.close(conn, ps, rs);
		}
		return examList;
	}

	/**
	 * 删除
	 */
	@Override
	public void delNewExam(Integer paperId) {
		//定义sql
		String sql = "DELETE FROM t_NewExam WHERE paperId=?";
		//调用方法
		JdbcUtil.executeUpdate(sql, paperId);
	}

}
