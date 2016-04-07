package com.za.tutorial.java.xml.sax;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.za.tutorial.java.xml.domain.Channel;
import com.za.tutorial.java.xml.domain.Topic;
import com.za.tutorial.java.xml.domain.Tutorial;

public class SAXParserDriver {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		saxParserFactory.setValidating(true);
		saxParserFactory.setNamespaceAware(true);
		SAXParser saxParser = saxParserFactory.newSAXParser();
		saxParser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
			      "http://www.w3.org/2001/XMLSchema");
		ZAHandler zaHandler = new ZAHandler();
		saxParser.parse(new File("zaneacademy.xml"), zaHandler);
		displayChannel(zaHandler.getChannel());
	}
	
	private static void displayChannel(Channel channel) {
		
		Topic topic = null;
		System.out.println("channel (name = " + channel.getName() + ")");
		Iterator<Topic> topicsIterator = channel.getTopics().iterator();
		while (topicsIterator.hasNext()) {
			topic = topicsIterator.next();
			System.out.println("\t|_topic (name = " + topic.getName() + ")");
			Iterator<Tutorial> tutorialsIterator = topic.getTutorials().iterator();
			while (tutorialsIterator.hasNext()) {
				System.out.println("\t\t|_tutorial (name = " + tutorialsIterator.next().getName() + ")");
			}
		}
	}

}
