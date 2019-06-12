/*
    Program Title:  JVMComponent
    Author:         D. Lambord
    Created:        05/09/13
    Version:        1.0
*/

package assign1;


import java.awt.*;
import javax.swing.*;

public class JVMComponent extends JComponent
{
    // Override superclass method
    @Override
    public void paintComponent(Graphics g)
    {
        // Recover Graphics2D context using upcast 
        Graphics2D g2 = (Graphics2D) g;

        // Create instance of JVMDiagram
        JVMDiagram component = new JVMDiagram();
        
        // Draw shape using methods
        component.drawRect(g2, 300, 50, 140 ,80, "Class loader", "","sub system" ,  18);
        component.leftArrow(g2, 190, 90,100 );
        component.upArrow(g2, 350, 140, 30);
        component.downArrow(g2, 380, 130, 30);
        component.dash(g2, 110.0, 170.0, 510.0, 150.0);
        component.drawRect(g2, 120, 190, 90 ,90, "Method", "   area","" , 18);
        component.drawRect(g2, 220, 190, 90 ,90, "", "  Heap" ,"" , 20);
        component.drawRect(g2, 320, 190, 90 ,90, "  Java", " stacks","" , 18);
        component.drawRect(g2, 420, 190, 90 ,90, "      PC", " Registers","" ,14);
        component.drawRect(g2, 520, 190, 90 ,90, "Native", "method", "stacks", 12);
        component.upArrow(g2, 420, 330, 20);
        component.downArrow(g2, 420, 330, 20);
        component.upArrow(g2, 170, 330, 30);
        component.downArrow(g2, 200, 320, 30);  
        component.drawRect(g2, 150, 360, 140 ,80, "Execution", "", "   Engine", 18);
        component.drawRect(g2, 400, 360, 90 ,90, "   Native", "  method", " interface", 14);
        component.leftArrow(g2, 340, 405, 50);
        component.rightArrow(g2, 300, 405);
        component.rightArrow(g2, 500, 405);
        component.drawRect(g2, 520, 360, 90 ,90, "Native", "method", "stacks", 12);
        component.drawString(g2, 300, 310, "Runtime data areas", 16);
        component.drawString(g2, 200, 80, "Class files", 16);
        
        
     
        
        
    }
}
