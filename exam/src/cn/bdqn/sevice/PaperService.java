package cn.bdqn.sevice;

import java.util.List;

import cn.bdqn.entity.Paper;

/**
 * �Ծ�ҵ��ӿ�
 * @author �ο���
 *
 */
public interface PaperService {

	/**
	 * ����Ծ�
	 * @param paper
	 */
	public void insertPaper(Paper paper);
	
	/**
	 * ��ѯȫ���Ծ�
	 * @return
	 */
	public List<Paper> queryPaper();
	
	/**
	 * ����id�����Ծ�
	 * @param id
	 * @return
	 */
	public Paper queryPaperId(Integer id);
	
	/**
	 * ����idɾ���Ծ�
	 * @param paperId
	 */
	public void delPaper(Integer paperId);
}
