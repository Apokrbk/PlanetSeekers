package SpaceGame;

import SpaceGame.SpaceGameController.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Apok on 14.10.2016.
 */
class KeyInput extends KeyAdapter {

    private Controller gameEngine;

    KeyInput(Controller gameEngine)
    {
        this.gameEngine = gameEngine;
    }

    public void keyPressed(KeyEvent e)
    {
        gameEngine.keyPressed(e.getKeyCode());
    }
    public void keyReleased(KeyEvent e)
    {
        gameEngine.keyReleased(e.getKeyCode());
    }
}

