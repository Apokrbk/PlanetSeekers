package SpaceGame.SpaceGameModel;

/**
 * Created by Apok on 14.10.2016.
 */
public class Enemy extends GameObject {

    private int hp;

    Enemy(int x, int y)
    {
        super(x,y);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


}
