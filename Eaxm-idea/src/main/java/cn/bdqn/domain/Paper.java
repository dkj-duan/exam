package cn.bdqn.domain;

/**
 * 试卷类
 */
public class Paper {
    //试卷ID
    private Integer paperid;

    //试卷名称
    private String papername;

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername == null ? null : papername.trim();
    }
}