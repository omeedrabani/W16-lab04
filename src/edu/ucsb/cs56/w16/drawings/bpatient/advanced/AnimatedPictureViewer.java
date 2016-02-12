package edu.ucsb.cs56.w16.drawings.bpatient.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

public class AnimatedPictureViewer 
{

    private DrawPanel panel = new DrawPanel();
    
    private Screenception screen = new Screenception(150,150,300,150);
    
    Thread anim;   
    
    private int x = 150;
    private int y = 300;
    
    private int dx = 5;
    private int dy = 5;

    /*private float r = rand.nextFloat();
	private float g = rand.nextFloat();
	private float b = rand.nextFloat();

	privateColor randomColor = new Color(r, g, b);*/


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
        
        public void mousePressed(MouseEvent e) 
        {
            System.out.println("Mouse pressed");
            x = 200;
            y = 150;
            anim.interrupt();
            while (anim.isAlive()){}
            anim = null;         
            panel.repaint();   
        }

        public void mouseReleased(MouseEvent e) 
        {
            System.out.println("Mouse released");
            //x = 100;
            //y = 400;
            anim = new Animation();
            anim.start();  
        }

      });
      
    }

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());
          g2.setColor(Color.RED);
          Screenception test = new Screenception(x,x,y,y/2);
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            if (x >= 225) { dx = -5; }
            if (x <= 50) { dx = 5; }
            if (y >= 400) { dy = -3; }
            if (y <= 150) { dy = 3; }
            
            x += dx;
            y += dy;            
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