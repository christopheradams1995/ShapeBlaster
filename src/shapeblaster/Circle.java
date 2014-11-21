
package shapeblaster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Circle extends Shape implements Runnable
{

    private int x = 0 , y = 0 , w = 25 , h = 25;
    private int ax = 2, ay = 0;
    private int maxX = 800 , maxY = 600;
    private Thread t;
    private int speed;
    public static Random ran = new Random();
    private String dir;
    
    Circle()
    {
        int ranx = ran.nextInt(maxX);
        int rany = ran.nextInt(maxY);
        speed = ran.nextInt(3)+2;
        x = ranx;
        y = rany;
        
        dir = returnDirection();
        updateDirection();
        
        t = new Thread(this);
        t.start();
    }
    


    public void setSize() {
        
    }
    
    public static String returnDirection() 
    {
        int i = ran.nextInt(4);
        String dir = "";
        switch(i)
        {
            case 1: 
                dir = "up";
                break;
            case 2: 
                dir = "down";
                break;
            case 3: 
                dir = "left";
                break;
            case 4: 
                dir = "right";
                break;
        }
        return dir;
    }

    public void updateDirection() 
    {
        if(dir.equals("up"))
        {
            ay = -speed;
            ax = 0;
        }
        else if(dir.equals("down"))
        {
            ay = speed;
            ax = 0;
        }
        else if(dir.equals("right"))
        {
            ax = speed;
            ay = 0;
        }
        else if(dir.equals("left"))
        {
            ax = -speed;
            ay = 0;
        }
    }
    
    public void setDirection(String dir) 
    {
        this.dir = dir;
    }
    
    public void setLocation(int x, int y) 
    {
        
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                x += ax;
                y += ay;
                if(x >= maxX-w)
                {
                    setDirection("left");
                    updateDirection();
                }
                
                if(x <= 0)
                {
                    setDirection("right");
                    updateDirection();
                }
                
                if(y <= 0)
                {
                    setDirection("down");
                    updateDirection();
                }
                
                if(y >= maxY-50)
                {
                    setDirection("up");
                    updateDirection();
                }
                rec = new Rectangle(x,y,w,h);
                Thread.sleep(14);
            }
            catch(InterruptedException e)
            {
             
            }
            catch(Exception er)
            {
             
            }
        }
    }
    
    public void draw(Graphics2D g)
    {
        g.setColor(Color.blue);
        g.fillOval(x, y, w, h);
    }
    
}
