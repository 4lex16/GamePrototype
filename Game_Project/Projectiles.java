import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Projectiles extends Actor
{
    private int projectileSpeed;
    private int projectileDirection;
    private int duration;
    
    public Projectiles(String type, int direction)
    {
        if (type == "pizza") {
            this.projectileSpeed = 4;
            this.projectileDirection = direction;
            this.duration = 200;
            this.setImage("pizza_cheese.png");
            this.setRotation(projectileDirection);
        }
        if (type == "whistle") {
            this.projectileSpeed = 5;
            this.projectileDirection = direction;
            this.duration = 150;
            this.setImage("whistle.png");
            this.setRotation(projectileDirection);
        }
    }
    public void act()
    {
        move();
        eliminatePlayer();
        delete();
    }
    public void move()
    {   
        move(this.projectileSpeed);
        /*this.setRotation(this.getRotation() + 2);
        if(this.projectileDirection >= 0 && this.projectileDirection < 90) 
        {
            this.setLocation(getX() + ((int) (this.projectileSpeed * (Math.cos(this.projectileDirection)))),
            getY() + ((int)(this.projectileSpeed * (Math.sin(this.projectileDirection)))));
        }
        else if(this.projectileDirection >= 90 && this.projectileDirection < 180) 
        {
            this.setLocation(getX() + (-1)*((int) (this.projectileSpeed * (Math.cos(this.projectileDirection)))),
            getY() + ((int)(this.projectileSpeed * (Math.sin(this.projectileDirection)))));
        }
        else if(this.projectileDirection >= 180 && this.projectileDirection < 270) 
        {
            this.setLocation(getX() + (-1)*((int) (this.projectileSpeed * (Math.cos(this.projectileDirection)))),
            getY() + (-1)*((int)(this.projectileSpeed * (Math.sin(this.projectileDirection)))));
        }
        else if(this.projectileDirection >= 270 && this.projectileDirection < 360) 
        {
            this.setLocation(getX() + ((int) (this.projectileSpeed * (Math.cos(this.projectileDirection)))),
            getY() + (-1)*((int)(this.projectileSpeed * (Math.sin(this.projectileDirection)))));
        }
        */
        
    }
    public void eliminatePlayer()
    {    
        Actor player = getOneIntersectingObject(Player.class);
        if(player != null)
        {
            if (getWorld().getObjects(Player.class).get(0).getHealth() <= 0) 
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
        if (duration < 0 || isAtEdge())
        {
            getWorld().removeObject(this);
        }
        duration -= 1;
    }
}
