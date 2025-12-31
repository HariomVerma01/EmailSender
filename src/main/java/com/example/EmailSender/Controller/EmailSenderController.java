package com.example.EmailSender.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmailSender.FileReader.EmailFileReader;
import com.example.EmailSender.FileReader.ServiceFatory.EmailReaderServiceFatory;
import com.example.EmailSender.Model.EmailBody;
import com.example.EmailSender.Service.EmailSenderService;

@RestController
@RequestMapping("/mail")
public class EmailSenderController {
	
	@Autowired 
	private EmailSenderService emailSenderService;
	
	@Autowired
	private EmailReaderServiceFatory emailReaderServiceFatory;
	
	
	
	@PostMapping("/send")
	public String mailSend(@RequestBody EmailBody emailBody)
	{
		EmailFileReader emailFileReader=emailReaderServiceFatory.getReader(emailBody.getFilePath());
		
		List<String>emails=emailFileReader.emails(emailBody.getFilePath());
		if(emails.isEmpty())
		{
			return "No Valid Emails";
		}
		for(String email:emails)
		{
			emailSenderService.sendMail(email, emailBody.getSubject(), emailBody.getBody());
		}
	//	emailSenderService.sendMail("vermahariom326@gmai.com","Testing Api 2", "Message Send");
		return "Mail Sent Successfully";
	}
	

}
