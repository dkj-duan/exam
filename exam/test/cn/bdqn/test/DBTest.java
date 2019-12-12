package cn.bdqn.test;

import java.sql.Connection;

import org.junit.Test;

import cn.bdqn.utils.JdbcUtil;

/**
 *	测试类
 *		a. 类名
 *				DBTest
 *				UserTest
 			类名以Test结尾
 		b. 方法
 				方法名:  --> test开头
 						testGetConnection()
 						testInsert()
 						testSelect()
 				抛异常         Exception
 				声明		
 						public void 方法名() throws Exception
 						{
 						}
 						
*/
public class DBTest {

	@Test
	public void testGetConnection() throws Exception{
		Connection connection = JdbcUtil.getConection();
		System.out.println(connection);
	}
	
	@Test
	public void testExecuteUpdate() throws Exception{
		String sql = "insert into users(username,phone,sex) values(?,?,?)";
	
		JdbcUtil.executeUpdate(sql, "helloworld","13282430000",1);
	}
	
	
}
