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
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import static shapeblaster.ShapeBlaster.point;

public class MainMenu extends JComponent implements MouseListener, MouseMotionListener
{
    // used for the button events including the movement of the arrow
    private static Rectangle recNew= new Rectangle(230,160,316,95)
            ,recLoad = new Rectangle(230,280,316,95),
            recOption = new Rectangle(230,400,316,95);
    private Point p;
    
    
    
    MainMenu()
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        try
        {
            //Load Images
            BufferedImage back = getImage("images\\space1_0.PNG");
            BufferedImage button = getImage("images\\MainMenuButton.PNG");
            BufferedImage title = getImage("images\\MainMenuTitle.PNG");
            BufferedImage arrow = getImage("images\\arrow.PNG");
            
            //Draw Images
            g2d.drawImage(back, 0, 0, null);
            g2d.drawImage(button, 230, 160, null);
            g2d.drawImage(button, 230, 280, null);
            g2d.drawImage(button, 230, 400, null);
            g2d.drawImage(title, 170, 60, null);
            if(p != null)
            {
                g2d.drawImage(arrow, p.x, p.y, null);
            }
            
            //Add Text for buttons
            Font font = new Font("Serif", Font.PLAIN, 55);
            g2d.setFont(font);
            g2d.setColor(Color.white);
            
            //anti alias
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                          RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            
            g2d.drawString("New Game", 250, 220);
            g2d.drawString("Load Game", 250, 340);
            g2d.drawString("Options", 250, 460);
            
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
    public static BufferedImage getImage(String url)
    {
        try
        {
            File img = new File(url);
            BufferedImage in = ImageIO.read(img);
            return in;
        }
        catch(Exception er)
        {
            System.out.println("Could not find the image");
            return null;
        }
        
    }
    

    public void mouseClicked(MouseEvent e) 
    {
        Point p = e.getPoint();
        if(recNew.contains(p))
        {
            ShapeBlaster.setDisplay("game");
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
    
    //Adjusts the location of the arrow that appears after the user hovers over
    // each button.
    public void mouseMoved(MouseEvent e) 
    {
        Point p = e.getPoint();
        if(recNew.contains(p))
        {
            this.p = new Point((int)recNew.getX()-110, (int)recNew.getY()+10);
        }
        else if(recLoad.contains(p))
        {
            this.p = new Point((int)recLoad.getX()-110, (int)recLoad.getY()+10);
        }
        else if(recOption.contains(p))
        {
            this.p = new Point((int)recOption.getX()-110, (int)recOption.getY()+10);
        }
        else
        {
            this.p = null;
        }
        
    }
}
