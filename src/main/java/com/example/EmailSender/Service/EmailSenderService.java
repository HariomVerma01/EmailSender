package com.example.EmailSender.Service;

import org.springframework.web.multipart.MultipartFile;

public interface EmailSenderService {
	
	void sendMail(String to,String Subject,String body);
	
	void sendMailWithAttachment(String to,String Subject,String body,MultipartFile resume);

}
