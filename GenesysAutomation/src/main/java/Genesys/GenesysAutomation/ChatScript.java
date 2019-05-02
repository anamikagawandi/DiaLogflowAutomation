package Genesys.GenesysAutomation;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
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
	//Logger logger;
	GenerateToken genTok;
	RequestJson reqJson;
	ResponseJson response;
	public ChatScript()
	{
		restClient=new RestClient();
		init = new Initializer();
		genTok= new GenerateToken();
		//logger = Logger.getLogger(this.getClass());
	}
	

	public String changeSessionInApiUri(String url)
	{
		Date date = Calendar.getInstance().getTime();  
	    DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");  
	    
	    String strDate = dateFormat.format(date);  
	    
	    return url.replace("{id}",strDate);   
	}
	
		
	public String[] getResponseString(String question,String api_uri)
	{
		restClient = new RestClient();
		
		
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
		//System.out.println(reqJsonString);
		
		
		
		String[] responseString = new String[2];
		
		//String api_uri=init.prop.getProperty("api_uri");
		
		
		//api_uri=api_uri.replace("{id}","12345");
		
		//api_uri=changeSessionInApiUri(api_uri);
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		//headerMap.put("Authorization", "Bearer "+genTok.getToken(init.prop.getProperty("token_url")).trim());
		headerMap.put("Authorization", "Bearer "+genTok.getTokenForDev().trim());
		
		
		try {
			closebaleHttpResponse = restClient.post(api_uri, reqJsonString, headerMap);
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
		//logger.info(statusCode= init.RESPONSE_STATUS_CODE_201);
		
		//2. JsonString:
		
		String responsestr=null;
		
		try {
			responsestr = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		responseString[0]=api_uri;
		
		responsestr=responsestr.replaceAll("webhook_latency_ms","webhookLatencyMs");
		responsestr=responsestr.replaceAll("when.original","whenOriginal");
		responsestr=responsestr.replaceAll("what.original","whatOriginal");
		responsestr=responsestr.replaceAll("where.original","whereOriginal");
		responsestr=responsestr.replaceAll("who.original","whoOriginal");
		responsestr=responsestr.replaceAll("item.original","itemOriginal");
		responsestr=responsestr.replaceAll("devcon.original","devconOriginal");
		responsestr=responsestr.replaceAll("next.original","nextOriginal");
		responsestr=responsestr.replaceAll("topic.original","topicOriginal");
		responsestr=responsestr.replaceAll("directions.original","directionsOriginal");
		responsestr=responsestr.replaceAll("general.original","generalOriginal");
		
		
		
		responseString[1]=responsestr;
	
		
		//System.out.println(responseString);
		
		return responseString;
	}
	
	
	
	public ResponseJson runChatScript(String responseString)
	{
		
		
		ObjectMapper res = new ObjectMapper();
		res.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

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
		
	
		//HashMap<String,String> data = new HashMap<String, String>();
		
		//data.put("answer", response.getQueryResult().getFulfillmentText());
		//data.put("intent", response.getQueryResult().getIntent().getDisplayName());
		//data.put("entity", response.getQueryResult().getParameters().getEntity().toString());
		//data.put("response_json", responseString.toString());
			
		return response;
	}
	
/*
	public static void main(String arg[])
	{
		ChatScript c=new ChatScript();
		Initializer init=new Initializer();
		ObjectMapper mapper = new ObjectMapper();
		//System.out.println(c.runChatScript(c.getResponseString("Is there a shuttle to the Westin?")).getQueryResult().getDiagnosticInfo().getWebhookLatencyMs());
		ResponseJson response_df=c.runChatScript(c.getResponseString("Where can I go to find my missing / lost badge?",init.prop.getProperty("api_uri").replace("{id}","1234"))[1]);
		System.out.println(response_df.getQueryResult().getFulfillmentText());
		System.out.println(response_df.getQueryResult().getParameters().getWhere());
		System.out.println(response_df.getQueryResult().getIntent().getDisplayName());
		//System.out.println(response_df.getQueryResult().getOutputContexts().get(0).getParameters().getWhere());
		//System.out.println(response_df.getQueryResult().getFulfillmentText());
		try {
			System.out.println(mapper.writeValueAsString(response_df));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
}
