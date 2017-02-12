package SpaceGame.SpaceGameView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 07.11.2016.
 */
class ShockwaveView {


    private BufferedImage[] tab = new BufferedImage[16];
    ShockwaveView()
    {
        for (int i = 0; i < 16; i++)
        {
            try
            {
                tab[i] = ImageIO.read(getClass().getResource("/shockwave/shockwave"+Integer.toString(i)+".png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }


    public void render(Graphics g, Shockwave shockwave)
    {
        if(shockwave.getStateOfAnimation()<15)
        g.drawImage(tab[(int)shockwave.getStateOfAnimation()], (int)shockwave.getX(), (int)shockwave.getY(), null );
    }


}
