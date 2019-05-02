package com.genesys.alternate.response;

public class Answer {
	private String source;
	private String faqQuestion;
	private String answer;
	private String matchConfidenceLevel;
	private Float matchConfidence;

	public String getSource() {
	return source;
	}

	public void setSource(String source) {
	this.source = source;
	}

	public String getFaqQuestion() {
	return faqQuestion;
	}

	public void setFaqQuestion(String faqQuestion) {
	this.faqQuestion = faqQuestion;
	}

	public String getAnswer() {
	return answer;
	}

	public void setAnswer(String answer) {
	this.answer = answer;
	}

	public String getMatchConfidenceLevel() {
	return matchConfidenceLevel;
	}

	public void setMatchConfidenceLevel(String matchConfidenceLevel) {
	this.matchConfidenceLevel = matchConfidenceLevel;
	}

	public Float getMatchConfidence() {
	return matchConfidence;
	}

	public void setMatchConfidence(Float matchConfidence) {
	this.matchConfidence = matchConfidence;
	}

}
