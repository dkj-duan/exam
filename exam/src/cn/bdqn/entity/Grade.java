package cn.bdqn.entity;

import java.util.Date;


/**
 * ѧ���ɼ�ʵ����
 * @author �ο���
 *
 */
public class Grade {

	private Integer stuId;//ѧ�����',
	private Integer stuGrade;//'ѧ���ɼ�',
	private Date examTime;//'����ʱ��'
	private String paperName;//�Ծ�����
	private double accuracy;//��ȷ��
	private String date;//ʱ���ַ���
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
