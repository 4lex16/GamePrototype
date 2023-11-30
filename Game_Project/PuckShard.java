import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PuckShard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuckShard extends Actor
{
    private int duration;
    private int acceleration;
    public PuckShard()
    {
        this.acceleration = 75;
        this.duration = 100;
    }
    public void act()
    {
        if (acceleration >= 0)
        {
            move(1 * acceleration/25);
        }
        puckDuration();
    }
    public void puckDuration()
    {
        duration -= 1;
        acceleration -= 1;
        if (duration < 0 || isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
