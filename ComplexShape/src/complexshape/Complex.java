
package complexshape;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
public class Complex
{
// Declare instance variables

// Constructor
public Complex()
{
}
// Draw method for shape
public void draw(Graphics2D g)
{
            Graphics2D g2;  //Creation of a new 2d element
    g2 = (Graphics2D) g;
            
            g2.draw(new Ellipse2D.Double(x, y,
                             rectwidth,
                             rectheight));

}
}