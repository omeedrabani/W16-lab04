package edu.ucsb.cs56.w16.drawings.jeffreyliu.advanced;

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
 * @author Jeffrey Liu
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few mountains
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Mountain m1 = new Mountain(100,300,50,75);
	g2.setColor(Color.MAGENTA); g2.draw(m1);
	
	Shape m2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.4);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	g2.setColor(Color.ORANGE); g2.draw(m2);
	
	m2 = ShapeTransforms.scaledCopyOfLL(m2,4,4);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,-30);
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(m2);
	
	SnowyMountain sm1 = new SnowyMountain(50,350,40,75);
	SnowyMountain sm2 = new SnowyMountain(230,400,150,120);
	
	g2.draw(sm1);
	g2.setColor(new Color(0xDDE26A)); g2.draw(sm2);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A Few Mountains by Jeffrey Liu", 20,20);
    }
    

    /** Draw another picture with a few mountains
     */
    public static void drawPicture2(Graphics2D g2) {
	
	Mountain m1 = new Mountain(100,20,225,150);
	Mountain m2 = new Mountain(20,20,40,30);
	SnowyMountain sm1 = new SnowyMountain(50,130,20,40);
	SnowyMountain sm2 = new SnowyMountain(20,230,40,20);
	
	g2.setColor(Color.RED);     g2.draw(m1);
	g2.setColor(Color.GREEN);   g2.draw(m2);
	g2.setColor(Color.BLUE);    g2.draw(sm1);
	g2.setColor(Color.MAGENTA); g2.draw(sm2);
	
	Shape m3 = ShapeTransforms.scaledCopyOfLL(m2,0.5,0.5);
	m3 = ShapeTransforms.translatedCopyOf(m3,150,0);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x563C5C)); 
	g2.draw(m3); 
	
	SnowyMountain sm3 = new SnowyMountain(200,350,80,95);
	
	g2.setColor(new Color(0x1E4D2B));
	
	Shape sm4 = ShapeTransforms.rotatedCopyOf(sm3, Math.PI);
	
	g2.draw(sm4);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("An Upside Down Snowy Mountain by Jeffrey Liu", 20,20);
	}
    
    /** Draw a different picture with a few mountains
     */
    
    public static void drawPicture3(Graphics2D g2) {

        Mountain m1 = new Mountain(35,45,80,120);
        Mountain m2 = new Mountain(60,120,60,60);
        SnowyMountain sm1 = new SnowyMountain(90,60,30,40);
        SnowyMountain sm2 = new SnowyMountain(20,150,40,30);
	
	g2.setColor(Color.RED);
	Shape s1 = ShapeTransforms.rotatedCopyOf(m1, Math.PI/2.0);
	g2.draw(s1);

	g2.setColor(Color.GREEN);
	Shape s2 = ShapeTransforms.rotatedCopyOf(m2, Math.PI/3.0);
	g2.draw(s2);

	g2.setColor(Color.LIGHT_GRAY);
	Shape s3 = ShapeTransforms.rotatedCopyOf(sm1, 3 * Math.PI/4.0);
	g2.draw(s3);

	g2.setColor(Color.YELLOW);
	Shape s4 = ShapeTransforms.rotatedCopyOf(sm2, 5 * Math.PI/3.0);
	g2.draw(s4);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	Stroke orig=g2.getStroke();
	g2.setStroke(orig);
	g2.setColor(Color.BLACK);
	g2.drawString("Tilted Mountains by Jeffrey Liu", 20, 20);
	
    }
}
