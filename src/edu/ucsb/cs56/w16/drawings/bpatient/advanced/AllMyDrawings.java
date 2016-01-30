package edu.ucsb.cs56.w16.drawings.bpatient.advanced;

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
 * @author Phill Conrad 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */
    
    public static void drawPicture1(Graphics2D g2) {
    	g2.drawString("A computer screenception by Ben Patient", 20,20);
		
		
		// Draws a screen in a screen hence screenception.
		
		Screenception inception = new Screenception(150,150,300,150);
		
		g2.setColor(Color.RED);     
		g2.draw(inception);
	
	
    }
    
    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) 
    {
		g2.drawString("A computer screen by Ben Patient", 20,20);
	
	
		// Draw a screen.
	
		Screen large = new Screen(150,150,300,150);
	
		g2.setColor(Color.RED);     
		g2.draw(large);
	}
    
    public static void drawPicture3(Graphics2D g2) {
	
		g2.drawString("A computer screenception by Ben Patient", 20,20);
		
		
		// Draws a screen in a screen hence screenception.
		
		Screenception inception = new Screenception(150,150,400,200);
		
		g2.setColor(Color.RED);     
		g2.draw(inception);
	
	
    }       
}
