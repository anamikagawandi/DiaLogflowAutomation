package com.genesys.response.json;

import java.util.HashMap;
import java.util.Map;

public class FulfillmentMessage {

private com.genesys.response.json.Text text;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public com.genesys.response.json.Text getText() {
return text;
}

public void setText(com.genesys.response.json.Text text) {
this.text = text;
}

public FulfillmentMessage withText(com.genesys.response.json.Text text) {
this.text = text;
return this;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public FulfillmentMessage withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

}