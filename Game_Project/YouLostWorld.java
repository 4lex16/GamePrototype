import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouLostWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouLostWorld extends World
{
    public GreenfootSound gfs_YouLost_world;
    /**
     * Constructor for objects of class YouLostWorld.
     * 
     */
    public YouLostWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1); 
        showTextWithBigWhiteFont("You Lost", 550,450);
        gfs_YouLost_world = new GreenfootSound("prologue.wav");
        prepare();
        
    }

    public void showTextWithBigWhiteFont(String message, int x, int y)
    {
        var  bg = getBackground(); 
        Font font = new Font(110);
        bg.setFont(font);
        bg.setColor(Color.WHITE);
        bg.drawString(message,x, y);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ExitGame exitGame = new ExitGame();
        addObject(exitGame,1442,835);
        exitGame.setLocation(1492,861);
    }
    
    public void started(){
        gfs_YouLost_world.playLoop();
    
    }
    
    public void stopped(){
        gfs_YouLost_world.stop();
    }
}

