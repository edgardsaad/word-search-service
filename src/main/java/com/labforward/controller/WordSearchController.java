package com.labforward.controller;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.labforward.vo.WordSearchResponse;

/**
 * 
 * @author Edgard Saad
 * WordSearchController is the main REST controller 
 *  
 *
 */
@RestController
public class WordSearchController {
	
	/**
	 * avoid facing a cors error when calling the API
	 * from an angular project used as POC
	 * can change the below URL depends from where this API will be called
	 */
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/ProcessText", method = {RequestMethod.GET})
	
	/**
	 * 
	 * @param word as a string representing the word to search for
	 * @param text as a string representing the notebook entry to search in
	 * @return
	 * @throws Exception
	 * Get method is being used below 
	 * 
	 */
	public @ResponseBody  ResponseEntity<?> getWordSimilarities(
			@RequestParam(value = "word", defaultValue = "") String word, 
			@RequestParam(value = "text", defaultValue = "") String text) throws Exception
	{
		try 
		{
			String aToken = null;
			ArrayList<String> similaritiesList = new ArrayList<String>();
			int frequency = 0;
			StringBuffer similarities = new StringBuffer();
			StringTokenizer tokenizer = new StringTokenizer(text, " \t\n\r\f,.:;?![]'");
			
			
			/**
			 * loop through the text word by word 
			 */
			while (tokenizer.hasMoreElements()) {
				
				aToken = tokenizer.nextToken();
				
				/**
				 * increment the frequency if exact match of a word was found
				 */
				if(word.equals(aToken))
					frequency++;
				
				/**
				 * call the apply method of the LevenshteinDistance
				 * @param word as the word we are searching for
				 * @param aToken representing each word of the notebook entry
				 * @return an integer as the levenshtein distance   
				 * @see LevenshteinDistance
				 */
				if(LevenshteinDistance.getDefaultInstance().apply(word, aToken) == 1)
				{
					/**
					 * if the Levenshtein distance between word and aToken is equal 1
					 * add the word to the similarities if not added already
					 */
					if (!similaritiesList.contains(aToken)) {
						similarities.append(aToken + ",");
						similaritiesList.add(aToken);
					}
				} 
		    }
			
			/**
			 * append the values computed above
			 * into the API response
			 * response of type
			 * @see WordSearchResponse
			 * 
			 */
			WordSearchResponse response = new WordSearchResponse();
			response.setFrequency(frequency);
			String similaritiesResult = similarities.toString();
			response.setSimilarities(similaritiesResult.length() > 0? similaritiesResult.substring(0, similaritiesResult.length() - 1): similaritiesResult);
	    	return new ResponseEntity<>(response, HttpStatus.OK);
		}
		catch(Exception e2)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Server Error");
		}
	}
	
}
