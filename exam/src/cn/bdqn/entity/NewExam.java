package cn.bdqn.entity;

/**
 * �Ծ���
 * @author �ο���
 *
 */
public class NewExam {

	private Integer issueId;//'������',
	private String issueText;//'��������',
	private Integer issueType;//'��������1��ѡ��2��ѡ',
	private Integer score; //'�������',
	private Integer paperId;//'�Ծ�id',
	private String answerA; //'��A',
	private String answerB;//'��B',
	private String answerC;//'��C',
	private String answerD;//'��D' 
	private String answer;// ��׼��ѡ��'
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
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
	public Integer getPaperId() {
		return paperId;
	}
	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
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
