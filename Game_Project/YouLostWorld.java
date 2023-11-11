import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouLostWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouLostWorld extends World
{

    /**
     * Constructor for objects of class YouLostWorld.
     * 
     */
    public YouLostWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        showTextWithBigWhiteFont("You Lost", 270,400);
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

