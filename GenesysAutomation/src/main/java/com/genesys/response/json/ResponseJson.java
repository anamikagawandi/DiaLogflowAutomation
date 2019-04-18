package com.genesys.response.json;

public class ResponseJson {

private String responseId;
private QueryResult queryResult;
private WebhookStatus webhookStatus;

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

}