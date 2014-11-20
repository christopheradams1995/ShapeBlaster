
package shapeblaster;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
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
    public static JPanel panel = new JPanel(new FlowLayout());
    private Thread t;
    private static List shapes = new ArrayList();
    public static Point point = new Point(0,0);
    
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
       panel.setBackground(Color.white);
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(800,600);
       frame.setLocationRelativeTo(null);
       
       frame.setVisible(true);
       
       ShapeBlaster sb = new ShapeBlaster();
       frame.setContentPane(sb);
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
        Object delShape = null;
        for(Object shape : shapes) 
        {
            Shape cshape = (Shape) shape;
            cshape.draw(g);
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
    
