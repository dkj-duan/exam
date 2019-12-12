package cn.bdqn.domain;

public class Exam {
    private Integer issueid;

    private String issuetext;

    private Integer issuetype;

    private Integer score;

    private String answera;

    private String answerb;

    private String answerc;

    private String answerd;

    private String answer;

    public Integer getIssueid() {
        return issueid;
    }

    public void setIssueid(Integer issueid) {
        this.issueid = issueid;
    }

    public String getIssuetext() {
        return issuetext;
    }

    public void setIssuetext(String issuetext) {
        this.issuetext = issuetext == null ? null : issuetext.trim();
    }

    public Integer getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(Integer issuetype) {
        this.issuetype = issuetype;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAnswera() {
        return answera;
    }

    public void setAnswera(String answera) {
        this.answera = answera == null ? null : answera.trim();
    }

    public String getAnswerb() {
        return answerb;
    }

    public void setAnswerb(String answerb) {
        this.answerb = answerb == null ? null : answerb.trim();
    }

    public String getAnswerc() {
        return answerc;
    }

    public void setAnswerc(String answerc) {
        this.answerc = answerc == null ? null : answerc.trim();
    }

    public String getAnswerd() {
        return answerd;
    }

    public void setAnswerd(String answerd) {
        this.answerd = answerd == null ? null : answerd.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}