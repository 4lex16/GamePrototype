import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ContendingTeam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContendingTeam extends Ennemy
{
    private boolean constructed = false;
    public void act()
    {
            if (constructed == false)
        {
            setStats(3, 6, 300);
            constructed = true;
        }
        collision();
        goTowardsPlayer();
        eliminatePlayer();
        die();
    
    }
}