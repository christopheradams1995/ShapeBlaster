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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import static shapeblaster.ShapeBlaster.point;

public class LevelSelection extends JComponent implements MouseListener, MouseMotionListener
{
    // used for the button events including the movement of the arrow
    private static Rectangle recMenu= new Rectangle(17,528,187,54)
            ,recShop = new Rectangle(588,531,188,54),
            recL1 = new Rectangle(41,81,143,119),
            recL2 = new Rectangle(238,81,143,119),
            recL3 = new Rectangle(429,80,143,119),
            recL4 = new Rectangle(615,80,143,119),
            recL5 = new Rectangle(39,235,143,119),
            recL6 = new Rectangle(239,235,143,119),
            recL7 = new Rectangle(430,235,143,119),
            recL8 = new Rectangle(615,235,143,119),
            recL9 = new Rectangle(40,383,143,119),
            recL10 = new Rectangle(239,383,143,119),
            recL11 = new Rectangle(430,384,143,119),
            recL12 = new Rectangle(616,383,143,119);
    
    private Point p;
    
    BufferedImage back;
    
    LevelSelection()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        //Load Images
        back = getImage("images/levelSelection.png");
    }
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        try
        {
            
            //Draw Images
            g2d.drawImage(back, 0, 0, null);

            this.repaint();
            this.revalidate();
            
        }catch(Exception er){System.out.println("ERROR");}
    }
    
    /**
     * Accepts the location of an image then returns the bufferedImage version
     * of it.
     * @param url : the location of the file
     * @return BufferedImage of the file from the location
     */
    public BufferedImage getImage(String s)
    {
        try
        {
            //uses the classLoader to get the path where the classes are
            URL url = MainMenu.class.getResource(s);
            
            BufferedImage in = ImageIO.read(url);
            return in;
        }
        catch(Exception er)
        {
            er.printStackTrace();
            return null;
        }
        
    }
    

    public void mouseClicked(MouseEvent e) 
    {
        Point p = e.getPoint();
        if(recMenu.contains(p))
        {
            ShapeBlaster.setDisplay("mainMenu");
        }
        else if(recL1.contains(p))
        {
            ShapeBlaster.setDisplay("game1");
        }
        else if(recL2.contains(p))
        {
            ShapeBlaster.setDisplay("game2");
        }
        else if(recL3.contains(p))
        {
            ShapeBlaster.setDisplay("game3");
        }
        else if(recL4.contains(p))
        {
            ShapeBlaster.setDisplay("game4");
        }
        else if(recL5.contains(p))
        {
            ShapeBlaster.setDisplay("game5");
        }
        else if(recL6.contains(p))
        {
            ShapeBlaster.setDisplay("game6");
        }
        else if(recL7.contains(p))
        {
            ShapeBlaster.setDisplay("game7");
        }
        else if(recL8.contains(p))
        {
            ShapeBlaster.setDisplay("game8");
        }
        else if(recL9.contains(p))
        {
            ShapeBlaster.setDisplay("game9");
        }
        else if(recL10.contains(p))
        {
            ShapeBlaster.setDisplay("game10");
        }
        else if(recL11.contains(p))
        {
            ShapeBlaster.setDisplay("game11");
        }
        else if(recL12.contains(p))
        {
            ShapeBlaster.setDisplay("game12");
        }
        
    }

    public void mousePressed(MouseEvent e) 
    {
        
    }

    public void mouseReleased(MouseEvent e) 
    {
        
    }

    public void mouseEntered(MouseEvent e) 
    {
       
    }

    public void mouseExited(MouseEvent e) 
    {
        
    }

    public void mouseDragged(MouseEvent e) 
    {
        
    }

    public void mouseMoved(MouseEvent e) 
    {
        
    }
    
}
