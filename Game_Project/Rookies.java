import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rookies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rookies extends Ennemy
{
    private boolean constructed = false;
    public void act()
    {
           if (constructed == false)
        {
            setStats(1, 3, 300);
            constructed = true;
        }
        goTowardsPlayer();
        eliminatePlayer();
        die();
    }
}
