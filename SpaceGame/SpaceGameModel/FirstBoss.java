package SpaceGame.SpaceGameModel;

/**
 * Created by Apok on 05.12.2016.
 */
public class FirstBoss extends Enemy {
    private static final int WIDTH_OF_BOSS1=200;
    private static final int HEIGHT_OF_BOSS1=100;
    private static final int VEL_X_OF_BOSS1 = 1;
    private static final int VEL_Y_OF_BOSS1 = 1;
    public static final int BOSS1_POSITION_OF_STOP = 100;
    private static final int BOSS1_STARTING_POSITION_X = 100;
    private static final int BOSS1_STARTING_POSITION_Y = -300;
    public static final int HP_TAKEN_FROM_BOSS_WHEN_HIT_BY_MISSILE = 15;

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    private int Hp=130;

    public FirstBoss(int x, int y)
    {
        super(x,y);
        this.setHeight(HEIGHT_OF_BOSS1);
        this.setWidth(WIDTH_OF_BOSS1);
        setVelY(VEL_Y_OF_BOSS1);
        setVelX(VEL_X_OF_BOSS1);
    }

    public FirstBoss()
    {
        super(BOSS1_STARTING_POSITION_X, BOSS1_STARTING_POSITION_Y);
        this.setHeight(HEIGHT_OF_BOSS1);
        this.setWidth(WIDTH_OF_BOSS1);
        setVelY(VEL_Y_OF_BOSS1);
        setVelX(VEL_X_OF_BOSS1);
    }
}
