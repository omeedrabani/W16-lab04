package edu.ucsb.cs56.w16.drawings.lanthony.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * A main class to view an animation
 *
 * @author Laura Anthony
 * @version for CS56, W16
 */

public class AnimatedPictureViewer {

    private WorkingWineGlass glass1  = new WorkingWineGlass(100, 100, 100, 100);
    
    int x = 0;
    int y = 150; 

    public static void main (String[] args) {
	AnimatedPictureViewer gui = new AnimatedPictureViewer();
	gui.go();
    }

    public void go(){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	MyDrawPanel drawPanel = new MyDrawPanel();
	frame.getContentPane().add(drawPanel);
	frame.setSize(800, 800);
	frame.setVisible(true);
	
	while (true){
	for(int i = 0; i < 90; i++){
	    x++;
	    y++;
	    y++;

	    drawPanel.repaint();


	    try {
		Thread.sleep(50);
	    }
	    catch(Exception ex){}

	}
	for(int i = 90; i > 0; i--){
	    x++;
	    y--;
	    y--;
	    
	  
	    drawPanel.repaint();


	    try {
	      	Thread.sleep(50);
	    }
	    catch(Exception ex){}

	}
	for(int i = 90; i > 0; i--){
	    x--;
	    y++;
	    y++;
	    
	    
	    drawPanel.repaint();


	    try {
	      	Thread.sleep(50);
	    }
	    catch(Exception ex){}

	}
     for(int i = 90; i > 0; i--){
	    x--;
	    y--;
	    y--;
	    
	    
	    drawPanel.repaint();


	    try {
	      	Thread.sleep(50);
	    }
	    catch(Exception ex){}

	}



	
	}


	
    }

	class MyDrawPanel extends JPanel {

	    public void paintComponent(Graphics g){
		Graphics2D g1 = (Graphics2D ) g;

		//prevent smearing
		g1.setColor(Color.white);
		g1.fillRect(0,0,this.getWidth(), this.getHeight());

		//Draw glass
		g1.setColor(Color.MAGENTA);
		BasicStroke wideStroke = new BasicStroke(4.0f);
		g1.setStroke(wideStroke);
		WorkingWineGlass glass = new WorkingWineGlass(x,y,70,120);
		g1.draw(glass);

	    }

	}
	
    
}
