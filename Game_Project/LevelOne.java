import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends World
{
    private static int WW = 1600;
    private static int WH = 900;
    private int spawn_duration = 100;
    private int spawn_cap = 10;
    private int timer = 61;
    private static ArrayList<Heart> hearts = new ArrayList<Heart>();
    
    SimpleTimer tim = new SimpleTimer();
    Counter timeCount =new Counter();
    int end = 0;
    
    
    public static ArrayList getHearts()
    {
        return hearts;
    }
    
    public LevelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WW, WH, 1);
        //timer
        //addObject(timeCount,950 , 50); 
        //timeCount.setValue(60);
        act();
        prepare();
        
    }
    
    
    private void prepare()
    {
        Player player = new Player();
        addObject(player,(WW/2),(WH/2));
        ExitGame exitGame2 = new ExitGame();
        addObject(exitGame2,1509,878);
        exitGame2.setLocation(1500,866);
        /*
        ArrayList<Heart> hearts = new ArrayList<Heart>();
        for (int i = 0; i < 3; i++)
        {
            Heart heart = new Heart();
            hearts.add(heart);
            addObject(heart, (100 + (60*i)), 50);
        }
        */
    }
    public void spawn()
    {
        int spawn_num = this.getObjects(Ennemy.class).size();
        while (spawn_num < spawn_cap && spawn_duration <= 0)
        {
            Fan fan = new Fan();
            Media media = new Media();
            int randomNum = Greenfoot.getRandomNumber(4);
            if (randomNum == 0)
            {
                randomNum = Greenfoot.getRandomNumber(2);
                if (randomNum == 0)
                {
                    addObject(fan,Greenfoot.getRandomNumber(WW), 0);
                }
                if (randomNum == 1)
                {
                    addObject(media,Greenfoot.getRandomNumber(WW), 0);
                }
            }
            if (randomNum == 1)
            {
                randomNum = Greenfoot.getRandomNumber(2);
                if (randomNum == 0)
                {
                    addObject(fan,0, Greenfoot.getRandomNumber(WH));
                }
                if (randomNum == 1)
                {
                    addObject(media,0, Greenfoot.getRandomNumber(WH));
                }
            }
            if (randomNum == 2)
            {
                randomNum = Greenfoot.getRandomNumber(2);
                if (randomNum == 0)
                {
                    addObject(fan,Greenfoot.getRandomNumber(WW), WH);
                }
                if (randomNum == 1)
                {
                    addObject(media,Greenfoot.getRandomNumber(WW), WH);
                }
            }
            if (randomNum == 3)
            {
                randomNum = Greenfoot.getRandomNumber(2);
                if (randomNum == 0)
                {
                    addObject(fan,WW, Greenfoot.getRandomNumber(WH));
                }
                if (randomNum == 1)
                {
                    addObject(media,WW, Greenfoot.getRandomNumber(WH));
                }
            }
            spawn_duration = 200;
            spawn_num = this.getObjects(Ennemy.class).size();
        }
        spawn_duration -= 1;
    }
    
    public void act()
    {  
        setPaintOrder(Player.class, Puck.class);
        if(tim.millisElapsed() > 1000)
        {
            timeCount.add(-1);
            tim.mark();
            timer--;
            showText("Time left: "+ timer, 830,50);
            if(timer <= 0)
            {
                World levelOne = this;
                levelOne.stopped();
                World levelTwo = new LevelTwo();
                levelTwo.started();
                Greenfoot.setWorld (new LevelTwo());
            }
        }
        
        spawn();
        if (isGameLost())
        {
            transitionToYouLostWorld();
        }
    }
    
    public boolean isGameLost()
    {
        if(this.getObjects(Player.class).isEmpty())
        {
            return true;
        }
        else
        {    
            return false;
        } 
    }
    
    public void transitionToYouLostWorld()
    {
        this.stopped();
        World YouLostWorld = new YouLostWorld();
        YouLostWorld.started();
        Greenfoot.setWorld(YouLostWorld);
    }
    
}
    
   
        
        
        


   
    
      
    
    
