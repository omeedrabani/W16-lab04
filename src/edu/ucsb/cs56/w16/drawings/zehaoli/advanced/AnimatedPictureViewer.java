package edu.ucsb.cs56.w16.drawings.zehaoli.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Zehao Li
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private laptop thisone = new laptop(100, 100, 80);

    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    private int height = 80;
    //cline degree
    private int k = 1;
    private int b = 0;
    private int count=1;

    //velocity
    private int dx = 1;

    //size
    private int size=1;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(900,600);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
	      //public void mouseEntered(MouseEvent e){
	      //  System.out.println("mouse entered");
	      //  anim = new Animation();
	      // anim.start();
	      //}
	      
	      public void mouseExited(MouseEvent e){        
		  System.out.println("Mouse exited");
		  // Kill the animation thread
		  anim.interrupt();
		  while (anim.isAlive()){}
		  anim = null;         
		  panel.repaint();        
	      }
	      
	      
	      public void mouseClicked(MouseEvent e){ 
		  
		  System.out.println("mouse click");
		  anim = new Animation();
		  anim.start();
		      
	      }
	      
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the laptop
          g2.setColor(Color.RED);
          laptop test = new laptop(x+5, y-5, height-2);
	  g2.draw(test);

	  g2.setStroke(new BasicStroke(10));
	  g2.setColor(Color.GREEN);
	  laptop test1 = new laptop(x-3, y+3, height+2);
	  g2.draw(test1);

	  g2.setStroke(new BasicStroke(5));
	  g2.setColor(Color.BLUE);
	  laptop test2 = new laptop(x, y, height);
	  g2.draw(test2);

          //g2.draw(test);
	  //g2.draw(test1);
	  //g2.draw(test2);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
	      
	      // hit the walls
	      if ((x >= 900-2.1*height)||(x <= 0.3*height)) { 
		  dx = - dx;
	      }
	      if ((x >= 900-2.1*height)||(x <= 0.3*height)||(y<=0)||(y>= 600-1.6*height)){
		  k=-k;
		  
		  b+=2*x*count;
		  count=-count;
	      }

	      
	      
	      if ((height>100)||(height<50)){
		  size=-size;
	      }
	      height+=size;
	      
	      x += dx;
	      y = k*x + b;                
	      panel.repaint();
	      Thread.sleep(15);
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