package com.js.xml.validation;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements ErrorHandler {

	@Override
	public void error(SAXParseException exception) throws SAXException {
		System.out.println("Error: \n" + exception.getMessage());		
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("FatalError: \n" + exception.getMessage());		
	}

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		System.out.println("Warning: \n" + exception.getMessage());		
	}		
	
}

