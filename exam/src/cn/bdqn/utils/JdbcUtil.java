package cn.bdqn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public final class JdbcUtil {

		private static String dirverClass;
		private static String url;
		private static String user;
		private static String password;

		static {
			// �����ļ�������
			InputStream is = null;
			try {
				// ����ļ�
				is = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
				// ����Properties����
				Properties prop = new Properties();
				prop.load(is);
				// ����ļ�����
				dirverClass = prop.getProperty("driver");
				url = prop.getProperty("url");
				user = prop.getProperty("user");
				password = prop.getProperty("password");
				// ��������
				Class.forName(dirverClass);
			} catch (Exception e) {
				throw new ExceptionInInitializerError();
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		/**
		 * ������ݿ�����
		 * 
		 * @return
		 * @throws SQLException
		 */
		public static Connection getConection() throws SQLException {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		}

		/**
		 * ��װ��ɾ�ĵķ���
		 * 
		 * @param sql
		 * @param obj
		 */
		public static int executeUpdate(String sql, Object... obj) {

			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			int id = 0; 
			try {

				// �������
				conn = getConection();
				// ���ps����
				ps = conn.prepareStatement(sql);

				// 3�����ռλ��
				if (obj != null && obj.length > 0) {
					for (int i = 0; i < obj.length; i++) {
						ps.setObject((i + 1), obj[i]);
					}
				}
				// ִ��
				ps.executeUpdate();
				rs =  ps.getGeneratedKeys();
				if (rs.next()) {
					id = rs.getInt(1);
				}
				
			} catch (Exception e) {
				throw new RuntimeException();
			} finally {
				// �ر�����
				close(conn, ps, rs);
			}
			return id;
		}

		/**
		 * �ر�����
		 * 
		 * @param conn
		 * @param se
		 * @param rs
		 */
		public static void close(Connection conn, Statement se, ResultSet rs) {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (se != null) {
						se.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		}

	}

