
package shapeblaster;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapeBlaster
{
    public static JFrame frame = new JFrame("Shape Blaster!");
    public static JPanel panel = new JPanel();
    
    public static void main(String[] args) 
    {

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(800,600);
       frame.setLocationRelativeTo(null);
       frame.getContentPane().setBackground(Color.white);
       frame.add(new Square());
       frame.setVisible(true);
    }
    
}
