/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sslretrival;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Date;
import javax.net.ssl.HttpsURLConnection;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author EEU689
 */
public class SslRetrival {

    /**
     * @param args the command line arguments
     */
    
    public String url1;
    public String url2;
    public URL url;
    public HttpsURLConnection connection;
    public X509Certificate[] certs;
    public Principal advanced;
    public HttpsURLConnection connection2;

    public int count;
    
    
        public boolean print () throws MalformedURLException, IOException {
        try{
        url = new URL(url1);
        connection = (HttpsURLConnection) url.openConnection();
        connection.connect();  
        certs = (X509Certificate[])connection.getServerCertificates();// #1 
        return true;
        }
        catch(javax.net.ssl.SSLHandshakeException ex){
            System.out.println("Certificate couldn't be retrieved");
            return false;
        }

} 
        public void setURL(String aurl)
        {
            url1 = aurl;
            url2 = aurl;

        }
        
        public String getURL()
        {
            return url1;
        }
        
        

        
     
        public String getValidity() throws IOException, CertificateParsingException, CertificateEncodingException
        {
           Date pk;
           Date date = new Date();
           String reportDate = "";
           
           pk =  certs[0].getNotAfter();          
           if (pk.compareTo(date) > 0) {
            reportDate = "Secure";
        } else if (pk.compareTo(date) < 0) {
            reportDate = "not Secure";
        } 
           return reportDate;
        }
        
        public String setDateText()
        {
            Date pk =  certs[0].getNotAfter(); 
            return "The certificate is valid until " + pk;
        }
        
        
        
        public String getAlg() throws IOException
        {
            String alg = certs[0].getSigAlgName();
            
            if(alg == "SHA256withRSA")
            {

                return "Secure";
            }
            else{
                return "Not a trusted algorithm";
            }
            
        }
        
        public String setAlgText()
        {
            String alg = certs[0].getSigAlgName();
            return "The algorithm used is " + alg;
        }
        
        public String getSubject() throws IOException
        {
           advanced = certs[0].getSubjectDN();
           String a = advanced.toString();
           return a;
        }
        
        
        public String urlCheck() throws CertificateParsingException
        {
            String secure = "";
            Collection<List<?>> i =  certs[0].getSubjectAlternativeNames();
            String b = i.toString();
            String t = url1.replace("https://", "");
           
            if(b.contains(t))
            {
                secure = "Secure";
                System.out.println("URL");

            }
            
            else
            {
                secure = "Not secure";
            }
           
            return secure;
        }
        
          public String setUrlText(String secure)
    {
        if(secure == "Secure")
        {
        return"The URL entered matches the URL on the certificate";
        }else{
         return "The URL entered doesn't match the URL on the certificate";
        }
    }
    
        
        
        
       
        
    }
    
    



