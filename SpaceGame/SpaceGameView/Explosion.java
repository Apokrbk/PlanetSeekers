package SpaceGame.SpaceGameView;

import SpaceGame.SpaceGameModel.GameObject;

/**
 * Created by Apok on 24.10.2016.
 */
public class Explosion extends GameObject {

    public static final double SPEED_OF_EXPLOSION_ANIMATION = 0.4;

    public double getStateOfAnimation() {
        return stateOfAnimation;
    }

    private double stateOfAnimation=0;

    public void increaseAnimation()
    {
        stateOfAnimation+= SPEED_OF_EXPLOSION_ANIMATION;
    }

    public Explosion(double x, double y)
    {
        super(x,y);
    }
}
