import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.World;


public class Play extends Button
{
    private static boolean isPaused = false;
    public GreenfootSound gfs_Gamemenu_World;
    public GreenfootSound gfs_LevelOne_World = new GreenfootSound("boss_battle_8_retro_01_loop.wav");
    public GreenfootSound gfs_YouLostWorld;
    
    public Play()
    {
        GreenfootImage playButton = new GreenfootImage(150, 60);
        Font adjustFont = new Font(true, false, 50);
        playButton.setFont(adjustFont);
        playButton.setColor(Color.BLACK);
        playButton.drawString("Play", 0, 50);
        setImage(playButton);
        gfs_Gamemenu_World = new GreenfootSound("boss_battle_#2_metal_loop.wav");
        gfs_YouLostWorld = new GreenfootSound("prologue.wav");
    }
    
    public void act()
    {
        checkMouse();
        
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new LevelOne());
            gfs_LevelOne_World.playLoop();
            gfs_Gamemenu_World.stop();
            gfs_YouLostWorld.stop();
        }
    }
}
