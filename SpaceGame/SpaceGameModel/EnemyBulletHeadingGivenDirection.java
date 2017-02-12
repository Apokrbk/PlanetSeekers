package SpaceGame.SpaceGameModel;

/**
 * Created by Apok on 12.12.2016.
 */
public class EnemyBulletHeadingGivenDirection extends EnemyBullet{

    private static final int HEIGHT_OF_BULLET = 15;
    private static final int WIDTH_OF_BULLET = 15;
    public static final int UP = 1;
    public static final int UP_RIGHT = 2;
    public static final int RIGHT = 3;
    public static final int DOWN_RIGHT = 4;
    public static final int DOWN = 5;
    public static final int DOWN_LEFT = 6;
    public static final int LEFT = 7;
    public static final int UP_LEFT = 8;
    public static final int VEL = 4;


    public EnemyBulletHeadingGivenDirection(double x, double y, int direction)
    {
        super(x,y);
        switch(direction) {
            case UP: setVelY(-4);  break;
            case UP_RIGHT: setVelY(-2.8); setVelX(2.8); break;
            case RIGHT: setVelX(4); break;
            case DOWN_RIGHT: setVelY(2.8); setVelX(2.8); break;
            case DOWN: setVelY(4); break;
            case DOWN_LEFT: setVelY(2.8); setVelX(-2.8); break;
            case LEFT: setVelX(-4); break;
            case UP_LEFT: setVelY(-2.8); setVelX(-2.8); break;
        }
        setHeight(HEIGHT_OF_BULLET);
        setWidth(WIDTH_OF_BULLET);
    }

}
