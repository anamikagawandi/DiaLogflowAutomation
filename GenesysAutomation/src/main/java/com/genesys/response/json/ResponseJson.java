package com.genesys.response.json;

import java.util.HashMap;
import java.util.Map;

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

public WebhookStatus getWebhookStatus() {
return webhookStatus;
}

public void setWebhookStatus(WebhookStatus webhookStatus) {
this.webhookStatus = webhookStatus;
}

public QueryResult getQueryResult() {
return queryResult;
}

public void setQueryResult(QueryResult queryResult) {
this.queryResult = queryResult;
}


}