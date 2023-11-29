import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class YouLostWorld extends World
{
    public GreenfootSound gfs_YouLost_world;
    
    public YouLostWorld()
    {
        super(1600, 900, 1);
        gfs_YouLost_world = new GreenfootSound("prologue.wav");
        prepare();
        
    }
    private void prepare()
    {
        ExitGame exitGame = new ExitGame();
        addObject(exitGame,1442,835);
        exitGame.setLocation(1492,861);
        showTextWithBigWhiteFont("You Lost", 550,450);
    }
    public void showTextWithBigWhiteFont(String message, int x, int y)
    {
        var  bg = getBackground(); 
        Font font = new Font(110);
        bg.setFont(font);
        bg.setColor(Color.WHITE);
        bg.drawString(message,x, y);
    }
    public void started(){
        gfs_YouLost_world.playLoop();
    
    }
    public void stopped(){
        gfs_YouLost_world.stop();
    }
}

