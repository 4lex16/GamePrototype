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
    private int timer = 60;

    
    
    /**
     * Constructor for objects of class LevelOne.
     * 
     */
    public LevelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WW, WH, 1);
        //timer
        
        
        prepare();
        
    }
    
    
    private void prepare()
    {
        Player player = new Player();
        addObject(player,(WW/2-200),(WH/2));
        Ennemy ennemy = new Ennemy();
        addObject(ennemy,(WW/2+200),(WH/2));    
 
    }
    

   
    
    
    }   
    
    
