package com.labforward.vo;

import java.io.Serializable;

public class WordSearchRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -938223432003424384L;
	private String word;
	private String text;
	
	public WordSearchRequest() {
		super();
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
