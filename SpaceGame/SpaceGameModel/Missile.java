package SpaceGame.SpaceGameModel;

/**
 * Created by Apok on 07.11.2016.
 */
public class Missile extends GameObject {

    private static final int HEIGHT_OF_PLAYERS_MISSILE = 50;
    private static final int WIDTH_OF_PLAYERS_MISSILE = 20;
    private static final int VEL_Y_OF_PLAYERS_MISSILE = -5;

    public Missile(double x, double y)
    {
        super(x,y);
        this.setHeight(HEIGHT_OF_PLAYERS_MISSILE);
        this.setWidth(WIDTH_OF_PLAYERS_MISSILE);
        setVelY(VEL_Y_OF_PLAYERS_MISSILE);
    }

}
