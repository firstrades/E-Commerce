package com.js.xml.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.js.xml.domain.SOAPReplyFactory;

public class StreamReaderDriver {	
	
	//Specifically, Stax like SAX are stream-based so you only see whatever is the current event or token. 
	//There are no accessors for children or parents because there is no guaranteed way to get to them, 
	//as that is not necessarily possible considering current stream position.
	
	private static SOAPReplyFactory soapReplyFactory = SOAPReplyFactory.getInstance();

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
		XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(new File("Rate.xml")));
		
		new StreamReaderHandler().processXMLFile(xmlStreamReader);
		displayXml();
	}
	
	private static void displayXml() {		
		
		String prefix = soapReplyFactory.getEnvelope().getNamespacePrefix();
		String uri    = soapReplyFactory.getEnvelope().getNamespaceURI();
		String highestSeverity = soapReplyFactory.getEnvelope().getBody().getRateReply().getHighestSeverity().getText();
		String rateUri = soapReplyFactory.getEnvelope().getBody().getRateReply().getNamespaceURI();
		String severityText = soapReplyFactory.getEnvelope().getBody().getRateReply().getNotifications().getSeverityText();
		String sourceText = soapReplyFactory.getEnvelope().getBody().getRateReply().getNotifications().getSourceText();
		String codeText = soapReplyFactory.getEnvelope().getBody().getRateReply().getNotifications().getCodeText();
		String messageText = soapReplyFactory.getEnvelope().getBody().getRateReply().getNotifications().getMessageText();
		String localizedMessageText = soapReplyFactory.getEnvelope().getBody().getRateReply().getNotifications().getLocalizedMessageText();
		String serviceIdText = soapReplyFactory.getEnvelope().getBody().getRateReply().getVersion().getServiceIdText();
		String majorText = soapReplyFactory.getEnvelope().getBody().getRateReply().getVersion().getMajorText();
		String intermediateText = soapReplyFactory.getEnvelope().getBody().getRateReply().getVersion().getIntermediateText();
		String minorText = soapReplyFactory.getEnvelope().getBody().getRateReply().getVersion().getMinorText();
		String serviceType = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getServiceType();
		String packagingType = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getPackagingType();
		String deliveryStation = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getDeliveryStation();
		String deliveryDayOfWeek = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getDeliveryDayOfWeek();
		String deliveryTimestamp = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getDeliveryTimestamp();
		String commodityName = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().getCommodityName();
		String serviceType1 = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().getServiceType();
		String commitTimestamp = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().getCommitTimestamp();
		String dayOfWeek = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().getDayOfWeek();
		String destinationServiceArea = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().getDestinationServiceArea();
		String brokerToDestinationDays = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().getBrokerToDestinationDays();
		String documentContent = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getCommitDetails().getDocumentContent();
		String destinationAirportId = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getDestinationAirportId();
		String ineligibleForMoneyBackGuarantee = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getIneligibleForMoneyBackGuarantee();
		String originServiceArea = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getOriginServiceArea();
		String destinationServiceArea1 = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getDestinationServiceArea();
		String signatureOption = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getSignatureOption();
		String actualRateType = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getActualRateType();		
		String rateType = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getRateType();
		String rateScale = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getRateScale();
		String rateZone = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getRateZone();
		String pricingCode = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getPricingCode();
		String ratedWeightMethod = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getRatedWeightMethod();		
		String dimDivisor = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getDimDivisor();
		String fuelSurchargePercent = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getFuelSurchargePercent();		
		String fromCurrency = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getCurrencyExchangeRate().getFromCurrency();
		String intoCurrency = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getCurrencyExchangeRate().getIntoCurrency();
		String rate = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getCurrencyExchangeRate().getRate();
		
		String units = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getTotalBillingWeight().getUnits();
		String value = soapReplyFactory.getEnvelope().getBody().getRateReply().getRateReplyDetails().getRatedShipmentDetails().getShipmentRateDetail().getTotalBillingWeight().getValue();
		
		
		System.out.println("<"+prefix+":"+"Envelope xmlns:" + prefix+"=\""+uri+"\">");
		System.out.println("\t<"+prefix+":Header />");
		System.out.println("\t<"+prefix+":Body>");
		System.out.println("\t\t<RateReply xmlns=\""+rateUri+"\">");
		System.out.println("\t\t\t<HighestSeverity>"+highestSeverity+"</HighestSeverity>");
		System.out.println("\t\t\t<Notifications>");		
		System.out.println("\t\t\t\t<Severity>"+severityText+"</Severity>");
		System.out.println("\t\t\t\t<Source>"+sourceText+"</Source>");
		System.out.println("\t\t\t\t<Code>"+codeText+"</Code>");
		System.out.println("\t\t\t\t<Message>"+messageText+"</Message>");
		System.out.println("\t\t\t\t<LocalizedMessage>"+localizedMessageText+"</LocalizedMessage>");		
		System.out.println("\t\t\t</Notifications>");		
		System.out.println("\t\t\t<Version>");
		System.out.println("\t\t\t\t<ServiceId>"+serviceIdText+"</ServiceId>");
		System.out.println("\t\t\t\t<Major>"+majorText+"</Major>");
		System.out.println("\t\t\t\t<Intermediate>"+intermediateText+"</Intermediate>");
		System.out.println("\t\t\t\t<Minor>"+minorText+"</Minor>");		
		System.out.println("\t\t\t</Version>");
		
		System.out.println("\t\t\t<RateReplyDetails>");
		System.out.println("\t\t\t\t<ServiceType>"+serviceType+"</ServiceType>");
		System.out.println("\t\t\t\t<PackagingType>"+packagingType+"</PackagingType>");
		System.out.println("\t\t\t\t<DeliveryStation>"+deliveryStation+"</DeliveryStation>");
		System.out.println("\t\t\t\t<DeliveryDayOfWeek>"+deliveryDayOfWeek+"</DeliveryDayOfWeek>");
		System.out.println("\t\t\t\t<DeliveryTimestamp>"+deliveryTimestamp+"</DeliveryTimestamp>");	
		
		System.out.println("\t\t\t\t<CommitDetails>");		
		System.out.println("\t\t\t\t\t<CommodityName>"+commodityName+"</CommodityName>");
		System.out.println("\t\t\t\t\t<ServiceType>"+serviceType1+"</ServiceType>");
		System.out.println("\t\t\t\t\t<CommitTimestamp>"+commitTimestamp+"</CommitTimestamp>");
		System.out.println("\t\t\t\t\t<DayOfWeek>"+dayOfWeek+"</DayOfWeek>");
		System.out.println("\t\t\t\t\t<DestinationServiceArea>"+destinationServiceArea+"</DestinationServiceArea>");
		System.out.println("\t\t\t\t\t<BrokerToDestinationDays>"+brokerToDestinationDays+"</BrokerToDestinationDays>");
		System.out.println("\t\t\t\t\t<DocumentContent>"+documentContent+"</DocumentContent>");		
		System.out.println("\t\t\t\t</CommitDetails>");
		
		System.out.println("\t\t\t\t<DestinationAirportId>"+destinationAirportId+"</DestinationAirportId>");
		System.out.println("\t\t\t\t<IneligibleForMoneyBackGuarantee>"+ineligibleForMoneyBackGuarantee+"</IneligibleForMoneyBackGuarantee>");
		System.out.println("\t\t\t\t<OriginServiceArea>"+originServiceArea+"</OriginServiceArea>");
		System.out.println("\t\t\t\t<DestinationServiceArea>"+destinationServiceArea1+"</DestinationServiceArea>");
		System.out.println("\t\t\t\t<SignatureOption>"+signatureOption+"</SignatureOption>");
		System.out.println("\t\t\t\t<ActualRateType>"+actualRateType+"</ActualRateType>");		
		System.out.println("\t\t\t\t<RatedShipmentDetails>");	
		System.out.println("\t\t\t\t\t<ShipmentRateDetail>");		
		System.out.println("\t\t\t\t\t\t<RateType>"+rateType+"</RateType>");
		System.out.println("\t\t\t\t\t\t<RateScale>"+rateScale+"</RateScale>");
		System.out.println("\t\t\t\t\t\t<RateZone>"+rateZone+"</RateZone>");
		System.out.println("\t\t\t\t\t\t<PricingCode>"+pricingCode+"</PricingCode>");
		System.out.println("\t\t\t\t\t\t<RatedWeightMethod>"+ratedWeightMethod+"</RatedWeightMethod>");		
		System.out.println("\t\t\t\t\t\t<CurrencyExchangeRate>");		
		System.out.println("\t\t\t\t\t\t\t<FromCurrency>"+fromCurrency+"</FromCurrency>");
		System.out.println("\t\t\t\t\t\t\t<IntoCurrency>"+intoCurrency+"</IntoCurrency>");
		System.out.println("\t\t\t\t\t\t\t<Rate>"+rate+"</Rate>");		
		System.out.println("\t\t\t\t\t\t</CurrencyExchangeRate>");		
		System.out.println("\t\t\t\t\t\t<DimDivisor>"+dimDivisor+"</DimDivisor>");
		System.out.println("\t\t\t\t\t\t<FuelSurchargePercent>"+fuelSurchargePercent+"</FuelSurchargePercent>");
		System.out.println("\t\t\t\t\t\t<TotalBillingWeight>");
		System.out.println("\t\t\t\t\t\t\t<Units>"+units+"</Units>");
		System.out.println("\t\t\t\t\t\t\t<Value>"+value+"</Value>");
		System.out.println("\t\t\t\t\t\t</TotalBillingWeight>");
		
		
		
		
		
		
		
		
		
		System.out.println("\t\t\t\t\t</ShipmentRateDetail>");	
		System.out.println("\t\t\t\t</RatedShipmentDetails>");
		
		
		
		
		
		System.out.println("\t\t\t</RateReplyDetails>");
		
		System.out.println("</"+prefix+":"+"Envelope>");
	}

}
