
package shapeblaster;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public abstract class Shape extends JComponent
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

    }
    public abstract void setSize();
    public abstract void setLocation(int x, int y);
}
