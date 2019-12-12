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
	 * 添加标准答案
	 */
	@Override
	public void insertAnswer(Answer answer) {

		// 定义sql语句
		String sql = "INSERT INTO t_answer(issueId,answer) " + " 	VALUES(?,?)";
		// 填充数据
		Object[] obj = { answer.getIssueId(), answer.getAnswer() };

		// 调用方法
		JdbcUtil.executeUpdate(sql, obj);

	}

	/**
	 * 查询标准答案
	 */
	@Override
	public List<Answer> seletAnswer() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 便准答案集合
		List<Answer> answerList = new ArrayList<Answer>();
		// 标准答案对象
		Answer ans = null;
		try {
			// 获得连接
			conn = JdbcUtil.getConection();
			// 定义sql
			String sql = "";
			// 获得ps 对象
			ps = conn.prepareStatement(sql);
			// 执行并接收结果
			rs = ps.executeQuery();
			// 循环遍历添加到集合中
			while (rs.next()) {
				// 实例化标准答案对象
				ans = new Answer();
				ans.setAnswerId(rs.getInt("answerId"));
				ans.setIssueId(rs.getInt("issueId"));
				ans.setAnswer(rs.getString("answer"));
				answerList.add(ans);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			JdbcUtil.close(conn, ps, rs);
		}
		
		//返回连接
		return answerList;
	}

	/**
	 * 根据id查询答案
	 */
	@Override
	public Answer selectIssueIdAnswer(Integer id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 标准答案对象
		Answer ans = null;
		try {
			// 获得连接
			conn = JdbcUtil.getConection();
			// 定义sql
			String sql = " SELECT answerId,issueId,answer FROM t_answer WHERE issueId = ?";
			
			// 获得ps 对象
			ps = conn.prepareStatement(sql);
			//填充ps值
				ps.setObject(1, id);
			
			// 执行并接收结果
			rs = ps.executeQuery();
			// 循环遍历添加到集合中
			if(rs.next()) {
				// 实例化标准答案对象
				ans = new Answer();
				ans.setAnswerId(rs.getInt("answerId"));
				ans.setIssueId(rs.getInt("issueId"));
				ans.setAnswer(rs.getString("answer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			JdbcUtil.close(conn, ps, rs);
		}
		
		//返回连接
		return ans;
	}
}
