import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends World
{
    private static int WW = 1000;
    private static int WH = 800;
    private int timer = 61;
    //private int timer = 0;
    SimpleTimer tim = new SimpleTimer();
    Counter timeCount =new Counter();
    int end = 0;
    /**
     * Constructor for objects of class LevelOne.
     * 
     */
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
        addObject(player,(WW/2-200),(WH/2));
        Ennemy ennemy = new Ennemy();
        addObject(ennemy,(WW/2+200),(WH/2));    

    }
    
    public void act(){  
     if(tim.millisElapsed() > 1000){
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
    }
}    
        
        
        


   
    
      
    
    
