package cn.bdqn.entity;

import java.util.Date;


/**
 * 学生成绩实体类
 * @author 段康家
 *
 */
public class Grade {

	private Integer stuId;//学生编号',
	private Integer stuGrade;//'学生成绩',
	private Date examTime;//'考试时间'
	private String paperName;//试卷名称
	private double accuracy;//正确率
	private String date;//时间字符串
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public Integer getStuGrade() {
		return stuGrade;
	}
	public void setStuGrade(Integer stuGrade) {
		this.stuGrade = stuGrade;
	}
	public Date getExamTime() {
		return examTime;
	}
	public void setExamTime(Date examTime) {
		this.examTime = examTime;
	}
	
}
