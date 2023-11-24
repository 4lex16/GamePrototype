import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.World;


public class Play extends Button
{
    private static boolean isPaused = false;
    public GreenfootSound gfs_levelOne_world;
     
    public Play()
    {
        GreenfootImage playButton = new GreenfootImage(150, 60);
        Font adjustFont = new Font(true, false, 50);
        playButton.setFont(adjustFont);
        playButton.setColor(Color.BLACK);
        playButton.drawString("Play", 0, 50);
        setImage(playButton);
        gfs_levelOne_world = new GreenfootSound("boss_battle_8_retro_01_loop.wav");
    }
    
    public void act()
    {
        checkMouse();
        
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new LevelOne());
            gfs_levelOne_world.play();
        }
    }
}
