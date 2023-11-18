import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class pizza extends Actor
{
    private int duration = 200;
    public void act()
    {
        move(2);
        eliminatePlayer();
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
    
    public void eliminatePlayer()
    {    
        Actor player = getOneIntersectingObject(Player.class);
        if(player != null)
        {
            if (getWorld().getObjects(Player.class).get(0).getHealth() <= 0) 
            {
                World world = getWorld();
                world.removeObject(player);
            }
            else
            {
                getWorld().getObjects(Player.class).get(0).loseHealth();
            }
        } 
    }
}

