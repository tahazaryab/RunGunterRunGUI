import java.awt.event.KeyAdapter;   //note these new key imports
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter {
	GunterModel b;   //this Class has a variable which will be the gunter so all keypress
                     //handling happens in GunterModel Class because of the variable’s Ball type
        
	public KeyAdapt(GunterModel patrick){ //the gunter is received from GameFrame after gunter is created
		b=patrick;   //this sets the sent ball as the one being key controlled
	}
	
	public void keyPressed(KeyEvent e){
		b.keyPressed(e);    //method from GunterModel Class dictates reaction to keystrokes
	}
	public void keyReleased (KeyEvent e) {
		b.keyReleased(e);  //method to react to keyrelease
	}
	
	 
}
