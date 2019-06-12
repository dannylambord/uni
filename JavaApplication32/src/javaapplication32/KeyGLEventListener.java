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
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import java.awt.font.*;
import java.text.*;
import java.awt.geom.*;
import java.lang.Math;

import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import com.sun.opengl.util.*;
import com.sun.opengl.util.texture.*;
import com.sun.opengl.util.j2d.*;

public class KeyGLEventListener
  implements GLEventListener, 
	     KeyListener,                     // For keyboard
	     MouseListener,               // For Mouse Buttons
	     MouseMotionListener   // For Mouse Motion
{
  GL gl;
  GLAutoDrawable my_canvas;
  int xPosition = 25;
  int yPosition = 25;
  
  float red = 0.0f;
  float green = 0.0f;
  float blue = 1.0f;
  

  /**
   * Take care of initialization here.
   */
  public void init(GLAutoDrawable gld) {

    GLU glu = new GLU();
    gl = gld.getGL();    

    gld.addKeyListener(this);                    // connect keyboard
    gld.addMouseListener(this);              // connect mouse
    gld.addMouseMotionListener(this); // connect mouse

    my_canvas = (GLAutoDrawable) gld; // save Drawable

    red = 0.0f;
    green = 0.0f;
    blue = 1.0f;
    
    gl.glClearColor(red, green, blue, 0.0f);
    
    gl.glViewport(0, 0, 50, 50);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    glu.gluOrtho2D(0.0, 50.0, 0.0, 50.0);
  }

  
  /*
   * Take care of drawing here.
   */
  public void display(GLAutoDrawable drawable) {
    
    gl = drawable.getGL();

     gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    
    // Remember point size refers to pixels, not the coordinate
    // system we've set up in the GLCanvas
    gl.glPointSize(6.0f);
    
    red = 0.0f;
    green = 1.0f;
    blue = 0.0f;
    
    gl.glColor3f(red, green, blue);
    
    gl.glBegin(GL.GL_POINTS);
      gl.glVertex2i(xPosition, yPosition);
    gl.glEnd();
    gl.glFlush();
  }
  
 
  public void reshape(GLAutoDrawable gLDrawable, int x, int y, int w, int h)
  {
  }
    

  public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}
  

  /** Invoked when a key has been typed.
   * See the class description for KeyEvent for a definition of
   * a key typed event.
   * @param k The KeyEvent.
   */
  public void keyTyped(KeyEvent k) {
  }

  /** Invoked when a key has been released.
   * @param e The KeyEvent.
   */
  public void keyReleased(KeyEvent k) {}

  /** Invoked when a key has been pressed.
   */
  public void keyPressed(KeyEvent k) {  
    if (k.getKeyCode() == KeyEvent.VK_8) {
      yPosition += 1;
      my_canvas.display();
    }
  }

  public void mouseEntered(MouseEvent m) {}
  public void mouseExited(MouseEvent m) {}
  public void mouseClicked(MouseEvent m) {}
  public void mousePressed(MouseEvent e) { }
  public void mouseReleased(MouseEvent m) { }

  public void mouseMoved(MouseEvent e) {}
  public void mouseDragged(MouseEvent e) { }
  
 } // End of GLEventListener
