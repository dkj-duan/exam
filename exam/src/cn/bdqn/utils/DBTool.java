package cn.bdqn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//数据库连接的工具类
public class DBTool {
	public static String username = "root";
	public static String password = "123456";
	public static String url = "jdbc:mysql:///exam";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return conn;
	}

	public static void main(String[] args) {
		System.out.print(DBTool.getConnection());
	}

}
