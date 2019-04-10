package com.genesys.response.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Text {

private List<String> text = new ArrayList<String>();
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<String> getText() {
return text;
}

public void setText(List<String> text) {
this.text = text;
}

public Text withText(List<String> text) {
this.text = text;
return this;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public Text withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

}