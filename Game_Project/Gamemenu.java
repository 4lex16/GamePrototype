import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Gamemenu extends World
{

    private static int WW = 1600;
    private static int WH = 900;
    public GreenfootSound gfs_gameMenu_World;
    public Gamemenu()
    {    
        super(WW, WH, 1); 
        prepare();
        gfs_gameMenu_World = new GreenfootSound("boss_battle_#2_metal_loop.wav");
    }
    
    private void prepare()
    {
        GreenfootImage boxArt = new GreenfootImage("BoxArt.png");
        Picture boxArtPic = new Picture(boxArt);
        addObject(boxArtPic, WW/2, WH/2-300);
        Play play = new Play();
        addObject(play,WW/2,WH/2);

        Instructions instructions = new Instructions();
        addObject(instructions,763,552);

        instructions.setLocation(875,541);

        instructions.setLocation(803,528);

        instructions.setLocation(815,546);
        VanierCollege vanierCollege = new VanierCollege();
        addObject(vanierCollege,715,731);
        vanierCollege.setLocation(1106,742);
        removeObject(vanierCollege);
        
        addObject(vanierCollege,165,65);
        vanierCollege.setLocation(181,112);
        vanierCollege.setLocation(222,85);
    }
    
    public void started(){
        gfs_gameMenu_World.play();
    
    }
    
    public void stopped(){
        
            gfs_gameMenu_World.stop();
        
    
    }
}
