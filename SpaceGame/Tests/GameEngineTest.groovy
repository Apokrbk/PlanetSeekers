package SpaceGame.Tests

import SpaceGame.Game
import SpaceGame.SpaceGameController.GameEngine
import SpaceGame.SpaceGameController.PlayerController
import SpaceGame.SpaceGameModel.BonusHp
import SpaceGame.SpaceGameModel.BonusMissile
import SpaceGame.SpaceGameModel.Bullet
import SpaceGame.SpaceGameModel.Enemy
import SpaceGame.SpaceGameModel.EnemyBulletHeadingGivenDirection
import SpaceGame.SpaceGameModel.EnemyBulletHeadingPlayer
import SpaceGame.SpaceGameModel.EnemyOne
import SpaceGame.SpaceGameModel.EnemyTwo
import SpaceGame.SpaceGameModel.FirstBoss
import SpaceGame.SpaceGameModel.FirstBossBomb
import SpaceGame.SpaceGameModel.Missile
import SpaceGame.SpaceGameModel.Player

import java.awt.event.KeyEvent

/**
 * Created by Apok on 13.11.2016.
 */
class GameEngineTest extends GroovyTestCase {

    void test_GivenGame_WhenPlayerIsCreated_ThenHisHpIs5() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        assertEquals(5, gameEngine.getPlayer().getHp());
    }

    void test_GivenGame_WhenPlayerIsCreated_ThenHisQuantityOfMissilesIs3() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        assertEquals(3, gameEngine.getPlayer().getQuantityOfMissiles());
    }

    void test_GivenGame_WhenLeftArrowIsPressed_ThenPlayerMovesLeft() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        double position_x_of_player_before_moving_left;
        position_x_of_player_before_moving_left = gameEngine.getPlayer().getX();
        gameEngine.keyPressed(KeyEvent.VK_LEFT);
        gameEngine.update();

        assertEquals(position_x_of_player_before_moving_left - gameEngine.getPlayer().getVelX(), gameEngine.getPlayer().getX());
    }

    void test_GivenGame_WhenRightArrowIsPressed_ThenPlayerMovesRight() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        double position_x_of_player_before_moving_right;
        position_x_of_player_before_moving_right = gameEngine.getPlayer().getX();
        gameEngine.keyPressed(KeyEvent.VK_RIGHT);
        gameEngine.update();

        assertEquals(position_x_of_player_before_moving_right + gameEngine.getPlayer().getVelX(), gameEngine.getPlayer().getX());
    }

    void test_GivenGame_WhenUpArrowIsPressed_ThenPlayerMovesUp() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        double position_y_of_player_before_moving_up;
        position_y_of_player_before_moving_up = gameEngine.getPlayer().getY();
        gameEngine.keyPressed(KeyEvent.VK_UP);
        gameEngine.update();

        assertEquals(position_y_of_player_before_moving_up - gameEngine.getPlayer().getVelY(), gameEngine.getPlayer().getY());
    }


    void test_GivenGame_WhenDownArrowIsPressed_ThenPlayerMovesDown() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        double position_y_of_player_before_moving_down;
        position_y_of_player_before_moving_down = gameEngine.getPlayer().getY();
        gameEngine.keyPressed(KeyEvent.VK_DOWN);
        gameEngine.update();

        assertEquals(position_y_of_player_before_moving_down + gameEngine.getPlayer().getVelY(), gameEngine.getPlayer().getY());
    }

    void test_GivenPlayerAtTheEdgeOfScreen_WhenTriesToMoveRight_ThenPlayerIsNotMoving()
    {
        Player player = new Player((400-Player.WIDTH_OF_PLAYER), 500);
        PlayerController controller = new PlayerController(player);
        player.isMovingRight = true;

        for(int i=0; i<10; i++)
            controller.movePlayer();

        assertEquals(400-Player.WIDTH_OF_PLAYER, player.getX());
    }

    void test_GivenPlayerAtTheEdgeOfScreen_WhenTriesToMoveLeft_ThenPlayerIsNotMoving()
    {
        Player player = new Player((0), 500);
        PlayerController controller = new PlayerController(player);
        player.isMovingLeft = true;

        for(int i=0; i<10; i++)
            controller.movePlayer();

        assertEquals(0, player.getX());
    }

    void test_GivenPlayerAtTheEdgeOfScreen_WhenTriesToMoveUp_ThenPlayerIsNotMoving()
    {
        Player player = new Player(200, 0);
        PlayerController controller = new PlayerController(player);
        player.isMovingUp = true;

        for(int i=0; i<10; i++)
            controller.movePlayer();

        assertEquals(0, player.getY());
    }

    void test_GivenPlayerAtTheEdgeOfScreen_WhenTriesToMoveDown_ThenPlayerIsNotMoving()
    {
        Player player = new Player(200, Game.HEIGHT);
        PlayerController controller = new PlayerController(player);
        player.isMovingDown = true;

        for(int i=0; i<10; i++)
            controller.movePlayer();

        assertEquals(Game.HEIGHT, player.getY());
    }

    void test_GivenGame_When_B_IsPressed_ThenPlayerHasLessMissiles() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        int quantity_before_shoot = gameEngine.getPlayer().getQuantityOfMissiles();
        gameEngine.keyPressed(KeyEvent.VK_B);
        gameEngine.update();

        assertEquals(quantity_before_shoot - 1, gameEngine.getPlayer().getQuantityOfMissiles())
    }

    void test_GivenEnemyOneAndShockwave_WhenEnemyIsInsideShockwave_ThenEnemyIsDestroyed() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        EnemyOne enemy = new EnemyOne(110, 110);

        gameEngine.addEnemy(enemy);
        gameEngine.addShockwave(100, 100);

        assertTrue(enemy.getHp() <= 0);
    }

    void test_GivenEnemyTwoAndShockwave_WhenEnemyIsInsideShockwave_ThenEnemyIsDestroyed() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        EnemyTwo enemy = new EnemyTwo(110, 110);

        gameEngine.addEnemy(enemy);
        gameEngine.addShockwave(100, 100);

        assertTrue(enemy.getHp() <= 0);
    }

    void test_GivenEnemyOneAndShockwave_WhenEnemyIsOutsideShockwave_ThenEnemyDoesNotLooseHP() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        EnemyOne enemyOne = new EnemyOne(500, 500);

        gameEngine.addEnemy(enemyOne);
        gameEngine.addShockwave(100, 100);

        assertEquals(1, enemyOne.getHp());
    }

    void test_GivenEnemyTwoAndShockwave_WhenEnemyIsOutsideShockwave_ThenEnemyDoesNotLooseHP() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        EnemyTwo enemyTwo = new EnemyTwo(100, 100);

        gameEngine.addEnemy(enemyTwo);
        gameEngine.addShockwave(280, 300);

        assertEquals(3, enemyTwo.getHp());
    }

    void test_GivenGame_WhenSpaceIsPressed_ThenBulletIsCreated() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        gameEngine.keyPressed(KeyEvent.VK_SPACE);
        gameEngine.keyReleased(KeyEvent.VK_SPACE);

        assertEquals(1, gameEngine.bullets.size());
    }

    void test_GivenGame_WhenBulletIsCreatedAndLeavesScreen_ThenBulletIsDestroyed() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        gameEngine.keyPressed(KeyEvent.VK_SPACE);
        gameEngine.keyReleased(KeyEvent.VK_SPACE);
        for (int i = 0; i < 300; i++)
            gameEngine.update();

        assertEquals(0, gameEngine.bullets.size());
    }

    void test_GivenGame_WhenPlayerCollectsBonusHpButHisHpIsMax_ThenHpIsNotIncreased() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        BonusHp bonusHp = new BonusHp(300, 300);
        gameEngine.player.setX(300);
        gameEngine.player.setY(300);

        assertTrue(gameEngine.collisionBetween(gameEngine.getPlayer(), bonusHp));
        assertEquals(5, gameEngine.player.getHp());
    }


    void test_GivenGame_WhenPlayerCollectsBonusHpButHisHpIsNotMax_ThenHpIsIncreased() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        BonusHp bonusHp = new BonusHp(300, 300);

        gameEngine.bonuses.add(bonusHp);
        gameEngine.player.setHp(4);
        gameEngine.player.setX(300);
        gameEngine.player.setY(300);
        gameEngine.updateBonuses();

        assertTrue(gameEngine.collisionBetween(gameEngine.getPlayer(), bonusHp));
        assertEquals(5, gameEngine.player.getHp());
    }

    void test_GivenGame_WhenPlayerCollectsBonusMissileButHisQuantityOfMissilesIsMax_ThenQuantityIsNotIncreased() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        BonusMissile bonusMissile = new BonusMissile(300, 300);

        gameEngine.player.setX(300);
        gameEngine.player.setY(300);
        gameEngine.update();

        assertTrue(gameEngine.collisionBetween(gameEngine.getPlayer(), bonusMissile));
        assertEquals(3, gameEngine.player.getQuantityOfMissiles());
    }

    void test_GivenGame_WhenPlayerCollectsBonusMissileButHisQuantityOfMissilesIsNotMax_ThenQuantityIsIncreased() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        BonusMissile bonusMissile = new BonusMissile(300, 300);

        gameEngine.bonuses.add(bonusMissile);
        gameEngine.player.setX(300);
        gameEngine.player.setY(300);
        gameEngine.player.setQuantityOfMissiles(2);
        gameEngine.update();

        assertTrue(gameEngine.collisionBetween(gameEngine.getPlayer(), bonusMissile));
        assertEquals(3, gameEngine.player.getQuantityOfMissiles());
    }

    void test_GivenGame_WhenEnemiesTwoAreMoving_ThenNotLeavingTheScreen() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        for (int j = 0; j < 100; j++) {
            gameEngine.addNewEnemyTwoEverySeconds(1);
            for (int i = 0; i < 500; i++) {
                gameEngine.moveEnemy(gameEngine.enemies.get(j));
                assertFalse(gameEngine.enemies.get(j).getX() < 0 || gameEngine.enemies.get(j).getX() > 350)
            }
        }
    }

    void test_GivenGame_WhenCreatingManyEnemies_ThenAllEnemiesAreCreatedOnScreen() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        for (int i = 0; i < 200; i++) {
            gameEngine.addNewEnemyOneEverySeconds(1);
        }
        for (int i = 0; i < 200; i++) {
            assertTrue(gameEngine.enemies.get(i).getX() >= 0 && gameEngine.enemies.get(i).getX() <= 350)
        }
    }

    void test_GivenGame_WhenEnemyTwoIsMoving_ThenLeavesAtTheBottom() {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        for (int j = 0; j < 100; j++) {
            gameEngine.addNewEnemyTwoEverySeconds(1);
        }
        for (int i = 0; i < 1000; i++) {
            for (Iterator<Enemy> iterator = gameEngine.enemies.iterator(); iterator.hasNext();) {
                Enemy enemy = iterator.next();
                gameEngine.moveEnemy(enemy);
            }
        }
        gameEngine.updateEnemies();
        assertEquals(1, gameEngine.enemies.size());
    }

    void test_GivenGame_WhenPlayerShootsAtEnemy_ThenHpOfEnemyIsDecreased()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        gameEngine.getPlayer().setX(100);
        gameEngine.getPlayer().setY(500);
        EnemyOne enemyOne = new EnemyOne(100,350 );
        gameEngine.addEnemy(enemyOne);

        gameEngine.keyPressed(KeyEvent.VK_SPACE);
        for(int i=0; i<200; i++)
            gameEngine.update();

        assertEquals(0,enemyOne.getHp());
    }

    void test_GivenGame_WhenEnemyBulletIsMovingAtPlayer_ThenHpOfPlayerIsDecreased()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        gameEngine.getPlayer().setX(100);
        gameEngine.getPlayer().setY(500);
        EnemyBulletHeadingGivenDirection bullet = new EnemyBulletHeadingGivenDirection(100,300, EnemyBulletHeadingGivenDirection.DOWN);
        gameEngine.addEnemyBullet(bullet);
        int howManyMovesAreNeededToHit = 200/EnemyBulletHeadingGivenDirection.VEL +1;

        for(int i=0; i<howManyMovesAreNeededToHit; i++)
            gameEngine.enemyBulletController.moveEnemyBullet(bullet);
        gameEngine.update()

        assertEquals(4,gameEngine.getPlayer().getHp());
    }

    void test_GivenGame_WhenEnemyBulletIsMovingAtPlayer2_ThenHpOfPlayerIsDecreased()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        gameEngine.getPlayer().setX(100);
        gameEngine.getPlayer().setY(500);
        EnemyBulletHeadingPlayer bullet = new EnemyBulletHeadingPlayer(300,100, gameEngine.getPlayer().getX(), gameEngine.getPlayer().getY());
        gameEngine.addEnemyBullet(bullet);
        int howManyMovesAreNeededToHit = 450/EnemyBulletHeadingPlayer.VEL_OF_ENEMYONE_BULLET +1;

        for(int i=0; i<howManyMovesAreNeededToHit; i++)
            gameEngine.enemyBulletController.moveEnemyBullet(bullet);
        gameEngine.update();

        assertEquals(4,gameEngine.getPlayer().getHp());
    }

    void test_GivenGame_WhenOneSecondPassed_ThenEnemyIsCreated()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        for(int i=0; i<61; i++)
            gameEngine.update();

        assertEquals(1, gameEngine.enemies.size())
    }

    void test_GivenGame_WhenSpaceIsPressedAndNotReleased_ThenOnlyOneBulletIsCreated()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        for(int i=0; i<15; i++)
            gameEngine.keyPressed(KeyEvent.VK_SPACE);

        assertEquals(1, gameEngine.bullets.size());
    }

    void test_GivenGame_WhenOneSecondPassedOnLevel2_ThenEnemyIsCreated()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        gameEngine.deleteAllEnemies();
        gameEngine.level1=false;
        gameEngine.level2=true;

        for(int i=0; i<61; i++)
            gameEngine.update();

        assertEquals(1, gameEngine.enemies.size())
    }

    void test_GivenGame_WhenMissileHitsEnemy_ThenShockwaveIsCreated()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        EnemyOne enemy = new EnemyOne(100,300);

        gameEngine.addEnemy(enemy);
        gameEngine.missiles.add(new Missile(100,300));
        gameEngine.update();

        assertEquals(1, gameEngine.shockwaves.size());
    }

    void test_GivenGame_WhenBulletHitsEnemy_ThenHpOfEnemyIsDecreasedBy1()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        EnemyTwo enemy = new EnemyTwo(100,300);

        gameEngine.addEnemy(enemy);
        gameEngine.bullets.add(new Bullet(100,300));
        gameEngine.update();

        assertEquals(2, enemy.getHp());
    }

    void test_GivenGame_WhenPlayerCollidesWithEnemy_ThenEnemyIsDestroyed()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        gameEngine.getPlayer().setX(200);
        gameEngine.getPlayer().setY(200);
        gameEngine.addEnemy(new EnemyOne(200,200));
        gameEngine.update();

        assertEquals(0, gameEngine.enemies.size());
    }

    void test_GivenGame_WhenPlayerCollidesWithEnemy_ThenHisHpIsDecreasedBy1()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        gameEngine.getPlayer().setX(200);
        gameEngine.getPlayer().setY(200);
        gameEngine.addEnemy(new EnemyOne(200,200));
        gameEngine.update();

        assertEquals(4, gameEngine.getPlayer().getHp());
    }

    void test_GivenGame_WhenPlayerCollidesWithFirstBoss_ThenPlayerIsDestroyed()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        gameEngine.getPlayer().setX(200);
        gameEngine.getPlayer().setY(200);
        gameEngine.level1=false;
        gameEngine.firstBossFight=true;
        gameEngine.firstBoss = new FirstBoss(200,200);
        gameEngine.update();

        assertEquals(-1, gameEngine.getPlayer().getHp());
    }

    void test_GivenGame_WhenFirstBossIsMovingDown_ThenItStops()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);
        gameEngine.level1=false;
        gameEngine.firstBossFight=true;
        gameEngine.update();

        for(int i=0; i<400; i++)
            gameEngine.firstBossController.moveFirstBoss(gameEngine.firstBoss);

        assertEquals(FirstBoss.BOSS1_POSITION_OF_STOP, gameEngine.firstBoss.getY());
    }

    void test_GivenGame_WhenFirstBossBombExplodes_ThenEightBulletsAreCreated()
    {
        Game game = new Game();
        GameEngine gameEngine = new GameEngine(game);

        gameEngine.firstBossBomb = new FirstBossBomb(300,300);
        gameEngine.firstBossController.explosionOfBomb(gameEngine.firstBossBomb);

        assertEquals(8, gameEngine.enemyBullets.size());
    }




}