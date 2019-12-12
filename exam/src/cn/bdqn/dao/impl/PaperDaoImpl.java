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
	 * ���
	 */
	@Override
	public void insertPaper(Paper paper) {
		//����sql
		String sql = "INSERT INTO  t_paper(paperName) VALUES(?)";
		//���÷���
		JdbcUtil.executeUpdate(sql, paper.getPaperName());

	}

	/**
	 * ��ѯȫ��
	 */
	@Override
	public List<Paper> selectPaper() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Paper> paperList = new ArrayList<Paper>();//���⼯��
		Paper paper = null;//�����������
		try {
			//�������
			conn = JdbcUtil.getConection();
			//����sql���
			String sql = "  SELECT paperId,paperName  FROM t_paper";
			//���ps����
			ps = conn.prepareStatement(sql);
			//ִ�в����ؽ��
			rs = ps.executeQuery();
			//ѭ������
			while (rs.next()) {
				paper = new Paper();
				paper.setPaperId(rs.getInt("paperId"));
				paper.setPaperName(rs.getString("paperName"));
				paperList.add(paper);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		return paperList;
	}

	/**
	 * ����id��ѯ�Ծ�
	 */
	@Override
	public Paper selectPaperId(Integer id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Paper paper = null;
		try {
			//�������
			conn = JdbcUtil.getConection();
			//����sql���
			String sql = "  SELECT paperId,paperName  FROM t_paper WHERE  paperId=?";
			//���ps����
			ps = conn.prepareStatement(sql);
			//���ռλ��
			ps.setInt(1, id);
			//ִ�в����ؽ��
			rs = ps.executeQuery();
			//ѭ������
			if (rs.next()) {
				paper = new Paper();
				paper.setPaperId(rs.getInt("paperId"));
				paper.setPaperName(rs.getString("paperName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			JdbcUtil.close(conn, ps, rs);
		}
		return paper;
	}

	/**
	 * ɾ��
	 */
	@Override
	public void delPaper(Integer paperId) {
		
		//����sql
		String sql = "DELETE FROM t_paper WHERE paperId=?";
		//���÷���
		JdbcUtil.executeUpdate(sql, paperId);
	}

}
