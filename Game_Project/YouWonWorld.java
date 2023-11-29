import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class YouWonWorld extends World
{
    public GreenfootSound gfs_YouWon_world;

    public YouWonWorld()
    {
        super(1600, 900, 1);
        gfs_YouWon_world = new GreenfootSound("Ending.wav");
        prepare();
    }
    private void prepare()
    {
        ExitGame exitGame = new ExitGame();
        addObject(exitGame,1499,821);
        exitGame.setLocation(1488,859);
        showTextWithBigWhiteFont("YOU ARE THE WINNER", 250,450);
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
        gfs_YouWon_world.playLoop();
    
    }
    public void stopped(){
        gfs_YouWon_world.stop();
    
    }
}
