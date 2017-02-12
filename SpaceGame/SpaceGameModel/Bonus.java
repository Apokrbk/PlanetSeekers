package SpaceGame.SpaceGameModel;

/**
 * Created by Apok on 08.12.2016.
 */
public abstract class Bonus extends GameObject {
    private static final int HEIGHT_OF_BONUS = 40;
    private static final int WIDTH_OF_BONUS = 40;
    private static final int VEL_Y_OF_BONUS = 5;

    Bonus(double x, double y)
    {
        super(x,y);
        setHeight(HEIGHT_OF_BONUS);
        setWidth(WIDTH_OF_BONUS);
        setVelY(VEL_Y_OF_BONUS);
    }
}
