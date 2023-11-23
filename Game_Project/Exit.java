import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Button
{
    public GreenfootSound gfs_InstructionMenu_World; 
    public GreenfootSound gfs_Gamemenu_World;
    public Exit()
    {
        GreenfootImage exitButton = new GreenfootImage(100, 60);
        Font adjustFont = new Font(true, false, 50);
        exitButton.setFont(adjustFont);
        exitButton.setColor(Color.BLACK);
        exitButton.drawString("Exit", 0, 50);
        setImage(exitButton);
        gfs_InstructionMenu_World = new GreenfootSound("boss_battle_#2_metal_loop.wav");
        gfs_Gamemenu_World = new GreenfootSound("boss_battle_#2_metal_loop.wav");
    }
    public void act()
    {
        checkMouse();
        
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Gamemenu());
            gfs_InstructionMenu_World.stop();
            gfs_Gamemenu_World.play();
            
        }
    }
}
