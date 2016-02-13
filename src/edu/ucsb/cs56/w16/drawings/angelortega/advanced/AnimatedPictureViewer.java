package edu.ucsb.cs56.w16.drawings.angelortega.advanced;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  * Created by angel on 2/12/16.
 *   */
public class AnimatedPictureViewer {

    private int xPos;
    private int yPos;
    private Thread anim;
    private PaintCanvas canvas = new PaintCanvas();
    private static Shape zaa;


    public static void main(String[] args) {
        new AnimatedPictureViewer().go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setSize(640,480);
        frame.setTitle("Angel Ortega's Rotating Pizza");
        frame.getContentPane().addMouseListener(new MouseAdapter() {


            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

                anim = new Thread(new Rotate());
                anim.start();
            }

        });
        frame.setVisible(true);

    }

    public class Rotate implements Runnable {

        @Override
        public void run() {
            try {
                while(true) {
                    canvas.repaint();
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public class PaintCanvas extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.WHITE);
            g2.fillRect(0,0,this.getWidth(),this.getHeight());
            xPos = this.getWidth()/2;
            yPos = this.getHeight()/3;
            g2.setColor(Color.RED);
            Stroke thick = new BasicStroke(4.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);
            g2.setStroke(thick);
            if(zaa == null) {
                zaa = new PepperoniPizza(xPos, yPos, 150.0, 15.0);
                g2.draw(zaa);
            }
            else {
                zaa = ShapeTransforms.rotatedCopyOf(zaa, Math.PI / (360.0/5.0));
                g2.draw(zaa);
            }
            g2.setColor(Color.DARK_GRAY);
            g2.drawString("A Rotating Pizza by Angel Ortega", 20,20);
        }
    }

}


