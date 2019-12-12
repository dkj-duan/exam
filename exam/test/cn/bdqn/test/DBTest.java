package cn.bdqn.test;

import java.sql.Connection;

import org.junit.Test;

import cn.bdqn.utils.JdbcUtil;

/**
 *	������
 *		a. ����
 *				DBTest
 *				UserTest
 			������Test��β
 		b. ����
 				������:  --> test��ͷ
 						testGetConnection()
 						testInsert()
 						testSelect()
 				���쳣         Exception
 				����		
 						public void ������() throws Exception
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
