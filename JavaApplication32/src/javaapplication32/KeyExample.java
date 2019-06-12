/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication32;

/**
 *
 * @author danny
 */


/* ICP3036 - Lab 6
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;
import com.sun.opengl.util.*;

public class KeyExample extends JFrame {

  static Animator loop = null;
  
  public static void main(String[] args) {
    final KeyExample app = new KeyExample();
    
    // show what we've done
    SwingUtilities.invokeLater ( new Runnable() {
	public void run() {
	  app.setVisible(true);
	}
      }
    );

    // start the animator
    SwingUtilities.invokeLater ( new Runnable() {
	public void run() {
	  loop.start();
	}
      }
    );
  }
    
  public KeyExample() {
    // set the JFrame title - this must be the first command in the constructor
    super("Keyboard Events Example");
    
    // kill the process when the JFrame is closed
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addWindowListener(new shutDownWindow());


    // we'll create our GLEventListener
    KeyGLEventListener my_demo = new KeyGLEventListener();
    // Now we will create our GLCanvasOpenGL Drawable
    GLCanvas my_drawable = new GLCanvas(); 
    my_drawable.addGLEventListener(my_demo);

    // create the animator:
    loop = new Animator(my_drawable);

    // Now add the Drawable 
    getContentPane().add(my_drawable, BorderLayout.CENTER);
    setSize(500, 500);
    
    //centre the JFrame on the screen
    centreWindow(this);

  }
  
  public void centreWindow(Component frame) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize  = frame.getSize();
    
    if (frameSize.width  > screenSize.width ) frameSize.width  = screenSize.width;
    if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;
    
    frame.setLocation ((screenSize.width  - frameSize.width ) >> 1, 
		       (screenSize.height - frameSize.height) >> 1
		       );
  }

  public class shutDownWindow extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
      loop.stop();
    }
  }

}


