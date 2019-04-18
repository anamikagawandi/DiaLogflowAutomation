package com.genesys.response.json;

import java.util.List;

import com.genesys.context.response.OutputContext;

public class QueryResult {

private String queryText;
private Parameters parameters;
private Boolean allRequiredParamsPresent;
private String fulfillmentText;
private List<FulfillmentMessage> fulfillmentMessages = null;
private List<OutputContext> outputContexts = null;
private Intent intent;
private Integer intentDetectionConfidence;
private DiagnosticInfo diagnosticInfo;
private String languageCode;
private String action;


public String getAction() {
return action;
}

public void setAction(String action) {
this.action = action;
}





public String getQueryText() {
return queryText;
}

public void setQueryText(String queryText) {
this.queryText = queryText;
}

public Parameters getParameters() {
return parameters;
}

public void setParameters(Parameters parameters) {
this.parameters = parameters;
}

public Boolean getAllRequiredParamsPresent() {
return allRequiredParamsPresent;
}

public void setAllRequiredParamsPresent(Boolean allRequiredParamsPresent) {
this.allRequiredParamsPresent = allRequiredParamsPresent;
}

public String getFulfillmentText() {
return fulfillmentText;
}

public void setFulfillmentText(String fulfillmentText) {
this.fulfillmentText = fulfillmentText;
}

public List<FulfillmentMessage> getFulfillmentMessages() {
return fulfillmentMessages;
}

public void setFulfillmentMessages(List<FulfillmentMessage> fulfillmentMessages) {
this.fulfillmentMessages = fulfillmentMessages;
}

public List<OutputContext> getOutputContexts() {
return outputContexts;
}

public void setOutputContexts(List<OutputContext> outputContexts) {
this.outputContexts = outputContexts;
}

public Intent getIntent() {
return intent;
}

public void setIntent(Intent intent) {
this.intent = intent;
}

public Integer getIntentDetectionConfidence() {
return intentDetectionConfidence;
}

public void setIntentDetectionConfidence(Integer intentDetectionConfidence) {
this.intentDetectionConfidence = intentDetectionConfidence;
}

public DiagnosticInfo getDiagnosticInfo() {
return diagnosticInfo;
}

public void setDiagnosticInfo(DiagnosticInfo diagnosticInfo) {
this.diagnosticInfo = diagnosticInfo;
}

public String getLanguageCode() {
return languageCode;
}

public void setLanguageCode(String languageCode) {
this.languageCode = languageCode;
}

}