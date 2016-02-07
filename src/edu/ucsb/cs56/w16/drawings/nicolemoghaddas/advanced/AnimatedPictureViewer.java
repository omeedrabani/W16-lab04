package edu.ucsb.cs56.w16.drawings.nicolemoghaddas.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Nicole Moghaddas
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private SunWithFace sun = new SunWithFace(100, 100, 50);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 320;
    
    private int dx = 5;
    private int dy = 5;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    } // go()

    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
	    
	    Graphics2D g2 = (Graphics2D) g;
	    
	    // Clear the panel first
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());
	    
	    // Draw the Sun
	    Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	    g2.setStroke(thick);
	    // color changes from light orange to deep red to shades of pink
	    // changes with the height in the sky
	    // orange: 255 140 0
	    // yellow: 255 255 0
	    // pink:   255 20  147
	    int green;
	    if ((255 - x/2)<0)
		green = 20;
	    else
		green = 255- (x/2);
	    int blue;
	    if (x<=300){
		blue=0;}
	    else if (x>300 && x<=455){
		blue = x-200;}
	    else 
		blue = 147;
	    Color c = new Color(255, green, blue);
	    g2.setColor(c);
	    SunWithFace swf = new SunWithFace(x, y, 50);
	    g2.draw(swf);
	}
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Rise and fall
	    // 6 sections of x for dy
	    // 6 * 60 = 360 => each section is ~60 units wide in x
	    // y loses steepness in slope each segment up and grows down
	      
	    //these two x if statements control the direction
            if (x >= 510) { dx = -5; }
            if (x <= 100) { dx = 5; }
	    // the rest control the steepness in y
	    if (x <= 160) {
		if (dx>0)
		    dy = -10;
		else
		    dy = 10;
	    }
	    if (x>160 && x <= 220) {
		if (dx>0)
		    dy = -5;
		else
		    dy = 5;
	    }
	    if (x>220 && x <= 300) {
		if (dx>0)
		    dy = -1;
		else
		    dy = 1;
	    }
	    if (x >= 300 && x<380) {
		if (dx>0)
		    dy = 1;
		else
		    dy = -1;
	    }
	    if (x >= 380 && x<450) {
		if (dx>0)
		    dy = 5;
		else
		    dy = -5;
	    }
	    if (x >= 450) {
		if (dx>0)
		    dy = 10;
		else
		    dy = -10;
	    }

            x += dx;
	    y += dy;
	    
            panel.repaint();
            Thread.sleep(100);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
