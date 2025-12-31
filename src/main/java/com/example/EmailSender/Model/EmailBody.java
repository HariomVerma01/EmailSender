package com.example.EmailSender.Model;

import org.springframework.web.multipart.MultipartFile;

public class EmailBody {
	private String filePath;
	private String subject;
	private String body;
	private MultipartFile resume;
	public MultipartFile getResume() {
		return resume;
	}
	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}
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
	public EmailBody(String filePath, String subject, String body,MultipartFile resume) {
		super();
		this.filePath = filePath;
		this.subject = subject;
		this.body = body;
		this.resume=resume;
	}
	@Override
	public String toString() {
		return "EmailBody [filePath=" + filePath + ", subject=" + subject + ", body=" + body +",resume="+resume+"]";
	}
	
	
}
