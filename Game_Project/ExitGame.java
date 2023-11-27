import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExitGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitGame extends Button
{
    
    
    
    public ExitGame()
    {
        GreenfootImage exitGameButton = new GreenfootImage(300, 60);
        Font adjustFont = new Font(true, false, 50);
        exitGameButton.setFont(adjustFont);
        exitGameButton.setColor(Color.WHITE);
        exitGameButton.drawString("Exit Game", 0, 50);
        setImage(exitGameButton);
      
    }
    public void act()
    {
         checkMouse();
        
        if (Greenfoot.mouseClicked(this))
        {
            getWorld().stopped();
            World worldGameMenu = new Gamemenu();
            worldGameMenu.started();
            Greenfoot.setWorld(worldGameMenu);
        
        }
    }
}
