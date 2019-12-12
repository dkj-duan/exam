package cn.bdqn.sevice.impl;

import java.util.List;

import cn.bdqn.dao.GradeDao;
import cn.bdqn.dao.impl.GradeDaoImpl;
import cn.bdqn.entity.Grade;
import cn.bdqn.sevice.GradeService;

/**
 * 
 * @author ¶Î¿µ¼Ò
 *
 */
public class GradeServiceImpl implements GradeService {

	private GradeDao gradeDao = new GradeDaoImpl();
	
	@Override
	public void addGrade(Grade grade) {
		
		gradeDao.insterGrade(grade);
		
	}

	@Override
	public List<Grade> queryGrade(Integer stuId) {
		return gradeDao.selectGrade(stuId);
	}

	@Override
	public void insterGrade(Grade grade) {
		gradeDao.insterGradePaer(grade);
		
	}

	@Override
	public int select(Integer stuId, String paperName) {
		return gradeDao.select(stuId, paperName);
	}

	@Override
	public int selectcount(Integer stuId, String paperName) {
		return gradeDao.selectcount(stuId, paperName);
	}

	
}
