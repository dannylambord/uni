package com.mycompany.lab3;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ReadWeatherXml
{
    public String location;
    public String id;
    public String url;
    
    
    
    
    public void setLocation(String location1) throws Exception
    {
        location = location1;//Setting URL
        System.out.println(location);
        start();
        
    }
    
    void start() throws Exception
    {
        URL url = new URL("http://api.geonames.org/search?q="+location+"&maxRows=1&lang=en&username=lambord97");//Setting url
        
        URLConnection connection = url.openConnection();//Creating url connection

        Document doc = parseXML(connection.getInputStream());
        NodeList descNodes = doc.getElementsByTagName("geonameId");//Finding xml tag "geonameId"

        for(int i=0; i<descNodes.getLength();i++)
        {
            
            id = descNodes.item(i).getTextContent();//Getting the second instance of the xml tag
        }
    }
    
    
    
    private Document parseXML(InputStream stream)
    throws Exception
    {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);//Reads the XML file
        }
        catch(Exception ex)
        {
            throw ex;
        }       

        return doc;
        
    
    }
 
        public String getId()
    {
        System.out.println(id);
        return id;//Returning weather conditions
    }
        
}
