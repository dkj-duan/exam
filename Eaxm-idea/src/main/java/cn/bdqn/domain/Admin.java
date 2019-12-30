package cn.bdqn.domain;

/**
 * 管理员类
 */
public class Admin {
    //管理员ID
    private Integer adminid;
    //管理员姓名
    private String adminname;
    //管理员密码
    private String adminpwd;
    //管理员邮箱
    private String adminemail;
    //管理员身份证号
    private String admincardid;
    //管理员手机号
    private String adminphone;

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd == null ? null : adminpwd.trim();
    }

    public String getAdminemail() {
        return adminemail;
    }

    public void setAdminemail(String adminemail) {
        this.adminemail = adminemail == null ? null : adminemail.trim();
    }

    public String getAdmincardid() {
        return admincardid;
    }

    public void setAdmincardid(String admincardid) {
        this.admincardid = admincardid == null ? null : admincardid.trim();
    }

    public String getAdminphone() {
        return adminphone;
    }

    public void setAdminphone(String adminphone) {
        this.adminphone = adminphone == null ? null : adminphone.trim();
    }
}