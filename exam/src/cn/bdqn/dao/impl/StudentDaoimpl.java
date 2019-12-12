package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.bdqn.dao.StudentDao;
import cn.bdqn.entity.Student;
import cn.bdqn.utils.JdbcUtil;

public class StudentDaoimpl implements StudentDao {

	/**
	 * 查询学生信息
	 */
	@Override
	public Student selectStu(String stuName, String StuPwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			// 获得链接
			conn = JdbcUtil.getConection();
			// 定义sql语句
			String sql = " 	SELECT stuId,stuName,stuPwd,stuEmail,stuCardId,stuPhone"
					+ "  	FROM t_student  "
					+ " 	WHERE stuName = ? AND stuPwd = ?";
			// 获得ps对象
			ps = conn.prepareStatement(sql);
			// 填充占位符
			ps.setString(1, stuName);
			ps.setString(2, StuPwd);
			// 执行并接收数据
			rs = ps.executeQuery();
			// 判断是否返回数据
			if (rs.next()) {
				stu = new Student();
				stu.setStuId(rs.getInt("stuId"));
				stu.setStuName(rs.getString("stuName"));
				stu.setStuPwd(rs.getString("stuPwd"));
				stu.setStuEmail(rs.getString("stuEmail"));
				stu.setStuCardId(rs.getString("stuCardId"));
				stu.setStuPhone(rs.getString("stuPhone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭链接
			JdbcUtil.close(conn, ps, rs);
		}
		return stu;
	}

	/**
	 * 添加学生信息
	 */
	@Override
	public void insertIntoStu(Student stu) {
		// 定义sql语句
		String sql = "INSERT INTO t_student(stuName,stuPwd,stuEmail,stuCardId,stuPhone) VALUES(?,?,?,?,?)";
		// 获得值
		Object[] obj = { stu.getStuName(), stu.getStuPwd(), stu.getStuEmail(),stu.getStuCardId(),stu.getStuPhone() };
		// 调用添加方法
		JdbcUtil.executeUpdate(sql, obj);
		
	}

	/**
	 * 按照用户名查询
	 */
	@Override
	public Student selectName(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			// 获得链接
			conn = JdbcUtil.getConection();
			// 定义sql语句
			String sql = " 	SELECT stuId,stuName,stuPwd,stuEmail,stuCardId,stuPhone"
					+ "  	FROM t_student  "
					+ " 	WHERE stuName = ?";
			// 获得ps对象
			ps = conn.prepareStatement(sql);
			// 填充占位符
			ps.setString(1, name);
			// 执行并接收数据
			rs = ps.executeQuery();
			// 判断是否返回数据
			if (rs.next()) {
				stu = new Student();
				stu.setStuId(rs.getInt("stuId"));
				stu.setStuName(rs.getString("stuName"));
				stu.setStuPwd(rs.getString("stuPwd"));
				stu.setStuEmail(rs.getString("stuEmail"));
				stu.setStuCardId(rs.getString("stuCardId"));
				stu.setStuPhone(rs.getString("stuPhone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭链接
			JdbcUtil.close(conn, ps, rs);
		}
		return stu;
	}

	/**
	 * 更新密码
	 */
	@Override
	public void updatePwd(Student stu) {
		//定义sql语句
		String sql  = "UPDATE  t_student SET stuPwd = ? WHERE stuId = ?";
		
		Object [] values = {stu.getStuPwd(),stu.getStuId()};
		JdbcUtil.executeUpdate(sql, values);
		
	}

}
