import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouWonWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWonWorld extends World
{
    public GreenfootSound gfs_YouWonWorld;

    /**
     * Constructor for objects of class YouWonWorld.
     * 
     */
    public YouWonWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1); 
        showTextWithBigWhiteFont("YOU ARE THE WINNER", 250,450);
        prepare();
        gfs_YouWonWorld = new GreenfootSound("Ending.wav");
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
        addObject(exitGame,1499,821);
        exitGame.setLocation(1488,859);
    }
    
    public void started(){
        gfs_YouWonWorld.playLoop();
    
    }
    
    public void stopped(){
        gfs_YouWonWorld.stop();
    
    }
}
