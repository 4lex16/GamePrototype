import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTwo extends World
{
    private static int WW = 1000;
    private static int WH = 800;
    private int spawn_duration = 250;
    private int spawn_cap = 10;
    SimpleTimer tim = new SimpleTimer();
    Counter timeCount =new Counter();
    private int timer = 61;
    /**
     * Constructor for objects of class LevelTwo.
     * 
     */
    public LevelTwo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WW, WH, 1);
        prepare();
        //addObject(timeCount,950 , 50); 
        //timeCount.setValue(60);
        act();
    }
    private void prepare()
    {
        Player player = new Player();
        addObject(player,(WW/2),(WH/2-200)); 
    }
    public void spawn()
    {
        int spawn_num = this.getObjects(Ennemy.class).size();
        while (spawn_num < spawn_cap && spawn_duration <= 0)
        {
            Ennemy ennemy = new Ennemy();
            addObject(ennemy,Greenfoot.getRandomNumber(WW), Greenfoot.getRandomNumber(WH));
            spawn_duration = 150;
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
                Greenfoot.stop();
            }    
        }
        spawn();
    }
}
