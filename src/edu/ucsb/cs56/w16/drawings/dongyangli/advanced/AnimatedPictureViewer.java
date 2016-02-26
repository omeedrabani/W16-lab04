package edu.ucsb.cs56.w16.drawings.dongyangli.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;

/**
 * A main class to view an animation
 *
 * @author Dongyang Li
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private LetterPaper p = new LetterPaper(100, 100, 100, 100);
    
    Thread anim;   
    
    private double x = 100;
    private double y = 100;
    
    private int dx = 5;
    private int dy = 0;

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
          g2.setColor(Color.yellow);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the LetterPaper
          g2.setColor(Color.RED);
          LetterPaper test = new LetterPaper(x, y, 100, 100);
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls
         
	      if(x==100 && y>=100){
		  dx=0;
		  dy=5;
	      }
	      if(x==100 && y>=150){
		  dx=5;
		  dy=0;
	      }
	      if(x==200 && y==150){
		  dx=0;
		  dy=5;
	      }
	      if(x==200 && y>=200){
		  dx=5;
		  dy=0;
	      }
	      if(x==300 && y==200){
		  dx=0;
		  dy=5;
	      }
	      if(x==300 && y>=250){
		  dx=5;
		  dy=0;
	      }
	      if(x==400 && y==250){
		  dx=0;
		  dy=-5;
	      }
	      if(x==400 && y==100){
		  dx=-5;
		  dy=0;
	      }
		  

	    x += dx; 
	    y += dy;
            
	    panel.repaint();
            Thread.sleep(50);
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