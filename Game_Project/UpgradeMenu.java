import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class UpgradeMenu extends World
{

    private static int WW = 1600;
    private static int WH = 900;
    private int playerHealth = 3;
    private String nextLevel = "levelTwo";
    
    private boolean gainHealth = false;
    private boolean fasterMovementSpeed = false;
    private boolean longerInvincibility = false;
    private boolean splitPuck = false;
    private boolean fasterPuck = false;
    private boolean biggerPuck = false;
    private boolean pierceEnnemy = false;
    private boolean multiplePuck = false;
    private boolean longerLastingPuck = false;
    
    public UpgradeMenu(
            int playerHealth, String nextLevel,
            boolean gainHealth, boolean fasterMovementSpeed, boolean longerInvincibility,
            boolean splitPuck, boolean fasterPuck, boolean biggerPuck,
            boolean pierceEnnemy, boolean multiplePuck, boolean longerLastingPuck
    )
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WW, WH, 1);
        prepare();
        this.playerHealth = playerHealth;
        this.nextLevel = nextLevel;
    }
    private void prepare()
    {
        Continue cont = new Continue();
        addObject(cont,WW/2,WH-200);
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
            this.pierceEnnemy,
            this.multiplePuck,
            this.longerLastingPuck
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
            this.pierceEnnemy,
            this.multiplePuck,
            this.longerLastingPuck
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
    }
}