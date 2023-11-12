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
                World levelOne = this;
                levelOne.stopped();
                World levelTwo = new LevelTwo();
                levelTwo.started();
                Greenfoot.setWorld (new LevelTwo());
            }
        }
        spawn();
    }

    public void spawn()
    {
        int spawn_num = this.getObjects(Ennemy.class).size();
        while (spawn_num < spawn_cap && spawn_duration <= 0)
        {
            Ennemy ennemy = new Ennemy();
            int randomNum = Greenfoot.getRandomNumber(4);
            if (randomNum == 0)
            {
                addObject(ennemy,Greenfoot.getRandomNumber(WW), 0);
            }
            if (randomNum == 1)
            {
                addObject(ennemy,0, Greenfoot.getRandomNumber(WH));
            }
            if (randomNum == 2)
            {
                addObject(ennemy,Greenfoot.getRandomNumber(WW), WH);
            }
            if (randomNum == 3)
            {
                addObject(ennemy,WW, Greenfoot.getRandomNumber(WH));
            }
            spawn_duration = 150;
            spawn_num = this.getObjects(Ennemy.class).size();
        }
        spawn_duration -= 1;
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,1327,463);
    }
}
