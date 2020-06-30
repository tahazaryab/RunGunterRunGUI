import java.awt.Color;

import javax.swing.JFrame;


public class RunGunter {
    	       public static void main(String[] args) {
    	    	   
        		 JFrame frame = new JFrame("Run Gunter Run!");//sets up the frame
        		 frame.setSize(1370,680);				//sizes it
        		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //activates the close icon
        		 frame.setResizable(false);				//prevents resizing by users
        		 frame.add(new GameFrame());			//creates the game window itself
         		 frame.setVisible(true);					//makes it visible
         		
	
         		
         		         
   	       }
    	       
}
