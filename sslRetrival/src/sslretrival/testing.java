/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sslretrival;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danny
 */
public class testing {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.security.cert.CertificateParsingException
     * @throws java.security.cert.CertificateEncodingException
     */
    public static void main(String[] args) throws IOException, CertificateParsingException, CertificateEncodingException, MalformedURLException, CRLException, CertificateException, CertificateException {
        Text i = new Text();
        SslRetrival s = new SslRetrival();
        Crl c = new Crl();
        ShieldRetrieval sr = new ShieldRetrieval();
        
//        //Test 1
//        String text = i.setText("Secure", "Not a trusted algorithm", "Secure", "Secure");
//        System.out.println(text);
//        
//        //Test 2
//        String text = i.setText("Secure", "Not a trusted algorithm", "Secure", "Secure");
//        System.out.println(text);

//        //Test 3
//        s.setURL("https://www.google.co.uk");
//        String text = s.getURL();
//        System.out.println(text);

//        //Test 4
//        s.setURL("https://www.google.co.uk");
//        if(s.print() == true)
//      {
//        String text = s.getSubject();
//        System.out.println(text);
//          }
//            else{
//            System.out.println("Certificate couldn't be retrieved");
//            }

//        //Test 4
//        s.setURL("https://www.google.co.uk");
//        if(s.print() == true)
//        {
//        System.out.println(s.getValidity());
//        }
//        else{
//            System.out.println("Certificate couldn't be retrieved");
//        }
//

//         //Test 5
//        s.setURL("https://www.google.co.uk");
//        if(s.print() == true)
//        {
//        System.out.println(s.getAlg());
//        }
//        else{
//            System.out.println("Certificate couldn't be retrieved");
//        }

//         //Test 6
//        s.setURL("https://www.google.co.uk");
//        if(s.print() == true)
//        {
//        System.out.println(s.print());
//        }
//        else{
//            System.out.println("Certificate couldn't be retrieved");
//        }
//

//        //Test 7
//        c.setURL("https://www.google.co.uk");
//        if(c.print() == true)
//        {
//           c.getCrl();
//            try {
//                System.out.println(c.crl());
//            } catch (CertificateException ex) {
//                Logger.getLogger(testing.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        else{
//            System.out.println("Certificate couldn't be retrieved");
//        }

//        //Test 8
//        String text = sr.setLeft("Secure");
//        System.out.println(text);

//        //Test 9
//        String text = sr.setLeft("Not secure");
//        System.out.println(text);

//        //Test 10
//        String text = sr.setRight("Secure");
//        System.out.println(text);

//        //Test 11
//        String text = sr.setRight("Not secure");
//        System.out.println(text);

//        //Test 12
//        String text = sr.setLeftTop("Secure");
//        System.out.println(text);

//        //Test 13
//        String text = sr.setLeftTop("Not secure");
//        System.out.println(text);

//        //Test 14
//        String text = sr.setRightTop("Secure");
//        System.out.println(text);

//        //Test 15
//        String text = sr.setRightTop("Not secure");
//        System.out.println(text);

//        //Test 16
//        c.setURL("https://www.google.co.uk");
//        c.print();
//        String text = c.setCrlText();
//        System.out.println(text);
    }
}
