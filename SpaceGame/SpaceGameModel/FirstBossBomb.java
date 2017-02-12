package SpaceGame.SpaceGameModel;

/**
 * Created by Apok on 08.12.2016.
 */
public class FirstBossBomb extends GameObject {

    private static final int VEL_Y_OF_BOSS1BOMB = 2;

    public FirstBossBomb(double x, double y)
    {
        super(x,y);
        setVelY(VEL_Y_OF_BOSS1BOMB);
    }
}
