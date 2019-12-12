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
			// 创建文件输入流
			InputStream is = null;
			try {
				// 获得文件
				is = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
				// 创建Properties对象
				Properties prop = new Properties();
				prop.load(is);
				// 获得文件内容
				dirverClass = prop.getProperty("driver");
				url = prop.getProperty("url");
				user = prop.getProperty("user");
				password = prop.getProperty("password");
				// 加载驱动
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
		 * 获得数据库链接
		 * 
		 * @return
		 * @throws SQLException
		 */
		public static Connection getConection() throws SQLException {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		}

		/**
		 * 封装增删改的方法
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

				// 获得链接
				conn = getConection();
				// 获得ps对象
				ps = conn.prepareStatement(sql);

				// 3、填充占位符
				if (obj != null && obj.length > 0) {
					for (int i = 0; i < obj.length; i++) {
						ps.setObject((i + 1), obj[i]);
					}
				}
				// 执行
				ps.executeUpdate();
				rs =  ps.getGeneratedKeys();
				if (rs.next()) {
					id = rs.getInt(1);
				}
				
			} catch (Exception e) {
				throw new RuntimeException();
			} finally {
				// 关闭链接
				close(conn, ps, rs);
			}
			return id;
		}

		/**
		 * 关闭链接
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

