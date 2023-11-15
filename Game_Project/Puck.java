import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Puck extends Actor
{
    private int duration = 200;
    private int acceleration = 75;
    private int rotation = getRotation();
    
    public void act()
    {
        if (acceleration >= 0)
        {
            move(3 * acceleration/25);
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
