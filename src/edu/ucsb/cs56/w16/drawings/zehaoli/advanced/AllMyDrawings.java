package edu.ucsb.cs56.w16.drawings.zehaoli.advanced;

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
 * @author Zehao Li
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with laptops and charging laptops 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	laptop h1 = new laptop(100,250,80);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black laptop that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two charging laptops
	
	charginglaptop cl1 = new charginglaptop(50,350,40);
	charginglaptop cl2 = new charginglaptop(200,350,100);
	
	g2.draw(cl1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(cl2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few laptops by Zehao Li", 20,20);
    }
    
    
    /** Draw a picture with a few laptop and charging laptop
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some laptops.
	
	laptop a = new laptop(100,50,150);
	laptop b = new laptop(20,50,30);
	laptop c = new laptop(20,150,40);
	laptop d = new laptop(20,250,20);
	
	g2.setColor(Color.RED);     g2.draw(a);
	g2.setColor(Color.GREEN);   g2.draw(b);
	g2.setColor(Color.BLUE);    g2.draw(c);
	g2.setColor(Color.MAGENTA); g2.draw(d);
	
	charginglaptop h1 = new charginglaptop(100,250,75);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two charging laptops
	
	charginglaptop cl1 = new charginglaptop(50,350,75);
	charginglaptop cl2 = new charginglaptop(200,350,100);
	
	g2.draw(cl1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(cl2, Math.PI/4.0);
	
	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of laptops and a few charginglaptops by Zehao Li", 20,20);
    }
    
    /** Draw a different picture with a laptop and a charging laptop cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of laptops by Zehao Li", 20,20);
	
	
	// Draw a laptop and a charging laptop.
	
	laptop large = new laptop(100,50,150);
	charginglaptop small = new charginglaptop(20,50,30);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	
    }       
}
