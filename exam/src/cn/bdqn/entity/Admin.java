package cn.bdqn.entity;

/**
 * ����Ա��
 *
 */
public class Admin {
	private Integer adminId;//'����Աid',
	private String adminName; //'����Ա����',
	private String adminPwd; //'����Ա����',
	private String adminEmail;//'����'
	private String adminCardId;//'���֤��',
	private String adminPhone; //'�ֻ���'
	public String getAdminCardId() {
		return adminCardId;
	}
	public void setAdminCardId(String adminCardId) {
		this.adminCardId = adminCardId;
	}
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	/**
	 * �޲ι���
	 */
	public Admin() {
		
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
}
