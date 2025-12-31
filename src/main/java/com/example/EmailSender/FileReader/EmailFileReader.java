package com.example.EmailSender.FileReader;

import java.util.List;

public interface EmailFileReader {
	String supportedExtension();
	List<String> emails(String filePath);
}
