package SpaceGame.SpaceGameView;

import SpaceGame.SpaceGameModel.BonusMissile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 02.12.2016.
 */
class BonusMissileView {

    private BufferedImage bonusMissile;
    BonusMissileView()
    {
        try
        {
            bonusMissile = ImageIO.read(getClass().getResource("/bonusmissile.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    public void render(Graphics g, double x, double y)
    {
        g.drawImage(bonusMissile, (int)x,(int)y, null);
    }
}
