package cn.bdqn.entity;

/**
 * ѧ����
 *
 */
public class Student {
	/**
	 * �޲ι���
	 */
	public Student() {
	}
	private Integer stuId; //'ѧ��id',
	private String stuName;//'ѧ������',
	private String stuPwd;//'ѧ������',
	private String stuEmail; //'����'
 	private String stuCardId; //'���֤��',
	private String stuPhone;// '�ֻ���'
	
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
