import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class Background extends Entity {

	public Background(int x, int y) {
		super(x, y);
		
	}
	public void draw(Graphics2D g2d){
		g2d.drawImage(getBackgroundImg(),x,y,1360,680,null); //stretching size of image
	
	}
	public void update(){
		
	}
	public Image getBackgroundImg(){
        //ImageIcon ic=new ImageIcon("/imgs/bikinibottom.jpg");  //getting background image
		ImageIcon ic=new ImageIcon(getClass().getClassLoader().getResource("skybackground.jpg"));
        return ic.getImage();
   }

}
