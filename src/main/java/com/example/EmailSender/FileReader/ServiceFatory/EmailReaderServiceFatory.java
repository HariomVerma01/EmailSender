package com.example.EmailSender.FileReader.ServiceFatory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.EmailSender.FileReader.EmailFileReader;

@Service
public class EmailReaderServiceFatory {
	
	private Map<String,EmailFileReader> readerMap;		
	
	public EmailReaderServiceFatory(List<EmailFileReader> readers)
	{
		readerMap =new HashMap<>();
		readers.forEach(r->readerMap.put(r.supportedExtension(), r));
	}
	
	public EmailFileReader getReader(String filePath)
	{
		if(filePath==null || !filePath.contains("."))
			throw new IllegalArgumentException("File Path is InValid"+filePath);
		
		String extension=filePath.substring(filePath.lastIndexOf(".")+1).toLowerCase();
		EmailFileReader reader=readerMap.get(extension);
		if(reader==null)
			throw new IllegalArgumentException("Unsupported file: "+reader);
		return reader;
	}
}
