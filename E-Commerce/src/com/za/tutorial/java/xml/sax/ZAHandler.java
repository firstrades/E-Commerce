package com.za.tutorial.java.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.za.tutorial.java.xml.domain.Channel;
import com.za.tutorial.java.xml.domain.Topic;
import com.za.tutorial.java.xml.domain.Tutorial;

public class ZAHandler extends DefaultHandler {

	private Channel  channel  = null;
	private Topic    topic    = null;
	private Tutorial tutorial = null;
	private int currentElement    = 0;
	private static int TOPIC_ELEMENT    = 1;
	private static int TUTORIAL_ELEMENT = 2;
	
	public Channel getChannel() {
		return channel;
	}
	
	@Override
	public void startDocument() throws SAXException {
		channel = new Channel();
	}	

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("channel")) {
			channel.setName(attributes.getValue("name"));
		} else if (qName.equals("topic")) {
			topic = new Topic();
			topic.setName(attributes.getValue("name"));
			currentElement = TOPIC_ELEMENT;
		} else if (qName.equals("tutorial")) {
			tutorial = new Tutorial();
			currentElement = TUTORIAL_ELEMENT;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (currentElement == TUTORIAL_ELEMENT) {
			String value = new String(ch, start, length).trim();
			if (value.length() != 0) tutorial.setName(value.trim());
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("topic"))         channel.addTopic(topic);
		else if (qName.equals("tutorial")) topic.addTutorial(tutorial);
	}	
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

}
