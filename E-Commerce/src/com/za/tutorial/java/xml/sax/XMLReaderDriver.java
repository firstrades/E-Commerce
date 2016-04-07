package com.za.tutorial.java.xml.sax;

import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.js.xml.validation.SimpleErrorHandler;
import com.za.tutorial.java.xml.domain.Channel;
import com.za.tutorial.java.xml.domain.Topic;
import com.za.tutorial.java.xml.domain.Tutorial;

public class XMLReaderDriver {

	public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
		XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
		xmlReader.setErrorHandler(new SimpleErrorHandler());
		ZAHandler zaHandler = new ZAHandler();
		xmlReader.setContentHandler(zaHandler);
		xmlReader.parse(new InputSource("zaneacademy.xml"));
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
