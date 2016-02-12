package edu.ucsb.cs56.w16.drawings.andychen152.advanced;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.lang.Math;
/**                                                                                                                                                                                                                            
 * A main class to view an animation                                                                                                                                                                                           
 *                                                                                                                                                                                                                             
 * @author Andy Chen                                                                                                                                                                                                        
 * @version for CS56, W16                                                                                                                                                                                                      
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    private ComputerMonitor computerMonitor = new ComputerMonitor(250, 170, 100,80);

    Thread anim;
    Thread anim2;

    private int x = 250;
    private int y = 170;
    private int height = 80;
    private int width = 100;

    private int tmpx = x;
    private int tmpy = y;
    private boolean clicked = true;
    private double counter = 0.0;

    private int dx = 5;
    private int dy = 4;
    private int dheight = -8;
    private int dwidth = -10;

    private int circleRadius = 5;

    private int colorChanger = 0;
    private int vibrator = 0;


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

		public void mousePressed(MouseEvent e){
		    System.out.println("Mouse pressed");
		    tmpx = x;
		    tmpy = y;
		    clicked = false;
		    anim.interrupt();
		    while(anim.isAlive()){}
		    anim = null;
		    panel.repaint();
		    anim2 = new Animation2();
		    anim2.start();
		   
		}
		public void mouseReleased(MouseEvent e){
		    System.out.println("MouseReleased");
		    y = tmpy;
		    x = tmpx;
		    clicked = true;
		    anim2.interrupt();
		    while(anim2.isAlive()){}
		    anim2=null;
		    panel.repaint();
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
	    g2.setColor(Color.BLACK);
	   
	    g2.drawString("Click and hold buttom to vibrate and reverse direction monitor is turning", 20, 20);


	    // Draw the Computer Monitor                                                                                                                                                                          
	    switch(colorChanger%4){
	    case 0:
		g2.setColor(Color.BLUE);
		break;
	    case 1:
		g2.setColor(Color.RED);
		break;
	    case 2:
		g2.setColor(Color.GREEN);
		break;
	    case 3:
		g2.setColor(Color.YELLOW);
	    default:
		g2.setColor(Color.BLACK);
	    }

	    
	    ComputerMonitor test = new ComputerMonitor(x, y, width, height);

	    Shape test2 = ShapeTransforms.rotatedCopyOf(test, counter % (2*Math.PI));
	    if (clicked)
		counter += 0.03;
	    else
		counter -= 0.03;
	    g2.draw(test2);
	}
    }

    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {

		    //want to make smaller
		    if (x <= 70){
			dx = 5;
			dy = 4;
			dheight = -8;
			dwidth = -10;
		    }
		    //grow bigger
		    if(x >= 250){
			dx = -5;
			dy = -4;
			dheight = 8;
			dwidth = 10;
		    }

		    colorChanger += 1;
		    x += dx;
		    y += dy;
		    height += dheight;
		    width += dwidth;
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



    class Animation2 extends Thread {
        public void run() {
            try {
                while (true) {
		    if (vibrator%6==0){
			x-=7;
			y-=10;
		    }
		    else if (vibrator%6==1){
			x+=7;
			y+=10;
		    }
		    else if(vibrator%6==2){
			x+=7;
			y-=10;
		    }
		    else if(vibrator%6==3){
			x-=7;
			y+=10;
		    }
		    else if(vibrator%6==4){
			y+=10;
		    }
		    else{
			y-=10;
		    }
		    vibrator+=1;
		    panel.repaint();
		    Thread.sleep(10);
			

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
