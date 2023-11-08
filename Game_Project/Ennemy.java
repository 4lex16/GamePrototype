import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ennemy extends Actor
{
    private int playerX;
    private int playerY;
    private int health = 2;
    
    
    public void act()
    {
        goTowardsPlayer();
        die();
    }
    public void die()
    {
        if (isTouching(Puck.class))
        {
            health -= 1;
            getWorld().removeObject(getOneIntersectingObject(Puck.class));
            if (health == 0)
            {
                getWorld().removeObject(this);
            }
        }
    }
    public void goTowardsPlayer()
    {
        playerX = getWorld().getObjects(Player.class).get(0).getX();
        playerY = getWorld().getObjects(Player.class).get(0).getY();
        turnTowards(playerX, playerY);
        move(1);
    }
}
