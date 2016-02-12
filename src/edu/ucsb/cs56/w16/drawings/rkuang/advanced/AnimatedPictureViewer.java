package edu.ucsb.cs56.w16.drawings.rkuang.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

/**
 * A main class to view an animation
 *
 * @author Ricky Kuang
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    // private Spoon spoon = new Spoon(50, 50, 100, 340);
    
    Thread anim;
    
    private int x = -250;
    private int y = 20;
    private double scoop = 0.15;

    private int dx = 5;
    private int dy = 10;
    private double dscoop = 0.025;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setTitle("Ricky Kuang's Animation: Scoops!");
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

          // Draw the Spoon
          g2.setColor(Color.RED);
          Spoon spoon = new Spoon(x, y, 100, 340);
          Shape spoonRotated = ShapeTransforms.rotatedCopyOf(spoon, Math.PI/2);
          spoonRotated = ShapeTransforms.rotatedCopyOf(spoonRotated, scoop);
          g2.draw(spoonRotated);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 800) { x = -250; }
            if (x <= 640) { x += dx; }

            if (y >= 140) { dy = -10; dscoop = -0.025; }
            if (y <= -80) { dy = 10; dscoop = 0.025; }
            
            x += dx;
            y += dy;
            scoop += dscoop;

            panel.repaint();
            Thread.sleep(30);
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

