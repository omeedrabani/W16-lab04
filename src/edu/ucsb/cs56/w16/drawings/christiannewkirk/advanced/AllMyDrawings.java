package edu.ucsb.cs56.w16.drawings.christiannewkirk.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Christian Newkirk
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with an IPad
     */
    
    public static void drawPicture1(Graphics2D g2) {

	// Simple IPad close to center of the frame
        IPad p1 = new IPad(285,250,200,253);
        g2.setColor(Color.BLACK); g2.draw(p1);


	
        g2.drawString("An IPad by Christian Newkirk",20,20);	
	
    }
    
    
    /** Draw a picture with a big center IPad and 4 IPads around it rotated around it
     */
    public static void drawPicture2(Graphics2D g2) {

	// IPad in the center
        IPad p1 = new IPad(285,250,200,253);
        g2.setColor(Color.BLACK); g2.draw(p1);


	// Make 4 smaller IPads on the outside of the center IPad
	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,250,-63);

	Shape p3 = ShapeTransforms.rotatedCopyOf(p2, Math.PI/2);
	g2.setColor(Color.BLACK); g2.draw(p3);

	p3 = ShapeTransforms.translatedCopyOf(p3,-400,0);
	p3 = ShapeTransforms.rotatedCopyOf(p3, Math.PI);
	g2.setColor(Color.BLACK); g2.draw(p3);

 	p2 = ShapeTransforms.translatedCopyOf(p2,-200,-220);
	g2.setColor(Color.BLACK); g2.draw(p2);

	p2 = ShapeTransforms.translatedCopyOf(p2,0,440);
	p2 = ShapeTransforms.rotatedCopyOf(p2, Math.PI);
	g2.setColor(Color.BLACK); g2.draw(p2);

      

	g2.drawString("An IPad portfolio by Christian Newkirk",20,20);	   



    }
    
    /** Draw a picture with IPads inside IPads with each inside IPad the next color of the rainbow
     *  *Note: I could not get this one to be pefect because methods round to nearest pixel. I tried.
     */
    
    public static void drawPicture3(Graphics2D g2) {
	// IPadception rainbow
        IPad p1 = new IPad(285,250,300,380);
        g2.setColor(Color.RED); g2.draw(p1);

	
	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.73,0.73);
	p2 = ShapeTransforms.translatedCopyOf(p2,41,-51);
	g2.setColor(Color.YELLOW); g2.draw(p2);
		
	p2 = ShapeTransforms.scaledCopyOfLL(p2,0.73,0.73);
	p2 = ShapeTransforms.translatedCopyOf(p2,30,-37);
	g2.setColor(Color.GREEN); g2.draw(p2);

	p2 = ShapeTransforms.scaledCopyOfLL(p2,0.73,0.73);
	p2 = ShapeTransforms.translatedCopyOf(p2,22,-27);
	g2.setColor(Color.BLUE); g2.draw(p2);

        p2 = ShapeTransforms.scaledCopyOfLL(p2,0.73,0.73);
	p2 = ShapeTransforms.translatedCopyOf(p2,16,-20);
	g2.setColor(Color.MAGENTA); g2.draw(p2);

        p2 = ShapeTransforms.scaledCopyOfLL(p2,0.73,0.73);
	p2 = ShapeTransforms.translatedCopyOf(p2,12,-13);
	g2.setColor(Color.BLACK); g2.draw(p2);



	g2.drawString("A very colorful IPad illustration by Christian Newkirk",20,20);	   
		

    }       
}
