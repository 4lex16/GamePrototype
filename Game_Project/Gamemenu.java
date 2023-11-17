import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Gamemenu extends World
{

    private static int WW = 1600;
    private static int WH = 900;
    
    public Gamemenu()
    {    
        super(WW, WH, 1); 
        //showTextWithBlackFont("Instruction",698 ,600);
        prepare();
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
    }
    
    /**public void showTextWithBlackFont(String message, int x, int y){
        var  bg = getBackground(); 
        Font font = new Font(50);
        bg.setFont(font);
        bg.setColor(Color.BLACK);
        bg.drawString(message,x, y);
    
    }*/
}
