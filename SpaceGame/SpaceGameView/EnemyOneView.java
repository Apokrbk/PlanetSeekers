package SpaceGame.SpaceGameView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 13.12.2016.
 */
class EnemyOneView {
    private BufferedImage enemyI;
    EnemyOneView()
    {

        try
        {
            enemyI = ImageIO.read(getClass().getResource("/enemy22.png"));
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
