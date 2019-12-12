package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Paper;

/**
 * 试卷操作dao
 * @author 段康家
 *
 */
public interface PaperDao {

	/**
	 * 添加试卷
	 * @param paper
	 */
	public void insertPaper(Paper paper);
	
	/**
	 * 查询全部试卷
	 * @return
	 */
	public List<Paper> selectPaper();
	
	/**
	 * 根据id查找试卷
	 * @param id
	 * @return
	 */
	public Paper selectPaperId(Integer id);
	
	/**
	 * 根据id删除试卷
	 * @param paperId
	 */
	public void delPaper(Integer paperId);
}
