package SpaceGame.SpaceGameView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 05.12.2016.
 */
public class Boss1View{
    private BufferedImage boss1i;
    public Boss1View()
    {

        try
        {
            boss1i = ImageIO.read(getClass().getResource("/bosslevel1.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    public void render(Graphics g, double x, double y)
    {
        g.drawImage(boss1i, (int)x,(int)y,null);
    }
}
