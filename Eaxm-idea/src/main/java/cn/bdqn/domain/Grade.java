package cn.bdqn.domain;

import java.util.Date;

public class Grade {
    private Integer stuid;

    private String papername;

    private Integer stugrade;

    private Date examtime;

    private String accuracy;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername == null ? null : papername.trim();
    }

    public Integer getStugrade() {
        return stugrade;
    }

    public void setStugrade(Integer stugrade) {
        this.stugrade = stugrade;
    }

    public Date getExamtime() {
        return examtime;
    }

    public void setExamtime(Date examtime) {
        this.examtime = examtime;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy == null ? null : accuracy.trim();
    }
}