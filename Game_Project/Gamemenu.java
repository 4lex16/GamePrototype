import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Gamemenu extends World
{

    private static int WW = 1600;
    private static int WH = 900;
    
    public Gamemenu()
    {    
        super(WW, WH, 1); 
        prepare();
    }
    private void prepare()
    {
        GreenfootImage boxArt = new GreenfootImage("BoxArt.png");
        Picture boxArtPic = new Picture(boxArt);
        addObject(boxArtPic, WW/2, WH/2-300);
    }
}
