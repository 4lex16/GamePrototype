import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Puck extends Actor
{
    private int duration;
    private int acceleration;
    private int rotation = getRotation();
    private boolean splitPuck;
    private boolean pierceEnnemy;
    private boolean biggerPuck;
    
    public Puck(
            boolean splitPuck, boolean fasterPuck,
            boolean pierceEnnemy, boolean longerLastingPuck
    )
    {
        this.duration = longerLastingPuck ? 300 : 200;
        this.acceleration = fasterPuck ? 100 : 75;
        this.splitPuck = splitPuck;
        this.pierceEnnemy = pierceEnnemy;
        this.biggerPuck = biggerPuck;
    }
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
            splitPuck();
            getWorld().removeObject(this);
        }
    }
    public void splitPuck()
    {
        if(this.splitPuck)
        {
            PuckShard puckShard1 = new PuckShard();
            puckShard1.setRotation(45);
            getWorld().addObject(puckShard1, getX(), getY());
            PuckShard puckShard2 = new PuckShard();
            puckShard2.setRotation(135);
            getWorld().addObject(puckShard2, getX(), getY());
            PuckShard puckShard3 = new PuckShard();
            puckShard3.setRotation(225);
            getWorld().addObject(puckShard3, getX(), getY());
            PuckShard puckShard4 = new PuckShard();
            puckShard4.setRotation(315);
            getWorld().addObject(puckShard4, getX(), getY());
        }
    }
    public void biggerPuck()
    {
        this.getImage().scale(20, 20);
    }
    public void pierceEnnemy()
    {
        if(this.pierceEnnemy)
        {
        
        }

    }
    
}
