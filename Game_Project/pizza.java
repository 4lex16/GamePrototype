import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class pizza extends Actor
{
    private int duration = 200;
    public void act()
    {
        move(2);
        delete();
    }
    public void delete()
    {
        if (duration < 0 || isAtEdge())
        {
            getWorld().removeObject(this);
        }
        duration -= 1;
    }
}
