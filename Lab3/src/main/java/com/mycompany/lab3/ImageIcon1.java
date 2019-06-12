/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab3;

/**
 *
 * @author danny
 */
public class ImageIcon1 {
    
    String location;
    
    public String setImage(String weather)
    {

        if(weather == "Thick Cloud")
        {
            location = "C:\\Users\\danny\\Documents\\NetBeansProjects\\Lab3\\src\\main\\resources\\thick_cloud.png";
        } 
        else if(weather == "Sunny")
        {
            location = "C:\\Users\\danny\\Documents\\NetBeansProjects\\Lab3\\src\\main\\resources\\sunny.png";
        }
        else if(weather == "Light Cloud")
        {
            location = "C:\\Users\\danny\\Documents\\NetBeansProjects\\Lab3\\src\\main\\resources\\light_showers.png";
        }
        
        return location;
    }
    
}
