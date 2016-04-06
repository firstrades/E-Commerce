package com.za.tutorial.java.xml.stax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import com.za.tutorial.java.xml.domain.Channel;
import com.za.tutorial.java.xml.domain.Topic;
import com.za.tutorial.java.xml.domain.Tutorial;

public class XMLEventReaderDriver {

	public static void main(String...args) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
		
		displayChannel(new XMLEventReaderHandler().processXMLFile(new File("zaneacademy.xml")));
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
