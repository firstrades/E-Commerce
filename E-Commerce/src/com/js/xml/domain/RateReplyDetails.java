package com.js.xml.domain;

public class RateReplyDetails {

	private String serviceType;
	private String packagingType;
	private String deliveryStation;
	private String deliveryDayOfWeek;
	private String deliveryTimestamp;
	private CommitDetails commitDetails = new CommitDetails();
	private String destinationAirportId;
	private String ineligibleForMoneyBackGuarantee;
	private String originServiceArea;
	private String destinationServiceArea;
	private String signatureOption;
	private String actualRateType;
	private RatedShipmentDetails ratedShipmentDetails = new RatedShipmentDetails();
	
	
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getPackagingType() {
		return packagingType;
	}
	public void setPackagingType(String packagingType) {
		this.packagingType = packagingType;
	}
	public String getDeliveryStation() {
		return deliveryStation;
	}
	public void setDeliveryStation(String deliveryStation) {
		this.deliveryStation = deliveryStation;
	}
	public String getDeliveryDayOfWeek() {
		return deliveryDayOfWeek;
	}
	public void setDeliveryDayOfWeek(String deliveryDayOfWeek) {
		this.deliveryDayOfWeek = deliveryDayOfWeek;
	}
	public String getDeliveryTimestamp() {
		return deliveryTimestamp;
	}
	public void setDeliveryTimestamp(String deliveryTimestamp) {
		this.deliveryTimestamp = deliveryTimestamp;
	}
	public CommitDetails getCommitDetails() {
		return commitDetails;
	}	
	public String getDestinationAirportId() {
		return destinationAirportId;
	}
	public void setDestinationAirportId(String destinationAirportId) {
		this.destinationAirportId = destinationAirportId;
	}
	public String getIneligibleForMoneyBackGuarantee() {
		return ineligibleForMoneyBackGuarantee;
	}
	public void setIneligibleForMoneyBackGuarantee(
			String ineligibleForMoneyBackGuarantee) {
		this.ineligibleForMoneyBackGuarantee = ineligibleForMoneyBackGuarantee;
	}
	public String getOriginServiceArea() {
		return originServiceArea;
	}
	public void setOriginServiceArea(String originServiceArea) {
		this.originServiceArea = originServiceArea;
	}
	public String getDestinationServiceArea() {
		return destinationServiceArea;
	}
	public void setDestinationServiceArea(String destinationServiceArea) {
		this.destinationServiceArea = destinationServiceArea;
	}
	public String getSignatureOption() {
		return signatureOption;
	}
	public void setSignatureOption(String signatureOption) {
		this.signatureOption = signatureOption;
	}
	public String getActualRateType() {
		return actualRateType;
	}
	public void setActualRateType(String actualRateType) {
		this.actualRateType = actualRateType;
	}
	public RatedShipmentDetails getRatedShipmentDetails() {
		return ratedShipmentDetails;
	}
	
	
	
}
