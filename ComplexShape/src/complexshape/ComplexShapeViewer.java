/*
    Program Title:  JVMViewer
    Author:         D. Lambord
    Created:        05/09/13
    Version:        1.0
*/
package complexshape;

/**
 *
 * @author eeu689
 */
import javax.swing.JFrame;
public class ComplexShapeViewer
{
    public static void main(String[] args)
    {
        //Creation of a new JFrame
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 800;
        final int FRAME_HEIGHT = 700;
        
        // Set frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("JVM Diagram");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create and add component to frame
        ComplexShapeComponent component = new ComplexShapeComponent();
        frame.add(component);
        frame.setVisible(true);
    }
}
