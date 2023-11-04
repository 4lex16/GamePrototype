import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Puck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puck extends Actor
{
    /**
     * Act - do whatever the Puck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int duration = 300;
    public void act()
    {
        move(1);
        duration -= 1;
        if (duration < 0)
        {
            getWorld().removeObject(this);
        }
    }
}
