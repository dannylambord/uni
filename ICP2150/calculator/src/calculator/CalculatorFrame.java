/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    private JPanel key1Panel;
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
        double x = 0;
        String s = "";
        JTextField display;
        String[] a;
        Calculator calc = new Calculator();
        JMenuBar menuBar;
        JFrame frame ;
   
   


    public CalculatorFrame()
    {
        
        
        
        frame = new JFrame();
        createKeyPanel();
        
        
        
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
        
        ActionListener listener = new InsertAction();
        ActionListener listener1 = new CommandAction();
        
        
        
        key1Panel = new JPanel();
        key1Panel.setLayout(new GridLayout(4, 4));
        key1Panel.add(button7);
        key1Panel.add(button8);
        key1Panel.add(button9);
        key1Panel.add(button10);
        key1Panel.add(button4);
        key1Panel.add(button5);
        key1Panel.add(button6);
        key1Panel.add(button11);
        key1Panel.add(button1);
        key1Panel.add(button2);
        key1Panel.add(button3);
        key1Panel.add(button12);
        key1Panel.add(button0);
        key1Panel.add(button13);
        key1Panel.add(button14);
        key1Panel.add(button15);
        
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
        button5.addActionListener(listener);
        button6.addActionListener(listener);
        button7.addActionListener(listener);
        button8.addActionListener(listener);
        button9.addActionListener(listener);
        button10.addActionListener(listener1);
        button11.addActionListener(listener1);
        button12.addActionListener(listener1);
        button13.addActionListener(listener1);
        button14.addActionListener(listener1);
        button15.addActionListener(listener1);
        button0.addActionListener(listener);
        
        menuBar = new JMenuBar();
        JMenu menuEdit = new JMenu("Edit");
        JMenu menuView = new JMenu("View");
        JMenu menuHelp = new JMenu("Help");
        JMenuItem menuEditCopy = new JMenuItem("Copy");
        JMenuItem menuEditPaste = new JMenuItem("Paste");
        JMenuItem menuViewStand = new JMenuItem("Standard");
        JMenuItem menuViewSci = new JMenuItem("Scientific");
        JMenuItem menuViewDig = new JMenuItem("Digital Grouping");
        JMenuItem menuHelpTop = new JMenuItem("Help Topics");
        JMenuItem menuHelpAbout = new JMenuItem("About Calculator");



        // put the menu parts with eachother
        menuBar.add(menuEdit);
        menuBar.add(menuView);
        menuBar.add(menuHelp);
        menuEdit.add(menuEditCopy);
        menuEdit.add(menuEditPaste);
        menuView.add(menuViewStand);
        menuView.add(menuViewSci);
        menuView.add(menuViewDig);
        menuHelp.add(menuHelpTop);
        menuHelp.add(menuHelpAbout);

    
        
        
        add(key1Panel, BorderLayout.SOUTH);
        add(menuBar, BorderLayout.PAGE_START);
        display = new JTextField();
        display.setText("0");
        add(display, BorderLayout.CENTER);
           
        

        
        
        
        
        

    }

    
    


/**
 * This action inserts the button action string to the end of the display
 * text.
 */
public class InsertAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        String input = event.getActionCommand();
        if (calc.start) {
            display.setText("");
            calc.start = false;
        }
        display.setText(display.getText() + input);
    }
}

/**
 * This action executes the command that the button action string denotes.
 */
public class CommandAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (calc.start) {
            if (command.equals("-")) {
                display.setText(command);
                calc.start = false;
            } else 
                calc.lastOperator = command;


        } else {
            calc.calculate(Double.parseDouble(display.getText()));
            calc.lastOperator = command;
            calc.start = true;
        }
    }
}


}
