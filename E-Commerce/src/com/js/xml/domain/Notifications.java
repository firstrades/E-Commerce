package com.js.xml.domain;

public class Notifications {

	private String severityText;
	private String sourceText;
	private String codeText;
	private String messageText;
	private String localizedMessageText;
	
	
	public String getSeverityText() {
		return severityText;
	}
	public String getSourceText() {
		return sourceText;
	}
	public String getCodeText() {
		return codeText;
	}
	public String getMessageText() {
		return messageText;
	}
	public String getLocalizedMessageText() {
		return localizedMessageText;
	}
	public void setSeverityText(String severityText) {
		this.severityText = severityText;
	}
	public void setSourceText(String sourceText) {
		this.sourceText = sourceText;
	}
	public void setCodeText(String codeText) {
		this.codeText = codeText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public void setLocalizedMessageText(String localizedMessageText) {
		this.localizedMessageText = localizedMessageText;
	}
	
	
}
