package SpaceGame.SpaceGameController;

import SpaceGame.Game;
import SpaceGame.SpaceGameView.Chooser;

import SpaceGame.SpaceGameView.ChooserView;
import SpaceGame.SpaceGameView.MenuView;


import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Apok on 22.10.2016.
 */
public class Menu extends Controller {


    private static final int Y_OF_CHOOSER_ON_PLAY_BUTTON = 435;
    private static final int Y_OF_CHOOSER_ON_EXIT_BUTTON = 580;
    private static final int X_OF_CHOOSER=20;



    private MenuView menuView = new MenuView();
    private Chooser chooser = new Chooser(X_OF_CHOOSER,Y_OF_CHOOSER_ON_PLAY_BUTTON);
    private ChooserView chooserView = new ChooserView(chooser);


    private Game game;

    public Menu(Game game, int score)
    {
        this.game = game;
        this.setScore(score);
    }

    public void update()
    {

    }

    public void render(Graphics g)
    {
        menuView.render(g);
        chooserView.render(g);
        g.drawString(Integer.toString(this.getScore()),220,374);
    }

    public void keyPressed(int key)
    {

        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_UP)
        {
            changeActiveButton();
        }
        if(key == KeyEvent.VK_ENTER )
        {
            if(chooser.getY()==Y_OF_CHOOSER_ON_PLAY_BUTTON && getScore()==0) game.changeController(1);
            else if(chooser.getY() == Y_OF_CHOOSER_ON_PLAY_BUTTON && getScore()>0) game.changeController(2);
            else System.exit(1);
        }
    }

    public void keyReleased(int key)
    {

    }

    private void changeActiveButton() {
        if(chooser.getY()==Y_OF_CHOOSER_ON_EXIT_BUTTON) chooser.setY(Y_OF_CHOOSER_ON_PLAY_BUTTON);
        else chooser.setY(Y_OF_CHOOSER_ON_EXIT_BUTTON);
    }
}
