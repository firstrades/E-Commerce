package com.za.tutorial.java.xml.domain;

import java.util.ArrayList;

public class Topic {

	private String name;
	private ArrayList<Tutorial> tutorials = new ArrayList<>();
	
	public Topic() {}
	
	public Topic(String name) { this.name = name; }
	
	public void addTutorial(Tutorial tutorial) {
		tutorials.add(tutorial);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Tutorial> getTutorials() {
		return tutorials;
	}
	public void setTutorials(ArrayList<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}
	
}
