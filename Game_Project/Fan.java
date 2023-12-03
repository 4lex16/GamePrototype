import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fan extends Ennemy
{
    public Fan()
    {
        setStats(1, 1, 300);
    }
    public void act()
    {
        goTowardsPlayer();
        eliminatePlayer();
        shoot("pizza");
        die();
    }
}
