package com.example.EmailSender.Service;


public interface EmailSenderService {
	
	void sendMail(String to,String Subject,String body);
	
	void sendMailWithAttachment(String to,String Subject,String body);

}
