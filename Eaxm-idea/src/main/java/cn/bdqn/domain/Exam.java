package cn.bdqn.domain;

/**
 * 考试类
 */
public class Exam {
    //考题编号
    private Integer issueid;

    //考试内容
    private String issuetext;

    //考试类型1、单选 2、多选
    private Integer issuetype;

    //考题分数
    private Integer score;

    //答案A
    private String answera;

    //答案B
    private String answerb;

    //答案C
    private String answerc;

    //答案D
    private String answerd;

    //标准答案选项
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

    @Override
    public String toString() {
        return "Exam{" +
                "issueid=" + issueid +
                ", issuetext='" + issuetext + '\'' +
                ", issuetype=" + issuetype +
                ", score=" + score +
                ", answera='" + answera + '\'' +
                ", answerb='" + answerb + '\'' +
                ", answerc='" + answerc + '\'' +
                ", answerd='" + answerd + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}