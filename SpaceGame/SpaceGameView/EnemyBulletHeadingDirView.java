package SpaceGame.SpaceGameView;

import SpaceGame.SpaceGameModel.EnemyBulletHeadingGivenDirection;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 12.12.2016.
 */
class EnemyBulletHeadingDirView {
    private BufferedImage enemybullet;
    EnemyBulletHeadingDirView()
    {
        try
        {
            enemybullet = ImageIO.read(getClass().getResource("/bulletheadingdir.png"));
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
