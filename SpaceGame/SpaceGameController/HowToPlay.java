package SpaceGame.SpaceGameController;

import SpaceGame.Game;
import SpaceGame.SpaceGameView.HowToPlayView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Apok on 13.12.2016.
 */
public class HowToPlay extends Controller {

    private Game game;
    private HowToPlayView howToPlayView = new HowToPlayView();

    public HowToPlay(Game game)
    {
        this.game = game;
    }

    public void update()
    {

    }

    public void render(Graphics g)
    {
        howToPlayView.render(g);
    }


    public void keyPressed(int key)
    {
        if(key == KeyEvent.VK_ENTER )
        {
            game.changeController(2);
        }
    }

    public void keyReleased(int key)
    {

    }

}
