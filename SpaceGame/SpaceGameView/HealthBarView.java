package SpaceGame.SpaceGameView;


import SpaceGame.SpaceGameModel.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 16.10.2016.
 */
public class HealthBarView {
    private BufferedImage oneHeart;
    private static final int HEALTHBAR_POSITION_X=0;
    private static final int HEALTHBAR_POSITION_Y=670;
    public HealthBarView()
    {
        try
        {
            oneHeart = ImageIO.read(getClass().getResource("/hpbar.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void render(Graphics g, int playersHp)
    {
        for(int i=0; i<playersHp; i++)
        g.drawImage(oneHeart,HEALTHBAR_POSITION_X+32*i,HEALTHBAR_POSITION_Y,null);
    }
}
