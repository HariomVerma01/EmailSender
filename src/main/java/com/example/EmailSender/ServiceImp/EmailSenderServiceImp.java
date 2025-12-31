package com.example.EmailSender.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.EmailSender.Service.EmailSenderService;

@Service
public class EmailSenderServiceImp implements EmailSenderService {
	
	@Autowired 
	JavaMailSender javaMailSender;

	@Override
	public void sendMail(String to, String Subject, String body) {
		
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(to);
		mail.setSubject(Subject);
		mail.setText(body);
		javaMailSender.send(mail);
	}

}
