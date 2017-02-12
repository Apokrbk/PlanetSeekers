package SpaceGame.SpaceGameController;

import SpaceGame.Game;
import SpaceGame.SpaceGameModel.EnemyBullet;

public class EnemyBulletController {

    protected void moveEnemyBullet(EnemyBullet enemyBullet) {
        enemyBullet.setX(enemyBullet.getX()+enemyBullet.getVelX());
        enemyBullet.setY(enemyBullet.getY()+enemyBullet.getVelY());
    }

    boolean isEnemyBulletOutsideScreen(EnemyBullet enemyBullet) {
        return enemyBullet.getX()<0 || enemyBullet.getX() > Game.WIDTH || enemyBullet.getY() < 0 || enemyBullet.getY() > Game.HEIGHT;
    }
}
