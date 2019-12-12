package cn.bdqn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.entity.UserBean;
import cn.bdqn.utils.DBTool;


//持久层
public class UserJsonDao {
  
	//查询所有用户信息
	public List<UserBean> finall() {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<UserBean> list = new ArrayList<UserBean>();
		
		try {
			
			conn = DBTool.getConnection();
			String sql = "SELECT ex.issueId,ex.issueText,ex.issueType,ex.score,ex.answerA,ex.answerB,ex.answerC,ex.answerD,an.`answer`   FROM t_exam AS ex,t_answer AS an    WHERE ex.`issueId`= an.issueId";
			
			
			
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserBean ub = new UserBean();
				
				ub.setIssueId(rs.getInt("issueId"));
				ub.setIssueText(rs.getString("issueText"));
				ub.setIssueType(rs.getInt("issueType"));
				ub.setScore(rs.getInt("score"));
				ub.setAnswerA(rs.getString("answerA"));
				ub.setAnswerB(rs.getString("answerB"));
				ub.setAnswerC(rs.getString("answerC"));
				ub.setAnswerD(rs.getString("answerD"));
				ub.setAnswer(rs.getString("answer"));
				list.add(ub);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
