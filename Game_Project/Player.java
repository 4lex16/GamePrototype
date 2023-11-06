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
    private int fire_delay = 0;
    private boolean shooting;
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
            //fire_delay <= 0 && (!(Greenfoot.mouseDragEnded(null)) || Greenfoot.mouseClicked(null))
            if (fire_delay <= 0 && (Greenfoot.mouseClicked(null) || Greenfoot.isKeyDown("space")))
            {
                double adjacent = (mouse.getX() - getX());
                double opposite = (mouse.getY() - getY());
                
                double angleRadians = Math.atan2(opposite, adjacent);
                double angleDegrees = Math.toDegrees(angleRadians);
                
                Actor puck = new Puck();
                getWorld().addObject(puck, getX(), getY());
                puck.setRotation((int)angleDegrees);
                fire_delay = 100;
            }
            else
            {
                fire_delay -= 1;
            }
        }
    } 
    public void movement()
    {
        if (Greenfoot.isKeyDown("w"))
        {
            setRotation(270);
            move(1);
        }
        if (Greenfoot.isKeyDown("s"))
        {
            setRotation(90);
            move(1);
        }
        if (Greenfoot.isKeyDown("a"))
        {
            setRotation(180);
            move(1);
        }
        if (Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(1);
        }
    }
}
