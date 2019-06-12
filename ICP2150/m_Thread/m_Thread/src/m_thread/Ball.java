/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eeu6d1
 */
package m_thread;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.lang.Math;
import java.util.Random;

public class Ball {
    public Ball(Graphics2D g2, int x, int y)
    {
        /*
        Color CGreen = new Color (181, 225, 53);
        Color CBrown = new Color (157, 121, 91);
        Color CPurple = new Color (172, 36, 88);
        Color CBlue = new Color (192, 212, 219);
        Color CDBlue = new Color (98, 114, 117);
        
        String colorArray[];
        colorArray = new String[5];
        colorArray[0] = "CGreen" ;
        colorArray[1] = "CBrown";
        colorArray[2] = "CPurple";
        colorArray[3] = "CBlue";
        colorArray[4] = "CDBlue";
        
        
        int rnd = new Random().nextInt(colorArray.length);
        */
        g2.setColor(Color.BLACK);
        g2.fillOval(x, y, 10,10);
    }
}

// http://stackoverflow.com/questions/20459029/draw-shapes-with-random-colors
        
        
        