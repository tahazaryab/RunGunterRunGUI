
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;	//to set random virus locations
import java.awt.event.ActionEvent;      //for timer
import java.awt.event.ActionListener;   //for timer
import java.util.ArrayList;	//because we have an ArrayList of virus
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.util.Random;		//to set random virus locations
import java.awt.event.ActionEvent;      //for timer
import java.awt.event.ActionListener;   //for timer
import java.util.ArrayList;		//because we have an ArrayList of virus
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;		//timer import

public class GameFrame extends JPanel implements ActionListener{
    Timer mainTimer;
    double timer=0;
    static GunterModel gunter;
    Random rand = new Random();     //seed the random generator
    static ArrayList<Virus> virus = new ArrayList<Virus>();     //initializing variables
    static int bro=1;
    int xbruh, ybruh;
    Background bruh= new Background(0,0);
	public GameFrame() {
        setFocusable(true);
        gunter = new GunterModel(650,420);		//postions gunter in the middle of the screen
        mainTimer = new Timer(10,this);     //sets Timer to update() every 10 milliseconds
        mainTimer.start();                  //to start the timer
        setVirus();      //calls the method below for setting up the virus randomly
        addKeyListener(new KeyAdapt(gunter));
	}
	public void setVirus() {
		for (int i=0;i<10;i++) {
		virus.add(new Virus(rand.nextInt(1300),rand.nextInt(620))); //adding 12 virus
		}
	}
	
	public void actionPerformed(ActionEvent arg0){  //this method nec'y for timers
       
		
		for (int i=0;i<virus.size();i++) {
		virus.get(i).update();
		
        }
        gunter.update();
        
        timer+=0.01;                       //timer adds 10 milliseconds per refresh
        
        repaint();
       
    }
	
	public void paint(Graphics g){	//this method paints everything onto the screen
        super.paint(g);
        
        Graphics2D g2d  = (Graphics2D) g;  //cast g as Graphics2d 
     
        bruh.draw(g2d); //draw background
        
        gunter.draw(g2d);	 //draw gunter
     
        for (int i=0;i<virus.size();i++){    //draw the ArrayList of virus (which is
            Virus tempVirus = virus.get(i);   //changiDng in size as we go)
            tempVirus.draw(g2d);
            
        }
        g.setColor(Color.green);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString("[Missisauga Hacks. Project G.U.I]",1030,620);
        g.setColor(Color.white);
        g.drawString("By. Kevin Le, Taha Zaryab, Srijay Mundlur, and Harmit Goswami",740,640);   //printing text and the timer
        g.setColor(Color.yellow);
        g.setFont(new Font(null,Font.BOLD,30));
        g.drawString("Timer:"+timer,1205,26);
        g.setFont(new Font(null,Font.BOLD,30));
        g.setColor(Color.yellow);
        g.drawString("Run Gunter Run!",600,26);
        g.setColor(Color.white);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString("Distance yourself from the virus for as long as you can!",440,46);
        g.setColor(Color.green);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString("Use the WASD keys to control Gunter!",5,620);
        g.setColor(Color.white);
        g.drawString("[W]_Up [S]_Down [A]_Left [D]_Right",5,640);
        
    }

	
	
		
	
	public static GunterModel getGunterList(){	//an ArrayList of gunter type
        return gunter;				//gets provided to checkCollisions()
 }
	public static int bruh() {
		return bro;
	}
 
}