import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class UpgradeMenu extends World
{

    private static int WW = 1600;
    private static int WH = 900;
    
    private int playerHealth;
    private String nextLevel;
    private boolean gainHealth = false;
    private boolean fasterMovementSpeed = false;
    private boolean longerInvincibility = false;
    private boolean splitPuck = false;
    private boolean fasterPuck = false;
    private boolean biggerPuck = false;
    private boolean multiplePuck = false;
    private boolean longerLastingPuck = false;
    private boolean fasterShooting = false;
    
    private ArrayList<Upgrades> Upgrades_List = new ArrayList<Upgrades>();
    
    public UpgradeMenu(
            int playerHealth, String nextLevel,
            boolean gainHealth, boolean fasterMovementSpeed, boolean longerInvincibility,
            boolean splitPuck, boolean fasterPuck, boolean biggerPuck,
            boolean multiplePuck, boolean longerLastingPuck, boolean fasterShooting
    )
    {
        super(WW, WH, 1);
        prepare();
        this.playerHealth = playerHealth;
        this.nextLevel = nextLevel;
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
    private void prepare()
    {
        Continue cont = new Continue();
        addObject(cont,WW/2,WH-200);
        selectUpgrade();
    }
    public void transitionWorld()
    {
        if(nextLevel == "levelTwo")
        {
            World levelTwo = new LevelTwo(
            this.playerHealth,
            this.gainHealth,
            this.fasterMovementSpeed,
            this.longerInvincibility,
            this.splitPuck,
            this.fasterPuck,
            this.biggerPuck,
            this.multiplePuck,
            this.longerLastingPuck,
            this.fasterShooting
        );
            this.stopped();
            levelTwo.started();
            Greenfoot.setWorld(levelTwo);
        }
        if(nextLevel == "levelThree")
        {
            World levelThree = new LevelThree(
            this.playerHealth,
            this.gainHealth,
            this.fasterMovementSpeed,
            this.longerInvincibility,
            this.splitPuck,
            this.fasterPuck,
            this.biggerPuck,
            this.multiplePuck,
            this.longerLastingPuck,
            this.fasterShooting
        );
            this.stopped();
            levelThree.started();
            Greenfoot.setWorld(levelThree);
        }
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this.getObjects(Continue.class).get(0)))
        {
            transitionWorld();
        }
        if (Greenfoot.mouseClicked(this.getObjects(Upgrades.class).get(0)))
        {
            int upgradeNum = this.getObjects(Upgrades.class).get(0).getNum();
            chooseUpgrade(upgradeNum);
            transitionWorld();
        }
        if (Greenfoot.mouseClicked(this.getObjects(Upgrades.class).get(1)))
        {
            int upgradeNum = this.getObjects(Upgrades.class).get(1).getNum();
            chooseUpgrade(upgradeNum);
            transitionWorld();
        }
        if (Greenfoot.mouseClicked(this.getObjects(Upgrades.class).get(2)))
        {
            int upgradeNum = this.getObjects(Upgrades.class).get(2).getNum();
            chooseUpgrade(upgradeNum);
            transitionWorld();
        }
    }
    public void selectUpgrade()
    {
        for(int i = 0; i<3; i++)
        {
            Upgrades upgrades = (Upgrades) new Upgrades();
            Upgrades_List.add(upgrades);
            this.addObject(Upgrades_List.get(i), (WW*(i+1))/4, WH/2);
        }
    }
    public void chooseUpgrade(int upgradeNum)
    {
        if(upgradeNum == 1) {this.gainHealth = true;}
        if(upgradeNum == 2) {this.fasterMovementSpeed = true;}
        if(upgradeNum == 3) {this.longerInvincibility = true;}
        if(upgradeNum == 4) {this.multiplePuck = true;}
        if(upgradeNum == 5) {this.biggerPuck = true;}
        if(upgradeNum == 6) {this.fasterShooting = true;}
        if(upgradeNum == 7) {this.splitPuck = true;}
        if(upgradeNum == 8) {this.fasterPuck = true;}
        if(upgradeNum == 9) {this.longerLastingPuck = true;}
    }
}