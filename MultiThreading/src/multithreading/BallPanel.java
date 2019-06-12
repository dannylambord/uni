/*
    Program Title:  Ball Panel
    Author:         D. Lambord
    Created:        05/12/16
    Version:        1.0
*/

package multithreading;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallPanel extends JFrame implements Runnable {

    private BallPanel1 ballPanel;
    BallComponent component;
    
    JButton button7 ;
    JButton button8 ;
    JButton button9 ;
    JFrame frame ;
    JSlider slide;
    
    int x;
    int y;
    int i;
    
    private Thread t; //initialisation of new thread
    private boolean stop = false; //initialisation of stop boolean
   

    public BallPanel()
    {
        ballPanel = new BallPanel1();
        add(ballPanel, BorderLayout.CENTER);
        createKeyPanel(); 
    }
    
    public void createKeyPanel()
    {   
        button7 = new JButton("Start");
        button8 = new JButton("Pause");
        button9 = new JButton("Stop");
        slide = new JSlider(JSlider.HORIZONTAL);// creation of new slider
        
        slide.setMajorTickSpacing(25);
        slide.setPaintTicks(true);
        slide.setSize(200, 200);
        slide.setVisible(true);

        JPanel key1Panel = new JPanel();
        key1Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        key1Panel.add(button7);
        key1Panel.add(button8);
        key1Panel.add(button9);
        key1Panel.add(slide);
        
        ActionListener s1 = new Start();
        ActionListener p = new Pause();
        ActionListener s2 = new Stop();

        button7.addActionListener(s1);
        button8.addActionListener(p);
        button9.addActionListener(s2);
        
        add(key1Panel, BorderLayout.SOUTH);
    }

    public void run()
    {
        Graphics g = this.getGraphics();
        BallComponent comp = new BallComponent();
        comp.animBall(g);// Calling method in ball component
    }
           
    public void stop()
    {
        stop = true;
    }
           
    public void start()
    {
        if(stop != true){
            if (t == null){
                System.out.println("Starting");
                t = new Thread (this, "1"); //Creation of new thread
                t.start();//running the run method
                t = null;
            }
            else if(stop == true)
            {
                System.out.println("Stopped");
            }
        }
    }
    
    public void pause()
    {
        t.interrupt(); // pausing the thread
    }
     
    
    class Start implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
           start();
        }   
    }
    
    class Pause implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
           pause();
        }
    }
    
    class Stop implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            stop();
        } 
    }
    
    class Slide implements ChangeListener
    {
        @Override
        public void changed(ObservableValue ov, Object t, Object t1) 
        {
            
        }
    }
}


    
