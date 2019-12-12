package cn.bdqn.entity;

/**
 * 管理员类
 *
 */
public class Admin {
	private Integer adminId;//'管理员id',
	private String adminName; //'管理员姓名',
	private String adminPwd; //'管理员密码',
	private String adminEmail;//'邮箱'
	private String adminCardId;//'身份证号',
	private String adminPhone; //'手机号'
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
	 * 无参构造
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
