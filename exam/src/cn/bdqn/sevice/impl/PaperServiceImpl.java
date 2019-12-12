package cn.bdqn.sevice.impl;

import java.util.List;

import cn.bdqn.dao.PaperDao;
import cn.bdqn.dao.impl.PaperDaoImpl;
import cn.bdqn.entity.Paper;
import cn.bdqn.sevice.PaperService;

public class PaperServiceImpl implements PaperService {

	private PaperDao paperDao = new PaperDaoImpl();
	
	/**
	 * 添加试卷
	 */
	@Override
	public void insertPaper(Paper paper) {
		
		paperDao.insertPaper(paper);

	}

	/**
	 * 查询全部试卷
	 */
	@Override
	public List<Paper> queryPaper() {
		
		return paperDao.selectPaper();
	}

	/**
	 * 根据id查询试卷
	 */
	@Override
	public Paper queryPaperId(Integer id) {
		return paperDao.selectPaperId(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delPaper(Integer paperId) {
		paperDao.delPaper(paperId);
		
	}

}
