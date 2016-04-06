package com.js.xml.stax;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.js.xml.domain.SOAPReplyFactory;

public class StreamReaderHandler {
	
	private static SOAPReplyFactory soapReplyFactory = SOAPReplyFactory.getInstance();

	public void processXMLFile(XMLStreamReader xmlStreamReader) throws XMLStreamException {	
		
		boolean isServiceType2 = true, isDestinationServiceArea2 = true;
		boolean isHighestSeverity = false, isSeverity = false, isSource = false, isCode = false, isMessage = false, isLocalizedMessage = false;
		boolean isServiceId = false, isMajor = false, isIntermediate = false, isMinor = false;
		boolean isServiceType = false, isPackagingType = false, isDeliveryStation = false, isDeliveryDayOfWeek = false, isDeliveryTimestamp = false;
		boolean isCommodityName = false, isServiceType1 = false, isCommitTimestamp = false, isDayOfWeek = false, isDestinationServiceArea = false, isBrokerToDestinationDays = false, isDocumentContent = false; 
		boolean isDestinationAirportId = false, isIneligibleForMoneyBackGuarantee = false, isOriginServiceArea = false, isDestinationServiceArea1 = false, isSignatureOption = false, isActualRateType = false;
		boolean isRateType = false, isRateScale = false, isRateZone = false, isPricingCode = false, isRatedWeightMethod = false,  isDimDivisor = false, isFuelSurchargePercent = false;
		boolean isFromCurrency = false, isIntoCurrency = false, isRate = false;
		boolean isUnits = false, isValue = false;
		
		while (xmlStreamReader.hasNext()) {
			
			switch (xmlStreamReader.next()) {			
				case XMLStreamConstants.START_ELEMENT : 
					//System.out.println(xmlStreamReader.getLocalName());	
					//Envelope
					if (xmlStreamReader.getLocalName().equals("Envelope")) { 
						soapReplyFactory.getEnvelope().setNamespacePrefix(xmlStreamReader.getNamespacePrefix(0));
						soapReplyFactory.getEnvelope().setNamespaceURI(xmlStreamReader.getNamespaceURI(soapReplyFactory.getEnvelope().getNamespacePrefix()));
					}
					//RateReply
					if (xmlStreamReader.getLocalName().equals("RateReply")) { 
						soapReplyFactory.getEnvelope().getBody().getRateReply().setNamespaceURI(xmlStreamReader.getNamespaceURI());						
					}					
					//HighestSeverity
					if (xmlStreamReader.getLocalName().equals("HighestSeverity")) { isHighestSeverity = true; }
					//Notifications
					if (xmlStreamReader.getLocalName().equals("Severity")) { isSeverity = true; }
					if (xmlStreamReader.getLocalName().equals("Source")) { isSource = true; }
					if (xmlStreamReader.getLocalName().equals("Code")) { isCode = true; }
					if (xmlStreamReader.getLocalName().equals("Message")) { isMessage = true; }
					if (xmlStreamReader.getLocalName().equals("LocalizedMessage")) { isLocalizedMessage = true; }
					//Version
					if (xmlStreamReader.getLocalName().equals("ServiceId")) { isServiceId = true; }
					if (xmlStreamReader.getLocalName().equals("Major")) { isMajor = true; }
					if (xmlStreamReader.getLocalName().equals("Intermediate")) { isIntermediate = true; }
					if (xmlStreamReader.getLocalName().equals("Minor")) { isMinor = true; }
					//RateReplyDetails					
					if (xmlStreamReader.getLocalName().equals("ServiceType")) { isServiceType = true; }
					if (xmlStreamReader.getLocalName().equals("PackagingType")) { isPackagingType = true; }
					if (xmlStreamReader.getLocalName().equals("DeliveryStation")) { isDeliveryStation = true; }
					if (xmlStreamReader.getLocalName().equals("DeliveryDayOfWeek")) { isDeliveryDayOfWeek = true; }
					if (xmlStreamReader.getLocalName().equals("DeliveryTimestamp")) { isDeliveryTimestamp = true; }
						//CommitDetails
						if (xmlStreamReader.getLocalName().equals("CommodityName")) { isCommodityName = true; }											
						if (xmlStreamReader.getLocalName().equals("ServiceType")) { isServiceType1 = true; }					
						if (xmlStreamReader.getLocalName().equals("CommitTimestamp")) { isCommitTimestamp = true; }
						if (xmlStreamReader.getLocalName().equals("DayOfWeek")) { isDayOfWeek = true; }
						if (xmlStreamReader.getLocalName().equals("DestinationServiceArea")) { isDestinationServiceArea = true; }
						if (xmlStreamReader.getLocalName().equals("BrokerToDestinationDays")) { isBrokerToDestinationDays = true; }
						if (xmlStreamReader.getLocalName().equals("DocumentContent")) { isDocumentContent = true; }
					if (xmlStreamReader.getLocalName().equals("DestinationAirportId")) { isDestinationAirportId = true; }
					if (xmlStreamReader.getLocalName().equals("IneligibleForMoneyBackGuarantee")) { isIneligibleForMoneyBackGuarantee = true; }
					if (xmlStreamReader.getLocalName().equals("OriginServiceArea")) { isOriginServiceArea = true; }
					if (xmlStreamReader.getLocalName().equals("DestinationServiceArea")) { isDestinationServiceArea1 = true; }
					if (xmlStreamReader.getLocalName().equals("SignatureOption")) { isSignatureOption = true; }
					if (xmlStreamReader.getLocalName().equals("ActualRateType")) { isActualRateType = true; }
					//ShipmentRateDetail
					if (xmlStreamReader.getLocalName().equals("RateType")) { isRateType = true; }
					if (xmlStreamReader.getLocalName().equals("RateScale")) { isRateScale = true; }
					if (xmlStreamReader.getLocalName().equals("RateZone")) { isRateZone = true; }
					if (xmlStreamReader.getLocalName().equals("PricingCode")) { isPricingCode = true; }
					if (xmlStreamReader.getLocalName().equals("RatedWeightMethod")) { isRatedWeightMethod = true; }
					if (xmlStreamReader.getLocalName().equals("DimDivisor")) { isDimDivisor = true; }
					if (xmlStreamReader.getLocalName().equals("FuelSurchargePercent")) { isFuelSurchargePercent = true; }
					//CurrencyExchangeRate
					if (xmlStreamReader.getLocalName().equals("FromCurrency")) { isFromCurrency = true; }
					if (xmlStreamReader.getLocalName().equals("IntoCurrency")) { isIntoCurrency = true; }
					if (xmlStreamReader.getLocalName().equals("Rate")) { isRate = true; }
					//TotalBillingWeight
					if (xmlStreamReader.getLocalName().equals("Units")) { isUnits = true; }
					if (xmlStreamReader.getLocalName().equals("Value")) { isValue = true; }
					
					break;
					
				case XMLStreamConstants.CHARACTERS    : 
					if (!xmlStreamReader.isWhiteSpace()) {
						if (isHighestSeverity) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getHighestSeverity().setText(xmlStreamReader.getText());
							isHighestSeverity = false;
						} 
						//Notifications
						if (isSeverity) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getNotifications().setSeverityText(xmlStreamReader.getText());
							isSeverity = false;
						}
						if (isSource) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getNotifications().setSourceText(xmlStreamReader.getText());
							isSource = false;
						}
						if (isCode) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getNotifications().setCodeText(xmlStreamReader.getText());
							isCode = false;
						}
						if (isMessage) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getNotifications().setMessageText(xmlStreamReader.getText());
							isMessage = false;
						}
						if (isLocalizedMessage) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getNotifications().setLocalizedMessageText(xmlStreamReader.getText());
							isLocalizedMessage = false;
						}
						//Version
						if (isServiceId) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getVersion().setServiceIdText(xmlStreamReader.getText());
							isServiceId = false;
						}
						if (isMajor) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getVersion().setMajorText(xmlStreamReader.getText());
							isMajor = false;
						}
						if (isIntermediate) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getVersion().setIntermediateText(xmlStreamReader.getText());
							isIntermediate = false;
						}
						if (isMinor) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getVersion().setMinorText(xmlStreamReader.getText());
							isMinor = false;
						}
						//RateReplyDetails
						if (isServiceType && isServiceType2) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().setServiceType(xmlStreamReader.getText());
							isServiceType = false;
							isServiceType2 = false;
						}
						if (isPackagingType) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().setPackagingType(xmlStreamReader.getText());
							isPackagingType = false;
						}
						if (isDeliveryStation) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().setDeliveryStation(xmlStreamReader.getText());
							isDeliveryStation = false;
						}
						if (isDeliveryDayOfWeek) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().setDeliveryDayOfWeek(xmlStreamReader.getText());
							isDeliveryDayOfWeek = false;
						}
						if (isDeliveryTimestamp) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().setDeliveryTimestamp(xmlStreamReader.getText());
							isDeliveryTimestamp = false;
						}
							//CommitDetails
							if (isCommodityName) {  
								soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().setCommodityName(xmlStreamReader.getText());
								isCommodityName = false;
							}
							if (isServiceType1 && !isServiceType2) {  
								soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().setServiceType(xmlStreamReader.getText());
								isServiceType1 = false;
							}
							if (isCommitTimestamp) {  
								soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().setCommitTimestamp(xmlStreamReader.getText());
								isCommitTimestamp = false;
							}
							if (isDayOfWeek) {  
								soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().setDayOfWeek(xmlStreamReader.getText());
								isDayOfWeek = false;
							}
							if (isDestinationServiceArea && isDestinationServiceArea2) {  
								soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().setDestinationServiceArea(xmlStreamReader.getText());
								isDestinationServiceArea = false;
								isDestinationServiceArea2 = false;
							}
							if (isBrokerToDestinationDays) {  
								soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().setBrokerToDestinationDays(xmlStreamReader.getText());
								isBrokerToDestinationDays = false;
							}
							if (isDocumentContent) {  
								soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().setDocumentContent(xmlStreamReader.getText());
								isDocumentContent = false;
							}
						if (isDestinationAirportId) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().setDestinationAirportId(xmlStreamReader.getText());
							isDestinationAirportId = false;
						}
						if (isIneligibleForMoneyBackGuarantee) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().setIneligibleForMoneyBackGuarantee(xmlStreamReader.getText());
							isIneligibleForMoneyBackGuarantee = false;
						}
						if (isOriginServiceArea) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().setOriginServiceArea(xmlStreamReader.getText());
							isOriginServiceArea = false;
						}
						if (isDestinationServiceArea1 && !isDestinationServiceArea2) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().setDestinationServiceArea(xmlStreamReader.getText());
							isDestinationServiceArea1 = false;
						}
						if (isSignatureOption) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().setSignatureOption(xmlStreamReader.getText());
							isSignatureOption = false;
						}
						if (isActualRateType) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().setActualRateType(xmlStreamReader.getText());
							isActualRateType = false;
						}
						//ShipmentRateDetail
						if (isRateType) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().setRateType(xmlStreamReader.getText());
							isRateType = false;
						}
						if (isRateScale) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().setRateScale(xmlStreamReader.getText());
							isRateScale = false;
						}
						if (isRateZone) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().setRateZone(xmlStreamReader.getText());
							isRateZone = false;
						}
						if (isPricingCode) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().setPricingCode(xmlStreamReader.getText());
							isPricingCode = false;
						}
						if (isRatedWeightMethod) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().setRatedWeightMethod(xmlStreamReader.getText());
							isRatedWeightMethod = false;
						}
						if (isDimDivisor) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().setDimDivisor(xmlStreamReader.getText());
							isDimDivisor = false;
						}
						if (isFuelSurchargePercent) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().setFuelSurchargePercent(xmlStreamReader.getText());
							isFuelSurchargePercent = false;
						}
						//CurrencyExchangeRate
						if (isFromCurrency) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getCurrencyExchangeRate().setFromCurrency(xmlStreamReader.getText());
							isFromCurrency = false;
						}
						if (isIntoCurrency) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getCurrencyExchangeRate().setIntoCurrency(xmlStreamReader.getText());
							isIntoCurrency = false;
						}
						if (isRate) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getCurrencyExchangeRate().setRate(xmlStreamReader.getText());
							isRate = false;
						}
						//TotalBillingWeight
						if (isUnits) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getTotalBillingWeight().setUnits(xmlStreamReader.getText());
							isUnits = false;
						}
						if (isValue) {  
							soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getTotalBillingWeight().setValue(xmlStreamReader.getText());
							isValue = false;
						}
					}
					
					break;
			}
		}
	}
}
