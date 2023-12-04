import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelTwo extends World
{
    private static int WW = 1600;
    private static int WH = 900;
    private int spawn_duration = 100;
    private int spawn_cap = 10;
    // Sound
    public GreenfootSound gfs_levelTwo_world;
    // Timer
    SimpleTimer tim = new SimpleTimer();
    Counter timeCount =new Counter();
    private int timer = 60;
    
    public LevelTwo(
        int playerHealth,
        boolean gainHealth, boolean fasterMovementSpeed, boolean longerInvincibility,
        boolean splitPuck, boolean fasterPuck, boolean biggerPuck,
        boolean multiplePuck, boolean longerLastingPuck,
        boolean fasterShooting)
    {
        super(WW, WH, 1);
        setPaintOrder(Player.class, Puck.class);
        prepare(playerHealth, gainHealth, fasterMovementSpeed,
        longerInvincibility, splitPuck, fasterPuck,
        biggerPuck, multiplePuck, longerLastingPuck, fasterShooting);
        gfs_levelTwo_world = new GreenfootSound("Boss Battle #5 V2.wav");
        
    }
    
    private void prepare(
        int playerHealth,
        boolean gainHealth, boolean fasterMovementSpeed, boolean longerInvincibility,
        boolean splitPuck, boolean fasterPuck, boolean biggerPuck,
        boolean multiplePuck, boolean longerLastingPuck,
        boolean fasterShooting)
    {
        Player player = new Player(
            playerHealth, gainHealth, fasterMovementSpeed,
            longerInvincibility, splitPuck, fasterPuck,
            biggerPuck, multiplePuck, longerLastingPuck,
            fasterShooting
        );
        addObject(player,(WW/2),(WH/2)); 
        ExitGame exitGame = new ExitGame();
        addObject(exitGame,1490,860);
        exitGame.setLocation(1505,871);
        exitGame.setLocation(1509,868);
        exitGame.setLocation(1488,857);
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
                transitionToUM();
            }    
        }
        if (isGameLost())
        {
            transitionToYouLostWorld();
        }
        spawn();
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
    
    public void transitionToUM()
    {
        World UM = new UpgradeMenu(
        this.getObjects(Player.class).get(0).getHealth(),
        "levelThree",
        this.getObjects(Player.class).get(0).getGainHealth(),
        this.getObjects(Player.class).get(0).getFasterMovementSpeed(),
        this.getObjects(Player.class).get(0).getLongerInvincibility(),
        this.getObjects(Player.class).get(0).getSplitPuck(),
        this.getObjects(Player.class).get(0).getFasterPuck(),
        this.getObjects(Player.class).get(0).getBiggerPuck(),
        this.getObjects(Player.class).get(0).getMultiplePuck(),
        this.getObjects(Player.class).get(0).getLongerLastingPuck(),
        this.getObjects(Player.class).get(0).getFasterShooting()
        );
        this.stopped();
        UM.started();
        Greenfoot.setWorld(UM);
    }

    
    public void started(){
        gfs_levelTwo_world.playLoop();
        
    }
    
    public void stopped(){
        gfs_levelTwo_world.stop();
    }
    
    public void spawn()
    {
        int spawn_num = this.getObjects(Ennemy.class).size();
        while (spawn_num < spawn_cap && spawn_duration <= 0)
        {
            Coach coach = new Coach();
            Rookies rookies = new Rookies();
            int randomNum = Greenfoot.getRandomNumber(4);
            if (randomNum == 0)
            {
                randomNum = Greenfoot.getRandomNumber(2);
                if (randomNum == 0)
                {
                    addObject(coach,Greenfoot.getRandomNumber(WW), 0);
                }
                if (randomNum == 1)
                {
                    addObject(rookies,Greenfoot.getRandomNumber(WW), 0);
                }
            }
            if (randomNum == 1)
            {
                randomNum = Greenfoot.getRandomNumber(2);
                if (randomNum == 0)
                {
                    addObject(coach,0, Greenfoot.getRandomNumber(WH));
                }
                if (randomNum == 1)
                {
                    addObject(rookies,0, Greenfoot.getRandomNumber(WH));
                }
            }
            if (randomNum == 2)
            {
                randomNum = Greenfoot.getRandomNumber(2);
                if (randomNum == 0)
                {
                    addObject(coach,Greenfoot.getRandomNumber(WW), WH);
                }
                if (randomNum == 1)
                {
                    addObject(rookies,Greenfoot.getRandomNumber(WW), WH);
                }
            }
            if (randomNum == 3)
            {
                randomNum = Greenfoot.getRandomNumber(2);
                if (randomNum == 0)
                {
                    addObject(coach,WW, Greenfoot.getRandomNumber(WH));
                }
                if (randomNum == 1)
                {
                    addObject(rookies,WW, Greenfoot.getRandomNumber(WH));
                }
            }
            spawn_duration = Greenfoot.getRandomNumber(50) + 125;
            spawn_num = this.getObjects(Ennemy.class).size();
        }
        spawn_duration -= 1;
    }
}
