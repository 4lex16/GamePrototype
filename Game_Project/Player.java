import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
public class Player extends Actor
{
    private int fire_delay = 0;
    private boolean shooting;
    private int movement_speed;
    private int health = 3;
    private int invincibilityFrames = 0;
    private int invincibilityFramesDuration = 50;
    
    
    public void act()
    {
        aim();
        movement();
        setNormal();
        invincibilityFrames -= 1;
    }
    public int getHealth()
    {
        return health;
    }
    public void setNormal()
    {
        if (invincibilityFramesDuration < 0) 
        {
            this.setImage("Dark_Circle.png");
        }
        else
        {
            invincibilityFramesDuration -=1;
        } 
    }
    public void transparency()
    {
        if (invincibilityFramesDuration < 0) 
        {
            invincibilityFramesDuration = 50;
            this.setImage("Gray_Circle.png");
        }     
    }
    public void loseHealth()
    {
        if (invincibilityFrames < 0)
        {
            ArrayList<Heart> hearts = LevelOne.getHearts();
            transparency();
            this.health -=1;
            //hearts.remove(hearts.size() - 1);
            invincibilityFrames = 50;
        }
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




