package SpaceGame.Music;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import javax.sound.sampled.*;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * Created by Apok on 07.11.2016.
 */
public class MusicPlayer implements Runnable{

    private ArrayList<String> musicFiles;
    private Thread thread;
    private boolean running = false;
    public MusicPlayer(String... files)
    {
        musicFiles = new ArrayList<String>();
        for(String file: files)
            musicFiles.add(file+".wav");
    }
    private void playSound(String fileName)
    {
        try{
            URL soundFile = getClass().getResource(fileName);
            InputStream is = soundFile.openStream();
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip)AudioSystem.getLine(info);
            clip.open(ais);
            clip.start();
        }catch (Exception e){ e.printStackTrace();}
    }

    @Override
    public void run() {
        while(true) {
           // playSound("/darude.wav");
            try
            {
                thread.sleep(195000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public synchronized void start() {
        if(!running){
            running = true;
        thread = new Thread(this);
        thread.start();}
    }

    public synchronized void stop()
    {
            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

    }
}
