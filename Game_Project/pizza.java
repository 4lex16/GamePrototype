import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class pizza extends Actor
{
    private int duration = 200;
    public void act()
    {
        move(2);
        eliminatePlayer();
        if (isGameLost())
        {
            transitionToYouLostWorld();
        }
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
      var Player = getOneIntersectingObject(Player.class);
      if(Player != null)
        { 
           World world = getWorld();
           world.removeObject(Player);
           
        }
      
      
      }
    
      public boolean isGameLost()
   {
    World world = getWorld();
    if(world.getObjects(Player.class).isEmpty())
        {
            return true;
    }else{    
            return false;
        } 
   }
    
    public void transitionToYouLostWorld()
    {
        getWorld().stopped();
        World YouLostWorld = new YouLostWorld();
        YouLostWorld.started();
        Greenfoot.setWorld(YouLostWorld);
    
    }
    
}

