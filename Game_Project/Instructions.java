import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends Button
{
     
    public Instructions()
    {
        GreenfootImage instructionsButton = new GreenfootImage(350, 50);
        Font adjustFont = new Font(true, false, 50);
        instructionsButton.setFont(adjustFont);
        instructionsButton.setColor(Color.BLACK);
        instructionsButton.drawString("Instructions", 0, 50);
        setImage(instructionsButton);
        
    }
    
    /**
     * Act - do whatever the Instructions wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkMouse();
        
        if (Greenfoot.mouseClicked(this))
        {
            getWorld().stopped();
            World worldInstruction = new InstructionScreen();
            worldInstruction.started();
            Greenfoot.setWorld(worldInstruction);
        }
    }
}
