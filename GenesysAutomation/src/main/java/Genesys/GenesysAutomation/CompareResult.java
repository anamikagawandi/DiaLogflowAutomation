package Genesys.GenesysAutomation;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.genesys.context.response.Parameters;
import com.genesys.response.json.ResponseJson;

public class CompareResult {

	FileInputStream file;
	Workbook wb;
	Sheet sheet;
	Row row;
	Cell cell;
	Logger logger;
	Initializer init;
	FileOutputStream outputStream;
	File file_name;
	ResponseJson response_df;
	ChatScript chat;
	CMS cms;
	String[] df_json_response;
	String cms_json_response;
	
	public CompareResult()
	{
		logger = Logger.getLogger(this.getClass());
		init = new Initializer();
		chat=new ChatScript();
		cms=new CMS();
	}

	
	public Workbook loadFile()
	{
		String file_extn=init.prop.getProperty("excel_path").substring(init.prop.getProperty("excel_path").lastIndexOf("."));
		logger.info("File extension :"+file_extn);
		//System.out.println(file_extn);

		file_name=new File(init.prop.getProperty("excel_path"));

		try {
			//System.out.println("Before setting I/P Stream");
			file = new FileInputStream(file_name);			
			//System.out.println("After setting I/P Stream");
		}catch(FileNotFoundException e)
		{
			//System.out.println("Excel file not found");
			logger.error("Excel file not found",e);
		}catch(IOException e){
			//System.out.println("IOException occurred");
			logger.error("IOException occurred",e);
		}


		try {
			wb=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		/*if(file_extn.equalsIgnoreCase((".xlsx")))
		{
			//System.out.println("In if block of File extn xlxs");
			try {
				wb = new XSSFWorkbook(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//System.out.println("Problem in loading file"+e);
				logger.error("Problem in loading file",e);
			}
			sheet = (XSSFSheet) wb.getSheetAt(0);
		}
		else{
			try {
				wb = new HSSFWorkbook(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("Problem in loading file",e);
			}
			sheet = (HSSFSheet) wb.getSheetAt(0);
		}
*/
		
		return wb;
		
	}
	
	
	
	
	
	
	
	
	
	
	public void compareData()
	{

		loadFile();
		sheet = wb.getSheetAt(0);
		

		int size=sheet.getLastRowNum();
		int col=sheet.getRow(0).getLastCellNum();
		System.out.println("row: "+size +"col: " +col);


		try
		{

			for(int i=1;i<=size;i++)
			{

				
				//System.out.println("This is indent"+sheet.getRow(i).getCell(2).getStringCellValue());
				sheet.getRow(i).getCell(5).setCellValue("");
				sheet.getRow(i).getCell(6).setCellValue("");
				sheet.getRow(i).getCell(7).setCellValue("");
				sheet.getRow(i).getCell(8).setCellValue("");
				sheet.getRow(i).getCell(9).setCellValue("");
				sheet.getRow(i).getCell(12).setCellValue("");
				sheet.getRow(i).getCell(13).setCellValue("");
				sheet.getRow(i).getCell(14).setCellValue("");
				sheet.getRow(i).getCell(15).setCellValue("");
				sheet.getRow(i).getCell(17).setCellValue("");
				
				
				
				
				String question=sheet.getRow(i).getCell(1).getStringCellValue().trim();
				double cms_id=sheet.getRow(i).getCell(10).getNumericCellValue();
				String cms_answer=null;
				System.out.println(question);
				
				String ans="NA";
				String intent="NA";
				String sheet_intent="NA";
				String sheet_entity_att="NA",sheet_entity_value="NA",entity_att="NA",entity_value="NA";
				
				String sheet_context="NA", df_context="NA";

				if(question.isEmpty())
					break;
				
				if(Double.toString(cms_id).isEmpty())
					break;

				try{

					df_json_response=chat.getResponseString(question);
					//System.out.println("This is th response"+  df_json_response );	
					response_df=chat.runChatScript(df_json_response[1]);
					
					
					cms_json_response=cms.getCMSResponseString(Double.toString(cms_id));
					
					try {
						cms_answer=cms.getCMSResponse(cms_json_response).getAnswer().trim();
					} catch (Exception e) {
						sheet.getRow(i).getCell(13).setCellValue(e.getMessage());
					}
	
					
					
					if(!response_df.getQueryResult().getFulfillmentText().trim().isEmpty())
					{
						ans=response_df.getQueryResult().getFulfillmentText().trim();
					}
					
					
					
					intent=response_df.getQueryResult().getIntent().getDisplayName().trim();
					sheet_intent=sheet.getRow(i).getCell(2).getStringCellValue().trim();
					
					
					
					
					
					//to add values when sheet has entity values
					if(!sheet.getRow(i).getCell(3).getStringCellValue().isEmpty())
					{
						sheet_entity_att=sheet.getRow(i).getCell(3).getStringCellValue().trim();
						sheet_entity_value=sheet.getRow(i).getCell(4).getStringCellValue().trim();
					}
					
					if(!sheet.getRow(i).getCell(16).getStringCellValue().isEmpty())
					{
						sheet_context=sheet.getRow(i).getCell(16).getStringCellValue().trim();
						df_context=response_df.getQueryResult().getOutputContexts().get(0).getParameters().getEntity().trim();
					}
					
					
					//to add values of entities from df
					if(!response_df.getQueryResult().getParameters().getWhat().trim().isEmpty())
					{
						entity_att="what";
						entity_value=response_df.getQueryResult().getParameters().getWhat().trim();
					}
					else if(!response_df.getQueryResult().getParameters().getWhen().trim().isEmpty())
					{
						entity_att="when";
						entity_value=response_df.getQueryResult().getParameters().getWhen().trim();
					}
					else if(!response_df.getQueryResult().getParameters().getWhere().trim().isEmpty())
					{
						entity_att="where";
						entity_value=response_df.getQueryResult().getParameters().getWhere().trim();
					}
					else if(!response_df.getQueryResult().getParameters().getWho().trim().isEmpty())
					{
						entity_att="who";
						entity_value=response_df.getQueryResult().getParameters().getWho().trim();
					}
					else if(!response_df.getQueryResult().getParameters().getItem().trim().isEmpty())
					{
						entity_att="item";
						entity_value=response_df.getQueryResult().getParameters().getItem().trim();
					}
					else if(!response_df.getQueryResult().getParameters().getTopic().trim().isEmpty())
					{
						entity_att="topic";
						entity_value=response_df.getQueryResult().getParameters().getTopic().trim();
					}
					
    
				    
					try {
					if(cms_answer.isEmpty())
						cms_answer="blank answer from cms";
					}
					catch(Exception e)
					{
						cms_answer="error to fetch from cms";
					}

					if(ans.equalsIgnoreCase(cms_answer) &&
							intent.equalsIgnoreCase(sheet_intent)
							&& entity_att.equalsIgnoreCase(sheet_entity_att)  && 
							entity_value.equalsIgnoreCase(sheet_entity_value) &&
							df_context.equalsIgnoreCase(sheet_context) )
						sheet.getRow(i).getCell(11).setCellValue("PASS");
					else
						sheet.getRow(i).getCell(11).setCellValue("FAIL");


			}catch(Exception e)
			{
				sheet.getRow(i).getCell(11).setCellValue("Some error occured. Check Manually");
				e.printStackTrace();
			}

				
				sheet.getRow(i).getCell(5).setCellValue(cms_answer);
				sheet.getRow(i).getCell(6).setCellValue(intent);
				sheet.getRow(i).getCell(7).setCellValue(entity_att);
				sheet.getRow(i).getCell(8).setCellValue(entity_value);
				sheet.getRow(i).getCell(9).setCellValue(ans);
				sheet.getRow(i).getCell(12).setCellValue(df_json_response[1]);
				sheet.getRow(i).getCell(13).setCellValue(cms_json_response);
				sheet.getRow(i).getCell(2).setCellValue(sheet_intent.toString());
				sheet.getRow(i).getCell(17).setCellValue(df_context);
				
				
				Date date = Calendar.getInstance().getTime();  
			    DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");  
			    
			    String strDate = dateFormat.format(date);  
				
			    sheet.getRow(i).getCell(14).setCellValue(strDate);
			    sheet.getRow(i).getCell(15).setCellValue(df_json_response[0]);
				
				
				System.out.println("Question asked:\t"+question);
				System.out.println("Answer by DF :\t"+ans);
				System.out.println("Answer by CMS :\t"+cms_answer);
				System.out.println("Intent expected:\t"+sheet.getRow(i).getCell(2).getStringCellValue().trim());
				System.out.println("Intent actual:\t"+intent);
				System.out.println("Entity Att expected :\t"+sheet_entity_att);
				System.out.println("Entity Att actual :\t"+entity_att);
				System.out.println("Entity Value expected :\t"+sheet_entity_value);
				System.out.println("Entity Value actual :\t"+entity_value);
				System.out.println("Context Value expected :\t"+sheet_context);
				System.out.println("Context Value actual :\t"+df_context);
				
			//	}

		}

		try {
		file.close();
		outputStream = new FileOutputStream(file_name);
		wb.write(outputStream);
		
		
		System.out.println("Task Complete");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//driver.quit();

	}catch(
			Exception e)
	{
		e.printStackTrace();
	}


}

}
