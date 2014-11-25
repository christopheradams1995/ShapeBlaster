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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

public abstract class Shape
{
    public Boolean delete = false;
    public boolean explode = false;
    public Boolean checkDelete = false;
    public Rectangle rec;
    public abstract void setSize();
    public abstract void setLocation(int x, int y);
    public abstract void draw(Graphics2D g);
    public abstract void react();
}
