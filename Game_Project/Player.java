import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Player extends Actor
{
    private int fire_delay = 0;
    private boolean shooting;
    SimpleTimer tim = new SimpleTimer();
    
    public void act()
    {
        movement();
        aim();
        isLevelFinished();
            
        
        
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
            move(5);
        }
        if (Greenfoot.isKeyDown("s"))
        {
            setRotation(90);
            move(5);
        }
        if (Greenfoot.isKeyDown("a"))
        {
            setRotation(180);
            move(5);
        }
        if (Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(5);
        }
    }

    public void isLevelFinished(){
        World world = getWorld();
        if(tim.millisElapsed() == -5000){
        World levelOne = getWorld();
        levelOne.stopped();
        World levelTwo = new LevelTwo();
        levelTwo.started();
        Greenfoot.setWorld (new LevelTwo());
            
        
    
    }
}
   
public void transitionTolevelTwo(){
        World levelOne = getWorld();
        levelOne.stopped();
        World levelTwo = new LevelTwo();
        levelTwo.started();
        Greenfoot.setWorld(levelTwo);
    
    }
    

}



