package edu.ucsb.cs56.w16.drawings.rkuang.advanced;

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
 * @author Ricky Kuang
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{

    // draw spoons and sporks
    public static void drawPicture1(Graphics2D g2) {
	
	// draw the original, hard-coded spoon in cyan
	Spoon s1 = new Spoon(130,200,50,195);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// draw the spoon at half size in black
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);

	// draw the spoon at quadruple the half spoon (double the original spoon) in a thick, dark blue
	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);

	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 
	
	// Draw two sporks
	Spork spork1 = new Spork(50,150,40,75);
	Spork spork2 = new Spork(200,75,200,200);
	
	g2.draw(spork1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(spork2);
	
	// Title and Sign
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Spoons and Sporks, Ricky Kuang", 20,20);
    }
    
    
    /** Draw a picture with a few Sporks and Spoons
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some Spoons
	
	Spoon spoon = new Spoon(260,60,100,390);
	Spork spork = new Spork(260,60,100,390);

	Shape spoonRotated = ShapeTransforms.rotatedCopyOf(spoon, Math.PI/4.0);
	Shape sporkRotated = ShapeTransforms.rotatedCopyOf(spork, -Math.PI/4.0);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	
	g2.setColor(Color.RED);     g2.draw(spoonRotated);
	g2.setColor(Color.BLUE);    g2.draw(sporkRotated);
	
	g2.setStroke(orig);

	Shape s1 = ShapeTransforms.scaledCopyOfLL(spoon,0.5,0.5);
	s1 = ShapeTransforms.translatedCopyOf(s1,230,-70);
	g2.setColor(new Color(0x002FA7)); g2.draw(s1);
	
	Shape s2 = ShapeTransforms.scaledCopyOfLL(spork,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,-160,-70);
	g2.setColor(new Color(0x8F00FF)); g2.draw(s2);
	

	
	g2.setColor(Color.BLACK); 
	g2.drawString("Utensil Fight", 20,20);
    }
    
    /** Sporky Spoon Spiral
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Sporky Spoon Spiral, Ricky Kuang", 20,20);

	Stroke thick = new BasicStroke (2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	
	Spoon spoon = new Spoon(260,60,100,390);
	Spork spork = new Spork(260,60,100,390);

	Shape spoonRotated = ShapeTransforms.rotatedCopyOf(spoon, 1.0/4.0);
	Shape sporkRotated = ShapeTransforms.rotatedCopyOf(spork, 1.0/4.0);
	
	for (int i = 0; i < 50; i++){
		int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        Color randomColor = new Color(red, green, blue);
        g2.setColor(randomColor);

		spoonRotated = ShapeTransforms.rotatedCopyOf(spoonRotated, 1.0/4.0);
		sporkRotated = ShapeTransforms.rotatedCopyOf(sporkRotated, 1.0/4.0);
		if (i % 2 == 1)
			g2.draw(spoonRotated);
		else
			g2.draw(sporkRotated);
	}
	
    }       
}
