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

public class Score extends JComponent implements MouseListener, MouseMotionListener
{
    // used for the button events including the movement of the arrow
    private static Rectangle recRight= new Rectangle(665,515,132,74);
    
    private Point p;
    
    BufferedImage back;    
    BufferedImage arrow;  
    public int shapesLeft;
    
    Score(int shapesLeft)
    {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.shapesLeft = shapesLeft;
        //Load Images
        back = getImage("images/space1_0.png");
        arrow = getImage("images/arrow.png");
    }
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        try
        {
            
            //Draw Images
            g2d.drawImage(back, 0, 0, null);
            g2d.drawImage(arrow, 665, 515, null);
            
            //Add Text for buttons
            Font font = new Font("Serif", Font.PLAIN, 55);
            g2d.setFont(font);
            g2d.setColor(Color.white);
            
            //anti alias
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                          RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            String s = "Shapes Left: " + shapesLeft;
            g2d.drawString(s, 100, 80);
            
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
        if(recRight.contains(p))
        {
            ShapeBlaster.setDisplay("levelSelection");
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
