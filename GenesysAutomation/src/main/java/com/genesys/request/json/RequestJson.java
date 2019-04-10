package com.genesys.request.json;

import java.util.HashMap;
import java.util.Map;

public class RequestJson {

private QueryInput queryInput;


public RequestJson (QueryInput queryInput)
{
	this.queryInput=queryInput;
}


public QueryInput getQueryInput() {
return queryInput;
}

public void setQueryInput(QueryInput queryInput) {
this.queryInput = queryInput;
}


}