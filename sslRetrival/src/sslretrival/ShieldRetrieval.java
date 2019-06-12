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
public class ShieldRetrieval {
    
    
    public String setRight(String secure)
    {
        if(secure == "Secure")
        {
        return "/sslretrival/images/right_bottom.png";
        }else{
         return "/sslretrival/images/right_bottom_red.png";
        }
    }
    
    public String setLeft(String secure)
    {
        if(secure == "Secure")
        {
        return "/sslretrival/images/left_bottom.png";
        }else{
         return "/sslretrival/images/left_bottom_red.png";
        }
    }
    
    public String setLeftTop(String secure)
    {
        if(secure == "Secure")
        {
        return "/sslretrival/images/left_top.png";
        }else{
         return "/sslretrival/images/left_top_red.png";
        }
    }
    
    public String setRightTop(String secure)
    {
        if(secure == "Secure")
        {
        return"/sslretrival/images/crest.png";
        }else{
         return "/sslretrival/images/right_top_red.png";
        }
    }
    
}
