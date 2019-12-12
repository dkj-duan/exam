package cn.bdqn.sevice.impl;

import java.util.List;

import cn.bdqn.dao.PaperDao;
import cn.bdqn.dao.impl.PaperDaoImpl;
import cn.bdqn.entity.Paper;
import cn.bdqn.sevice.PaperService;

public class PaperServiceImpl implements PaperService {

	private PaperDao paperDao = new PaperDaoImpl();
	
	/**
	 * ����Ծ�
	 */
	@Override
	public void insertPaper(Paper paper) {
		
		paperDao.insertPaper(paper);

	}

	/**
	 * ��ѯȫ���Ծ�
	 */
	@Override
	public List<Paper> queryPaper() {
		
		return paperDao.selectPaper();
	}

	/**
	 * ����id��ѯ�Ծ�
	 */
	@Override
	public Paper queryPaperId(Integer id) {
		return paperDao.selectPaperId(id);
	}

	/**
	 * ɾ��
	 */
	@Override
	public void delPaper(Integer paperId) {
		paperDao.delPaper(paperId);
		
	}

}
