package ballthreads;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BallThreads extends JFrame
{
    private ColoredBallPanel coloredBallPanel;
    private final int FRAME_WIDTH = 600;
    private final int FRAME_HEIGHT = 500;

        public void BallsFrame()
        {
            setSize(FRAME_WIDTH, FRAME_HEIGHT);
            

            coloredBallPanel = new ColoredBallPanel();
            add(coloredBallPanel, BorderLayout.CENTER);
            addBall(?,?); // add two balls to panel
            addBall(?,?);

        }
        // addBall to panel at specified coordinates (x,y)
        public void addBall(int x, int y)
        {
            // create coloured ball and add to panel
            
            ColoredBall ball = new ColoredBall();
            ball.ColoredBall(x,y);
            coloredBallPanel.add(ball);

            // create a runnable to control ball
            
            ColoredBallRunnable r = new ColoredBallRunnable();
            r.ColoredBallRunnable(1, 1);
            Thread t = new Thread(r);
            t.start();
        }
}
