import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionScreen extends World
{
    private static int WW = 1600;
    private static int WH = 900;
    public GreenfootSound gfs_InstructionMenu_World; 
    /**
     * Constructor for objects of class InstructionScreen.
     * 
     */
    public InstructionScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WW, WH, 1); 
        
        showTextWithBlackFont("Instruction", 700, 200);
        showGoalWithBlackFont("Eliminate and escape from the enemies", 550, 250);
        showControlsWithBlackFont("Controls", 750, 350);
        showMechanicsWithBlackFont("Move Up              : click W \nMove Down         : click S \nMove Right         : click D" + 
            "\nMove Left           : click A \nShoot                 : click Space \nAim                    : point Mouse towards enemy ", 600, 400 );
        gfs_InstructionMenu_World = new GreenfootSound("boss_battle_#2_metal_loop.wav");
        prepare();
        
    }

    public void showTextWithBlackFont(String message, int x, int y){
        var  bg = getBackground(); 
        Font font = new Font(50);
        bg.setFont(font);
        bg.setColor(Color.BLACK);
        bg.drawString(message,x, y);

    }

    public void showGoalWithBlackFont(String message, int x, int y){
        var  bg = getBackground(); 
        Font font = new Font(30);
        bg.setFont(font);
        bg.setColor(Color.BLACK);
        bg.drawString(message,x, y);

    }
    public void showControlsWithBlackFont(String message, int x, int y){
        var  bg = getBackground(); 
        Font font = new Font(40);
        bg.setFont(font);
        bg.setColor(Color.BLACK);
        bg.drawString(message,x, y);

    }

    public void showMechanicsWithBlackFont(String message, int x, int y){
        var  bg = getBackground(); 
        Font font = new Font(30);
        bg.setFont(font);
        bg.setColor(Color.BLACK);
        bg.drawString(message,x, y);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Exit exit = new Exit();
        addObject(exit,771,685);
        exit.setLocation(830,660);
        exit.setLocation(828,693);
    }
    public void started(){
        gfs_InstructionMenu_World.playLoop();
    
    }
    
    public void stopped(){
        gfs_InstructionMenu_World.stop();
    
    }
}

