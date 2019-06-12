/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eeu6d1
 */

package m_thread;
import javax.swing.JFrame;

public class EmptyFrameViewer {
    public static void main(String[] args){
        EmptyBallFrame frame = new EmptyBallFrame();
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
