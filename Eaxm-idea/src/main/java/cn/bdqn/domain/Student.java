package cn.bdqn.domain;

/**
 * 学生类
 */
public class Student {
    //学生ID
    private Integer stuid;

    //学生姓名
    private String stuname;

    //学生密码
    private String stupwd;

    //学生邮箱
    private String stuemail;

    //学生身份证号
    private String stucardid;

    //学生电话
    private String stuphone;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getStupwd() {
        return stupwd;
    }

    public void setStupwd(String stupwd) {
        this.stupwd = stupwd == null ? null : stupwd.trim();
    }

    public String getStuemail() {
        return stuemail;
    }

    public void setStuemail(String stuemail) {
        this.stuemail = stuemail == null ? null : stuemail.trim();
    }

    public String getStucardid() {
        return stucardid;
    }

    public void setStucardid(String stucardid) {
        this.stucardid = stucardid == null ? null : stucardid.trim();
    }

    public String getStuphone() {
        return stuphone;
    }

    public void setStuphone(String stuphone) {
        this.stuphone = stuphone == null ? null : stuphone.trim();
    }
}