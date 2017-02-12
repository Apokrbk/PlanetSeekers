package SpaceGame.SpaceGameController;
import SpaceGame.Game;
import SpaceGame.SpaceGameModel.*;
import SpaceGame.SpaceGameView.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Random;
import static java.lang.Thread.sleep;

public class GameEngine extends Controller
{
    private static final int SCORE_POSITION_X = 230;
    private static final int RADIUS_OF_SHOCKWAVE = 200;
    private static final int SCORE_OF_BOSS1_FIGHT = 20;
    private static final int BONUS_MISSILE_EVERY_SECONDS = 10;
    private static final int BONUS_HP_EVERY_SECONDS = 12;
    private static final int SCORE_FOR_KILLING_BOSS1 = 20;
    private static final int BOSS1_BOMB_POSITION_Y_OF_EXPLOSION = 400;
    private static final double VEL_Y_OF_BONUS = 2;
    private static final double SPEED_OF_SHOCKWAVE_ANIMATION = 0.6;
    private static final int SCORE_POSITION_Y = 700;

    public Player getPlayer() {
        return player;
    }

    private Player player;
    private ArrayList<Bullet>  bullets = new ArrayList<>();
    private ArrayList<Missile> missiles = new ArrayList<>();
    private ArrayList<Enemy>  enemies = new ArrayList<>();
    private ArrayList<EnemyBullet> enemyBullets = new ArrayList<>();
    private ArrayList<Shockwave> shockwaves = new ArrayList<>();
    private ArrayList<Explosion> explosions = new ArrayList<>();
    private ArrayList<Bonus> bonuses = new ArrayList<>();
    private Game game;
    private boolean firstBossFight =false;
    private boolean level1 = true;
    private boolean level2 = false;
    private FirstBoss firstBoss;
    private FirstBossBomb firstBossBomb;
    private int timer = 0;

    private PlayerController playerController;
    private EnemyController enemyController;
    private EnemyOneController enemyOneController;
    private EnemyTwoController enemyTwoController;
    private FirstBossController firstBossController;
    private EnemyBulletController enemyBulletController;
    private MainView mainView;

    public GameEngine(Game game)
    {
        this.game = game;
        player = new Player();
        playerController = new PlayerController(player);
        enemyOneController = new EnemyOneController(enemyBullets);
        enemyTwoController = new EnemyTwoController(enemyBullets, player);
        firstBossController = new FirstBossController(player, enemyBullets);
        enemyBulletController = new EnemyBulletController();
        enemyController = new EnemyController();
        mainView = new MainView(this);
    }

    public void update()
     {
         checkIfGameOver();
         addBonusMissileEverySeconds(BONUS_MISSILE_EVERY_SECONDS);
         addBonusHpEverySeconds(BONUS_HP_EVERY_SECONDS);
         timer++;
         turnOnBossFightModeWhenScoreIs(SCORE_OF_BOSS1_FIGHT);
         if(firstBossFight)
         {
             boss1fight();
             updateBoss1Bomb();
         }
             playerController.movePlayer();
             updateBullets();
             updateEnemies();
             updateEnemyBullets();
             updateExplosionsOfEnemies();
             updateShockwaves();
             updateMissiles();
             updateBonuses();

    }

    private void turnOnBossFightModeWhenScoreIs(int score) {
        if(getScore()>score && getScore()<score+5)
        {
            deleteAllEnemies();
            firstBossFight = true;
            level1 = false;
        }
    }

    private boolean collisionBetween(GameObject elem1, GameObject elem2)
    {
        Rectangle r1 = new Rectangle((int)elem1.getX(), (int)elem1.getY(), elem1.getWidth(), elem1.getHeight());
        Rectangle r2 = new Rectangle((int)elem2.getX(), (int)elem2.getY(), elem2.getWidth(), elem2.getHeight());
        return r1.intersects(r2);
    }

    private void boss1fight() {
        if(firstBoss == null)
            firstBoss = new FirstBoss();
        if(collisionBetween(firstBoss, player))
            player.setHp(-1);
        firstBossController.moveFirstBoss(firstBoss);
        firstBossController.firstBossShoot(timer, firstBoss);
        firstBossShootBomb();
        if(firstBoss.getHp()<=0)
        {
            setScore(getScore()+ SCORE_FOR_KILLING_BOSS1);
            firstBossFight = false;
            level2 = true;
            addBigExplosion(firstBoss.getX(), firstBoss.getY(), 3, 6);
            firstBoss = null;
        }
    }
    private void firstBossShootBomb()
    {
        if(givenSecondsPassed(6))
        {
            if(firstBossBomb==null)
                firstBossBomb = new FirstBossBomb(firstBoss.getX()+ firstBoss.getWidth()/2, firstBoss.getY()+ firstBoss.getHeight());
        }
    }

    private boolean givenSecondsPassed(int seconds)
    {
       return (timer!=0 && timer%(60*seconds)==0);
    }

    private void updateBoss1Bomb()
    {
        if(firstBossBomb !=null)
        {
            firstBossBomb.setY(firstBossBomb.getY()+ firstBossBomb.getVelY());
            if(firstBossBomb.getY()>= BOSS1_BOMB_POSITION_Y_OF_EXPLOSION)
            {
                firstBossController.explosionOfBomb(firstBossBomb);
                firstBossBomb = null;
            }
        }
    }

    private void addBigExplosion(double x, double y, int rows, int collumns) {
        for(int i=0; i<rows; i++)
            for(int j=0; j<collumns; j++)
                addExplosionOfEnemy(x+j*35,y+i*35);
    }

    private void addBonusHpEverySeconds(int seconds) {
        if(timer%(60*seconds)==0 && timer!=0)
            addBonusHp();
    }

    private void addBonusMissileEverySeconds(int seconds) {
        if(timer%(60*seconds)==0 && timer!=0)
        {
            addBonusMissile();
        }
    }

    private void deleteAllEnemies()
    {
        for(Enemy enemy :enemies)
            enemy.setHp(0);

    }

    private void checkIfGameOver() {
        if(player.getHp() <= 0)
        {
            try {
                sleep(500);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            showMenu();
        }
    }

    private void updateBonuses() {
        Bonus bonus;
        for(Iterator<Bonus> iterator = bonuses.iterator(); iterator.hasNext();)
        {
            if(iterator.hasNext())
            {bonus = iterator.next();
                if(bonus.getY()>Game.HEIGHT)
                    iterator.remove();
                else if(collisionBetween(bonus, player))
                {
                    playerController.playerCollectedBonus(bonus);
                    iterator.remove();
                }
                else  bonus.setY(bonus.getY()+ VEL_Y_OF_BONUS);}
        }
    }

    private void addEnemyBullet(EnemyBullet enemyBullet)
    {
        enemyBullets.add(enemyBullet);
    }

    private void addBonusMissile() {
        Random r = new Random();
        bonuses.add(new BonusMissile((r.nextInt(300)+50),-50));
    }

    private void addBonusHp()
    {
        Random r = new Random();
        bonuses.add(new BonusHp((r.nextInt(300)+50),-50));
    }
    public void render(Graphics g)
    {

        mainView.getPlayerView().render(g);
        mainView.getHealthBarView().render(g, player.getHp());
        mainView.getQuantityOfMissilesView().render(g, player.getQuantityOfMissiles());

        mainView.renderPlayersBullets(g, bullets);
        mainView.renderPlayersMissiles(g, missiles);
        mainView.renderShockwaves(g, shockwaves);
        mainView.renderEnemies(g, enemies);
        mainView.renderEnemyOneBullets(g, enemyBullets);
        mainView.renderExplosions(g,explosions);
        mainView.renderBonuses(g, bonuses);
        showScoreOnScreen(g);
        if(firstBossFight) {
            mainView.getBoss1View().render(g, firstBoss.getX(), firstBoss.getY());
            if(firstBossBomb !=null)
             mainView.getBoss1BombView().render(g, (int) firstBossBomb.getX(), (int) firstBossBomb.getY());

        }
    }

    private void updateShockwaves() {

        for(Iterator<Shockwave> iterator = shockwaves.iterator(); iterator.hasNext();)
        {
            Shockwave shockwave = iterator.next();
            shockwave.setStateOfAnimation(shockwave.getStateOfAnimation()+ SPEED_OF_SHOCKWAVE_ANIMATION);
            if(shockwave.getStateOfAnimation()>=15)
                iterator.remove();
        }

    }


    private void showMenu() {
        game.changeController(0);
    }


    private void updateMissiles()
    {
        Missile missile;
        for(Iterator<Missile> iterator = missiles.iterator(); iterator.hasNext();)
        {
            if(iterator.hasNext())
            {missile = iterator.next();
                if(missile.getY()<0 || missileHitEnemy(missile) || (firstBossFight && missileHitBoss1(missile)))
                    iterator.remove();
                else  missile.setY(missile.getY()+missile.getVelY());}
        }
    }

    private boolean missileHitBoss1(Missile missile) {
        if(collisionBetween(firstBoss, missile)) {
            firstBoss.setHp(firstBoss.getHp() - FirstBoss.HP_TAKEN_FROM_BOSS_WHEN_HIT_BY_MISSILE);
            addShockwave(firstBoss.getX()+(0.5)* firstBoss.getWidth(), firstBoss.getY()+(0.5)* firstBoss.getHeight());
            return true;
        }
        else
            return false;
    }

    private boolean missileHitEnemy(Missile missile)
    {
        for (Enemy enemy : enemies) {
            if(collisionBetween(enemy, missile)){
                addShockwave(enemy.getX()+(0.5)*enemy.getWidth(), enemy.getY()+(0.5)*enemy.getHeight());
                return true;
            }
        }
        return false;
    }

    private void addShockwave(double x, double y) {

        shockwaves.add(new Shockwave(x-RADIUS_OF_SHOCKWAVE, y-RADIUS_OF_SHOCKWAVE));
        Ellipse2D.Double shockwave = new Ellipse2D.Double(x-RADIUS_OF_SHOCKWAVE, y-RADIUS_OF_SHOCKWAVE, 2*RADIUS_OF_SHOCKWAVE, 2*RADIUS_OF_SHOCKWAVE);
        enemyController.checkIfEnemyIsInsideShockwave(shockwave, enemies, firstBossFight, firstBoss);

    }


    private void showScoreOnScreen(Graphics g) {
        g.drawString("SCORE: "+Integer.toString(getScore()), SCORE_POSITION_X, SCORE_POSITION_Y);
    }

    private void addEnemy(Enemy enemy)
    {
        enemies.add(enemy);
    }

    private void updateBullets()

    {
        Bullet bullet;
        for(Iterator<Bullet> iterator = bullets.iterator(); iterator.hasNext();)
        {
            if(iterator.hasNext())
            {
                try {
                    bullet = iterator.next();
                    if (bullet.getY() < 0 || bulletHitEnemy(bullet) || (firstBossFight && bulletHitBoss1(bullet)))
                        iterator.remove();
                    else {
                        bullet.setY(bullet.getY() + bullet.getVelY());
                    }
                }
                catch (ConcurrentModificationException ignored)
                {
                    break;
                }
            }
        }
    }



    private boolean bulletHitBoss1(Bullet bullet) {
        if(collisionBetween(firstBoss, bullet))
        {
            firstBoss.setHp(firstBoss.getHp()-1);
            return true;
        }
        else return false;
    }

    private boolean bulletHitEnemy(Bullet bullet) {

        Enemy enemy;
        for (Enemy enemy1 : enemies) {
            enemy = enemy1;
            if (collisionBetween(bullet, enemy)) {
                enemy.setHp(enemy.getHp() - 1);
                return true;
            }





        }

        return false;
    }

    private void updateEnemies()
    {
        Enemy enemy;
        if(level2)
            addNewEnemyTwoEverySeconds(1);
        if(level1)
            addNewEnemyOneEverySeconds(1);
        for(Iterator<Enemy> iterator = enemies.iterator(); iterator.hasNext();)
        {
            enemy = iterator.next();
            enemyShootEverySeconds(enemy,1);
            moveEnemy(enemy);
            removeEnemyIfNecessary(enemy, iterator);
        }
    }

    private void removeEnemyIfNecessary(Enemy enemy, Iterator<Enemy> iterator) {
        if(enemy.getY()>=Game.HEIGHT)
        {
            setScore(getScore()-1);
            iterator.remove();
        }
        else if(enemy.getHp()<=0)
        {
            setScore(getScore()+1);
            addExplosionOfEnemy(enemy.getX(), enemy.getY());
            iterator.remove();
        }
        else if(collisionBetween(player, enemy))
        {
            setScore(getScore()+1);
            player.setHp(player.getHp()-1);
            addExplosionOfEnemy(enemy.getX(), enemy.getY());
            iterator.remove();
        }
    }

    private void enemyShootEverySeconds(Enemy enemy, double seconds) {
        if(timer%60*seconds == 0)
        {
            if(enemy instanceof EnemyTwo)
                enemyTwoController.enemyTwoShoot(enemy);
            else if(enemy instanceof EnemyOne)
                enemyOneController.enemyOneShoot(enemy, player);
        }
    }

    private void addNewEnemyTwoEverySeconds(double seconds) {
        Random r = new Random();
        if(timer%(60*seconds) == 0 && !firstBossFight)
        {
            addEnemy(new EnemyTwo(r.nextInt(300)+50, -100));
        }
    }

    private void addNewEnemyOneEverySeconds(double seconds)
    {
        Random r = new Random();
        if(timer%(60*seconds) == 0 && !firstBossFight)
        {
            addEnemy(new EnemyOne(r.nextInt(300)+50, -100));
        }
    }

    private void moveEnemy(Enemy enemy)
    {
        if(enemy instanceof EnemyTwo)
        {
            enemyTwoController.moveEnemyTwo(enemy);
        }
        else if(enemy instanceof EnemyOne)
        {
            enemyOneController.moveEnemyOne(enemy);
        }
    }


    private void updateEnemyBullets()
    {
        for(Iterator<EnemyBullet> iterator = enemyBullets.iterator(); iterator.hasNext();)
        {
            EnemyBullet enemyBullet;
            enemyBullet = iterator.next();
            enemyBulletController.moveEnemyBullet(enemyBullet);
            if(collisionBetween(player, enemyBullet))
            {
                iterator.remove();
                player.setHp(player.getHp()-1);
            }
            else if(enemyBulletController.isEnemyBulletOutsideScreen(enemyBullet))
            {
                iterator.remove();
            }
        }
    }

    private void addExplosionOfEnemy(double x, double y)
    {
        Explosion explosion;
        explosion = new Explosion(x, y);
        explosions.add(explosion);
    }

    private void updateExplosionsOfEnemies()
    {
        Explosion explosion;
        for(Iterator<Explosion> iterator = explosions.iterator(); iterator.hasNext();)
        {
            explosion = iterator.next();
            explosion.increaseAnimation();
            if(explosion.getStateOfAnimation()>=15)
                iterator.remove();
        }
    }


    public void keyPressed(int key) {
        if(key==KeyEvent.VK_RIGHT)
        {
            player.setMovingRight(true);

        }
        if(key==KeyEvent.VK_LEFT)
        {
            player.setMovingLeft(true);

        }
        if(key==KeyEvent.VK_UP)
        {
            player.setMovingUp(true);
        }
        if(key==KeyEvent.VK_DOWN)
        {
            player.setMovingDown(true);
        }
        if(key==KeyEvent.VK_SPACE && !player.isShooting())
        {
            player.setShooting(true);
            playerController.playerShootBullet(bullets);
        }

        if(key==KeyEvent.VK_B && !player.isShooting())
        {
            player.setShooting(true);
            if(player.getQuantityOfMissiles()>0)
            {
                playerController.playerShootMissile(missiles);
            }
        }

    }

    public void keyReleased(int key) {

        if(key==KeyEvent.VK_RIGHT)
        {
            player.setMovingRight(false);

        }
        if(key==KeyEvent.VK_LEFT)
        {
            player.setMovingLeft(false);

        }
        if(key==KeyEvent.VK_UP)
        {
            player.setMovingUp(false);

        }
        if(key==KeyEvent.VK_DOWN)
        {
            player.setMovingDown(false);

        }

        if(key==KeyEvent.VK_SPACE || key==KeyEvent.VK_B)
        {
            player.setShooting(false);
        }

        if(key==KeyEvent.VK_ESCAPE)
        {
            showMenu();
        }

    }

}
