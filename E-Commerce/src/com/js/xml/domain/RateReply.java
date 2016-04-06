package com.js.xml.domain;

public class RateReply {
	
	private String namespaceURI;

	private HighestSeverity  highestSeverity  = new HighestSeverity();
	private Notifications    notifications    = new Notifications();
	private Version          version          = new Version();
	private RateReplyDetails rateReplyDetails = new RateReplyDetails();
	
	
	public HighestSeverity getHighestSeverity() {
		return highestSeverity;
	}
	public Notifications getNotifications() {
		return notifications;
	}
	public Version getVersion() {
		return version;
	}
	public RateReplyDetails getRateReplyDetails() {
		return rateReplyDetails;
	}
	public String getNamespaceURI() {
		return namespaceURI;
	}
	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}
	
	
	
}
