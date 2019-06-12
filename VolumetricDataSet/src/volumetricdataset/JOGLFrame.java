
package volumetricdataset;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cgray
 */
public class JOGLFrame extends JFrame {

    public JOGLFrame() throws HeadlessException {
        GLProfile glprofile = GLProfile.getDefault();
        GLCapabilities glcapabilities = new GLCapabilities( glprofile );
        final GLCanvas glcanvas = new GLCanvas( glcapabilities );
        glcanvas.setPreferredSize(new Dimension(1900,700));
        glcanvas.addGLEventListener(new GLEventListener());
        getContentPane().add(glcanvas);
        pack();
    }   
    
    public static void main(String[] args) {
        JOGLFrame instance = new JOGLFrame();
        instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instance.setVisible(true);
        

    }
}



