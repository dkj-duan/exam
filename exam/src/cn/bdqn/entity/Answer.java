package cn.bdqn.entity;
/**
 * 标准答案实体类
 * @author 段康家
 *
 */
public class Answer {

	private Integer answerId;//'答案编号',
	private Integer issueId; //'考题编号',
	private String answer; //'标准答案选项' 
	
	/**
	 * 无参构造
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
