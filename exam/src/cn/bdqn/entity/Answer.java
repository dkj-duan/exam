package cn.bdqn.entity;
/**
 * ��׼��ʵ����
 * @author �ο���
 *
 */
public class Answer {

	private Integer answerId;//'�𰸱��',
	private Integer issueId; //'������',
	private String answer; //'��׼��ѡ��' 
	
	/**
	 * �޲ι���
	 */
	public Answer() {
		
	}
	public Integer getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
