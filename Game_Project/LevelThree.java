import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelThree extends World
{
    private static int WW = 1600;
    private static int WH = 900;
    private int spawn_duration = 100;
    private int spawn_cap = 10;
    
    private boolean bossSpawn = false;
    // Sound
    public GreenfootSound gfs_levelThree_world;
    // Timer
    SimpleTimer tim = new SimpleTimer();
    Counter timeCount =new Counter();
    private int timer = 60;
    
    public LevelThree(
        int playerHealth, 
        boolean gainHealth, boolean fasterMovementSpeed, boolean longerInvincibility,
        boolean splitPuck, boolean fasterPuck, boolean biggerPuck,
        boolean multiplePuck, boolean longerLastingPuck, boolean fasterShooting)
    {
        super(WW, WH, 1);
        gfs_levelThree_world = new GreenfootSound("Boss Battle #2 V2.wav");
        prepare(playerHealth, gainHealth, fasterMovementSpeed,
        longerInvincibility, splitPuck, fasterPuck,
        biggerPuck, multiplePuck, longerLastingPuck,
        fasterShooting);
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
            biggerPuck,multiplePuck, longerLastingPuck,
            fasterShooting
        );
        addObject(player,1327,463);
        ExitGame exitGame = new ExitGame();
        addObject(exitGame,1441,863);
        exitGame.setLocation(1510,861);
        exitGame.setLocation(1473,862);
        exitGame.setLocation(1481,863);
    }
    public void act()
    {
        this.setPaintOrder(Goalie.class, GoalieMinions.class);
        if(tim.millisElapsed() > 1000)
        {
            if(timer >= 0)
            {
                timeCount.add(-1);
                tim.mark();
                timer--;
                showText("Time left: "+ timer, 830,50);
            }
            if (!this.bossSpawn && timer <= 30)
            {
                int e = getObjects(Ennemy.class).size();
                for(int i = 0; i < e;i++) {this.removeObject(this.getObjects(Ennemy.class).get(0));}
                this.addObject(new Goalie(), 800, 200);
                this.bossSpawn = true;
            }
            if(bossSpawn && this.getObjects(Goalie.class).size() == 0)
            {
                transitionToYouWonWorld();
            }
        }
        if (isGameLost())
        {
            transitionToYouLostWorld();
        }
        if(!this.bossSpawn)
        {spawn();}
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
    public void transitionToYouWonWorld()
    {
        World levelThree = this;
        levelThree.stopped();
        World YouWonWorld = new YouWonWorld();
        YouWonWorld.started();
        Greenfoot.setWorld (YouWonWorld);
    }
    public void started(){
        gfs_levelThree_world.playLoop();
    }
    public void stopped(){
        gfs_levelThree_world.stop();
    }
    public void spawn()
    {
        int spawn_num = this.getObjects(Ennemy.class).size();
        while (spawn_num < spawn_cap && spawn_duration <= 0)
        {
            ContendingTeam contendingTeam = new ContendingTeam();
            int randomNum = Greenfoot.getRandomNumber(4);
            if (randomNum == 0)
            {
                addObject(contendingTeam,Greenfoot.getRandomNumber(WW), 0);
            }
            if (randomNum == 1)
            {
                addObject(contendingTeam,0, Greenfoot.getRandomNumber(WH));
            }
            if (randomNum == 2)
            {
                addObject(contendingTeam,Greenfoot.getRandomNumber(WW), WH);
            }
            if (randomNum == 3)
            {
                addObject(contendingTeam,WW, Greenfoot.getRandomNumber(WH));
            }
            spawn_duration = Greenfoot.getRandomNumber(50) + 150;
            spawn_num = this.getObjects(Ennemy.class).size();
        }
        spawn_duration -= 1;
    }
}
