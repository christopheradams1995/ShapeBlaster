
package shapeblaster;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
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
    private static ShapeBlaster sb = new ShapeBlaster();
    
    ShapeBlaster()
    {
        
        t = new Thread(this,"main");
        t.start();
        
        for(int i=0;i<20;i++)
        {
            shapes.add(new Square());
        }
        for(int i=0;i<30;i++)
        {
            shapes.add(new Circle());
        }
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
        
        Object delShape = null;
        for(Object shape : shapes) 
        {
            Shape cshape = (Shape) shape;
            cshape.draw(g2d);
            if(cshape.rec.contains(point))
            {
                delShape = shape;
            }
        }
        if(delShape != null)
        {
            shapes.remove(delShape);
            delShape = null;
        }
        this.repaint();
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) 
    {
        System.out.println("potato");
        this.point = e.getPoint();
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
}
    
