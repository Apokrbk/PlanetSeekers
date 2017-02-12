package SpaceGame.SpaceGameView;

import SpaceGame.SpaceGameModel.GameObject;

/**
 * Created by Apok on 07.11.2016.
 */
public class Shockwave extends GameObject {

    private static final int RADIUS_OF_SHOCKWAVE = 200;

    private double stateOfAnimation;

    public Shockwave(double x, double y)
    {
        super(x,y);
    }

    public double getStateOfAnimation() {
        return stateOfAnimation;
    }

    public void setStateOfAnimation(double stateOfAnimation) {
        this.stateOfAnimation = stateOfAnimation;
    }
}
