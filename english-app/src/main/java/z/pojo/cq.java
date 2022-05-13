package z.pojo;

import com.baomidou.mybatisplus.annotation.TableName;



@TableName("cq")

public class cq {
	Integer id;
	Integer qid;
	String question;
	String qa;
	String qb;
	String qc;
	String qd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQa() {
		return qa;
	}
	public void setQa(String qa) {
		this.qa = qa;
	}
	public String getQb() {
		return qb;
	}
	public void setQb(String qb) {
		this.qb = qb;
	}
	public String getQc() {
		return qc;
	}
	public void setQc(String qc) {
		this.qc = qc;
	}
	public String getQd() {
		return qd;
	}
	public void setQd(String qd) {
		this.qd = qd;
	}
	
}
