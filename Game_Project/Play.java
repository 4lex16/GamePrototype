import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Play extends Button
{
    public Play()
    {
        GreenfootImage playButton = new GreenfootImage(100, 60);
        Font adjustFont = new Font(true, false, 50);
        playButton.setFont(adjustFont);
        playButton.setColor(Color.BLACK);
        playButton.drawString("Play", 0, 50);
        setImage(playButton);
    }
    
    public void act()
    {
        checkMouse();
        
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new LevelOne());
        }
    }
}
