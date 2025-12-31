package com.example.EmailSender.ServiceImp;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.EmailSender.Service.EmailSenderService;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderServiceImp implements EmailSenderService {
	
	
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

	@Override
	public void sendMailWithAttachment(String to, String Subject, String body, MultipartFile resume) {
		try 
		{
		MimeMessage message =javaMailSender.createMimeMessage();
		MimeMessageHelper mail= new MimeMessageHelper(message,true);
		mail.setTo(to);
		mail.setSubject(Subject);
		mail.setText(body,false);
		if(resume!=null && !resume.isEmpty())
			{
				mail.addAttachment(resume.getOriginalFilename(), resume);
			}
		javaMailSender.send(message);
		}
		catch(Exception e)
		{
			throw new RuntimeException("Attachment is not Added");
		}
		
	}

}
