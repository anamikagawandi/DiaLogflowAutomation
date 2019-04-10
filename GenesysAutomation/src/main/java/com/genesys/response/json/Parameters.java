package com.genesys.response.json;

import java.util.HashMap;
import java.util.Map;

public class Parameters {

private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public Parameters withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

}