package cn.bdqn.entity;

//用户的实体类
public class UserBean {
	
	 //考题编号
	 private int issueId;
	 //考试内容
	 private String issueText;
	 //考试类型1单选、2多选
	 private int issueType;
	 //考题分数
	 private int score;
	 //答案A
	 private String answerA;
	 //答案B
	 private String answerB;
	 //答案C
	 private String answerC;
	 //答案D
	 private String answerD;
	 
	 private String answer;
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public String getIssueText() {
		return issueText;
	}
	public void setIssueText(String issueText) {
		this.issueText = issueText;
	}
	public int getIssueType() {
		return issueType;
	}
	public void setIssueType(int issueType) {
		this.issueType = issueType;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
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

