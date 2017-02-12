package SpaceGame.SpaceGameController;

import SpaceGame.Game;
import SpaceGame.SpaceGameModel.Enemy;
import SpaceGame.SpaceGameModel.EnemyBullet;
import SpaceGame.SpaceGameModel.EnemyBulletHeadingPlayer;
import SpaceGame.SpaceGameModel.Player;

import java.util.ArrayList;
import java.util.Random;


class EnemyTwoController {
    private ArrayList<EnemyBullet> enemyBullets;
    private Player player;

    EnemyTwoController(ArrayList<EnemyBullet> enemyBullets, Player player)
    {
        this.enemyBullets = enemyBullets;
        this.player = player;
    }

    void enemyTwoShoot(Enemy enemy)
    {
        EnemyBulletHeadingPlayer bullet;
        if(enemy.getY()<player.getY())
        {
            bullet = new EnemyBulletHeadingPlayer(
                    enemy.getX()+(enemy.getWidth()/2),
                    enemy.getY()+(enemy.getHeight()/2),
                    player.getX()+(player.getWidth()/2),
                    player.getY()+(player.getHeight()/2));
            enemyBullets.add(bullet);
        }
    }

    void moveEnemyTwo(Enemy enemy)
    {
        Random r = new Random();
        if (enemy.getY() < Game.HEIGHT) {
            enemy.setVelX(enemy.getVelX() - 1 + r.nextInt(3));
            enemy.setY(enemy.getY() + enemy.getVelY());
            if (enemy.getX() + enemy.getVelX() >= 0 && enemy.getX() + enemy.getVelX() <= 350 && enemy.getVelX() <= 3 && enemy.getVelX() >= -3)
                enemy.setX(enemy.getX() + enemy.getVelX());
            else
                enemy.setVelX(enemy.getVelX() + enemy.getVelX() * (-1) / 2);
        }

    }
}
