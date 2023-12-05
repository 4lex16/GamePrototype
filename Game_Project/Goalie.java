import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goalie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goalie extends Actor
{
    private int maxAttackCooldown = 250;
    
    private int health;
    private int attackCooldown;
    private int nextAttack;
    private int spaceFromPlayer = 400;
    public Goalie()
    {
        this.health = 30;
        this.attackCooldown = maxAttackCooldown;
        this.nextAttack = 1;
    }
    public void act()
    {
        if(attackCooldown <= 0)
        {
            if(nextAttack == 1) {attack1();attack2();this.attackCooldown = maxAttackCooldown;}
            else if(nextAttack == 2) {attack3();attack4();this.attackCooldown = maxAttackCooldown;}
            else if(nextAttack == 3) {attack1();attack3();this.attackCooldown = maxAttackCooldown;}
            else if(nextAttack == 4) {attack2();attack4();this.attackCooldown = maxAttackCooldown;}
            else if(nextAttack == 5) {attack1();attack4();this.attackCooldown = maxAttackCooldown;}
            else if(nextAttack == 6) {attack2();attack3();this.attackCooldown = maxAttackCooldown;}
            else if(nextAttack == 7) {attack5();this.attackCooldown = maxAttackCooldown*2;}
            this.nextAttack = Greenfoot.getRandomNumber(7)+1;
        }
        else {attackCooldown--;}
        die();
    }
    public void die()
    {
        Puck puck = (Puck) getOneIntersectingObject(Puck.class);
        PuckShard puckShard = (PuckShard) getOneIntersectingObject(PuckShard.class);
        if (puck!=null)
        {
            health -= 1;
            getWorld().removeObject(puck);
            if (health == 0)
            {
                getWorld().removeObject(this);
            }
        }
        if (puckShard!=null)
        {
            health -= 1;
            getWorld().removeObject(puckShard);
            if (health == 0)
            {
                getWorld().removeObject(this);
            }
        }
    }
    public void attack1()
    {
        for(int i = 0; i<6;i++)
        {
            Actor goalieMinion1 = new GoalieMinions("Attack1");
            getWorld().addObject(goalieMinion1, getWorld().getObjects(Player.class).get(0).getX() - this.spaceFromPlayer, 0 + (i*225));
        }
    }
    public void attack2()
    {
        for(int i = 0; i<6;i++)
        {
            Actor goalieMinion1 = new GoalieMinions("Attack2");
            getWorld().addObject(goalieMinion1, getWorld().getObjects(Player.class).get(0).getX() + this.spaceFromPlayer, 100 + (i*225));
        }
    }
    public void attack3()
    {
        for(int i = 0; i<20;i++)
        {
            Actor goalieMinion1 = new GoalieMinions("Attack3");
            getWorld().addObject(goalieMinion1, 0 + (i*200), getWorld().getObjects(Player.class).get(0).getY() - this.spaceFromPlayer);
        }
    }
    public void attack4()
    {
        for(int i = 0; i<20;i++)
        {
            Actor goalieMinion1 = new GoalieMinions("Attack4");
            getWorld().addObject(goalieMinion1, 100 + (i*200), getWorld().getObjects(Player.class).get(0).getY() + this.spaceFromPlayer);
        }    
    }
    public void attack5()
    {
        
        int spawnDelay = 100;
        for(int i = 0; i < 5; i++)
        {
            int playerX = getWorld().getObjects(Player.class).get(0).getX();
            int playerY = getWorld().getObjects(Player.class).get(0).getY();
            GoalieMinions minion = new GoalieMinions("Attack5");
            int randomNum = Greenfoot.getRandomNumber(4);
            if (randomNum == 0)
            {
                getWorld().addObject(minion,playerX - this.spaceFromPlayer, Greenfoot.getRandomNumber(getWorld().getHeight()));
            }
            if (randomNum == 1)
            {
                getWorld().addObject(minion,playerX  + this.spaceFromPlayer, Greenfoot.getRandomNumber(getWorld().getHeight()));
            }
            if (randomNum == 2)
            {
                getWorld().addObject(minion,Greenfoot.getRandomNumber(getWorld().getWidth()), playerY - this.spaceFromPlayer);
            }
            if (randomNum == 3)
            {
                getWorld().addObject(minion,Greenfoot.getRandomNumber(getWorld().getWidth()), playerY  + this.spaceFromPlayer );
            }
            spawnDelay = 100;
        }
    }
}
