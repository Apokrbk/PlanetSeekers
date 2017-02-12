package SpaceGame.SpaceGameModel;

import java.awt.*;

/**
 * Created by Apok on 14.10.2016.
 */
public abstract class GameObject
{
    private double x;
    private double y;
    private double velX=0;
    private double velY=0;
    private int width=0;
    private int height=0;

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }



    public GameObject(double x, double y) {
        this.y = y;
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
