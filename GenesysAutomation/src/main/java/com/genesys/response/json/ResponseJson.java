package com.genesys.response.json;

import java.util.List;

import com.genesys.alternate.response.AlternativeQueryResult;

public class ResponseJson {

private String responseId;
private QueryResult queryResult;
private WebhookStatus webhookStatus;
private List<AlternativeQueryResult> alternativeQueryResults = null;


public String getResponseId() {
return responseId;
}

public void setResponseId(String responseId) {
this.responseId = responseId;
}

public QueryResult getQueryResult() {
return queryResult;
}

public void setQueryResult(QueryResult queryResult) {
this.queryResult = queryResult;
}

public WebhookStatus getWebhookStatus() {
return webhookStatus;
}

public void setWebhookStatus(WebhookStatus webhookStatus) {
this.webhookStatus = webhookStatus;
}


public List<AlternativeQueryResult> getAlternativeQueryResults() {
return alternativeQueryResults;
}

public void setAlternativeQueryResults(List<AlternativeQueryResult> alternativeQueryResults) {
this.alternativeQueryResults = alternativeQueryResults;
}
}