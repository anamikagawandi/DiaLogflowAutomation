package Genesys.GenesysAutomation;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class GenerateToken {

	
	RestClient restClient;
	CloseableHttpResponse closebaleHttpResponse;
	HttpResponse httpResponse;
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
	
	
	public String getTokenForDev()
	{
		
		String accessToken=null;
		String url="https://us-central1-katex19dev.cloudfunctions.net/getToken";
		
		CloseableHttpResponse response = null;
		
		//byte[] encodedBytes = Base64.getEncoder().encode("kate:experience@19");

        String userPassword = "kate" + ":" + "experience@19";
        byte[] encodeBase64 = Base64.encodeBase64(userPassword.getBytes());
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
		//headerMap.put("Content-Type", "application/json");
		headerMap.put("Authorization", "Basic "+new String(encodeBase64));
		
		
		
		try {
			response=restClient.get(url, headerMap);
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	try {
		accessToken=EntityUtils.toString(response.getEntity(), "UTF-8");
		System.out.println(accessToken);
	} catch (ParseException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return accessToken;
	
	}
	
	
	/*
	public static void main(String rgs[])
	{
		
		GenerateToken i=new GenerateToken();
		System.out.println(i.getTokenForDev());
		//i.getToken("https://us-central1-kate-experience-19.cloudfunctions.net/getToken");
		
		
		
		
	}*/

}
