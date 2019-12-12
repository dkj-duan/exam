package cn.bdqn.sevice;

import java.util.List;

import cn.bdqn.entity.Paper;

/**
 * 试卷业务接口
 * @author 段康家
 *
 */
public interface PaperService {

	/**
	 * 添加试卷
	 * @param paper
	 */
	public void insertPaper(Paper paper);
	
	/**
	 * 查询全部试卷
	 * @return
	 */
	public List<Paper> queryPaper();
	
	/**
	 * 根据id查找试卷
	 * @param id
	 * @return
	 */
	public Paper queryPaperId(Integer id);
	
	/**
	 * 根据id删除试卷
	 * @param paperId
	 */
	public void delPaper(Integer paperId);
}
