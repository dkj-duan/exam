package cn.bdqn.domain;

/**
 * 学生答案类
 */
public class Stuanswer {
    //学生ID
    private Integer stuid;

    //考题编号
    private Integer issueid;

    //试卷ID
    private Integer paperid;

    //学生答案
    private String stuanswer;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getIssueid() {
        return issueid;
    }

    public void setIssueid(Integer issueid) {
        this.issueid = issueid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public String getStuanswer() {
        return stuanswer;
    }

    public void setStuanswer(String stuanswer) {
        this.stuanswer = stuanswer == null ? null : stuanswer.trim();
    }

    @Override
    public String toString() {
        return "Stuanswer{" +
                "stuid=" + stuid +
                ", issueid=" + issueid +
                ", paperid=" + paperid +
                ", stuanswer='" + stuanswer + '\'' +
                '}';
    }
}