package com.example.EmailSender.FileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component("ExcelReader")
public class ExcelReader implements EmailFileReader{

	@Override
	public List<String> emails(String filePath) {
		Set<String>mails=new HashSet<>();
		try(FileInputStream fis=new FileInputStream(filePath);
				Workbook workbook=new XSSFWorkbook(fis))
		{
			Sheet sheet=workbook.getSheetAt(0);
			for(Row row:sheet)
			{
				Cell cell=row.getCell(0);
				if(cell!=null)
				{
					String mail=cell.toString().trim();
					if(!mail.isEmpty() && !mail.isBlank())
					{
						mails.add(mail);
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File not Found"+filePath,e);
		} catch (IOException e) {
			throw new RuntimeException("Error while reading excel file"+filePath,e);
		}
		
		List<String> listMails=mails.stream().toList();
		return listMails;
	}

	@Override
	public String supportedExtension() {
		
		return "xlsx";
	}


}
