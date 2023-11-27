import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelOne extends World
{
    private static int WW = 1600;
    private static int WH = 900;
    private int spawn_duration = 100;
    private int spawn_cap = 10;
    private int timer = 11;
    
    
    SimpleTimer tim = new SimpleTimer();
    Counter timeCount =new Counter();
    int end = 0;
    private boolean timerEnded;
    public GreenfootSound gfs_levelOne_world;
    
    public LevelOne()
    {
        super(WW, WH, 1);
        //act();
        prepare();
        setPaintOrder(Player.class, Puck.class);
        gfs_levelOne_world = new GreenfootSound("boss_battle_8_retro_01_loop.wav");
    
    }
    private void prepare()
    {
        Player player = new Player();
        addObject(player,(WW/2),(WH/2));
        ExitGame exitGame2 = new ExitGame();
        addObject(exitGame2,1509,878);
        exitGame2.setLocation(1500,866);
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
                World levelOne = this;
                levelOne.stopped();
                World LevelTwo = new LevelTwo(2);
                LevelTwo.started();
                Greenfoot.setWorld (LevelTwo);
            }
        }
        if (!timerEnded)
        {
            spawn();
        }
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
        
        Greenfoot.setWorld(YouLostWorld);
    }
    
    
    public void transitionToLevelTwo()
    {
        if (this.getObjects(Ennemy.class).size() - 1 <= 0)
        {
            World levelOne = this;
            World levelTwo = new LevelTwo(this.getObjects(Player.class).get(0).getHealth());
            levelOne.stopped();
            levelTwo.started();
            Greenfoot.setWorld(levelTwo);
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
    
    public void stopped(){
        gfs_levelOne_world.stop();
        
    
    }
    
    public void started(){
        gfs_levelOne_world.playLoop();
    }
}
    
   
        
        
        


   
    
      
    
    
