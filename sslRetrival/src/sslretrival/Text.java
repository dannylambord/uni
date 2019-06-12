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
public class Text {
    

    String text;

    public String setText(String crl, String date, String alg, String url)
    {

        
        if(crl == "Secure" && date == "Secure" && alg == "Secure" && url == "Secure")
        {
            text = "This site is considered secure, for more information please press advanced information";
        } 
        else
        {
            text = "This site is not considered secure, for more information please press advanced information";

        }
        
        
        return text;
    }
    
}
