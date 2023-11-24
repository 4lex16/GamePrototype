import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelTwo extends World
{
    private static int WW = 1600;
    private static int WH = 900;
    private int spawn_duration = 250;
    private int spawn_cap = 10;
    SimpleTimer tim = new SimpleTimer();
    Counter timeCount =new Counter();
    
    public GreenfootSound gfs_levelTwo_world;

    private int timer = 61;
    /**
     * Constructor for objects of class LevelTwo.
     * 
     */
    public LevelTwo(int playerHealth)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WW, WH, 1);
        prepare(playerHealth);
        //addObject(timeCount,950 , 50); 
        //timeCount.setValue(60);
        act();
        gfs_levelTwo_world = new GreenfootSound("Boss Battle #5 V2.wav");
        
    }
    
    private void prepare(int playerHealth)
    {
        Player player = new Player();
        player.setHealth(playerHealth);
        addObject(player,(WW/2),(WH/2)); 
        ExitGame exitGame = new ExitGame();
        addObject(exitGame,1490,860);
        exitGame.setLocation(1505,871);
        exitGame.setLocation(1509,868);
        exitGame.setLocation(1488,857);
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
        if(tim.millisElapsed() > 1000)
        {
            timeCount.add(-1);
            tim.mark();
            timer--;
            showText("Time left: "+ timer, 830,50);
            if(timer <= 0)
            {
                World levelTwo = this;
                levelTwo.stopped();
                World levelThree = new LevelThree(this.getObjects(Player.class).get(0).getHealth());
                levelThree.started();
                Greenfoot.setWorld (levelThree);
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
    
    public void started(){
        gfs_levelTwo_world.play();
        
    }
    
    public void stopped(){
        gfs_levelTwo_world.stop();
    }
}
