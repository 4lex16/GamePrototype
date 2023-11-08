import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ennemy extends Actor
{
    private int playerX;
    private int playerY;
    private int health = 2;
    private int fire_delay = 300;
    
    
    public void act()
    {
        goTowardsPlayer();
        shoot();
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
    public void shoot(){
        if (fire_delay <= 0)
        {
            double adjacent = (playerX - getX());
            double opposite = (playerY - getY());
                    
            double angleRadians = Math.atan2(opposite, adjacent);
            double angleDegrees = Math.toDegrees(angleRadians);
            
            Actor pizza = new pizza();
            getWorld().addObject(pizza, this.getX(), this.getY());
            pizza.setRotation((int)angleDegrees);
            fire_delay = 300;
        }
        else
        {
            fire_delay -=1;
        }
    }
}
