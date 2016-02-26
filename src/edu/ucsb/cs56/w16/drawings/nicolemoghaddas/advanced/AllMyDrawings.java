package edu.ucsb.cs56.w16.drawings.nicolemoghaddas.advanced;

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
    /** Draw a picture with a few suns 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Sun s1 = new Sun(165,110,25);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// Make a black sun that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,200,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a sun that's 2.2x as big
	// and moved over 140 more pixels to right.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,2.2,2.2);
	s2 = ShapeTransforms.translatedCopyOf(s2,140,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #FFFF333 is Yellow
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xFFFF33)); 
	g2.draw(s2); 
	
	// Draw two suns with Faces
	
	SunWithFace sw1 = new SunWithFace(105,320,51);
	SunWithFace sw2 = new SunWithFace(400,300,50);
	
	g2.setColor(new Color(0xFF9900)); g2.draw(sw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(sw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.PINK); 
	g2.drawString("A few suns by Nicole", 20,20);
    }
    
    
    /** Draw a picture with everything - suns, coffee cups, and houses
     */
    public static void drawPicture2(Graphics2D g2) {
	
	Sun s2 = new Sun(50,90,20);
        HouseWithWindows h1 = new HouseWithWindows(20,170,20,40);
	
	g2.setColor(Color.BLUE);    g2.draw(h1);
	g2.setColor(Color.MAGENTA); g2.draw(s2);
	
	SunWithFace s1 = new SunWithFace(150,240,35);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// Make a black sun that's half the size, 
	// and moved over 150 pixels in x direction
	Shape s3 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s3 = ShapeTransforms.translatedCopyOf(s3,165,0);
	g2.setColor(Color.BLACK); g2.draw(s3);
	
	// Here's a sun that's 3x as big
	// and moved over 140 more pixels to right.
	s3 = ShapeTransforms.scaledCopyOfLL(s3,3,3);
	s3 = ShapeTransforms.translatedCopyOf(s3,140,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 

	g2.setColor(new Color(0x339900)); 
        CoffeeCup c1 = new CoffeeCup(150,350,70,60);
	
	g2.draw(c1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second sun 45 degrees around its center.
	Shape s4 = ShapeTransforms.rotatedCopyOf(s2, Math.PI/4.0);
	
	g2.draw(s3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A Nice Day with Suns, Coffee, and a Home by Nicole Moghaddas", 20,20);
    }
    
    /** Draw a different picture with a few suns
     */
    
    public static void drawPicture3(Graphics2D g2) {

	// A drawing with two suns - uncomment this one
	/*
	// label the drawing

	g2.drawString("A Couple Suns by Nicole Moghaddas", 20,20);
	
	// Draw some suns.
	
        Sun reg = new Sun(100,150,40);
	SunWithFace smiley = new SunWithFace(415,240,70);
	
	g2.setColor(Color.MAGENTA);     g2.draw(reg);
	g2.setColor(Color.YELLOW);   g2.draw(smiley);
	*/
	
	//////////////////////////////////////////////////////////////////////
	// A drawing of a scene - uncomment this one

	// label
	g2.drawString("A Soothing Day :]", 20,20);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	SunWithFace smile = new SunWithFace(450,120,50);
	g2.setColor(Color.YELLOW); g2.draw(smile);

	g2.setStroke(orig);
	HouseWithWindows house = new HouseWithWindows(180, 240, 200, 200);
	g2.setColor(Color.DARK_GRAY); g2.draw(house);

	g2.setStroke(thick);
	CoffeeCup mug = new CoffeeCup(500, 390, 50, 50);
	g2.setColor(Color.PINK); g2.draw(mug);
    }       
}
