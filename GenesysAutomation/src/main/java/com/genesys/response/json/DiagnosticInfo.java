package com.genesys.response.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties
public class DiagnosticInfo {
	
@JsonIgnoreProperties
private Integer webhookLatencyMs;

@JsonIgnoreProperties
public Integer getWebhookLatencyMs() {
return webhookLatencyMs;
}

@JsonIgnoreProperties
public void setWebhookLatencyMs(Integer webhookLatencyMs) {
this.webhookLatencyMs = webhookLatencyMs;
}

}