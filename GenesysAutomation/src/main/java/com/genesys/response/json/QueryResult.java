package com.genesys.response.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class QueryResult {

private String queryText;
private Parameters parameters;
private String action;
private boolean allRequiredParamsPresent;
private String fulfillmentText;
private List<FulfillmentMessage> fulfillmentMessages = new ArrayList<FulfillmentMessage>();
private Intent intent;


private DiagnosticInfo diagnosticInfo;
private int intentDetectionConfidence;
private String languageCode;

public String getQueryText() {
return queryText;
}

public void setQueryText(String queryText) {
this.queryText = queryText;
}


public String getAction() {
return action;
}

public void setAction(String action) {
this.queryText = action;
}



public Parameters getParameters() {
return parameters;
}

public void setParameters(Parameters parameters) {
this.parameters = parameters;
}


public boolean isAllRequiredParamsPresent() {
return allRequiredParamsPresent;
}

public void setAllRequiredParamsPresent(boolean allRequiredParamsPresent) {
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


public Intent getIntent() {
return intent;
}

public void setIntent(Intent intent) {
this.intent = intent;
}



public int getIntentDetectionConfidence() {
return intentDetectionConfidence;
}

public void setIntentDetectionConfidence(int intentDetectionConfidence) {
this.intentDetectionConfidence = intentDetectionConfidence;
}



public String getLanguageCode() {
return languageCode;
}

public void setLanguageCode(String languageCode) {
this.languageCode = languageCode;
}

@JsonIgnoreProperties
public DiagnosticInfo getDiagnosticInfo() {
return diagnosticInfo;
}

@JsonIgnoreProperties
public void setDiagnosticInfo(DiagnosticInfo diagnosticInfo) {
this.diagnosticInfo = diagnosticInfo;
}

}