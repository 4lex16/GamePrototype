import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private static int WW = 1000;
    private static int WH = 800;
    private static int spawn_delay = 10;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(WW, WH, 1);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,(WW/2-200),(WH/2));
        Ennemy ennemy = new Ennemy();
        addObject(ennemy,(WW/2+200),(WH/2));
        if (spawn_delay <= 0)
        {
            Ennemy ennemy1 = new Ennemy();
            addObject(ennemy1,(WW/2+200),(WH/2));
            spawn_delay = 10;
        }
        else
        {
            spawn_delay -= 1;
        }
        
    }
}
