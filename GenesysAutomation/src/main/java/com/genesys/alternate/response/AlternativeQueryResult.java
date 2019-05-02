package com.genesys.alternate.response;

import java.util.List;

import com.genesys.context.response.OutputContext;

public class AlternativeQueryResult {

	
	private String queryText;
	private Parameters parameters;
	private Boolean allRequiredParamsPresent;
	private Intent intent;
	private Float intentDetectionConfidence;
	private String languageCode;
	private SentimentAnalysisResult sentimentAnalysisResult;
	private KnowledgeAnswers knowledgeAnswers;
	private List<OutputContext> outputContexts = null;

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

	public Intent getIntent() {
	return intent;
	}

	public void setIntent(Intent intent) {
	this.intent = intent;
	}

	public Float getIntentDetectionConfidence() {
	return intentDetectionConfidence;
	}

	public void setIntentDetectionConfidence(Float intentDetectionConfidence) {
	this.intentDetectionConfidence = intentDetectionConfidence;
	}

	public String getLanguageCode() {
	return languageCode;
	}

	public void setLanguageCode(String languageCode) {
	this.languageCode = languageCode;
	}

	public SentimentAnalysisResult getSentimentAnalysisResult() {
	return sentimentAnalysisResult;
	}

	public void setSentimentAnalysisResult(SentimentAnalysisResult sentimentAnalysisResult) {
	this.sentimentAnalysisResult = sentimentAnalysisResult;
	}

	public KnowledgeAnswers getKnowledgeAnswers() {
	return knowledgeAnswers;
	}

	public void setKnowledgeAnswers(KnowledgeAnswers knowledgeAnswers) {
	this.knowledgeAnswers = knowledgeAnswers;
	}
	
	public List<OutputContext> getOutputContexts() {
		return outputContexts;
		}

		public void setOutputContexts(List<OutputContext> outputContexts) {
		this.outputContexts = outputContexts;
		}
}
