package com.example.EmailSender.ServiceImp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.EmailSender.Service.EmailSenderService;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderServiceImp implements EmailSenderService {
	
	@Value("${resume.path}")
	private String resumePath;
	private final JavaMailSender javaMailSender;
	
	public EmailSenderServiceImp(JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
	}

	@Override
	public void sendMail(String to, String Subject, String body) {
		
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(to);
		mail.setSubject(Subject);
		mail.setText(body);
		javaMailSender.send(mail);
	}

	@Async("mailExecutor")
	@Override
	public void sendMailWithAttachment(String to, String Subject, String body) {
		try 
		{
		MimeMessage message =javaMailSender.createMimeMessage();
		MimeMessageHelper mail= new MimeMessageHelper(message,true);
		mail.setTo(to);
		mail.setSubject(Subject);
		mail.setText(body,false);
		FileSystemResource resume =
			    new FileSystemResource(resumePath);
			mail.addAttachment("HariOmVermaLatestResume.pdf", resume);
			javaMailSender.send(message);		
		 System.out.println("Sent to : " + to + " Thread : " + Thread.currentThread().getName());
		}
		
		catch (Exception e) {
		    System.err.println("Failed to send email to: " + to);
		    e.printStackTrace();
		}
		
	}

}
