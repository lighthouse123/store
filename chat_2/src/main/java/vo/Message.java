package vo;

import java.util.Date;
import java.util.List;


public class Message {
	private Gson gson = new Gson();
	private String message;
	private List<String> usernames;
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setContent(String name,String msg) {
		
		this.content = name=": "+new Date().toString()+"<br/>"+
		msg+"<br/>";
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getUsernames() {
		return usernames;
	}

	public void setUsernames(List<String> usernames) {
		this.usernames = usernames;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", usernames=" + usernames + "]";
	}

//	public String toJson() {
//		return gson.toJson(this);
//	}



}
