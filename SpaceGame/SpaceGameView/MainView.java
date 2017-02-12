package SpaceGame.SpaceGameView;
import SpaceGame.SpaceGameController.GameEngine;
import SpaceGame.SpaceGameModel.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class MainView{

    private BonusHpView bonusHpView;
    private BonusMissileView bonusMissileView;
    private Boss1BombView boss1BombView;
    private Boss1View boss1View;
    private BulletView bulletView;
    private EnemyBulletHeadingDirView enemyBulletHeadingDirView;


    public Boss1View getBoss1View() {
        return boss1View;
    }

    public Boss1BombView getBoss1BombView() {
        return boss1BombView;
    }


    public HealthBarView getHealthBarView() {
        return healthBarView;
    }


    public PlayerView getPlayerView() {
        return playerView;
    }

    public QuantityOfMissilesView getQuantityOfMissilesView() {
        return quantityOfMissilesView;
    }


    private EnemyOneBulletView enemyOneBulletView;
    private EnemyOneView enemyOneView;
    private EnemyTwoView enemyTwoView;
    private ExplosionView explosionView;
    private HealthBarView healthBarView;
    private MissileView missileView;
    private PlayerView playerView;
    private QuantityOfMissilesView quantityOfMissilesView;
    private ShockwaveView shockwaveView;


    public MainView(GameEngine gameEngine)
    {
        bonusHpView = new BonusHpView();
        bonusMissileView = new BonusMissileView();
        boss1BombView = new Boss1BombView();
        boss1View = new Boss1View();
        bulletView = new BulletView();
        enemyBulletHeadingDirView = new EnemyBulletHeadingDirView();
        enemyOneBulletView = new EnemyOneBulletView();
        enemyOneView = new EnemyOneView();
        enemyTwoView = new EnemyTwoView();
        explosionView = new ExplosionView();
        healthBarView = new HealthBarView();
        missileView = new MissileView();
        playerView = new PlayerView(gameEngine.getPlayer());
        quantityOfMissilesView = new QuantityOfMissilesView();
        shockwaveView = new ShockwaveView();

    }

    public void renderBonuses(Graphics g, ArrayList<Bonus> bonuses)
    {
        Bonus bonus;
        for (Bonus bonuse : bonuses) {
            bonus = bonuse;
            if (bonus instanceof BonusMissile)
                bonusMissileView.render(g, bonus.getX(), bonus.getY());
            else if (bonus instanceof BonusHp)
                bonusHpView.render(g, bonus.getX(), bonus.getY());
        }

    }

    public void renderEnemyOneBullets(Graphics g, ArrayList<EnemyBullet> enemyBullets) {

        EnemyBullet enemyBullet;
        for (EnemyBullet enemyBullet1 : enemyBullets) {
            enemyBullet = enemyBullet1;
            if (enemyBullet instanceof EnemyBulletHeadingPlayer)
                enemyOneBulletView.render(g, enemyBullet.getX(), enemyBullet.getY());
            else if (enemyBullet instanceof EnemyBulletHeadingGivenDirection)
                enemyBulletHeadingDirView.render(g, enemyBullet.getX(), enemyBullet.getY());
        }

    }

    public void renderExplosions(Graphics g, ArrayList<Explosion> explosions) {

        Explosion explosion;
        for (Explosion explosion1 : explosions) {
            explosion = explosion1;
            explosionView.render(g, explosion);
        }
    }

    public void renderEnemies(Graphics g, ArrayList<Enemy> enemies) {

        Enemy enemy;
        for (Enemy enemy1 : enemies) {
            enemy = enemy1;
            if (enemy instanceof EnemyTwo)
                enemyTwoView.render(g, enemy.getX(), enemy.getY());
            else if (enemy instanceof EnemyOne)
                enemyOneView.render(g, enemy.getX(), enemy.getY());
        }
    }

    public void renderShockwaves(Graphics g, ArrayList<Shockwave> shockwaves) {

        Shockwave shockwave;
        for (Shockwave shockwave1 : shockwaves) {
            shockwave = shockwave1;
            shockwaveView.render(g, shockwave);

        }
    }

    public void renderPlayersMissiles(Graphics g, ArrayList<Missile> missiles) {

        Missile missile;
        for (Missile missile1 : missiles) {
            missile = missile1;
            missileView.render(g, (int) missile.getX(), (int) missile.getY());
        }
    }

    public void renderPlayersBullets(Graphics g, ArrayList<Bullet> bullets) {

        Bullet bullet;
        for(Iterator<Bullet> iterator = bullets.iterator(); iterator.hasNext();)
        {
            try {
                bullet = iterator.next();
                bulletView.render(g, bullet.getX(), bullet.getY());
            }
            catch(ConcurrentModificationException ignored)
            {
                break;
            }
        }


    }
    /*
    public void keyPressed(int key) {
        if(key== KeyEvent.VK_RIGHT)
        {
            gameEngine.getPlayer().setMovingRight(true);

        }
        if(key==KeyEvent.VK_LEFT)
        {
            gameEngine.getPlayer().setMovingLeft(true);
        }
        if(key==KeyEvent.VK_UP)
        {
            gameEngine.getPlayer().setMovingUp(true);
        }
        if(key==KeyEvent.VK_DOWN)
        {
            gameEngine.getPlayer().setMovingDown(true);
        }
        if(key==KeyEvent.VK_SPACE && !gameEngine.getPlayer().isShooting())
        {
            gameEngine.getPlayer().setShooting(true);
            gameEngine.getPlayerController().playerShootBullet();
        }

        if(key==KeyEvent.VK_B && !gameEngine.getPlayer().isShooting())
        {
            gameEngine.getPlayer().setShooting(true);
            if(gameEngine.getPlayer().getQuantityOfMissiles()>0)
            {
                gameEngine.getPlayer().setQuantityOfMissiles(gameEngine.getPlayer().getQuantityOfMissiles()-1);
                gameEngine.getPlayerController().playerShootMissile();
            }
        }

    }

    public void keyReleased(int key) {

        if(key==KeyEvent.VK_RIGHT)
        {
            gameEngine.getPlayer().setMovingRight(false);

        }
        if(key==KeyEvent.VK_LEFT)
        {
            gameEngine.getPlayer().setMovingLeft(false);

        }
        if(key==KeyEvent.VK_UP)
        {
            gameEngine.getPlayer().setMovingUp(false);
        }
        if(key==KeyEvent.VK_DOWN)
        {
            gameEngine.getPlayer().setMovingDown(false);
        }

        if(key==KeyEvent.VK_SPACE || key==KeyEvent.VK_B)
        {
            gameEngine.getPlayer().setShooting(false);
        }

        if(key==KeyEvent.VK_ESCAPE)
        {
            gameEngine.showMenu();
        }

    }
*/
}
