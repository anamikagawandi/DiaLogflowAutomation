package Genesys.GenesysAutomation;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	String df_json_response;
	
	public CompareResult()
	{
		logger = Logger.getLogger(this.getClass());
		init = new Initializer();
		chat=new ChatScript();
		cms=new CMS();
	}

	public void compareData()
	{


		String file_extn=init.prop.getProperty("excel_path").substring(init.prop.getProperty("excel_path").lastIndexOf("."));
		logger.info("File extension :"+file_extn);
		System.out.println(file_extn);

		file_name=new File(init.prop.getProperty("excel_path"));

		try {
			System.out.println("Before setting I/P Stream");
			file = new FileInputStream(file_name);			
			System.out.println("After setting I/P Stream");
		}catch(FileNotFoundException e)
		{
			System.out.println("Excel file not found");
			logger.error("Excel file not found",e);
		}catch(IOException e){
			System.out.println("IOException occurred");
			logger.error("IOException occurred",e);
		}



		if(file_extn.equalsIgnoreCase((".xlsx")))
		{
			System.out.println("In if block of File extn xlxs");
			try {
				wb = new XSSFWorkbook(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Problem in loading file"+e);
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



		int size=sheet.getLastRowNum();
		int col=sheet.getRow(0).getLastCellNum();
		System.out.println(size +"col" +col);


		try
		{

			for(int i=1;i<size;i++)
			{

				String question=sheet.getRow(i).getCell(1).getStringCellValue().trim();
				double cms_id=sheet.getRow(i).getCell(10).getNumericCellValue();

				System.out.println(question);

				if(question.isEmpty())
					break;

				try{

					df_json_response=chat.getResponseString(question);
					System.out.println("This is th response"+  df_json_response );
					
					
					
					response_df=chat.runChatScript(df_json_response);


					String ans=response_df.getQueryResult().getFulfillmentText();
					String intent=response_df.getQueryResult().getIntent().getDisplayName();
					String sheet_entity_att="NA",sheet_entity_value="NA",entity_att="NA",entity_value="NA";
					
					//to add values when sheet has entity values
					if(!sheet.getRow(i).getCell(3).getStringCellValue().isEmpty())
					{
						sheet_entity_att=sheet.getRow(i).getCell(3).getStringCellValue();
						sheet_entity_value=sheet.getRow(i).getCell(4).getStringCellValue();
					}
					
					
					//to add values of entities from df
					if(!response_df.getQueryResult().getParameters().getSession().isEmpty())
					{
						entity_att="session";
						entity_value=response_df.getQueryResult().getParameters().getSession();
					}
					else if(!response_df.getQueryResult().getParameters().getActivity().isEmpty())
					{
						entity_att="activity";
						entity_value=response_df.getQueryResult().getParameters().getActivity();
					}
					
					
					
					sheet.getRow(i).getCell(6).setCellValue(intent);
					sheet.getRow(i).getCell(7).setCellValue(entity_att);
					sheet.getRow(i).getCell(8).setCellValue(entity_value);
					sheet.getRow(i).getCell(9).setCellValue(ans);
					sheet.getRow(i).getCell(12).setCellValue(df_json_response);
					

					if(ans.equalsIgnoreCase(cms.getCMSResponse(Double.toString(cms_id)).getAnswer()) &&
							intent.equalsIgnoreCase(sheet.getRow(i).getCell(2).getStringCellValue())
							&& entity_att.equalsIgnoreCase(sheet_entity_att)  && entity_value.equalsIgnoreCase(sheet_entity_value))
						sheet.getRow(i).getCell(11).setCellValue("PASS");
					else
						sheet.getRow(i).getCell(11).setCellValue("FAIL");


			}catch(Exception e)
			{
				sheet.getRow(i).getCell(11).setCellValue("Some error occured. Check Manually");
				e.printStackTrace();
			}

			//	}

		}

		
		file.close();
		outputStream = new FileOutputStream(file_name);
		wb.write(outputStream);

		//driver.quit();

	}catch(
			Exception e)
	{
		e.printStackTrace();
	}



}

}
