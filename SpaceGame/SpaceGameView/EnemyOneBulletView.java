package SpaceGame.SpaceGameView;

import SpaceGame.SpaceGameModel.EnemyBulletHeadingPlayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 15.10.2016.
 */
class EnemyOneBulletView {
    private BufferedImage enemybullet;
    EnemyOneBulletView()
    {
        try
        {
           enemybullet = ImageIO.read(getClass().getResource("/newbullet1.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    public void render(Graphics g, double x, double y)
    {
        g.drawImage(enemybullet, (int)x,(int)y,null);
    }
}
