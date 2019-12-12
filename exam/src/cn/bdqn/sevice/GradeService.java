package cn.bdqn.sevice;

import java.util.List;

import cn.bdqn.entity.Grade;

/**
 * 成绩业务类
 * @author 段康家
 *
 */
public interface GradeService {

	/**
	 * 添加
	 */
	public void addGrade(Grade grade);
	
	/**
	 * 根据学生id查询
	 * @param stuId
	 * @return
	 */
	public List<Grade> queryGrade(Integer stuId);
	
	/**
	 * 添加随机试卷
	 */
	public void insterGrade(Grade grade);
	
	
	/**
	 * 根据学生id和试卷名字查询
	 * @param stuId
	 * @param paperName
	 * @return
	 */
	public int select(Integer stuId,String paperName);
	
	/**
	 * 根据学生id和试卷查询试卷总数
	 * @param stuId
	 * @param paperName
	 * @return
	 */
	public int selectcount(Integer stuId,String paperName);
}
