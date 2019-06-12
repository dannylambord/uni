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
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ControlComponent extends JPanel{
    public ControlComponent(){
        
        JButton start = new JButton("Start");
        add(start);
        JButton pause = new JButton("Pause");
        add(pause);
        JButton stop = new JButton("Stop");
        add(stop);
        
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        add(slider);
    }
}
