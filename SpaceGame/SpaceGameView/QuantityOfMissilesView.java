package SpaceGame.SpaceGameView;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 08.11.2016.
 */
public class QuantityOfMissilesView {
    private BufferedImage oneRocket;
    public QuantityOfMissilesView()
    {
        try
        {
            oneRocket = ImageIO.read(getClass().getResource("/missile.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void render(Graphics g, int quantityOfRockets)
    {
        for(int i=0; i<quantityOfRockets; i++)
            g.drawImage(oneRocket,10+25*i,610,null);
    }

}
