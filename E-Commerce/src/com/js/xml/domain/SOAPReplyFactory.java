package com.js.xml.domain;

public class SOAPReplyFactory {

	private static SOAPReplyFactory soapReplyFactory = new SOAPReplyFactory();
	private Envelope envelope = new Envelope();
	
	private SOAPReplyFactory() {}
	
	public static SOAPReplyFactory getInstance() {
		return soapReplyFactory;
	}

	public Envelope getEnvelope() {
		return envelope;
	}
	
	
}
