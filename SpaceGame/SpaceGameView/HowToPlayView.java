package SpaceGame.SpaceGameView;

import SpaceGame.SpaceGameController.HowToPlay;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 13.12.2016.
 */
public class HowToPlayView {
    private BufferedImage background;
    public HowToPlayView()
    {
        try
        {
            background = ImageIO.read(getClass().getResource("/guide.png"));
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
