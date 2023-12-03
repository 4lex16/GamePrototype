import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Upgrades extends Button
{
    private int upgradeNum;
    public Upgrades()
    {
        this.upgradeNum = Greenfoot.getRandomNumber(8)+1;
        String upgrade = String.format("Upgrade%d.png", this.upgradeNum);
        GreenfootImage square = new GreenfootImage(upgrade);
        setImage(square);
    }
    public void act()
    {
        checkMouse();
    }
    public int getNum(){return this.upgradeNum;}
}
