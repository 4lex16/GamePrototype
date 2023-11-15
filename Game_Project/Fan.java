import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fan extends Ennemy
{
    private boolean constructed = false;
    public void act()
    {
        if (constructed == false)
        {
            setStats(1, 3, 300);
            constructed = true;
        }
        collision();
        goTowardsPlayer();
        eliminatePlayer();
        shoot();
        die();
    }
}
