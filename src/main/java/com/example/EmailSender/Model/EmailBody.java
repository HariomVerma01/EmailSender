package com.example.EmailSender.Model;

public class EmailBody {
	private String filePath;
	private String subject;
	private String body;
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public EmailBody(String filePath, String subject, String body) {
		super();
		this.filePath = filePath;
		this.subject = subject;
		this.body = body;
	}
	@Override
	public String toString() {
		return "EmailBody [filePath=" + filePath + ", subject=" + subject + ", body=" + body + "]";
	}
	
	
}
