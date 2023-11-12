import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouWonWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWonWorld extends World
{

    /**
     * Constructor for objects of class YouWonWorld.
     * 
     */
    public YouWonWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1); 
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
}
