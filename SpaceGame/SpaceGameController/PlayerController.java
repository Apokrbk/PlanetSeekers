package SpaceGame.SpaceGameController;

import SpaceGame.Game;
import SpaceGame.SpaceGameModel.*;

import java.util.ArrayList;

/**
 * Created by Apok on 27.12.2016.
 */
public class PlayerController {

    private Player player;

    PlayerController(Player player)
    {
        this.player = player;
    }

    void movePlayer()
    {
        if(player.isMovingDown()&& player.getY()< Game.HEIGHT-player.getHeight())
            player.setY(player.getY()+player.getVelY());

        if(player.isMovingUp()&& player.getY()>0)
            player.setY(player.getY()-player.getVelY());

        if(player.isMovingLeft()&& player.getX()>0)
            player.setX(player.getX()-player.getVelX());

        if(player.isMovingRight()&& player.getX()<Game.WIDTH-player.getWidth())
            player.setX(player.getX()+player.getVelX());
    }

    void playerShootBullet(ArrayList<Bullet> bullets)
    {
        Bullet bullet;
        bullet = new Bullet(player.getX()+player.getWidth()/2-5, player.getY()-20);
        bullets.add(bullet);
    }

    void playerShootMissile(ArrayList<Missile> missiles)
    {
        player.setQuantityOfMissiles(player.getQuantityOfMissiles()-1);
        Missile missile;
        missile = new Missile(player.getX()+player.getWidth()/2-5, player.getY()-20);
        missiles.add(missile);
    }

   void playerCollectedBonus(Bonus bonus)
    {
        if(bonus instanceof BonusMissile && player.getQuantityOfMissiles()< Player.STARTING_QUANTITY_OF_MISSILES)
            player.setQuantityOfMissiles(player.getQuantityOfMissiles()+1);
        if(bonus instanceof BonusHp && player.getHp()< Player.STARTING_HP)
            player.setHp(player.getHp()+1);
    }
}
