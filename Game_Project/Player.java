import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Player extends Actor
{
    private int fire_delay = 0;
    private boolean shooting;
    private int movement_speed;
    
    
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
            if (fire_delay <= 0 && (Greenfoot.mouseClicked(null) || Greenfoot.isKeyDown("space")))
            {
                double adjacent = (mouse.getX() - getX());
                double opposite = (mouse.getY() - getY());
                
                double angleRadians = Math.atan2(opposite, adjacent);
                double angleDegrees = Math.toDegrees(angleRadians);
                
                Actor puck = new Puck();
                getWorld().addObject(puck, getX(), getY());
                puck.setRotation((int)angleDegrees);
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
        if (Greenfoot.isKeyDown("shift"))
        {
            movement_speed = 3;
        }
        else
        {
            movement_speed = 2;
        }
        if (Greenfoot.isKeyDown("w"))
        {
            setRotation(270);
            move(movement_speed);
        }
        if (Greenfoot.isKeyDown("s"))
        {
            setRotation(90);
            move(movement_speed);
        }
        if (Greenfoot.isKeyDown("a"))
        {
            setRotation(180);
            move(movement_speed);
        }
        if (Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(movement_speed);
        }
 } 

}



