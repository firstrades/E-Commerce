package com.za.tutorial.java.xml.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.za.tutorial.java.xml.domain.Channel;
import com.za.tutorial.java.xml.domain.Topic;
import com.za.tutorial.java.xml.domain.Tutorial;

public class XMLEventReaderHandler {

	public Channel processXMLFile(File xmlFile) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
		Channel channel   = null;
		Topic topic       = null;
		Tutorial tutorial = null;
		XMLEvent xmlEvent = null;
		boolean isTutorialFlag = false;
		Characters characters = null;
		
		XMLEventReader xmlEventReader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(xmlFile));
		while (xmlEventReader.hasNext()) {
			xmlEvent = xmlEventReader.nextEvent(); // creating an object
			switch (xmlEvent.getEventType()) {
			
				case XMLStreamConstants.START_DOCUMENT:
					channel = new Channel();
					break;
				case XMLStreamConstants.START_ELEMENT:
					if(((StartElement) xmlEvent).getName().getLocalPart().equals("channel")) {
						channel.setName(((StartElement) xmlEvent).getAttributeByName(new QName("name")).toString());
					} else if(((StartElement) xmlEvent).getName().getLocalPart().equals("topic")) {
						topic = new Topic();
						topic.setName(((StartElement) xmlEvent).getAttributeByName(new QName("name")).toString());
						channel.addTopic(topic);
						isTutorialFlag = false;
					} else if(((StartElement) xmlEvent).getName().getLocalPart().equals("tutorial")) {
						tutorial = new Tutorial();
						topic.addTutorial(tutorial);
						isTutorialFlag = true;
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					characters = (Characters) xmlEvent;
					if (!(characters.isWhiteSpace() || characters.isIgnorableWhiteSpace()))
						if (isTutorialFlag) tutorial.setName(characters.getData());
					break;			
			}
		}
		
		return channel;
	}
}
