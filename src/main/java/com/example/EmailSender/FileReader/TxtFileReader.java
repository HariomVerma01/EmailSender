package com.example.EmailSender.FileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component("TxtReader")
public class TxtFileReader implements EmailFileReader {

	@Override
	public List<String> emails(String filePath) {
		Set<String> mails=new HashSet<>();	
		try(BufferedReader br=new BufferedReader(new FileReader(filePath)))
		{
			String line;
			while((line=br.readLine())!=null)
			{
				if(!line.trim().isEmpty())
				{
					mails.add(line.trim());
				}
			}
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File Not Found"+filePath,e);
		} catch (IOException e) {
			throw new RuntimeException("Error During Reading File"+filePath,e);
		}
		List<String> listMails=mails.stream().toList();
		return listMails;
	}

	@Override
	public String supportedExtension() {
		return "txt";
	}

}
