package z.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user")
public class User {
	int cur;
	int id;
	String username;
	String password;
	
	
	public int getCur() {
		return cur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCur(int cur) {
		this.cur = cur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
