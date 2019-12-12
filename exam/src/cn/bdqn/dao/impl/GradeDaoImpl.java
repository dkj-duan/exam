package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.GradeDao;
import cn.bdqn.entity.Grade;
import cn.bdqn.utils.JdbcUtil;

public class GradeDaoImpl implements GradeDao {

	/**
	 * 添加随机试卷数据
	 */
	@Override
	public void insterGrade(Grade grade) {
		
		//定义sql
		String sql = "INSERT INTO  t_grade(stuId,stuGrade,examTime,accuracy) VALUES(?,?,?,?)";
		
		//设置值
		Object [] values = {grade.getStuId(),grade.getStuGrade(),grade.getExamTime(),grade.getAccuracy()};
		//调用
		JdbcUtil.executeUpdate(sql, values);
	}

	/**
	 * 根据学生id查询成绩
	 */
	@Override
	public List<Grade> selectGrade(Integer stuId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Grade> grades = new ArrayList<Grade>();//试题集合
		Grade grade = null;//创建试题对象
		try {
			//获得连接
			conn = JdbcUtil.getConection();
			//定义sql语句
			String sql = "SELECT stuId,stuGrade,examTime,paperName,accuracy FROM t_grade WHERE stuId = ?";
			//获得ps对象
			ps = conn.prepareStatement(sql);
			//填充占位符
			ps.setInt(1, stuId);
			//执行并返回结果
			rs = ps.executeQuery();
			//循环遍历
			while (rs.next()) {
				grade = new Grade();
				grade.setStuId(rs.getInt("stuId"));
				grade.setStuGrade(rs.getInt("stuGrade"));
				grade.setExamTime(new java.util.Date(rs.getTimestamp("examTime").getTime()));
				grade.setPaperName(rs.getString("paperName"));
				grade.setAccuracy(rs.getDouble("accuracy"));
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				//得到字符串时间 
				String date = formatter.format(new java.util.Date(rs.getTimestamp("examTime").getTime())); 
				grade.setDate(date);
				grades.add(grade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			JdbcUtil.close(conn, ps, rs);
		}
		return grades;
	}

	/**
	 * 添加试卷题目数据
	 */
	@Override
	public void insterGradePaer(Grade grade) {
		//定义sql
				String sql = "INSERT INTO  t_grade(stuId,stuGrade,examTime,paperName,accuracy) VALUES(?,?,?,?,?)";
				
				//设置值
				Object [] values = {grade.getStuId(),grade.getStuGrade(),grade.getExamTime(),grade.getPaperName(),grade.getAccuracy()};
				//调用
				JdbcUtil.executeUpdate(sql, values);
		
	}

	@Override
	public int select(Integer stuId, String paperName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int  count = 0;
		try {
			//获得连接
			conn = JdbcUtil.getConection();
			//定义sql语句
			String sql = " SELECT COUNT(*) as jiGe FROM t_grade WHERE stuId =? AND paperName = ? AND accuracy > 60";
			//获得ps对象
			ps = conn.prepareStatement(sql);
			//填充占位符
			ps.setInt(1, stuId);
			ps.setString(2, paperName);
			//执行并返回结果
			rs = ps.executeQuery();
			//循环遍历
			while (rs.next()) {
				count = rs.getInt("jiGe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			JdbcUtil.close(conn, ps, rs);
		}
		return count;
	}

	@Override
	public int selectcount(Integer stuId, String paperName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int  count = 0;
		try {
			//获得连接
			conn = JdbcUtil.getConection();
			//定义sql语句
			String sql = " SELECT COUNT(*) as jiGe FROM t_grade WHERE stuId =? AND paperName = ?";
			//获得ps对象
			ps = conn.prepareStatement(sql);
			//填充占位符
			ps.setInt(1, stuId);
			ps.setString(2, paperName);
			//执行并返回结果
			rs = ps.executeQuery();
			//循环遍历
			while (rs.next()) {
				count = rs.getInt("jiGe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			JdbcUtil.close(conn, ps, rs);
		}
		return count;
	}

}
