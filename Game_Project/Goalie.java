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
            if(nextAttack == 1) {attack1();attack2();this.attackCooldown = maxAttackCooldown;this.nextAttack = 2;}
            else if(nextAttack == 2) {attack3();attack4();this.attackCooldown = maxAttackCooldown;this.nextAttack = 3;}
            else if(nextAttack == 3) {attack1();attack3();this.attackCooldown = maxAttackCooldown;this.nextAttack = 4;}
            else if(nextAttack == 4) {attack2();attack4();this.attackCooldown = maxAttackCooldown;this.nextAttack = 5;}
            else if(nextAttack == 5) {attack1();attack4();this.attackCooldown = maxAttackCooldown;this.nextAttack = 6;}
            else if(nextAttack == 6) {attack2();attack3();this.attackCooldown = maxAttackCooldown;this.nextAttack = 1;}
            
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
            getWorld().addObject(goalieMinion1, 100, 100 + (i*200));
        }
    }
    public void attack2()
    {
        for(int i = 0; i<6;i++)
        {
            Actor goalieMinion1 = new GoalieMinions("Attack2");
            getWorld().addObject(goalieMinion1, 1500, 150 + (i*200));
        }
    }
    public void attack3()
    {
        for(int i = 0; i<20;i++)
        {
            Actor goalieMinion1 = new GoalieMinions("Attack3");
            getWorld().addObject(goalieMinion1, 100 + (i*175), 100);
        }
    }
    public void attack4()
    {
        for(int i = 0; i<20;i++)
        {
            Actor goalieMinion1 = new GoalieMinions("Attack4");
            getWorld().addObject(goalieMinion1, 50 + (i*175), 800);
        }    
    }
}
