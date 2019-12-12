package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.PaperDao;
import cn.bdqn.entity.Paper;
import cn.bdqn.utils.JdbcUtil;

public class PaperDaoImpl implements PaperDao {



	/**
	 * 添加
	 */
	@Override
	public void insertPaper(Paper paper) {
		//定义sql
		String sql = "INSERT INTO  t_paper(paperName) VALUES(?)";
		//调用方法
		JdbcUtil.executeUpdate(sql, paper.getPaperName());

	}

	/**
	 * 查询全部
	 */
	@Override
	public List<Paper> selectPaper() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Paper> paperList = new ArrayList<Paper>();//试题集合
		Paper paper = null;//创建试题对象
		try {
			//获得连接
			conn = JdbcUtil.getConection();
			//定义sql语句
			String sql = "  SELECT paperId,paperName  FROM t_paper";
			//获得ps对象
			ps = conn.prepareStatement(sql);
			//执行并返回结果
			rs = ps.executeQuery();
			//循环遍历
			while (rs.next()) {
				paper = new Paper();
				paper.setPaperId(rs.getInt("paperId"));
				paper.setPaperName(rs.getString("paperName"));
				paperList.add(paper);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			JdbcUtil.close(conn, ps, rs);
		}
		return paperList;
	}

	/**
	 * 根据id查询试卷
	 */
	@Override
	public Paper selectPaperId(Integer id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Paper paper = null;
		try {
			//获得连接
			conn = JdbcUtil.getConection();
			//定义sql语句
			String sql = "  SELECT paperId,paperName  FROM t_paper WHERE  paperId=?";
			//获得ps对象
			ps = conn.prepareStatement(sql);
			//填充占位符
			ps.setInt(1, id);
			//执行并返回结果
			rs = ps.executeQuery();
			//循环遍历
			if (rs.next()) {
				paper = new Paper();
				paper.setPaperId(rs.getInt("paperId"));
				paper.setPaperName(rs.getString("paperName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			JdbcUtil.close(conn, ps, rs);
		}
		return paper;
	}

	/**
	 * 删除
	 */
	@Override
	public void delPaper(Integer paperId) {
		
		//定义sql
		String sql = "DELETE FROM t_paper WHERE paperId=?";
		//调用方法
		JdbcUtil.executeUpdate(sql, paperId);
	}

}
