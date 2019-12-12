package cn.bdqn.entity;
/**
 * 试卷实体类
 * @author 段康家
 *
 */
public class Exam {

	private Integer issueId;//'考题编号',
	private String issueText;//'考试内容',
	private Integer issueType;//'考试类型1单选、2多选',
	private Integer score; //'考题分数',
	private String answerA; //'答案A',
	private String answerB;//'答案B',
	private String answerC;//'答案C',
	private String answerD;//'答案D' 
	
	/**
	 * 无参构造
	 */
	public Exam() {
		
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public String getIssueText() {
		return issueText;
	}
	public void setIssueText(String issueText) {
		this.issueText = issueText;
	}
	public Integer getIssueType() {
		return issueType;
	}
	public void setIssueType(Integer issueType) {
		this.issueType = issueType;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getAnswerA() {
		return answerA;
	}
	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}
	public String getAnswerB() {
		return answerB;
	}
	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}
	public String getAnswerC() {
		return answerC;
	}
	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}
	public String getAnswerD() {
		return answerD;
	}
	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}
}
