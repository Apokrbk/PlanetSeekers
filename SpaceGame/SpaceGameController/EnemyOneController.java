package SpaceGame.SpaceGameController;

import SpaceGame.Game;
import SpaceGame.SpaceGameModel.Enemy;
import SpaceGame.SpaceGameModel.EnemyBullet;
import SpaceGame.SpaceGameModel.EnemyBulletHeadingGivenDirection;
import SpaceGame.SpaceGameModel.Player;

import java.util.ArrayList;

class EnemyOneController {

    private ArrayList<EnemyBullet> enemyBullets;

    EnemyOneController(ArrayList<EnemyBullet> enemyBullets)
    {
        this.enemyBullets = enemyBullets;
    }

    void moveEnemyOne(Enemy enemy)
    {
        if(enemy.getY() < Game.HEIGHT)
            enemy.setY(enemy.getY()+enemy.getVelY());
    }

    void enemyOneShoot(Enemy enemy, Player player)
    {
        EnemyBulletHeadingGivenDirection bullet;
        if(enemy.getY()<player.getY())
        {
            bullet = new EnemyBulletHeadingGivenDirection(
                    enemy.getX()+(0.5)*enemy.getWidth(),
                    enemy.getY()+(0.5)*enemy.getHeight(),
                    EnemyBulletHeadingGivenDirection.DOWN);
            enemyBullets.add(bullet);
        }
    }
}
