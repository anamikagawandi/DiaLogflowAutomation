package Genesys.GenesysAutomation;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class GenerateToken {

	
	RestClient restClient;
	CloseableHttpResponse closebaleHttpResponse;
	Initializer init;
	Logger logger;
	
	public GenerateToken()
	{
		restClient=new RestClient();
		init = new Initializer();
		logger = Logger.getLogger(this.getClass());
	}
	
	
	public String getToken(String url)
	{
		String accessToken=null;
		

		try {
				closebaleHttpResponse = restClient.get(url);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e);
			}
		
		
		try {
				accessToken = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//System.out.println(accessToken);
		
		return accessToken;
	}
	
	
	
	/*
	
	public static void main(String rgs[])
	{
		
		GenerateToken i=new GenerateToken();
		
		i.getToken("https://us-central1-kate-experience-19.cloudfunctions.net/getToken");
	}
*/
}
