package com.js.xml.validation;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SaxXsdInternal {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		//http://www.edankert.com/validate.html
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);

		SAXParser parser = factory.newSAXParser();
		parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
		      "http://www.w3.org/2001/XMLSchema");

		XMLReader reader = parser.getXMLReader();
		reader.setErrorHandler(new SimpleErrorHandler());
		reader.parse(new InputSource("contacts.xml"));
	}
}
