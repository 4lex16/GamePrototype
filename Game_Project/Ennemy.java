import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ennemy extends Actor
{
    private int playerX;
    private int playerY;
    
    private int movement_speed;
    private int health;
    private int set_fire_delay;
    private int fire_timer;
    
    public void setStats(int movement_speed, int health, int set_fire_delay)
    {
        this.movement_speed = movement_speed;
        this.health = health;
        this.set_fire_delay = set_fire_delay;
        fire_timer = set_fire_delay;
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
        if(!(getWorld().getObjects(Player.class).isEmpty()))
        {
            playerX = getWorld().getObjects(Player.class).get(0).getX();
            playerY = getWorld().getObjects(Player.class).get(0).getY();
            turnTowards(playerX, playerY);
            move(movement_speed);
        }
    }
    
    public void shoot()
    {
        if (fire_timer <= 0)
        {
            double adjacent = (playerX - getX());
            double opposite = (playerY - getY());
                    
            double angleRadians = Math.atan2(opposite, adjacent);
            double angleDegrees = Math.toDegrees(angleRadians);
            
            Actor pizza = new pizza();
            getWorld().addObject(pizza, this.getX(), this.getY());
            pizza.setRotation((int)angleDegrees);
            fire_timer = this.set_fire_delay;
        }
        else
        {
            fire_timer -=1;
        }
    }
    
    public void eliminatePlayer()
    {    
        Actor player = getOneIntersectingObject(Player.class);
        if(player != null)
        { 
           World world = getWorld();
           world.removeObject(player);
        } 
    }
}
