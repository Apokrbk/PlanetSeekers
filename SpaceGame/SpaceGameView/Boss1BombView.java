package SpaceGame.SpaceGameView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 08.12.2016.
 */
public class Boss1BombView {
    private BufferedImage boss1bomb;
    public Boss1BombView()
    {
        try
        {
            boss1bomb = ImageIO.read(getClass().getResource("/boss1bomb.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    public void render(Graphics g, double x, double y)
    {
        g.drawImage(boss1bomb, (int)x,(int)y, null);
    }
}
