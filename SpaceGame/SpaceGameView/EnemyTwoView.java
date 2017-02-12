package SpaceGame.SpaceGameView;

import SpaceGame.SpaceGameModel.EnemyTwo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 15.10.2016.
 */
class EnemyTwoView {
    private BufferedImage enemyI;
    EnemyTwoView()
    {

        try
        {
            enemyI = ImageIO.read(getClass().getResource("/enemy1.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    public void render(Graphics g, double x, double y)
    {
        g.drawImage(enemyI, (int)x,(int)y,null);
    }
}
