package com.exempla.utils;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class UtilidadesXPath {
    
	public static void main(String[] args) {  
		String expression;
        try {
        	expression = "/bookstore/book[contains(title,\"Harry\")]";         
            xmlquery(expression);
        } catch (Exception e) {            
            e.printStackTrace();
        }
        
        try {
        	expression = "/bookstore/book[price < 30.0]";         
            xmlquery(expression);
        } catch (Exception e) {            
            e.printStackTrace();
        }
        
        try {
        	expression = "/bookstore/book[author=\"Erik T. Ray\"]";      
            xmlquery(expression);
        } catch (Exception e) {            
            e.printStackTrace();
        }

    }
	
	public static int xmlquery(String expression){
		int nr=0;
		
        try {

            Document doc = UtilidadesXML.File2Document("src/test/resources/bookstore-jaxb.xml");
            
            XPath xpath = XPathFactory.newInstance().newXPath();   
            NodeList nodes = (NodeList) xpath.evaluate(expression, doc.getDocumentElement(), XPathConstants.NODESET);
            nr = nodes.getLength();
            System.out.println(UtilidadesXML.Nodes2String(nodes));
            
        } catch (Exception e) {            
            e.printStackTrace();
        }
        
        return nr;
	}
}