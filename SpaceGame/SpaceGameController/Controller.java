package SpaceGame.SpaceGameController;

import java.awt.*;

public abstract class Controller {


    public int getScore() {
        return score;
    }

    void setScore(int score) {
        this.score = score;
    }

    private int score=0;

    public abstract void keyPressed(int key);

    public abstract void keyReleased(int key);

    public abstract void update();

    public abstract void render(Graphics g);

}
