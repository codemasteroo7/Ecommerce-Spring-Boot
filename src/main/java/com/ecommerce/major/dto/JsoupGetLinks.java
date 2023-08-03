package com.ecommerce.major.dto;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
/**
 * This class is used get links from HTML using Jsoup.
 * @author w3spoint
 */
public class JsoupGetLinks {
  public static void main(String args[]){
    Document document;
    try {
    	//Get Document object after parsing the html from given url.
	document = Jsoup.connect("https://www.w3schools.blog/").get();
 
	//Get links from document object. 
	Elements links = document.select("a[href]");
 
	//Iterate links and print link attributes.
	for (Element link : links) {
		System.out.println("Link: " + link.attr("href"));
		System.out.println("Text: " + link.text());
		System.out.println("");
	}
 
    } catch (IOException e) {
	e.printStackTrace();
    }		
  }
}