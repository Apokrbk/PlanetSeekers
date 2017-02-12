package SpaceGame.SpaceGameView;

import SpaceGame.SpaceGameModel.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 14.10.2016.
 */
public class PlayerView {
    private BufferedImage player;
    private Player myPlayer;
    public PlayerView(Player p)
    {
        myPlayer = p;
        try
        {
            player = ImageIO.read(getClass().getResource("/cekinstatek.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void render(Graphics g)
    {
        g.drawImage(player, (int)myPlayer.getX(),(int)myPlayer.getY(),null);
    }
}
