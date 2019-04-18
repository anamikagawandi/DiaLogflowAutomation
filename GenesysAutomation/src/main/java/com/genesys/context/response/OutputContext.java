package com.genesys.context.response;


public class OutputContext {

private String name;
private Integer lifespanCount;
private Parameters parameters;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Integer getLifespanCount() {
return lifespanCount;
}

public void setLifespanCount(Integer lifespanCount) {
this.lifespanCount = lifespanCount;
}

public Parameters getParameters() {
return parameters;
}

public void setParameters(Parameters parameters) {
this.parameters = parameters;
}

}