package SpaceGame.SpaceGameModel;

/**
 * Created by Apok on 14.10.2016.
 */
public class Bullet extends GameObject {

    private static final int HEIGHT_OF_PLAYERS_BULLET = 45;
    private static final int WIDTH_OF_PLAYERS_BULLET = 15;
    private static final int VEL_Y_OF_BULLET = -15;

    public Bullet(double x, double y)
    {
        super(x,y);
        this.setHeight(HEIGHT_OF_PLAYERS_BULLET);
        this.setWidth(WIDTH_OF_PLAYERS_BULLET);
        setVelY(VEL_Y_OF_BULLET);
    }

}
