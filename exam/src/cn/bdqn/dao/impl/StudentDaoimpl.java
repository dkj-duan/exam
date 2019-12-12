package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.bdqn.dao.StudentDao;
import cn.bdqn.entity.Student;
import cn.bdqn.utils.JdbcUtil;

public class StudentDaoimpl implements StudentDao {

	/**
	 * ��ѯѧ����Ϣ
	 */
	@Override
	public Student selectStu(String stuName, String StuPwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			// �������
			conn = JdbcUtil.getConection();
			// ����sql���
			String sql = " 	SELECT stuId,stuName,stuPwd,stuEmail,stuCardId,stuPhone"
					+ "  	FROM t_student  "
					+ " 	WHERE stuName = ? AND stuPwd = ?";
			// ���ps����
			ps = conn.prepareStatement(sql);
			// ���ռλ��
			ps.setString(1, stuName);
			ps.setString(2, StuPwd);
			// ִ�в���������
			rs = ps.executeQuery();
			// �ж��Ƿ񷵻�����
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
			// �ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		return stu;
	}

	/**
	 * ���ѧ����Ϣ
	 */
	@Override
	public void insertIntoStu(Student stu) {
		// ����sql���
		String sql = "INSERT INTO t_student(stuName,stuPwd,stuEmail,stuCardId,stuPhone) VALUES(?,?,?,?,?)";
		// ���ֵ
		Object[] obj = { stu.getStuName(), stu.getStuPwd(), stu.getStuEmail(),stu.getStuCardId(),stu.getStuPhone() };
		// ������ӷ���
		JdbcUtil.executeUpdate(sql, obj);
		
	}

	/**
	 * �����û�����ѯ
	 */
	@Override
	public Student selectName(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			// �������
			conn = JdbcUtil.getConection();
			// ����sql���
			String sql = " 	SELECT stuId,stuName,stuPwd,stuEmail,stuCardId,stuPhone"
					+ "  	FROM t_student  "
					+ " 	WHERE stuName = ?";
			// ���ps����
			ps = conn.prepareStatement(sql);
			// ���ռλ��
			ps.setString(1, name);
			// ִ�в���������
			rs = ps.executeQuery();
			// �ж��Ƿ񷵻�����
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
			// �ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		return stu;
	}

	/**
	 * ��������
	 */
	@Override
	public void updatePwd(Student stu) {
		//����sql���
		String sql  = "UPDATE  t_student SET stuPwd = ? WHERE stuId = ?";
		
		Object [] values = {stu.getStuPwd(),stu.getStuId()};
		JdbcUtil.executeUpdate(sql, values);
		
	}

}
