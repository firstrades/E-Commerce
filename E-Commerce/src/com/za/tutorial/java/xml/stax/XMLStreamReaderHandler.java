package com.za.tutorial.java.xml.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.za.tutorial.java.xml.domain.Channel;
import com.za.tutorial.java.xml.domain.Topic;
import com.za.tutorial.java.xml.domain.Tutorial;

public class XMLStreamReaderHandler {

	public Channel processXMLFile(File xmlFile) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
		
		Channel channel   = null;
		Topic topic       = null;
		Tutorial tutorial = null;
		boolean isTutorialFlag = false;
		XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(xmlFile));
		
		while (xmlStreamReader.hasNext()) {
		
			switch (xmlStreamReader.next()) {
			
				case XMLStreamConstants.START_ELEMENT:
					if (xmlStreamReader.getLocalName().equals("channel")) {						
						channel = new Channel();
						channel.setName(xmlStreamReader.getAttributeValue(0));
						isTutorialFlag = false;
					} else if (xmlStreamReader.getLocalName().equals("topic")) {
						topic = new Topic();
						topic.setName(xmlStreamReader.getAttributeValue(0));
						channel.addTopic(topic);
						isTutorialFlag = false;
					} else if (xmlStreamReader.getLocalName().equals("tutorial")) {
						tutorial = new Tutorial();
						topic.addTutorial(tutorial);
						isTutorialFlag = true;
					}					
					break;
				
				case XMLStreamConstants.CHARACTERS:
					if (!xmlStreamReader.isWhiteSpace())
						if (isTutorialFlag) tutorial.setName(xmlStreamReader.getText());
					break;
			
			}		
		}
		
		return channel;
	}
}
