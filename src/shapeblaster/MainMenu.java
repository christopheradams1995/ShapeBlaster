package shapeblaster;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import static shapeblaster.ShapeBlaster.point;

public class MainMenu extends JComponent
{
    private static List shapes = new ArrayList();
    
    MainMenu()
    {
        //add shapes
        for(int i=0;i<20;i++)
        {
            shapes.add(new Square());
        }
        for(int i=0;i<30;i++)
        {
            shapes.add(new Circle());
        }
        this.repaint();
        this.revalidate();
    }
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        try
        {
            //background
            BufferedImage back = getImage("images\\MainMenu4.png");
            BufferedImage button = getImage("images\\MainMenuButton.png");
            BufferedImage title = getImage("images\\MainMenuTitle.png");
            
            g2d.drawImage(back, 0, 0, null);
            
            //moving shapes
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias!
            RenderingHints.VALUE_ANTIALIAS_ON);
        
            for(Object shape : shapes) 
            {
                
                Shape cshape = (Shape) shape;
                cshape.draw(g2d);
            }
            g2d.drawImage(button, 250, 160, null);
            g2d.drawImage(button, 250, 280, null);
            g2d.drawImage(button, 250, 400, null);
            g2d.drawImage(title, 200, 60, null);
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
