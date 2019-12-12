package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.bdqn.dao.AdminDao;
import cn.bdqn.entity.Admin;
import cn.bdqn.utils.JdbcUtil;

public class AdminDaoImpl implements AdminDao {

	/**
	 * ��ѯ����Ա
	 */
	@Override
	public Admin selectAdmin(String adminName, String adminPwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = null;
		try {
			// �������
			conn = JdbcUtil.getConection();
			// ����sql���
			String sql = " 	  SELECT adminId,adminName,adminPwd,adminEmail,adminCardId,adminPhone	"
					+ "  FROM t_admin  "
					+ "   WHERE adminName = ? AND adminPwd = ?";
			// ���ps����
			ps = conn.prepareStatement(sql);
			// ���ռλ��
			ps.setString(1, adminName);
			ps.setString(2, adminPwd);
			// ִ�в���������
			rs = ps.executeQuery();
			// �ж��Ƿ񷵻�����
			if (rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminPwd(rs.getString("adminPwd"));
				admin.setAdminEmail(rs.getString("adminEmail"));
				admin.setAdminCardId(rs.getString("adminCardId"));
				admin.setAdminPhone(rs.getString("adminPhone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		
		return admin;
	}

	/**
	 * ��ӹ���Ա
	 */
	@Override
	public void insertIntoAdmin(Admin admin) {
		// ����sql���
		String sql = " INSERT INTO t_admin(adminName,adminPwd,adminEmail,adminCardId,adminPhone) VALUES(?,?,?,?,?)";

		// ���ֵ
		Object[] obj = { admin.getAdminName(), admin.getAdminPwd(),
				admin.getAdminEmail(),admin.getAdminCardId(),admin.getAdminPhone() };

		// ���÷���
		JdbcUtil.executeUpdate(sql, obj);
	}

	/**
	 * ��ѯ�û����Ƿ����
	 */
	@Override
	public Admin selectAdminName(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = null;
		try {
			// �������
			conn = JdbcUtil.getConection();
			// ����sql���
			String sql = " 	  SELECT adminId,adminName,adminPwd,adminEmail,adminCardId,adminPhone	"
					+ "  FROM t_admin  "
					+ "   WHERE adminName = ?";
			// ���ps����
			ps = conn.prepareStatement(sql);
			// ���ռλ��
			ps.setString(1, name);
			
			// ִ�в���������
			rs = ps.executeQuery();
			// �ж��Ƿ񷵻�����
			if (rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminPwd(rs.getString("adminPwd"));
				admin.setAdminEmail(rs.getString("adminEmail"));
				admin.setAdminCardId(rs.getString("adminCardId"));
				admin.setAdminPhone(rs.getString("adminPhone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		return admin;	
	}

}
