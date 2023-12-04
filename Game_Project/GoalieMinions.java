import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoalieMinions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoalieMinions extends Actor
{
    private int duration = 300;
    private String attackPattern;
    public GoalieMinions(String attackPattern)
    {
        this.attackPattern = attackPattern;
        if(this.attackPattern.equals("Attack1")) {this.duration = 250;}
        else if(this.attackPattern.equals("Attack2")) {this.duration = 250;}
        else if(this.attackPattern.equals("Attack3")) {this.duration = 200;}
        else if(this.attackPattern.equals("Attack4")) {this.duration = 200;}
    }
    public void act()
    {
        if(this.attackPattern.equals("Attack1")) {move(5);}
        else if(this.attackPattern.equals("Attack2")) {move(-5);}
        else if(this.attackPattern.equals("Attack3")) {move(4);this.setRotation(90);}
        else if(this.attackPattern.equals("Attack4")) {move(-4);this.setRotation(90);}
        eliminatePlayer();
        delete();
    }
    public void eliminatePlayer()
    {    
        Actor player = getOneIntersectingObject(Player.class);
        if(player != null)
        {
            if (getWorld().getObjects(Player.class).get(0).getHealth() <= 1) 
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
    public void delete()
    {
        if (duration <= 0)
        {
            getWorld().removeObject(this);
        } else {duration--;}   
    }
    
}
