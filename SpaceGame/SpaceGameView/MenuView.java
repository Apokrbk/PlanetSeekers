package SpaceGame.SpaceGameView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 22.10.2016.
 */
public class MenuView{

    private BufferedImage background;
    public MenuView()
    {
        try
        {
            background = ImageIO.read(getClass().getResource("/menu.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void render(Graphics g)
    {
        g.drawImage(background,0,0, null);
    }

}
