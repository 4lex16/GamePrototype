import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
public class Player extends Actor
{
    private int fire_delay = 0;
    private boolean shooting;
    private int movement_speed;
    private int health = 3;
    private int invincibilityFrames = 0;
    private int invincibilityFramesDuration = 50;
    private static ArrayList<Heart> hearts = new ArrayList<Heart>();
    
    // Booleans for Upgrades
    private boolean gainHealth = false;
    private boolean fasterMovementSpeed = false;
    private boolean longerInvincibility = false;
    private boolean splitPuck = false;
    private boolean fasterPuck = false;
    private boolean biggerPuck = false;
    private boolean pierceEnnemy = false;
    private boolean multiplePuck = false;
    private boolean longerLastingPuck = false;
    
    
    public boolean getGainHealth() {return this.gainHealth;}
    public boolean getFasterMovementSpeed() {return this.fasterMovementSpeed;}
    public boolean getLongerInvincibility() {return this.longerInvincibility;}
    public boolean getSplitPuck() {return this.splitPuck;}
    public boolean getFasterPuck() {return this.fasterPuck;}
    public boolean getBiggerPuck() {return this.biggerPuck;}
    public boolean getPierceEnnemy() {return this.pierceEnnemy;}
    public boolean getMultiplePuck() {return this.multiplePuck;}
    public boolean getLongerLastingPuck() {return this.longerLastingPuck;}
    
    
    private String playerDirection = "characterR.png";
    
    public Player(
        int health,
        boolean gainHealth, boolean fasterMovementSpeed, boolean longerInvincibility,
        boolean splitPuck, boolean fasterPuck, boolean biggerPuck,
        boolean pierceEnnemy, boolean multiplePuck, boolean longerLastingPuck
    )
    {
        this.health = health;
        this.gainHealth = gainHealth;
        this.fasterMovementSpeed = fasterMovementSpeed;
        this.longerInvincibility = longerInvincibility;
        this.splitPuck = splitPuck;
        this.fasterPuck = fasterPuck;
        this.biggerPuck = biggerPuck;
        this.pierceEnnemy = pierceEnnemy;
        this.multiplePuck = multiplePuck;
        this.longerLastingPuck = longerLastingPuck;
    }
    public void act()
    {
        aim();
        movement();
        setNormal();
        invincibilityFrames -= 1;
        updateHeart(this.health);
    }
    public int getHealth()
    {
        return health;
    }
    public void setHealth(int health)
    {
        this.health = health;
    }
    public void setNormal()
    {
        if (invincibilityFramesDuration < 0) 
        {
            this.setImage(playerDirection);
        }
        else
        {
            invincibilityFramesDuration -=1;
        } 
    }
    public void transparency()
    {
        if (invincibilityFramesDuration < 0) 
        {
            invincibilityFramesDuration = 50;
            this.setImage("Gray_Circle.png");
        }     
    }
    public void loseHealth()
    {
        if (invincibilityFrames < 0)
        {
            transparency();
            this.health -=1;
            //hearts.remove(hearts.size() - 1);
            invincibilityFrames = 50;
        }
    }
    public void aim()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null)
        {
            if (fire_delay <= 0 && (Greenfoot.mouseClicked(null) || Greenfoot.isKeyDown("space")))
            {   
                double adjacent = (mouse.getX() - getX());
                double opposite = (mouse.getY() - getY());
                
                double angleRadians = Math.atan2(opposite, adjacent);
                double angleDegrees = Math.toDegrees(angleRadians);
                
                Actor puck = new Puck();
                getWorld().addObject(puck, getX(), getY());
                puck.setRotation((int) angleDegrees);
                fire_delay = 50;
            }
            else
            {
                fire_delay -= 1;
            }
        }
    }
    
    public void movement()
    {
        if ((Greenfoot.mouseClicked(null) || Greenfoot.isKeyDown("space")))
        {
            movement_speed = 1;
        }
        else
        {
            movement_speed = 3;
        }
        if (Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - movement_speed);
        }
        if (Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + movement_speed);
        }
        if (Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - movement_speed, getY());
            playerDirection = "characterL.png";
        }
        if (Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + movement_speed, getY());
            playerDirection = "characterR.png";
        }
    } 
    public void updateHeart(int numHearts)
    {
        getWorld().removeObjects(hearts);
        for (int i = 0; i < numHearts; i++)
        {
            Heart heart = new Heart();
            hearts.add(heart);
            getWorld().addObject(heart, (100 + (60*i)), 50);
        }
    }
}




