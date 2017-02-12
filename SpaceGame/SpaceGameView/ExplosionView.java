package SpaceGame.SpaceGameView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 24.10.2016.
 */
class ExplosionView {
    private BufferedImage[] tab = new BufferedImage[16];
    ExplosionView()
    {
        for (int i = 0; i < 16; i++)
        {
            try
            {
                tab[i] = ImageIO.read(getClass().getResource("/myexp/explosion"+Integer.toString(i)+".png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void render(Graphics g, Explosion explosion)

    {
        g.drawImage(tab[(int)explosion.getStateOfAnimation()], (int)explosion.getX(), (int)explosion.getY(), null );
    }
}
