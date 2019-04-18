package Genesys.GenesysAutomation;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genesys.cms.response.CMSResponse;
import com.genesys.response.json.ResponseJson;

public class CMS {
	
		
		RestClient restClient;
		CloseableHttpResponse closebaleHttpResponse;
		Initializer init;
		CMSResponse response;
		Logger logger;
		
		public CMS()
		{
			restClient=new RestClient();
			init = new Initializer();
			logger = Logger.getLogger(this.getClass());
		}
		
		
		public String getCMSResponseString(String id)
		{
			String cms_response=null;
			
			String uri=init.prop.getProperty("cms_uri").replace("CMS_ID",id);
			
			
			try {
					closebaleHttpResponse = restClient.get(uri);
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
				cms_response = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			cms_response=cms_response.replaceAll("account_id","accountId");
			cms_response=cms_response.replaceAll("is_published","isPublished");
			cms_response=cms_response.replaceAll("language_id","languageId");
			cms_response=cms_response.replaceAll("created_at","createdAt");
			cms_response=cms_response.replaceAll("updated_at","updatedAt");
			
			return cms_response;
		}
		
		
		public CMSResponse getCMSResponse(String cms_response) throws JsonParseException,JsonMappingException,IOException
		{
			
			//System.out.println("THis is new CMS"+cms_response);
			
			ObjectMapper res = new ObjectMapper();

			response = res.readValue(cms_response, CMSResponse.class);

			return response;
		}
		
		
		
		
	/*	
		public static void main(String rgs[])
		{
			
			CMS i=new CMS();
			
				
			i.getCMSResponse("376576");
		}
*/

}
