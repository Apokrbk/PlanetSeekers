package SpaceGame.SpaceGameView;

import SpaceGame.SpaceGameModel.Bullet;
import SpaceGame.SpaceGameModel.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 14.10.2016.
 */
class BulletView {
    private BufferedImage bulleti;
    BulletView()
    {
        try
        {
            bulleti = ImageIO.read(getClass().getResource("/bullet.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    public void render(Graphics g, double x,double y)
    {
        g.drawImage(bulleti, (int)x,(int)y, null);
    }
}
