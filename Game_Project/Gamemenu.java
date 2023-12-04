import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Gamemenu extends World
{
    private static int WW = 1600;
    private static int WH = 900;
    public GreenfootSound gfs_MainMenu_World;
    double timeWelcomeScreenCreation = System.currentTimeMillis();
    public Gamemenu()
    {    
        super(WW, WH, 1); 
        showText("Please select an option or wait 10 seconds for the game to start", getWidth()/2,700);
        showText("Press Space Bar or click Play to beginning", getWidth()/2, 800);
        prepare();
        gfs_MainMenu_World = new GreenfootSound("boss_battle_#2_metal_loop.wav");
        
    }
    
     public void act()
    {
        Display display = new Display();
        addObject(display , 280, 500);
        
        int timerValue = (int) (System.currentTimeMillis() - timeWelcomeScreenCreation)/1000;
        
        display.setImage(new GreenfootImage("Timer Value :" + timerValue , 35, Color.WHITE, Color.BLACK, Color.BLUE));
        

        if (Greenfoot.isKeyDown("space"))
        {
            this.stopped();
            World world1 = new LevelOne();
            world1.started();
            Greenfoot.setWorld(world1);
            

        }

        if (System.currentTimeMillis() >= (timeWelcomeScreenCreation + (10 * 1000)))
        {
            this.stopped();
            World world1 = new LevelOne();
            world1.started();
            Greenfoot.setWorld(world1);
        }

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
        
        showTextWithBlackFont("Alexandru Cirlan \nMassimo Prioriello", 100, 200);
    }
    
    
    
    public void started(){
        gfs_MainMenu_World.playLoop();
    }
    
    public void stopped(){
        gfs_MainMenu_World.stop();
    }
    
    public void showTextWithBlackFont(String message, int x, int y){
        var  bg = getBackground(); 
        Font font = new Font(30);
        bg.setFont(font);
        bg.setColor(Color.BLACK);
        bg.drawString(message,x, y);
    }
}
