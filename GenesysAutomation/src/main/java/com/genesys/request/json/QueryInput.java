package com.genesys.request.json;

import java.util.HashMap;
import java.util.Map;

import com.genesys.response.json.Text;

public class QueryInput {
	
	

private com.genesys.request.json.Text text;

public QueryInput(com.genesys.request.json.Text text)
{
	this.text=text;
}

public com.genesys.request.json.Text getText() {
return text;
}

public void setText(com.genesys.request.json.Text text) {
this.text = text;
}

}