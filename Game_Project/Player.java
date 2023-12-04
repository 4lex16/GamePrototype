import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
public class Player extends Actor
{
    private int fire_delay = 0;
    private boolean shooting;
    private int movement_speed;
    private int maxHealth = 3;
    private int health;
    private int invincibilityFrames = 0;
    private int invincibilityFramesDuration = 50;
    private static ArrayList<Heart> hearts = new ArrayList<Heart>();
    
    // Booleans for Upgrades
    private boolean gainHealth;
    private boolean fasterMovementSpeed;
    private boolean longerInvincibility;
    private boolean multiplePuck;
    private boolean biggerPuck;
    private boolean fasterShooting;
    private boolean splitPuck;
    private boolean fasterPuck;
    private boolean longerLastingPuck;
    
    
    public boolean getGainHealth() {return this.gainHealth;}
    public boolean getFasterMovementSpeed() {return this.fasterMovementSpeed;}
    public boolean getLongerInvincibility() {return this.longerInvincibility;}
    public boolean getSplitPuck() {return this.splitPuck;}
    public boolean getFasterPuck() {return this.fasterPuck;}
    public boolean getBiggerPuck() {return this.biggerPuck;}
    public boolean getMultiplePuck() {return this.multiplePuck;}
    public boolean getLongerLastingPuck() {return this.longerLastingPuck;}
    public boolean getFasterShooting() {return this.fasterShooting;}
    
    private String playerDirection = "characterR.png";
    
    public Player(
        int health,
        boolean gainHealth, boolean fasterMovementSpeed, boolean longerInvincibility,
        boolean splitPuck, boolean fasterPuck, boolean biggerPuck,
        boolean multiplePuck, boolean longerLastingPuck, boolean fasterShooting
    )
    {
        this.health = health;
        this.gainHealth = gainHealth;
        this.fasterMovementSpeed = fasterMovementSpeed;
        this.longerInvincibility = longerInvincibility;
        this.splitPuck = splitPuck;
        this.fasterPuck = fasterPuck;
        this.biggerPuck = biggerPuck;
        this.multiplePuck = multiplePuck;
        this.longerLastingPuck = longerLastingPuck;
        this.fasterShooting = fasterShooting;
    }
    public Player()
    {
        this.health = maxHealth;
        this.gainHealth = true;
        this.fasterMovementSpeed = true;
        this.longerInvincibility = true;
        this.splitPuck = true;
        this.fasterPuck = true;
        this.biggerPuck = true;
        this.multiplePuck = true;
        this.longerLastingPuck = true;
        this.fasterShooting = true;
    }
    public void act()
    {
        methodgainHealth();
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
            invincibilityFramesDuration = longerInvincibility ? 100 : 50;
            this.setImage("Gray_Circle.png");
        }     
    }
    public void loseHealth()
    {
        if (invincibilityFrames < 0)
        {
            transparency();
            this.health -=1;
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
                
                if(this.multiplePuck)
                {
                    Puck puck1 = new Puck(this.splitPuck, this.fasterPuck, this.longerLastingPuck);
                    Puck puck2 = new Puck(this.splitPuck, this.fasterPuck, this.longerLastingPuck);
                    if (this.biggerPuck)
                    {
                        puck1.biggerPuck();
                        puck2.biggerPuck();
                    }
                    getWorld().addObject(puck1, getX(), getY());
                    getWorld().addObject(puck2, getX(), getY());
                    puck1.setRotation((int) angleDegrees + Greenfoot.getRandomNumber(15));
                    puck2.setRotation((int) angleDegrees - Greenfoot.getRandomNumber(15));
                    fire_delay = this.fasterShooting ? 35: 50;
                }
                else
                {
                    Puck puck = new Puck(this.splitPuck, this.fasterPuck, this.longerLastingPuck);
                    if (this.biggerPuck)
                    {
                        puck.biggerPuck();
                    }
                    getWorld().addObject(puck, getX(), getY());
                    puck.setRotation((int) angleDegrees);
                    fire_delay = this.fasterShooting ? 35 : 50;
                }   
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
            movement_speed = this.fasterMovementSpeed ? 2 : 1;
        }
        else
        {
            movement_speed = this.fasterMovementSpeed ? 5 : 4;
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
    public void methodgainHealth()
    {
        if(this.gainHealth)
        {
            this.maxHealth += 1;
            this.health += 1;
            gainHealth = false;
        }
    }
}




