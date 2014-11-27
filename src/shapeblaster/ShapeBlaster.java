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
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapeBlaster extends JComponent implements Runnable, MouseListener
{
    public static JFrame frame = new JFrame("Shape Blaster!");
    private Thread t;

    private static List shapes = new ArrayList();
    public static Point point = new Point(0,0);
    private static MainMenu mm = new MainMenu();
    private static ShapeBlaster sb;
    private static LevelSelection ls = new LevelSelection();
    private static Instructions in = new Instructions();
    
    //images to load
    BufferedImage back;
    
    ShapeBlaster(int squares, int circles, int triangles)
    {
        
        t = new Thread(this,"main");
        t.start();
        
        for(int i=0;i<squares;i++)
        {
            shapes.add(new Square());
        }
        for(int i=0;i<circles;i++)
        {
            shapes.add(new Circle());
        }
        
        //Load Images
        back = getImage("images/space1_0.png");
        this.addMouseListener(this);
    }
    
    public static void main(String[] args) 
    { 
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(800,630);
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
        if(con.equals("game1"))
        {
            sb = new ShapeBlaster(0,200,0);
            frame.setContentPane(sb);
        }
        else if(con.equals("game2"))
        {
            sb = new ShapeBlaster(100,0,0);
            frame.setContentPane(sb);
        }
        else if(con.equals("game3"))
        {
            sb = new ShapeBlaster(100,100,0);
            frame.setContentPane(sb);
        }
        else if(con.equals("game4"))
        {
            
        }
        else if(con.equals("game5"))
        {
            
        }
        else if(con.equals("game6"))
        {
            
        }
        else if(con.equals("game7"))
        {
            
        }
        else if(con.equals("game8"))
        {
            
        }
        else if(con.equals("game9"))
        {
            
        }
        else if(con.equals("game10"))
        {
            
        }
        else if(con.equals("game11"))
        {
            
        }
        else if(con.equals("game12"))
        {
            
        }
        else if(con.equals("mainMenu"))
        {
            frame.setContentPane(mm);
        }
        else if(con.equals("levelSelection"))
        {
            frame.setContentPane(ls);
        }
        else if(con.equals("instructions"))
        {
            frame.setContentPane(in);
        }
        
    }

    //Iterates through each shape and checks if it reacted with the reacted
    // rectangle that's given
    // hitCount: How many hits do you want to give the shape?
    //returns true if something is hit
    public static Boolean checkReact(Rectangle rec)
    {
        Iterator i = shapes.iterator();
        while(i.hasNext())
        {
            Shape cshape = (Shape) i.next();
            //Set up the next shape to be deleted
            if(cshape.rec.intersects(rec) && !cshape.explode)
            {
                cshape.react();
                System.out.println("REACT!@");
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
}
    
