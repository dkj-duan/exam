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
	 * �������Ծ�����
	 */
	@Override
	public void insterGrade(Grade grade) {
		
		//����sql
		String sql = "INSERT INTO  t_grade(stuId,stuGrade,examTime,accuracy) VALUES(?,?,?,?)";
		
		//����ֵ
		Object [] values = {grade.getStuId(),grade.getStuGrade(),grade.getExamTime(),grade.getAccuracy()};
		//����
		JdbcUtil.executeUpdate(sql, values);
	}

	/**
	 * ����ѧ��id��ѯ�ɼ�
	 */
	@Override
	public List<Grade> selectGrade(Integer stuId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Grade> grades = new ArrayList<Grade>();//���⼯��
		Grade grade = null;//�����������
		try {
			//�������
			conn = JdbcUtil.getConection();
			//����sql���
			String sql = "SELECT stuId,stuGrade,examTime,paperName,accuracy FROM t_grade WHERE stuId = ?";
			//���ps����
			ps = conn.prepareStatement(sql);
			//���ռλ��
			ps.setInt(1, stuId);
			//ִ�в����ؽ��
			rs = ps.executeQuery();
			//ѭ������
			while (rs.next()) {
				grade = new Grade();
				grade.setStuId(rs.getInt("stuId"));
				grade.setStuGrade(rs.getInt("stuGrade"));
				grade.setExamTime(new java.util.Date(rs.getTimestamp("examTime").getTime()));
				grade.setPaperName(rs.getString("paperName"));
				grade.setAccuracy(rs.getDouble("accuracy"));
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				//�õ��ַ���ʱ�� 
				String date = formatter.format(new java.util.Date(rs.getTimestamp("examTime").getTime())); 
				grade.setDate(date);
				grades.add(grade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		return grades;
	}

	/**
	 * ����Ծ���Ŀ����
	 */
	@Override
	public void insterGradePaer(Grade grade) {
		//����sql
				String sql = "INSERT INTO  t_grade(stuId,stuGrade,examTime,paperName,accuracy) VALUES(?,?,?,?,?)";
				
				//����ֵ
				Object [] values = {grade.getStuId(),grade.getStuGrade(),grade.getExamTime(),grade.getPaperName(),grade.getAccuracy()};
				//����
				JdbcUtil.executeUpdate(sql, values);
		
	}

	@Override
	public int select(Integer stuId, String paperName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int  count = 0;
		try {
			//�������
			conn = JdbcUtil.getConection();
			//����sql���
			String sql = " SELECT COUNT(*) as jiGe FROM t_grade WHERE stuId =? AND paperName = ? AND accuracy > 60";
			//���ps����
			ps = conn.prepareStatement(sql);
			//���ռλ��
			ps.setInt(1, stuId);
			ps.setString(2, paperName);
			//ִ�в����ؽ��
			rs = ps.executeQuery();
			//ѭ������
			while (rs.next()) {
				count = rs.getInt("jiGe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر�����
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
			//�������
			conn = JdbcUtil.getConection();
			//����sql���
			String sql = " SELECT COUNT(*) as jiGe FROM t_grade WHERE stuId =? AND paperName = ?";
			//���ps����
			ps = conn.prepareStatement(sql);
			//���ռλ��
			ps.setInt(1, stuId);
			ps.setString(2, paperName);
			//ִ�в����ؽ��
			rs = ps.executeQuery();
			//ѭ������
			while (rs.next()) {
				count = rs.getInt("jiGe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		return count;
	}

}
