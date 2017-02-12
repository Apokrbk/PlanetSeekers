package SpaceGame.SpaceGameView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 02.12.2016.
 */
class BonusHpView {
    private BufferedImage bonusHp;
    BonusHpView()
    {
        try
        {
            bonusHp = ImageIO.read(getClass().getResource("/bonusHP.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    public void render(Graphics g, double x, double y)
    {
        g.drawImage(bonusHp, (int)x,(int)y, null);
    }
}
