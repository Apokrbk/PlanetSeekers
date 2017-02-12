package SpaceGame.SpaceGameController;

import SpaceGame.SpaceGameModel.*;

import java.util.ArrayList;


class FirstBossController {

    private Player player;
    private ArrayList<EnemyBullet> enemyBullets;

    FirstBossController(Player player, ArrayList<EnemyBullet> enemyBullets)
    {
        this.player = player;
        this.enemyBullets = enemyBullets;
    }

    void moveFirstBoss(FirstBoss firstBoss) {
        if(firstBoss.getY()< FirstBoss.BOSS1_POSITION_OF_STOP)
            firstBoss.setY(firstBoss.getY()+ firstBoss.getVelY());
        else
        {
            firstBoss.setX(firstBoss.getX()+ firstBoss.getVelX());
        }

        if(firstBoss.getX()<0 || firstBoss.getX()>200)
            firstBoss.setVelX(firstBoss.getVelX()*(-1));
    }

    void firstBossShoot(int timer, FirstBoss firstBoss)
    {
        if(isLeftGunShooting(timer)) {
            EnemyBulletHeadingPlayer enemyBulletHeadingPlayer = new EnemyBulletHeadingPlayer(firstBoss.getX() + firstBoss.getWidth() - 30,
                    firstBoss.getY() + 70,
                    player.getX(),
                    player.getY());
            enemyBullets.add(enemyBulletHeadingPlayer);
        }
        if(isRightGunShooting(timer))
        {
            EnemyBulletHeadingPlayer enemyBulletHeadingPlayer = new EnemyBulletHeadingPlayer(firstBoss.getX()+30,
                    firstBoss.getY()+70,
                    player.getX(),
                    player.getY());
            enemyBullets.add(enemyBulletHeadingPlayer);
        }

    }

    private boolean isRightGunShooting(int timer) {
        return timer!=0 && timer%50==25;
    }

    private boolean isLeftGunShooting(int timer) {
        return timer!=0 && timer%50==0;
    }

    void explosionOfBomb(FirstBossBomb firstBossBomb)
    {
        enemyBullets.add(new EnemyBulletHeadingGivenDirection(firstBossBomb.getX(),
                firstBossBomb.getY(), EnemyBulletHeadingGivenDirection.UP));
        enemyBullets.add(new EnemyBulletHeadingGivenDirection(firstBossBomb.getX(),
                firstBossBomb.getY(), EnemyBulletHeadingGivenDirection.UP_RIGHT));
        enemyBullets.add(new EnemyBulletHeadingGivenDirection(firstBossBomb.getX(),
                firstBossBomb.getY(), EnemyBulletHeadingGivenDirection.RIGHT));
        enemyBullets.add(new EnemyBulletHeadingGivenDirection(firstBossBomb.getX(),
                firstBossBomb.getY(), EnemyBulletHeadingGivenDirection.DOWN_RIGHT));
        enemyBullets.add(new EnemyBulletHeadingGivenDirection(firstBossBomb.getX(),
                firstBossBomb.getY(), EnemyBulletHeadingGivenDirection.DOWN));
        enemyBullets.add(new EnemyBulletHeadingGivenDirection(firstBossBomb.getX(),
                firstBossBomb.getY(), EnemyBulletHeadingGivenDirection.DOWN_LEFT));
        enemyBullets.add(new EnemyBulletHeadingGivenDirection(firstBossBomb.getX(),
                firstBossBomb.getY(), EnemyBulletHeadingGivenDirection.LEFT));
        enemyBullets.add(new EnemyBulletHeadingGivenDirection(firstBossBomb.getX(),
                firstBossBomb.getY(), EnemyBulletHeadingGivenDirection.UP_LEFT));
    }
}
