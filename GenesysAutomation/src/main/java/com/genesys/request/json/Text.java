package com.genesys.request.json;

import java.util.HashMap;
import java.util.Map;

public class Text {

private String text;
private String languageCode;

public Text(String text,String languageCode)
{
	this.text=text;
	this.languageCode=languageCode;
}

public String getText() {
return text;
}

public void setText(String text) {
this.text = text;
}



public String getLanguageCode() {
return languageCode;
}

public void setLanguageCode(String languageCode) {
this.languageCode = languageCode;
}

}