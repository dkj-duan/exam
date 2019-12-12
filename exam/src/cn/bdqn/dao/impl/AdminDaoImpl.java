package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.bdqn.dao.AdminDao;
import cn.bdqn.entity.Admin;
import cn.bdqn.utils.JdbcUtil;

public class AdminDaoImpl implements AdminDao {

	/**
	 * 查询管理员
	 */
	@Override
	public Admin selectAdmin(String adminName, String adminPwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = null;
		try {
			// 获得链接
			conn = JdbcUtil.getConection();
			// 定义sql语句
			String sql = " 	  SELECT adminId,adminName,adminPwd,adminEmail,adminCardId,adminPhone	"
					+ "  FROM t_admin  "
					+ "   WHERE adminName = ? AND adminPwd = ?";
			// 获得ps对象
			ps = conn.prepareStatement(sql);
			// 填充占位符
			ps.setString(1, adminName);
			ps.setString(2, adminPwd);
			// 执行并接收数据
			rs = ps.executeQuery();
			// 判断是否返回数据
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
			// 关闭链接
			JdbcUtil.close(conn, ps, rs);
		}
		
		return admin;
	}

	/**
	 * 添加管理员
	 */
	@Override
	public void insertIntoAdmin(Admin admin) {
		// 定义sql语句
		String sql = " INSERT INTO t_admin(adminName,adminPwd,adminEmail,adminCardId,adminPhone) VALUES(?,?,?,?,?)";

		// 添加值
		Object[] obj = { admin.getAdminName(), admin.getAdminPwd(),
				admin.getAdminEmail(),admin.getAdminCardId(),admin.getAdminPhone() };

		// 调用方法
		JdbcUtil.executeUpdate(sql, obj);
	}

	/**
	 * 查询用户名是否存在
	 */
	@Override
	public Admin selectAdminName(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = null;
		try {
			// 获得链接
			conn = JdbcUtil.getConection();
			// 定义sql语句
			String sql = " 	  SELECT adminId,adminName,adminPwd,adminEmail,adminCardId,adminPhone	"
					+ "  FROM t_admin  "
					+ "   WHERE adminName = ?";
			// 获得ps对象
			ps = conn.prepareStatement(sql);
			// 填充占位符
			ps.setString(1, name);
			
			// 执行并接收数据
			rs = ps.executeQuery();
			// 判断是否返回数据
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
			// 关闭链接
			JdbcUtil.close(conn, ps, rs);
		}
		return admin;	
	}

}
