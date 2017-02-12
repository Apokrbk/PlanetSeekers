package SpaceGame.SpaceGameModel;

/**
 * Created by Apok on 13.12.2016.
 */
public class EnemyOne extends Enemy {

    private static final int WIDTH_OF_ENEMY_ONE=50;
    private static final int HEIGHT_OF_ENEMY_ONE=30;
    private static final int STARTING_HP_OF_ENEMY_ONE = 1;
    private static final int VEL_Y_OF_ENEMY_ONE = 1;

    public EnemyOne(int x, int y)
    {
        super(x,y);
        this.setHeight(HEIGHT_OF_ENEMY_ONE);
        this.setWidth(WIDTH_OF_ENEMY_ONE);
        setHp(STARTING_HP_OF_ENEMY_ONE);
        setVelY(VEL_Y_OF_ENEMY_ONE);
    }

}
