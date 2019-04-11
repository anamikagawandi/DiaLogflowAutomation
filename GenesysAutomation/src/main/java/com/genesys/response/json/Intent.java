package com.genesys.response.json;

import java.util.HashMap;
import java.util.Map;

public class Intent {

private String name;
private String displayName;
private boolean isFallback;


public boolean isFallback() {
return isFallback;
}

public void setIsFallback(boolean isFallback) {
this.isFallback = isFallback;
}



public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}



public String getDisplayName() {
return displayName;
}

public void setDisplayName(String displayName) {
this.displayName = displayName;
}




}