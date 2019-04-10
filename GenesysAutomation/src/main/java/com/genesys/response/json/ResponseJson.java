package com.genesys.response.json;

import java.util.HashMap;
import java.util.Map;

public class ResponseJson {

private String responseId;
private QueryResult queryResult;

public String getResponseId() {
return responseId;
}

public void setResponseId(String responseId) {
this.responseId = responseId;
}

public ResponseJson withResponseId(String responseId) {
this.responseId = responseId;
return this;
}

public QueryResult getQueryResult() {
return queryResult;
}

public void setQueryResult(QueryResult queryResult) {
this.queryResult = queryResult;
}


}