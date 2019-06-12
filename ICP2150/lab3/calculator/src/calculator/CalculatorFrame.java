/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author eeu689
 */
public class CalculatorFrame extends JFrame{
    
    
    JPanel keyPanel = new JPanel();
    JButton button7 ;
        JButton button8 ;
        JButton button9 ;
        JButton button10 ;
        JButton button4 ;
        JButton button5 ;
        JButton button6 ;
        JButton button11;
        JButton button1 ;
        JButton button2;
        JButton button3 ;
        JButton button12 ;
        JButton button0 ;
        JButton button13 ;
        JButton button14 ;
        JButton button15;
        JMenuBar menuBar;
   
   


    public CalculatorFrame()
    {
        
        
        
        
        JPanel keypadPanel = new JPanel();
        keypadPanel.setLayout(new BorderLayout());
        JPanel key1Panel = new JPanel();
        key1Panel.setLayout(new GridLayout(2,2));
        key1Panel = new JPanel();
        key1Panel.add(button7);
        key1Panel.add(button8);
        key1Panel.add(button9);
        key1Panel.add(button10);
        key1Panel.add(button4);
        key1Panel.add(button5);
        key1Panel.add(button6);
        key1Panel.add(button11);
        key1Panel.add(button3);
        key1Panel.add(button2);
        key1Panel.add(button1);
        key1Panel.add(button12);
        key1Panel.add(button0);
        key1Panel.add(button13);
        key1Panel.add(button14);
        key1Panel.add(button15);
        keypadPanel.add(key1Panel, BorderLayout.PAGE_END);
        JTextField display = new JTextField();
        keypadPanel.add(display, BorderLayout.CENTER);

        
        
        
        
        
    }
    
    public void createKeyPanel()
    {   
        
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
       button10 = new JButton("/");
         button4 = new JButton("4");
         button5 = new JButton("5");
         button6 = new JButton("6");
         button11 = new JButton("*");
         button1 = new JButton("1");
         button2 = new JButton("2");
         button3 = new JButton("3");
        button12 = new JButton("-");
         button0 = new JButton("0");
         button13 = new JButton(".");
         button14 = new JButton("=");
         button15 = new JButton("+");
        
        
        
        
        
        
    }

    
}