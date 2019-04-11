package Genesys.GenesysAutomation;

import java.util.HashMap;

public class readHashMap {
	
	
	public HashMap<String,String>  getHashMapFromString(String str)
	{
				
		HashMap<String,String> datatest = new HashMap<String, String>();
		
		String[] pairs = str.split(",");
		System.out.println(pairs.length);
		for(int i=0;i<pairs.length;i++)
		{
			
			String[] keyValue = pairs[i].split("=");
			System.out.println(keyValue[0].replaceAll("\\{|\\}","").trim());
			System.out.println(keyValue[1].replaceAll("\\{|\\}","").trim());
			datatest.put(keyValue[0].replaceAll("\\{|\\}","").trim(), keyValue[1].replaceAll("\\{|\\}","").trim());
			
			
		}

		System.out.println("Check here");
		System.out.println(datatest.get("activity"));
		System.out.println(datatest.get("session"));
		
		
		return datatest;
		
	}

}
