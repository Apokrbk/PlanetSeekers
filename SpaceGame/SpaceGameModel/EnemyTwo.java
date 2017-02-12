package SpaceGame.SpaceGameModel;

/**
 * Created by Apok on 15.10.2016.
 */
public class EnemyTwo extends Enemy {

    private static final int WIDTH_OF_ENEMY_TWO=50;
    private static final int HEIGHT_OF_ENEMY_TWO=30;
    private static final int STARTING_HP_OF_ENEMY_TWO = 3;
    private static final int VEL_Y_OF_ENEMY_TWO = 1;

    public EnemyTwo(int x, int y)
    {
        super(x,y);
        this.setHeight(HEIGHT_OF_ENEMY_TWO);
        this.setWidth(WIDTH_OF_ENEMY_TWO);
        setHp(STARTING_HP_OF_ENEMY_TWO);
        setVelY(VEL_Y_OF_ENEMY_TWO);
    }

}
