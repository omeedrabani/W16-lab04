package edu.ucsb.cs56.w16.drawings.andrewhuang.advanced;

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
 * @author Andrew Huang
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** This picture displays an Up-Arrow made of watches. It demonstrates that the Watch can be drawn in different colors, different positions, different sizes, and can be rotated and translated. 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	// Creates red watch
	Watch upRight = new Watch(250, 100, 100, 300);
	g2.setColor(Color.RED);
	g2.draw(upRight);

	// Creates cyan tilted watch 
	Watch leftSide = new Watch(100, 50, 200,50);
	Shape leftSideT = ShapeTransforms.rotatedCopyOf(leftSide,Math.PI-Math.PI/6.0);
	g2.setColor(Color.CYAN);
	g2.draw(leftSideT);

	// Creates green tilted watch
	Shape rightSide = ShapeTransforms.translatedCopyOf(leftSide,200,0);
	rightSide = ShapeTransforms.rotatedCopyOf(rightSide,Math.PI/6.0);

	g2.setColor(Color.GREEN);
	g2.draw(rightSide);

	g2.setColor(Color.BLACK); 
	g2.drawString("Arrow of Watches by Andrew Huang", 20,20);
    }
    
    
    /** Draws a picture of a pyramid of watches. This shows that the watches can be translated and scaled and they can be drawn in different colors.
     */
    public static void drawPicture2(Graphics2D g2) {
	// Base of pyramid 
	Watch base = new Watch(100, 330, 400, 75);
	g2.setColor(Color.GREEN);
	g2.draw(base);

	// Middle of pyramid
	Shape middle = ShapeTransforms.scaledCopyOfLL(base, .75, .75);
	middle = ShapeTransforms.translatedCopyOf(middle, 400*.125, -75);
	g2.setColor(Color.BLUE);
	g2.draw(middle);

	// Top of pyramid
	Shape top = ShapeTransforms.scaledCopyOfLL(middle, .75, .75);
	top = ShapeTransforms.translatedCopyOf(top, 400*(.125*.75), -75*.75);
	g2.setColor(Color.MAGENTA);
	g2.draw(top);
	
	g2.setColor(Color.BLACK); 
	g2.drawString("Pyramid of Watches by Andrew Huang",20,20);
    }
    
    /** This picture is a random orientation of watches that shows that the Watches can be drawn in a different color, position, size, and that they can be translated, rotated, and scaled.
     */
    
    public static void drawPicture3(Graphics2D g2) {
	//creates first watch
	Watch first = new Watch(10, 30, 200, 50);
	//creates 2nd watch with a different position and size
	Watch second = new Watch(30, 100, 50, 200);
	//scales the first watch
	Shape third = ShapeTransforms.scaledCopyOfLL(first, 2, 2);
	//translates the scaled first watch 
	third = ShapeTransforms.translatedCopyOf(third, 100, 250);
	//rotates the scaled first watch
	third = ShapeTransforms.rotatedCopyOf(third, Math.PI/4.0);

	//switches around the colors
	g2.setColor(Color.RED);
	g2.draw(first);
	g2.setColor(Color.ORANGE);
	g2.draw(second);
	g2.setColor(Color.YELLOW);
	g2.draw(third);

	g2.setColor(Color.BLACK);
	g2.drawString("Random Orientation of Watches by Andrew Huang", 20,20);
    }       
}
