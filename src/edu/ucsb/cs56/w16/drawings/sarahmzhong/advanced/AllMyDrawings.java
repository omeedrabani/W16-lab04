package edu.ucsb.cs56.w16.drawings.sarahmzhong.advanced;

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
 * @author Sarah Zhong
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few slugs and snails
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Slug h1 = new Slug(100,250,100,20);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black slug that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a slug that's 4x as big (2x the original)
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
	
	// Draw two snails
	
	Snail s1 = new Snail(50,350,150,35,60);
	Snail s2 = new Snail(200,350,500,30,90);
	
	g2.draw(s1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(s2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few slugs and snails by Sarah Zhong", 20,20);
    }
    
    
    /** Draw a picture with a few mollusks
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some snails
	
  Snail fat = new Snail(50, 400, 300, 100, 100);
	Snail tiny = new Snail(200,200,60,10,20);
	
	g2.setColor(Color.MAGENTA);     g2.draw(fat);
	g2.setColor(Color.GREEN);   g2.draw(tiny);
	
  Slug aSlug = new Slug(100,100,200,30);
  g2.setColor(Color.CYAN); g2.draw(aSlug);
	
	// Make a black snail that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(aSlug,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(aSlug,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a snail that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xDB7093)); 
	g2.draw(h2); 
	
	// Rotate snail 45 degrees around its center.
	Shape h3 = ShapeTransforms.rotatedCopyOf(h2, Math.PI/4.0);
	
	g2.draw(h3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of snails and slugs by Sarah Zhong", 20,20);
    }
    
    /** Draw a different picture with mollusks
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A snail and a slug by Sarah Zhong", 20,20);
	
  Snail s1 = new Snail(100,200,100,30,50);
  Slug s2 = new Slug(300,300,400,20);
  	
	// Draw some mollusks	
	
	g2.setColor(Color.RED);     g2.draw(s1);
	g2.setColor(Color.GREEN);   g2.draw(s2);
	
    }       
}
