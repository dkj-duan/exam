package cn.bdqn.domain;

import java.util.Date;

/**
 *学生成绩类
 */
public class Grade {
    //学生编号
    private Integer stuid;

    //随即试卷名称
    private String papername;

    //学生成绩
    private Integer stugrade;

    //考试时间
    private Date examtime;

    //正确率
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