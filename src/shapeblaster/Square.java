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
import java.awt.event.MouseEvent;
import java.util.Random;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;

public class Square extends Shape implements Runnable
{

    private int x = 0 , y = 0 , w = 20 , h = 20;
    private int ax = 2, ay = 0;
    
    private int speed;
    private int maxX = 800 , maxY = 550;
    private Thread t;
    public static Random ran = new Random();
    private String dir;
    private Color color = Color.red;
    
    Square()
    {
        int ranx = ran.nextInt(maxX);
        int rany = ran.nextInt(maxY);
        speed = ran.nextInt(3)+2;
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
        int i = 0;
        int j = 0;// used for hitcount
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
                //rec = new Rectangle(x,y,w,h);
                }
                else
                {
                    i++;

                    if(i == 80)
                    {
                        int ir = ran.nextInt(4);
                        speed = 5;
                        switch(ir)
                        {
                            case 0:
                                setDirection("down");
                                updateDirection();
                                break;
                            case 1:
                                setDirection("left");
                                updateDirection();
                                break;
                            case 2:
                                setDirection("up");
                                updateDirection();
                                break;
                            case 3:
                                setDirection("right");
                                updateDirection();
                                break;
                        }
                        //delete = true;
                        
                    }
                    if(i > 80)
                    {
                        x += ax;
                        y += ay;
                        Boolean hit = ShapeBlaster.checkReact(rec);
                        if(hit)
                            j++;
                        if(j >= 2)
                        {
                            delete = true;
                        }
                        
                        rec.setBounds(x, y, w, h);
                        
                        if(x >= maxX-w)
                        {
                            this.delete = true;
                        }
                
                        if(x <= 0)
                        {
                            this.delete = true;
                        }
                
                        if(y <= 0)
                        {
                            this.delete = true;
                        }
                
                        if(y >= maxY-50)
                        {
                            this.delete = true;
                        }
                    
                    }
                }
                
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
        if(!explode)
        {
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
            g.setColor(Color.red);
            g.fillRect(x, y, w, h);
        }
        else
        {
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
            g.setColor(Color.white);
            g.fillRect(x, y, w, h);
        }
        
        //Set the glow outline
        g.setColor(Color.white);
        g.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
        g.drawRect(x-1, y-1, w+2, h+2);
    }


    public void react()
    {
        this.explode = true;
    }
    
}
