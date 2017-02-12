package SpaceGame.SpaceGameController;

import SpaceGame.SpaceGameModel.Enemy;
import SpaceGame.SpaceGameModel.FirstBoss;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * Created by Apok on 06.01.2017.
 */
class EnemyController {

    void checkIfEnemyIsInsideShockwave(Ellipse2D.Double shockwave, ArrayList<Enemy> enemies, boolean boss1fight, FirstBoss firstBoss) {
        Enemy enemy;
        for (Enemy enemy1 : enemies) {
            enemy = enemy1;
            Rectangle r_enemy = new Rectangle((int) enemy.getX(), (int) enemy.getY(), enemy.getWidth(), enemy.getHeight());
            if (shockwave.intersects(r_enemy)) {
                enemy.setHp(enemy.getHp() - 3);
            }
            if (boss1fight) {
                Rectangle r_boss = new Rectangle((int) firstBoss.getX(), (int) firstBoss.getY(), firstBoss.getWidth(), firstBoss.getHeight());
                if (shockwave.intersects(r_boss))
                    firstBoss.setHp(firstBoss.getHp() - FirstBoss.HP_TAKEN_FROM_BOSS_WHEN_HIT_BY_MISSILE);
            }
        }
    }
}
