import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Player extends Actor
{
    private int fire_delay = 0;
    private boolean shooting;
    private int movement_speed;
    
    
    public void act()
    {
        aim();
        movement();
    }
    
    public void aim()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null)
        {
            if (fire_delay <= 0 && (Greenfoot.mouseClicked(null) || Greenfoot.isKeyDown("space")))
            {   
                double adjacent = (mouse.getX() - getX());
                double opposite = (mouse.getY() - getY());
                
                double angleRadians = Math.atan2(opposite, adjacent);
                double angleDegrees = Math.toDegrees(angleRadians);
                
                Actor puck = new Puck();
                getWorld().addObject(puck, getX(), getY());
                puck.setRotation((int) angleDegrees);
                fire_delay = 50;
            }
            else
            {
                fire_delay -= 1;
            }
        }
    }
    
    public void movement()
    {
        if ((Greenfoot.mouseClicked(null) || Greenfoot.isKeyDown("space")))
        {
            movement_speed = 1;
        }
        else
        {
            movement_speed = 3;
        }
        if (Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - movement_speed);
        }
        if (Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + movement_speed);
        }
        if (Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - movement_speed, getY());
        }
        if (Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + movement_speed, getY());
        }
    } 

}




