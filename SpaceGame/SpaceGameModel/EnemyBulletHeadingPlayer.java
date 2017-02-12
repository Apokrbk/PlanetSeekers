package SpaceGame.SpaceGameModel;

import static java.lang.Math.sqrt;

/**
 * Created by Apok on 15.10.2016.
 */
public class EnemyBulletHeadingPlayer extends EnemyBullet {

    private static final int HEIGHT_OF_ENEMYONE_BULLET = 15;
    private static final int WIDTH_OF_ENEMYONE_BULLET = 15;
    private static final int VEL_OF_ENEMYONE_BULLET = 4;

    private double c=0; //przeciwprostokatna
    public EnemyBulletHeadingPlayer(double x, double y, double px, double py)
    {
        super(x,y);
        this.countC(px,py);
        setVelX(VEL_OF_ENEMYONE_BULLET * (px - this.getX())/c);
        setVelY(VEL_OF_ENEMYONE_BULLET *(py - this.getY())/c);
        this.setWidth(WIDTH_OF_ENEMYONE_BULLET);
        this.setHeight(HEIGHT_OF_ENEMYONE_BULLET);

    }


    private void countC(double x, double y)
    {
        c = sqrt((x - this.getX())*(x - this.getX()) +  (y - this.getY())*(y - this.getY()));
    }

}
