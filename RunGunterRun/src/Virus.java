
import java.awt.Graphics2D;

import java.util.Random;
import java.awt.Image;
import java.awt.Rectangle;


import javax.swing.ImageIcon;

public class Virus extends Entity {
	static Random rand = new Random(); 
	private int moveX;
	private int moveY;
	
	int x=rand.nextInt(1300),y=rand.nextInt(50); //randomize starting position of the virus and make sure it only spawns on top to not auto close off spawn


	

		
	
	public Virus (int x, int y){
    	super(x,y);
    	
    	moveX=(int) (Math.random () * 4 + 1);    //randomize speed and movement for each virus
    	moveY=(int) (Math.random () * 4 + 1);   
    }
    public void update(){    
    	x+=moveX;
    	y+=moveY;
    	checkCollision();
    }
    public void checkCollision(){
    	if (x+getVirusImg().getWidth(null) >1355 ){ 	//1360 is the width of the window
            moveX*=-1;				//changes moveX from 3 to -3
    	}if(x+getVirusImg().getWidth(null)<45){
    		moveX*=-1;
    	}if(y+getVirusImg().getHeight(null)<42){  //bounce off wall
    		moveY*=-1;
    	}if(y+getVirusImg().getHeight(null)>650){
    		moveY*=-1;
    	}
    	GunterModel gunter = GameFrame.getGunterList();
    	
 
        	if (getBounds().intersects(gunter.getBounds())){	
        		int brother= GameFrame.bruh();    //if it intersects game closes
        		brother=0;
        		System.exit(0); 
    	}
    	

    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,getVirusImg().getWidth(null),getVirusImg().getHeight(null));
	}
    public void draw(Graphics2D g2d){
        g2d.drawImage(getVirusImg(),x,y,null);
    }
    public Image getVirusImg(){
        //ImageIcon ic=new ImageIcon("//res//Virus.png");  //getting the image
    	ImageIcon ic=new ImageIcon(getClass().getClassLoader().getResource("Virus.png"));
    
        return ic.getImage();
    }

}
