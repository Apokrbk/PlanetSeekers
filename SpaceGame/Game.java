package SpaceGame;

import SpaceGame.SpaceGameController.HowToPlay;
import SpaceGame.SpaceGameController.Menu;
import SpaceGame.SpaceGameController.Controller;
import SpaceGame.SpaceGameController.GameEngine;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Apok on 14.10.2016.
 */
public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 700;
    private final String TITLE = "Planet Seekers";
    private Thread thread;
    private boolean running = false;
    private BufferedImage background;
    private int i = -800;
    private Controller gameEngine = new Menu(this, 0);
    private Font font = new Font("Calibri", 0, 36);
    private Color color = new Color(121, 134, 124);
    private KeyInput keyInput = new KeyInput(gameEngine);



    public static void main(String[] args) {
        Game game = new Game();
       // MusicPlayer musicPlayer = new MusicPlayer("WoodyWoodpecker");


        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        game.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        game.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //musicPlayer.start();
        game.start();

    }


    private synchronized void start() {

        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    private synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    private void init() {
        requestFocus();
        addKeyListener(keyInput);
        try {
            background = ImageIO.read(getClass().getResource("/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void update()
    {
        gameEngine.update();
    }

    public void render() {
        if (i >= -1) i = -800;
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        i += 3;
        g.drawImage(background, 0, i, null);
        g.setFont(font);
        g.setColor(color);
        gameEngine.render(g);
        g.dispose();
        bs.show();

    }

    public void changeController(int w) {
        int score = gameEngine.getScore();
        removeKeyListener(keyInput);
        if (w == 1) gameEngine = new HowToPlay(this);
        else if (w == 0) gameEngine = new Menu(this, score);
        else if (w == 2) gameEngine = new GameEngine(this);
        keyInput = new KeyInput(gameEngine);
        addKeyListener(keyInput);
    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        //int updates = 0;
        //int frames = 0;
        long timer = System.currentTimeMillis();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                update();
                //updates++;
                render();
                delta--;
            }

            //frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS:" + updates + "   Render:" + frames );
                //updates = 0;
                //frames = 0;
            }
        }
        stop();

    }


}
