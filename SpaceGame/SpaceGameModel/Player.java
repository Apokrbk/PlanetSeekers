package SpaceGame.SpaceGameModel;

/**
 * Created by Apok on 14.10.2016.
 */
public class Player extends GameObject {

    private static final int PLAYERS_STARTING_POSITION_X=200;
    private static final int PLAYERS_STARTING_POSITION_Y=550;
    private static final int HEIGHT_OF_PLAYER=40;
    private static final int WIDTH_OF_PLAYER=40;
    private static final int VEL_X_OF_PLAYER = 7;
    private static final int VEL_Y_OF_PLAYER = 5;
    public static final int STARTING_QUANTITY_OF_MISSILES = 3;
    public static final int STARTING_HP = 5;
    private int hp = STARTING_HP;
    private int quantityOfMissiles=STARTING_QUANTITY_OF_MISSILES;
    private boolean isMovingUp, isMovingDown, isMovingLeft, isMovingRight, isShooting;

    public Player(int a, int b)
    {
        super(a,b);
        this.setHeight(HEIGHT_OF_PLAYER);
        this.setWidth(WIDTH_OF_PLAYER);
        setVelY(VEL_Y_OF_PLAYER);
        setVelX(VEL_X_OF_PLAYER);
    }

    public Player()
    {
        super(PLAYERS_STARTING_POSITION_X, PLAYERS_STARTING_POSITION_Y);
        this.setHeight(HEIGHT_OF_PLAYER);
        this.setWidth(WIDTH_OF_PLAYER);
        setVelY(VEL_Y_OF_PLAYER);
        setVelX(VEL_X_OF_PLAYER);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isMovingRight() {
        return isMovingRight;
    }

    public void setMovingRight(boolean movingRight) {
        isMovingRight = movingRight;
    }

    public boolean isMovingLeft() {
        return isMovingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        isMovingLeft = movingLeft;
    }

    public boolean isMovingDown() {
        return isMovingDown;
    }

    public void setMovingDown(boolean movingDown) {
        isMovingDown = movingDown;
    }

    public boolean isMovingUp() {
        return isMovingUp;
    }


    public void setMovingUp(boolean movingUp) {
        isMovingUp = movingUp;
    }

    public boolean isShooting() {
        return isShooting;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }


    public int getQuantityOfMissiles() {
        return quantityOfMissiles;
    }

    public void setQuantityOfMissiles(int quantityOfRockets) {
        this.quantityOfMissiles = quantityOfRockets;
    }
}
