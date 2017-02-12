package SpaceGame.SpaceGameView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 22.10.2016.
 */
public class ChooserView {

    private BufferedImage chooserImage;
    private Chooser chooser;

    public ChooserView(Chooser chooser)
    {
        this.chooser = chooser;
        try
        {
            chooserImage = ImageIO.read(getClass().getResource("/chooser.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void render(Graphics g)
    {
        g.drawImage(chooserImage, (int)chooser.getX(), (int)chooser.getY(), null);
    }
}
