import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLU;
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
/**
*
* @author cgray
*/
public class GLEventListener implements com.jogamp.opengl.GLEventListener {

    protected void setup(GL2 gl2, int width, int height) {
        gl2.glMatrixMode(GL2.GL_PROJECTION);
        gl2.glLoadIdentity();

        // coordinate system origin at lower left with width and height same as the window
        GLU glu = new GLU();
        glu.gluOrtho2D(0.0f, width, 0.0f, height);
        //glu.gluOrtho2D(-250.0f, 250.0f, -150.0f, 150.0f);
        

        gl2.glMatrixMode(GL2.GL_MODELVIEW);
        //gl2.glMatrixMode(GL2.GL_PROJECTION);
        gl2.glLoadIdentity();

        gl2.glViewport(0, 0, width, height);
        //gl2.glViewport(250, 150, -250, -150);
  
    }

    protected void render(GL2 gl2,int width, int height)
    {
        //Lab 2
        
        /*gl2.glTranslatef(20f, 20f,0f);
        l1task1(gl2);
        gl2.glTranslatef(300f, 0f,0f);
        l1task2(gl2);
        gl2.glTranslatef(-200f, 200f,0f);
        l1task3(gl2);*/
        
       //Lab 3
        
        /*gl2.glBegin(GL2.GL_POLYGON);
        //l2task1(gl2);
        //l2task2(gl2);
        //l2task3(gl2);
        gl2.glEnd();*/
        
        //Lab 4
        
        gl2.glPointSize(1.0f);
        gl2.glPushMatrix();
        drawArm(gl2,100, 100f, 30f, 0f);
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        drawArm(gl2,100, 105f, 40f, 0f);
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        drawArm(gl2,100, 110f, 50f, 0f);
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        drawArm(gl2,110, 115f, 60f, 0f);
        gl2.glPopMatrix();
        gl2.glTranslatef(600f,0f, 0f);
        gl2.glRotatef(180f,0f,1f,0f);
        gl2.glPushMatrix();
        drawArm(gl2,100, 100f, 30f, 0f);
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        drawArm(gl2,100, 130f, 40f, 0f);
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        drawArm(gl2,100, 110f, 50f, 0f);
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        drawArm(gl2,110, 115f, 60f, 0f);
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        gl2.glTranslatef(325f, 60f,0f);
        gl2.glRotatef(90f, 0f,0f,1f);
        drawTriangle(gl2,0,0,0,50,250,25,0,1,15);
        gl2.glPopMatrix();
        gl2.glPushMatrix();
        gl2.glTranslatef(270f, 300f,0f);
        draw(gl2, 0, 60, 1,0,0);
        gl2.glPopMatrix();
    }
    private void l1task1(GL2 gl2)
    {
        Square(gl2, 150,150,1,0,0);
    }
    private void l1task2(GL2 gl2)
    {
        Square(gl2, 150,150,1,0,0);
        gl2.glTranslatef(160f,0f,0f);
        Square(gl2, 150,150,0,1,0);
        gl2.glTranslatef(160f,0f,0f);
        Square(gl2, 150,150,0,0,1);
    }
    private void l1task3(GL2 gl2)
    {
        int x = 0;
        while( x < 10)
        {
            makeGrid(gl2, 1,0);
            x++;
        }
        
        gl2.glTranslatef(20f,0f,0f);
        x = 0;
        
        while( x < 10)
        {
            makeGrid(gl2, 0, 1);
            x++;
        }
        gl2.glEnd();
    }
    private void makeGrid(GL2 gl2, int r, int g)
    {
        int sf = 10;
        //create a 10x10 grid of squares
        for (int x = 1; x < 20; x+=4)
        {
            for (int y =1; y < 20; y+=2)
            {
                gl2.glBegin(GL2.GL_QUADS);
                gl2.glColor3f(r, g, 0);
                gl2.glVertex2f(sf*x, sf*y);
                gl2.glVertex2f(sf*x+10, sf*y);
                gl2.glVertex2f(sf*x+10, sf*y+10);
                gl2.glVertex2f(sf*x, sf*y+10);
                gl2.glEnd();
            }
        }
    }
    public void Square(GL2 gl2, int x, int y, int r, int g, int b)
    {
        gl2.glBegin(GL2.GL_QUADS);
        gl2.glColor3f(r, g, b);
        gl2.glVertex2f(0, 0);
        gl2.glVertex2f(0, y);
        gl2.glVertex2f(x, y);
        gl2.glVertex2f(x, 0);
        gl2.glEnd();
    }
    


    //Lab3

    public void rect(GL2 gl2, int xc1,int yc2, int width, int height)
    {
        gl2.glBegin(GL2.GL_POINTS);
        gl2.glVertex2f(xc1,yc2);
        gl2.glVertex2f(xc1,yc2+height);
        gl2.glVertex2f(xc1+width,yc2+height);
        gl2.glVertex2f(xc1+width,yc2); 
    }
    public void drawLine(GL2 gl2, int x1, int y1, int x2, int y2)
    {
        int my;
        int mx;
        int i;
        int y;
        
        my = (y2-y1);
        mx =(x2-x1);
        
        for(i=x1; i<=x2; i++)
        {
            y=y1+my*(i-x1)/mx;
            rect(gl2, i, y, 1, 1);
        }
    }
    public void drawCurveSin(GL2 gl2, int x1, int y1, int x2, int y2, int w, int h)
    {
        int i;
        int y;
        for(i=x1; i<=x2; i++)
        {
            rect(gl2, i, (int)(Math.sin(i/60.0)*100.0), w, h);
        }
    }
    public void drawCurveTan(GL2 gl2, int x1, int y1, int x2, int y2, int w, int h)
    {
        int i;
        for(i=x1; i<=x2; i++)
        {
            rect(gl2, i, (int)(Math.tan(i/60.0)*30.0), w, h);
        }
    }
    public void drawCurveCos(GL2 gl2, int x1, int y1, int x2, int y2, int w, int h)
    {
        int i;
        for(i=x1; i<=x2; i++)
        {
            rect(gl2, i, (int)(Math.cos(i/60.0)*100.0), w, h); 
        }
    }
    
    public void l2task1(GL2 gl2)
    {
        drawLine(gl2, 0,0,100,100);
    }
    public void l2task2 (GL2 gl2)
    {
        gl2.glColor3f(1,1,1); drawLine(gl2, 0,0,100,100);
        gl2.glColor3f(1,0,0); drawLine(gl2, 0,0,200,100);
        gl2.glColor3f(0,1,0); drawLine(gl2, 0,0,200,0);
        gl2.glColor3f(0,0,1); drawLine(gl2, 0,0,2,100);
        gl2.glColor3f(0,1,1); drawLine(gl2, 0,0,200,4);
        gl2.glColor3f(1,1,0); drawLine(gl2, -100,-100,100,100);
        gl2.glColor3f(1,1,0); drawLine(gl2, 0,0,-130,-130);
    }
    public void l2task3 (GL2 gl2)
    {
        gl2.glPushMatrix();
        gl2.glColor3f(1,0,0); drawCurveSin(gl2, -200,0,200,100,1,1);
        gl2.glColor3f(0,0,1); drawCurveTan(gl2, -200,0,200,100,1,1);
        gl2.glColor3f(0,1,0); drawCurveCos(gl2, -200,0,200,100,1,1);
        gl2.glPopMatrix();
    }

    //Lab4

    private void draw(GL2 gl2, int x, int y, int r, int g, int b)
    {
        gl2.glBegin(GL2.GL_POLYGON);
        gl2.glColor3f(r, g, b);
        gl2.glVertex2f(0, 0);
        gl2.glVertex2f(x, y);
        gl2.glVertex2f(y, y);
        gl2.glVertex2f(y, x);
        gl2.glEnd();
    }
    
    private void drawTriangle(GL2 gl2, int x1, int y1, int x2, int y2, int x3, int y3, int r, int g, int b)
    {
        // draw a triangle based on values inputted
        gl2.glBegin(GL2.GL_TRIANGLES);
        gl2.glColor3f(r, g, b);
        gl2.glVertex2f(x1, y1);
        gl2.glVertex2f(x2, y2);
        gl2.glVertex2f(x3, y3);
        gl2.glEnd();
    }
    
    private void drawArm(GL2 gl2, int offset, float angle0, float angle1, float angle2)
    {
        drawTriangle(gl2,0,0,0,0,0,0,0,0,0);//Setting origin to 0,0 and drawing a non exitent triangle
        gl2.glTranslatef(300f,50f,0f);
        gl2.glRotatef(angle0,0f,0f,1f);
        drawTriangle(gl2,0,0,0,20,offset,10,177,179,0);
        gl2.glTranslatef(100f,0f,0f);
        gl2.glRotatef(angle1, 0f, 0f, 1f);
        drawTriangle(gl2,0,0,0,20,offset,10,177,179,0);
        gl2.glTranslatef(100f,0f,0f);
        gl2.glRotatef(angle2, 0f, 0f, 1f);
        drawTriangle(gl2,0,0,0,20,offset,10,177,179,0);
        gl2.glTranslatef(100f,5f,0f);
        draw(gl2, 0, 10, 1, 0, 0);
    }

  @Override
    public void reshape(GLAutoDrawable glautodrawable, int x, int y, int width, int height) {
        setup(glautodrawable.getGL().getGL2(), width, height);
    }
    @Override
    public void init(GLAutoDrawable glautodrawable) {
    }
    @Override
    public void dispose(GLAutoDrawable glautodrawable) {
    }
    @Override
    public void display(GLAutoDrawable glautodrawable) {
        render(glautodrawable.getGL().getGL2(), glautodrawable.getSurfaceWidth(), glautodrawable.getSurfaceHeight());
    }

}