import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelThree extends World
{
    private int spawn_duration = 250;
    private int spawn_cap = 10;
    private int timer = 61;
    private static int WW = 1600;
    private static int WH = 900;

    SimpleTimer tim = new SimpleTimer();
    Counter timeCount =new Counter();

    
    /**
     * Constructor for objects of class LevelThree.
     * 
     */
    public LevelThree()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WW, WH, 1); 
        prepare();
    }

    public void act()
    {  
        if(tim.millisElapsed() > 1000)
        {
            timeCount.add(-1);
            tim.mark();
            timer--;
            showText("Time left: "+ timer, 830,50);
            if(timer <= 0)
            {
                World levelThree = this;
                levelThree.stopped();
                World YouWonWorld = new YouWonWorld();
                YouWonWorld.started();
                Greenfoot.setWorld (YouWonWorld);
            }
        }
        spawn();
        if (isGameLost())
        {
            transitionToYouLostWorld();
        }
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
    
    private void prepare()
    {
        Player player = new Player();
        addObject(player,1327,463);
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
