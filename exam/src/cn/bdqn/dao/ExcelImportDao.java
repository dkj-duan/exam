	package cn.bdqn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bdqn.entity.UserBean;
import cn.bdqn.utils.DBTool;
public class ExcelImportDao {
    
	//保存导入的信息
	public void save(List<UserBean> list) {
		for (int i = 0; i < list.size(); i++) {
			Connection conn = null;
			PreparedStatement ps = null;
			PreparedStatement ps1 = null;
			try {
				conn = DBTool.getConnection();
				String sql = "insert into t_exam(issueText,issueType, score, answerA, answerB,answerC,answerD) values('"
						+ list.get(i).getIssueText()
						+ "', '"
						+ list.get(i).getIssueType()
						+ "', '"
						+ list.get(i).getScore()
						+ "', '"
						+ list.get(i).getAnswerA()
						+ "', '"
						+ list.get(i).getAnswerB()
						+ "', '"
						+ list.get(i).getAnswerC()
						+ "', '" + list.get(i).getAnswerD() + "')";
				ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
				ps.execute(); 
				
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()){
					list.get(i).setIssueId(rs.getInt(1));
				}
				String _sql = "insert into t_answer(issueId,answer) values('"
						+ list.get(i).getIssueId()
						+ "','"
						+list.get(i).getAnswer()+"')";
				ps1 = conn.prepareStatement(_sql);
				ps1.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}