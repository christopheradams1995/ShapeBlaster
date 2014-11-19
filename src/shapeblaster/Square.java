
package shapeblaster;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape
{

    private int x = 100 , y = 100 , w = 100 , h = 100;
    
    Square()
    {
        
    }
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        System.out.println("SDDS");
        g.setColor(Color.red);
        g.fillRect(x, y, w, h);
    }

    public void setSize() {
        
    }

    public void setLocation(int x, int y) 
    {
        
    }
    
}
