package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Paper;

/**
 * �Ծ����dao
 * @author �ο���
 *
 */
public interface PaperDao {

	/**
	 * ����Ծ�
	 * @param paper
	 */
	public void insertPaper(Paper paper);
	
	/**
	 * ��ѯȫ���Ծ�
	 * @return
	 */
	public List<Paper> selectPaper();
	
	/**
	 * ����id�����Ծ�
	 * @param id
	 * @return
	 */
	public Paper selectPaperId(Integer id);
	
	/**
	 * ����idɾ���Ծ�
	 * @param paperId
	 */
	public void delPaper(Integer paperId);
}
