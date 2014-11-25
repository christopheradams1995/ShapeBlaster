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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static shapeblaster.MainMenu.getImage;

public class ShapeBlaster extends JComponent implements Runnable, MouseListener
{
    public static JFrame frame = new JFrame("Shape Blaster!");
    private Thread t;

    private static List shapes = new ArrayList();
    public static Point point = new Point(0,0);
    private static MainMenu mm = new MainMenu();
    private static ShapeBlaster sb = new ShapeBlaster();
    
    //images to load
    BufferedImage back;
    
    ShapeBlaster()
    {
        
        t = new Thread(this,"main");
        t.start();
        
        for(int i=0;i<50;i++)
        {
            shapes.add(new Square());
        }
        for(int i=0;i<30;i++)
        {
            shapes.add(new Circle());
        }
        
        //Load Images
        back = getImage("images\\space1_0.png");
        this.addMouseListener(this);
    }
    
    public static void main(String[] args) 
    { 
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(800,600);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       frame.setContentPane(mm);
       frame.setBackground(Color.white);
       

    }
    
    public void run()
    {

        while(true)
        {
            try
            {

                Thread.sleep(5);
            }
            catch(Exception er)
            {
            
            }
        }
    }
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias!
        RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Draw Images
        g2d.drawImage(back,0,0, null);
        
        //Draw/update each shape
        Iterator i = shapes.iterator();
        while(i.hasNext())
        {
            
            Shape cshape = (Shape) i.next();
            if(cshape.delete)
                i.remove();
            cshape.draw(g2d);
        }
        this.repaint();
        this.revalidate();
    }
    
    /**
     * Changes the current paint componenet that the jframe uses. When called
     * this method will change the current "frame" that is being displayed.
     * Options:
     *      -mainMenu
     *      -game
     */
    public static void setDisplay(String con)
    {
        if(con.equals("game"))
        {
            frame.setContentPane(sb);
        }
        else if(con.equals("mainMenu"))
        {
            frame.setContentPane(mm);
        }
        
    }

    //Iterates through each shape and checks if it reacted with the reacted
    // rectangle that's given
    // hitCount: How many hits do you want to give the shape?
    //returns true if something is hit
    public static Boolean checkReact(Rectangle rec, int hitCount)
    {
        Iterator i = shapes.iterator();
        int x = 0;
        while(i.hasNext())
        {
            Shape cshape = (Shape) i.next();
            //Set up the next shape to be deleted
            if(cshape.rec.intersects(rec) && !cshape.explode)
            {
                cshape.react();
                x++;
                System.out.println("REACT!@");
                if(x == hitCount)
                return true;
            }
        }
        return false;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) 
    {
        
        this.point = e.getPoint();
        System.out.println("clicked x:" +point.x + " y: " + point.y );

        Iterator i = shapes.iterator();
        //checks each shape to see if it was clicked
        while(i.hasNext())
        {
            Shape cshape = (Shape) i.next();
            //Set up the next shape to be deleted
            if(cshape.rec.contains(point))
            {
                cshape.react();
                
                point = null;
                break;
            }
            cshape.checkDelete = false;
        }
        point = null;
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
}
    
