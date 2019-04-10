package Genesys.GenesysAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;



public class Initializer {
	
	//public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	public int RESPONSE_STATUS_CODE_200 = 200;
	public int RESPONSE_STATUS_CODE_500 = 500;
	public int RESPONSE_STATUS_CODE_400 = 400;
	public int RESPONSE_STATUS_CODE_401 = 401;
	public int RESPONSE_STATUS_CODE_201 = 201;


	public Initializer()
	{
		logger = Logger.getLogger(this.getClass());
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(".\\prop\\config.properties");
			//FileInputStream ip = new FileInputStream("D:\\Selenium\\MagentoRepo\\src\\main\\java\\com\\magento\\qa\\config\\config.properties");//"D:\\SeleniumWorkspace\\MagentoCRM\\src\\main\\java\\com\\magento\\qa\\config\\config.properties");
			prop.load(ip);
			logger.info("Loading Config file");
			
		}catch(FileNotFoundException e)
		{
			logger.error("Config file not found",e);
		}catch(IOException e){
			logger.error("IOException occurred",e);
		}
	}

	
	public static void initialization()
	{
		
		
	
	}
	
	
	
	public static void main (String arg[])
	{
		
	}

}
