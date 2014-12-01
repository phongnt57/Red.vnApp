package com.example.red;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoup {
	Document doc;
	private String text=" ";
	public String getText(String link){
		try {
			 
			//get all images
			doc = Jsoup.connect(link).get();
			
					
			Elements p= doc.getElementsByTag("p");
			for (Element element  : p) {
				text = text + element.text()+"\n";
				
	 
				
	 
			}
			return text;
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	 
	  }
		
	
	}


