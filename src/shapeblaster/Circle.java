/**
* This is a reaction based game. When you click a shape the shape reactions which
* affect shapes around it. The point of the game is to react every shape and you
* gain points the better you do.
*
* @author  Christopher Adams
* @version 1.0
* @since   2014-11-23
*/
package shapeblaster;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Circle extends Shape implements Runnable
{

    private int x = 0 , y = 0 , w = 20 , h = 20;

    private int ax = 2, ay = 0;
    private int maxX = 800 , maxY = 500;
    private Thread t;
    private int xspeed, yspeed;
    public static Random ran = new Random();
    private String dir;
    
    Circle()
    {
        int ranx = ran.nextInt(maxX);
        int rany = ran.nextInt(maxY);
        xspeed = ran.nextInt(3)+2;
        yspeed = ran.nextInt(3)+2;
        x = ranx;
        y = rany;
        rec = new Rectangle(x,y,w,h);
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

    //This method 
    public void updateDirection() 
    {
        if(dir.equals("up"))
        {
            ay = -yspeed;
        }
        else if(dir.equals("down"))
        {
            ay = yspeed;
        }
        else if(dir.equals("right"))
        {
            ax = xspeed;
        }
        else if(dir.equals("left"))
        {
            ax = -xspeed;
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
        int i = 0;
        while(!delete)
        {
            try
            {
                if(!explode)
                {
                    x += ax;
                    y += ay;
                    rec.setBounds(x, y, w, h);
                
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
                }
                else
                {
                    i++;
                    System.out.println(i);
                    if(i == 50)
                    {
                        w = +90;
                        h = +90;
                        x -= 30;
                        y -= 30;
                        rec.setBounds(x, y, w, h);
                        ShapeBlaster.checkReact(rec);
                        
                    }
                    if(i > 50)
                    {
                        w -=2;
                        h -=2;
                        rec.setBounds(x, y, w, h);
                        ShapeBlaster.checkReact(rec);

                    }
                    if((i % 3) == 0 && i > 50)
                    {
                        x += 3;
                        y += 3;
                    }
                    if(i == 80)
                    {
                        delete = true;
                        
                    }
                }
                
                Thread.sleep(20);
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
        if(!explode)
        {
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
            g.setColor(Color.blue);
            g.fillOval(x, y, w, h);
        }
        
        //Set the glow outline
        g.setColor(Color.white);
        g.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
        g.drawOval(x-2, y-2, w+2, h+2);
    }
    
    public void react()
    {
        this.explode = true;
    }
    
}
