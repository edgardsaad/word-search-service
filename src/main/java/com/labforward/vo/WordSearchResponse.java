package com.labforward.vo;

import java.io.Serializable;

public class WordSearchResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6372881373149216289L;
	private int frequency;
	private String similarities;
	
	public WordSearchResponse() {
		super();
	}
	
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public String getSimilarities() {
		return similarities;
	}
	public void setSimilarities(String similarities) {
		this.similarities = similarities;
	}
	
}
