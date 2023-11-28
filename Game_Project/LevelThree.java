import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelThree extends World
{
    private int spawn_duration = 250;
    private int spawn_cap = 10;
    private int timer = 11;
    private static int WW = 1600;
    private static int WH = 900;
    public GreenfootSound gfs_levelThree_world;
    

    SimpleTimer tim = new SimpleTimer();
    Counter timeCount =new Counter();

    
    /**
     * Constructor for objects of class LevelThree.
     * 
     */
    public LevelThree(int playerHealth)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WW, WH, 1); 
        //act();
        gfs_levelThree_world = new GreenfootSound("Boss Battle #2 V2.wav");
        prepare(playerHealth);
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
            ContendingTeam contendingTeam = new ContendingTeam();
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
                    addObject(contendingTeam,Greenfoot.getRandomNumber(WW), 0);
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
                    addObject(contendingTeam,0, Greenfoot.getRandomNumber(WH));
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
                    addObject(contendingTeam,Greenfoot.getRandomNumber(WW), WH);
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
                    addObject(contendingTeam,WW, Greenfoot.getRandomNumber(WH));
                }
            }
            spawn_duration = 200;
            spawn_num = this.getObjects(Ennemy.class).size();
        }
        spawn_duration -= 1;
    }
    
    private void prepare(int playerHealth)
    {
        Player player = new Player();
        player.setHealth(playerHealth);
        addObject(player,1327,463);
        ExitGame exitGame = new ExitGame();
        addObject(exitGame,1441,863);
        exitGame.setLocation(1510,861);
        exitGame.setLocation(1473,862);
        exitGame.setLocation(1481,863);
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
        gfs_levelThree_world.playLoop();
    }
    
    public void stopped(){
        gfs_levelThree_world.stop();
    }
}
