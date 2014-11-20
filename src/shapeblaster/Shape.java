
package shapeblaster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

public abstract class Shape
{
    public Rectangle rec;
    public abstract void setSize();
    public abstract void setLocation(int x, int y);
    public abstract void draw(Graphics g);
}
