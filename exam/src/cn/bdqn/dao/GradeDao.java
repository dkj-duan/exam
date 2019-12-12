package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Grade;

public interface GradeDao {

	/**
	 * 添加带试卷的
	 */
	public void insterGradePaer(Grade grade);
	
	/**
	 * 添加随机试卷
	 */
	public void insterGrade(Grade grade);
	
	/**
	 * 根据学生id查询
	 * @param stuId
	 * @return
	 */
	public List<Grade> selectGrade(Integer stuId);
	
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
