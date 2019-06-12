package com.mycompany.lab3;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ReadXmlFile
{
    public String url;
    public String weather;
    public String wCondition;
    
    public void setUrl(String Url1) throws Exception
    {
       url = Url1;//Setting URL
       
    }
    
    public void start() throws Exception
    {
        String url2 = url;
        
        URL url = new URL("http://open.live.bbc.co.uk/weather/feeds/en/"+ url2 +"/observations.rss");//Setting url
        URLConnection connection = url.openConnection();//Creating url connection

        Document doc = parseXML(connection.getInputStream());
        NodeList descNodes = doc.getElementsByTagName("title");//Finding xml tag "title"

        for(int i=1; i<descNodes.getLength();i++)   
            
        {
            
            weather = descNodes.item(i).getTextContent();//Getting the second instance of the xml tag
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
 
        public String getWeather()
    {
        
        return weather;//Returning weather conditions
    }
        public String getWCondition()
        {
            if(weather.contains("Thick Cloud"))
            {
               
                wCondition = "Thick Cloud";
                
            }
            else if(weather.contains("Light Showers"))
            {
                wCondition = "Light Showers";
            }
            else if(weather.contains("Sunny"))
            {
                wCondition = "Sunny";
            }
            return wCondition;
        }
}
