package com.js.xml.domain;

public class CommitDetails {

	private String commodityName;
	private String serviceType;
	private String commitTimestamp;
	private String dayOfWeek;
	private String destinationServiceArea;
	private String brokerToDestinationDays;
	private String documentContent;
	
	
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getCommitTimestamp() {
		return commitTimestamp;
	}
	public void setCommitTimestamp(String commitTimestamp) {
		this.commitTimestamp = commitTimestamp;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getDestinationServiceArea() {
		return destinationServiceArea;
	}
	public void setDestinationServiceArea(String destinationServiceArea) {
		this.destinationServiceArea = destinationServiceArea;
	}
	public String getBrokerToDestinationDays() {
		return brokerToDestinationDays;
	}
	public void setBrokerToDestinationDays(String brokerToDestinationDays) {
		this.brokerToDestinationDays = brokerToDestinationDays;
	}
	public String getDocumentContent() {
		return documentContent;
	}
	public void setDocumentContent(String documentContent) {
		this.documentContent = documentContent;
	}
	
	
}
