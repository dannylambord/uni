/*
    Program Title:  JVMDiagram
    Author:         D. Lambord
    Created:        05/09/13
    Version:        1.0
*/
package assign1;

    import java.awt.*;

    import java.awt.geom.Rectangle2D;

    public class JVMDiagram
    {
        // Declare instance variables

        // Constructor
        public JVMDiagram()
        {

        }
        
        

        // Draw method for Rectangle with text centred 
        public void drawRect(Graphics2D g, int x, int y, int width,int height, String text, String secondLine, String thirdLine, int f)
        {
            Color color = new Color(221, 228, 241); //Assigning the RGB values, creating a new color

            int x1 = x + (width/8);//Setting of the x value for the text to be positioned in
            int y1 = y + (height/4);//Setting of the y value for the first line of text to be positioned in
            int y2 = y + (height/2);//Setting of the y value for the second line of text to be positioned in
            int y3 = y + (height / 4) * 3;//Setting of the y value for the third line of text to be positioned in


            Graphics2D g2 = (Graphics2D) g;  //Creation of a new 2d element
            g2.setColor(color);
            g2.fillRect(x, y, width ,height);
            g2.setColor(Color.black);
            g2.setFont(new Font("Calibri", Font.BOLD, f));
            g2.drawString(text , x1 , y1);
            g2.drawString(secondLine , x1 , y2);
            g2.drawString(thirdLine , x1 , y3);

        }

        //Draw method for up arrow
        public void upArrow(Graphics2D g, int x, int y, int height)
        {
            //Setting of the co-ordinate for the arrow head
            int x1 = x - 5;
            int x2 = x + 5;
            int x3 = x + 15;

            int y1 = y;
            int y2 = y - 10;
            int y3 = y;

            Color color = new Color (45, 71, 81); 

            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.RED);
            g2.fillRect(x, y,10,height);
            g2.fillPolygon(new int[] {x1,x2,x3}, new int[] {y1, y2, y3}, 3);//Creation of arrowhead as triangle
        }

        //Draw method for left arrow
        public void leftArrow(Graphics2D g, int x, int y, int length)
        {
            int x1 = x + length;
            int x2 = x + length;
            int x3 = (x  + length) + 10;//Position the point of the triangle

            int y1 = y + 15;
            int y2 = y - 5;
            int y3 = y + 5;

            Color color = new Color (45, 71, 81);

            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(color);
            g2.fillRect(x, y ,length,10);
            g2.fillPolygon(new int[] {x1,x2,x3}, new int[] {y1, y2, y3}, 3);
        }

        //Draw method for right arrow
        public void rightArrow(Graphics2D g, int x, int y)
        {
            int x1 = x ;
            int x2 = x ;
            int x3 = x  - 10;

            int y1 = y + 15;
            int y2 = y - 5;
            int y3 = y + 5;

            Color color = new Color (45, 71, 81);

            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(color);
            g2.fillRect(x, y ,50,10);
            g2.fillPolygon(new int[] {x1,x2,x3}, new int[] {y1, y2, y3}, 3);
        }

        //Draw method for down arrow
        public void downArrow(Graphics2D g, int x, int y, int height)
        {
            int x1 = x - 5;
            int x2 = x + 5;
            int x3 = x + 15;

            int y1 = y + height; //Length
            int y2 = (y + height) + 10; //Length + 10 for arrow head
            int y3 = y + height;

            Color color = new Color (45, 71, 81);

            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(color);
            g2.fillRect(x, y, 10,height);
            g2.fillPolygon(new int[] {x1,x2,x3}, new int[] {y1, y2, y3}, 3);
        }

        //Draw method for dashed rectangle    
        public void dash(Graphics2D g, double x, double y, double rectWidth, double rectHeight)
        {

        float dash1[] = {3.0f};//dash size


        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke( new BasicStroke(2.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, dash1, 0.0f));//Setting up properties
        g2.draw(new Rectangle2D.Double(x, y,rectWidth,rectHeight));//Drawing at co-ords with height and width paramaters
        }

        //Draw method for string
        public void drawString(Graphics2D g, int x1, int y1, String text, int fontSize)

        {
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(new Font("Calibri", Font.BOLD, fontSize));
            g2.drawString(text , x1 , y1);
        }
    }

