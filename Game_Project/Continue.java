import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Continue extends Button
{
    public Continue()
    {
        GreenfootImage playButton = new GreenfootImage(300, 60);
        Font adjustFont = new Font(true, false, 50);
        playButton.setFont(adjustFont);
        playButton.setColor(Color.WHITE);
        playButton.drawString("Continue", 0, 50);
        setImage(playButton);
    }
    public void act()
    {
        checkMouse();
        
    }
    
}
