package com.example.red;


import java.net.URL;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;


 
/**
 * Class reads RSS data.
 * @author ITCuties
 */
public class RssReader {
    // Our class has an attribute which represents RSS Feed URL
    private String rssUrl;
    /**
     * We set this URL with the constructor
     */
    public RssReader(String rssUrl) {
        this.rssUrl = rssUrl;
    }
    /**
     * Get RSS items. This method will be called to get the parsing process result.
     * @return
     */
    public List<RssItem> getItems() throws Exception {
        // At first we need to get an SAX Parser Factory object
    	try
		{
		URL url = new URL(rssUrl);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();
		RssParseHandler handler = new RssParseHandler();
		reader.setContentHandler(handler);
		InputSource source = new InputSource(url.openStream());
		//source.setEncoding("utf-8");
		//source.setEncoding("ISO-8859-1");
		reader.parse(source);
		return handler.getItems();
		}catch(Exception e){
			   e.printStackTrace();
		                   }
		return null;
		
	}
    }

