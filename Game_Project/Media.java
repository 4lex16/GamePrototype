import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Media here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Media extends Ennemy
{
    private boolean constructed = false;
    public void act()
    {
        if (constructed == false)
        {
            setStats(2, 2, 0);
            constructed = true;
        }
        goTowardsPlayer();
        eliminatePlayer();
        die();
    }
}
