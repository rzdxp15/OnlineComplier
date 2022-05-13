package z.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("UserAndWord")
public class Userandword {

	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getWord_fourid() {
		return word_fourid;
	}

	public void setWord_fourid(int word_fourid) {
		this.word_fourid = word_fourid;
	}

	public int getWord_sixid() {
		return word_sixid;
	}

	public void setWord_sixid(int word_sixid) {
		this.word_sixid = word_sixid;
	}

	int uid;
	int word_fourid;
	int word_sixid;

	public Userandword(int uid, int word_fourid, int word_sixid) {
		this.uid = uid;
		this.word_fourid = word_fourid;
		this.word_sixid = word_sixid;
	}

	public Userandword() {
		// TODO Auto-generated constructor stub
	}
}
