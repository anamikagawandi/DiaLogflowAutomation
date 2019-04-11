package com.genesys.response.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parameters {

	private String session;
	private String activity;
	private HashMap<String , String> entity ;
	
	
	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}


	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	
	public HashMap<String,String> getEntity()	
	{
		entity= new HashMap<String , String>();
		
		entity.put("session", getSession());
		entity.put("activity", getActivity());
		
		return entity;
	}

}