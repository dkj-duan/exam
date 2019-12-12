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
	 * 添加试题并返回主键id
	 */
	@Override
	public int insertExam(Exam exam) {
		//定义sql语句
		String sql = " INSERT INTO t_exam(issueText,issueType,score,answerA,answerB,answerC,answerD) "
					  + "	 VALUES(?,?,?,?,?,?,?)";
		Object [] obj = {exam.getIssueText(),exam.getIssueType(),exam.getScore(),exam.getAnswerA()
							,exam.getAnswerB(),exam.getAnswerC(),exam.getAnswerD()};
		int id = JdbcUtil.executeUpdate(sql, obj);
		return id;
	}

	/**
	 * 查询全部试题
	 */
	@Override
	public List<Exam> selectExam() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Exam> examList = new ArrayList<Exam>();//试题集合
		Exam exam = null;//创建试题对象
		try {
			//获得连接
			conn = JdbcUtil.getConection();
			//定义sql语句
			String sql = "  SELECT issueId,issueText,issueType,score,answerA,answerB,answerC,answerD"
					+ " FROM t_exam"
					+ " ORDER BY RAND()  "
					+ "LIMIT 0,20";
			//获得ps对象
			ps = conn.prepareStatement(sql);
			//执行并返回结果
			rs = ps.executeQuery();
			//循环遍历
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
			//关闭连接
			JdbcUtil.close(conn, ps, rs);
		}
		return examList;
	}

	@Override
	public Exam selectSingleExam(Integer issueId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Exam exam = null;//创建试题对象
		try {
			//获得连接
			conn = JdbcUtil.getConection();
			//定义sql语句
			String sql = "   SELECT issueId,issueText,issueType,score,answerA,answerB,answerC,answerD  "
					+ "  FROM t_exam  "
					+ "  WHERE  issueId = ?  ";
			//获得ps对象
			ps = conn.prepareStatement(sql);
			//填充占位符
			ps.setInt(1, issueId);
			//执行并返回结果
			rs = ps.executeQuery();
			//循环遍历
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
			//关闭连接
			JdbcUtil.close(conn, ps, rs);
		}
		return exam;
	}

}
