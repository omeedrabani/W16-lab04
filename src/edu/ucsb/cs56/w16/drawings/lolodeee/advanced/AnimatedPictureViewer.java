package edu.ucsb.cs56.w16.drawings.lolodeee.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Lauren Dumapias
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

  //  private PizzaWithPepperonis pizzaPeps = new PizzaWithPepperonis(100.0, 100.0, 50.0, 75.0);

    Thread anim;

    private double x = 100.0;
    private double y = 100.0;

    private int dx = 5;

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


          // Draw the Pizza
          g2.setColor(Color.RED);
          PizzaWithPepperonis test = new PizzaWithPepperonis(x-35, y-40, 10.0, 35.0);
          g2.draw(test);
          g2.setColor(Color.ORANGE);
          PizzaWithPepperonis test1 = new PizzaWithPepperonis(x-20, y-20, 30.0, 55.0);
           g2.draw(test1);
           g2.setColor(Color.YELLOW);
          PizzaWithPepperonis test2 = new PizzaWithPepperonis(x+5, y+5, 50.0, 75.0);
           g2.draw(test2);
           g2.setColor(Color.GREEN);
          PizzaWithPepperonis test3 = new PizzaWithPepperonis(x+45, y+45, 70.0, 95.0);
           g2.draw(test3);
           g2.setColor(Color.BLUE);
          PizzaWithPepperonis test4 = new PizzaWithPepperonis(x+95, y+95, 90.0, 115.0);
           g2.draw(test4);
           g2.setColor(Color.MAGENTA);
          PizzaWithPepperonis test5 = new PizzaWithPepperonis(x+160, y+160, 110.0, 135.0);
           g2.draw(test5);


       }
    }

    class Animation extends Thread {
      public void run() {
        try {
          while (true) {

            if (x >= 400) { dx = -20; }
            if (x <= 50) { dx = 20; }

            x += dx;
            y += dx;
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
