/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sslretrival;

/**
 *
 * @author danny
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;




/**
 * Check the revocation status of a public key certificate using a CRL.
 *
 * NOTE: it only works with V1 CRLs
 */

public class Crl {

    public String url1;
    public URL url;
    public HttpsURLConnection connection;
    public X509Certificate[] certs;
    public List<String> a;
    URL crlURL;

    
    public void setURL(String aurl)
        {
            url1 = aurl;
            
        }
    
    
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
    
    public void getCrl() throws IOException
        {
            try
        {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

            X509Certificate certificate = certs[0];//Certificate

            byte[] crlDistributionPointDerEncodedArray = certificate.getExtensionValue(Extension.cRLDistributionPoints.getId());//Get Crl dist points

            ASN1InputStream oAsnInStream = new ASN1InputStream(new ByteArrayInputStream(crlDistributionPointDerEncodedArray));
            ASN1Primitive derObjCrlDP = oAsnInStream.readObject();
            DEROctetString dosCrlDP = (DEROctetString) derObjCrlDP;

            oAsnInStream.close();

            byte[] crldpExtOctets = dosCrlDP.getOctets();
            ASN1InputStream oAsnInStream2 = new ASN1InputStream(new ByteArrayInputStream(crldpExtOctets));
            ASN1Primitive derObj2 = oAsnInStream2.readObject();
            CRLDistPoint distPoint = CRLDistPoint.getInstance(derObj2);

            oAsnInStream2.close();

            List<String> crlUrls = new ArrayList<>();//Create list of CRL URL's
            
            for (DistributionPoint dp : distPoint.getDistributionPoints())
            {
                DistributionPointName dpn = dp.getDistributionPoint();
                // Look for URIs in fullName
                if (dpn != null)
                {
                    if (dpn.getType() == DistributionPointName.FULL_NAME)//If URL's are present 
                    {
                        GeneralName[] genNames = GeneralNames.getInstance(dpn.getName()).getNames();
                        // Look for an URI
                        for (GeneralName genName : genNames) {
                            if (genName.getTagNo() == GeneralName.uniformResourceIdentifier) {
                                String url = DERIA5String.getInstance(genName.getName()).getString();
                                crlUrls.add(url);
                            }
                        }
                    }
                }
            }

            for (String url : crlUrls){
                crlURL = new URL(url);
            }
                
            
        }
        catch (IOException | CertificateException e)
        {
        } 
        }

    public String crl() throws MalformedURLException, IOException, CRLException, CertificateException
            {

                print();
                getCrl();
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            InputStream crlStream = crlURL.openStream();
            X509CRL crl = (X509CRL) 
            certFactory.generateCRL(crlStream);
            
            if(crl.getCriticalExtensionOIDs().isEmpty())
            {
                
                return "Secure";
                
            }else if(crl.getCriticalExtensionOIDs().contains("2.5.29.28")& crl.getCriticalExtensionOIDs().size()==1)
            {
                
                return "Secure";
                
            }else{
                return "Not Secure";
            }
                
            }
    
    public String setCrlText() throws IOException, CRLException, MalformedURLException, CertificateException
    {
        String text = "";
        try {
            if("Secure".equals(crl()))
            {

                text = "The website hasnt been revoked";
            }
            else
            {
                text = "The website has been revoked, please approach with caution";
            }
        } catch (CertificateException ex) {
            Logger.getLogger(Crl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return text;
    }
          

    
    
}

