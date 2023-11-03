import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movement();
        aim();
    }
    public void aim()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null)
        {
            if (Greenfoot.mouseClicked(null))
            {
                
                double adjacent = (mouse.getX() - getX());
                double opposite = (mouse.getY() - getY());
                
                double angleRadians = Math.atan2(opposite, adjacent);
                double angleDegrees = Math.toDegrees(angleRadians);
                
                Actor puck = new Puck();
                getWorld().addObject(puck, getX(), getY());
                puck.setRotation((int)angleDegrees);
            }
        }
    } 
    public void movement()
    {
        if (Greenfoot.isKeyDown("w"))
        {
            setRotation(270);
            move(2);
        }
        if (Greenfoot.isKeyDown("s"))
        {
            setRotation(90);
            move(2);
        }
        if (Greenfoot.isKeyDown("a"))
        {
            setRotation(180);
            move(2);
        }
        if (Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(2);
        }
    }
}
