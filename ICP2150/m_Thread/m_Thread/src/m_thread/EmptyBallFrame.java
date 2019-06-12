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
import java.awt.BorderLayout;
import javax.swing.*;

public class EmptyBallFrame extends JFrame
{
    private ControlComponent cComp;
    private BallComponent bComp;
    
    public EmptyBallFrame(){
        super();
        
        cComp = new ControlComponent();
        bComp = new BallComponent();
        
        add(cComp, BorderLayout.SOUTH);
        add(bComp,BorderLayout.CENTER);
    }
}