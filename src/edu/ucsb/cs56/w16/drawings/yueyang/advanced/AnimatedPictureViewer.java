package edu.ucsb.cs56.w16.drawings.yueyang.advanced;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Yueyang Li
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private ChristmasTree a = new ChristmasTree(0,100, 50,100);
    
    private Color Col = Color.RED;
    Thread anim;   
    
    private int x = 0;
    private int y = 0;
    private int dy=15;
    private int dx = 5;
    private int cx= 5;
    private int sw= 50;
    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(1000,1000);
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


          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

      
          g2.setColor(Col);
          ChristmasTree b = new ChristmasTree(x, y, sw,sw*2);
          g2.draw(b);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
              Random rand=new Random();
              int redValue=rand.nextInt(255);              
              int greenValue=rand.nextInt(255);
              int blueValue=rand.nextInt(255);
              if (sw<=5) {cx=1; Col=new Color(redValue,greenValue,blueValue);}
              if (sw>=50) {cx=-1; Col=new Color(redValue,greenValue,blueValue); }
	      if (y <= 100) {dy=10;}
              if (y >=1000) {dy=-10;}
              if (x>=800) {dx=-5;}
	      if (x <= 50) { dx =5;}
  

            x += dx;    
            y += dy;            
            sw += cx;
            panel.repaint();
            Thread.sleep(50);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
          
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
