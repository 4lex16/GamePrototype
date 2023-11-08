import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Puck extends Actor
{
    private int duration = 100;
    public void act()
    {
        move(3);
        puckDuration();
    }
    public void puckDuration()
    {
        duration -= 1;
        if (duration < 0)
        {
            getWorld().removeObject(this);
        }
    }
}
