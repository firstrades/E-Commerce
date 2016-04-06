package com.js.xml.domain;

public class Envelope {

	private String namespacePrefix;
	private String namespaceURI;
	
	private Header header = new Header();
	private Body   body   = new Body();
	
	public static Envelope newInstance() {
		return new Envelope();
	}	
	
	public Header getHeader() {
		return header;
	}
	public Body getBody() {
		return body;
	}

	public String getNamespacePrefix() {
		return namespacePrefix;
	}

	public void setNamespacePrefix(String namespacePrefix) {
		this.namespacePrefix = namespacePrefix;
	}

	public String getNamespaceURI() {
		return namespaceURI;
	}

	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}
	
	
}
