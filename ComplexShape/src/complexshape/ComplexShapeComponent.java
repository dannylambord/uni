package complexshape;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;


public class ComplexShapeComponent extends JComponent
{
// Override superclass method
public void paintComponent(Graphics g)
{
// Recover Graphics2D context using upcast
Graphics2D g2 = (Graphics2D) g;

// Create instance of ComplexShape
Complex complexShape
= new Complex();

// Draw shape
complexShape.draw(g2);
}
}