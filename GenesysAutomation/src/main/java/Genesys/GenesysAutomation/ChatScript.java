package Genesys.GenesysAutomation;


import java.io.IOException;
import java.util.HashMap;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genesys.request.json.QueryInput;
import com.genesys.request.json.RequestJson;
import com.genesys.request.json.Text;
import com.genesys.response.json.ResponseJson;


public class ChatScript {
	
	RestClient restClient;
	CloseableHttpResponse closebaleHttpResponse;
	Initializer init;
	Logger logger;
	GenerateToken genTok;
	RequestJson reqJson;
	ResponseJson response;
	public ChatScript()
	{
		restClient=new RestClient();
		init = new Initializer();
		genTok= new GenerateToken();
		logger = Logger.getLogger(this.getClass());
	}
	
	public HashMap<String,String> runChatScript(String question)
	{
		restClient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Authorization", "Bearer "+genTok.getToken(init.prop.getProperty("token_url")).trim());
		
		//jackson API:
		ObjectMapper req = new ObjectMapper();
		
		reqJson = new RequestJson(new QueryInput(new Text(question,"en"))); //expected users obejct

		
		//java object to json in String:
		String reqJsonString = null;
		try {
			reqJsonString = req.writeValueAsString(reqJson);
		} catch (JsonProcessingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println(reqJsonString);
		
		try {
			closebaleHttpResponse = restClient.post(init.prop.getProperty("api_uri"), reqJsonString, headerMap);
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //call the API
		
		//validate response from API:
		//1. status code:
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		logger.info(statusCode= init.RESPONSE_STATUS_CODE_201);
		
		//2. JsonString:
		String responseString = null;
		try {
			responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		ObjectMapper res = new ObjectMapper();

		try {
			response = res.readValue(responseString, ResponseJson.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(responseString.toString());
		System.out.println(response.getQueryResult().getFulfillmentText());
		
		
		HashMap<String,String> data = new HashMap<String, String>();
		
		data.put("answer", response.getQueryResult().getFulfillmentText());
		data.put("intent", response.getQueryResult().getIntent().getDisplayName());
		data.put("entity", "null");
		data.put("response_json", responseString.toString());
		
		return data;
	}
	

	public static void main(String arg[])
	{
		ChatScript c=new ChatScript();
		c.runChatScript("What's GCAP?");
	}
}
