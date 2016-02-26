package edu.ucsb.cs56.w16.drawings.jeffreyliu.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Jeffrey Liu
 * @version for CS56, W16
 */

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    private SnowyMountain sm = new SnowyMountain(150, 50, 100, 150);

    private boolean winter = true;

    Thread anim;

    private int x = 100;
    private int y = 100;

    private int dx = 5;
    private int dy = 5;

    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	frame.setSize(640, 480);
	frame.setVisible(true);

	frame.getContentPane().addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
		    anim = new Animation();
		    anim.start();
		}

		public void mouseExited(MouseEvent e) {
		    // Kill the animation thread
		    anim.interrupt();
		    while (anim.isAlive()) {}
		    anim = null;
		    panel.repaint();
		}
		public void mouseClicked(MouseEvent e) {
		    if (winter)
			winter = false;
		    else
			winter = true;
		}
	    });

    }

    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {

	    Graphics2D g2 = (Graphics2D) g;

	    // Clear the panel first
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());

	    // Draw the Snowy Mountain or Mountain
	    g2.setColor(Color.BLUE);
	    if (winter) {
		SnowyMountain sm = new SnowyMountain(x, y, 100, 150);
		g2.draw(sm);
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
		Stroke orig = g2.getStroke();
		g2.setStroke(orig);
		g2.setColor(Color.BLACK);
		g2.drawString("Winter", 20, 20);
	    }
	    else {
		Mountain m = new Mountain(x, y, 100, 150);
		g2.draw(m);
                Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
                Stroke orig = g2.getStroke();
                g2.setStroke(orig);
                g2.setColor(Color.BLACK);
                g2.drawString("Summer",20, 20);
	    }
	}
    }
    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // Bounce off the walls

		    if (x >= 400) { dx = -5; }
		    if (x <= 100) { dx = 5; }
		    if (y >= 250) { dy = -5; }
		    if (y <= 50) { dy = 5; }
            
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
