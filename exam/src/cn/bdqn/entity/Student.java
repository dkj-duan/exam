package cn.bdqn.entity;

/**
 * 学生类
 *
 */
public class Student {
	/**
	 * 无参构造
	 */
	public Student() {
	}
	private Integer stuId; //'学生id',
	private String stuName;//'学生姓名',
	private String stuPwd;//'学生密码',
	private String stuEmail; //'邮箱'
 	private String stuCardId; //'身份证号',
	private String stuPhone;// '手机号'
	
	public String getStuCardId() {
		return stuCardId;
	}
	public void setStuCardId(String stuCardId) {
		this.stuCardId = stuCardId;
	}
	public String getStuPhone() {
		return stuPhone;
	}
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPwd() {
		return stuPwd;
	}
	public void setStuPwd(String stuPwd) {
		this.stuPwd = stuPwd;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
}
