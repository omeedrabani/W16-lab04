package edu.ucsb.cs56.w16.drawings.lanthony.advanced;

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
 * @author Laura Anthony
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /* Draw a few glasses*/
    
    public static void drawPicture1(Graphics2D g2) {
	
	Glass h1 = new Glass(100,250,50,75);
	g2.setColor(Color.BLACK); g2.draw(h1);

	
	Glass w2 = new Glass(400,100,100,150);
	g2.setColor(Color.BLACK); g2.draw(w2);
	g2.setColor(Color.MAGENTA); g2.draw(w2);


	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
 
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.MAGENTA); 
	g2.draw(w2);


	Glass g4 = new Glass(50,50,25,50);
	g2.setColor(Color.RED); g2.draw(g4);


	Shape g5 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	g5 = ShapeTransforms.translatedCopyOf(g5,150,0);
	g2.setColor(Color.GREEN); g2.draw(g5);

	Glass g6 = new Glass(0,200,50,75);
	g2.setColor(Color.ORANGE); g2.draw(g6);
	
	// drawing label

	Stroke orig2=g2.getStroke();
	g2.setStroke(orig2);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few glasses by Laura Anthony", 20,20);
    }
    

    public static void drawPicture2(Graphics2D g2) {

	Glass h1 = new Glass(100,250,50,75);
	g2.setColor(Color.BLACK); g2.draw(h1);


      	WineGlass w1 = new WineGlass(100,150,50,75); 
	g2.setColor(Color.MAGENTA); g2.draw(w1);
	

	/*	
	// drawing label
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of glasses and a few wine glasses by Laura Anthony", 20,20);*/

	
    }
    
 
    public static void drawPicture3(Graphics2D g2) {
	
	
	g2.drawString("A bunch of wine glasses by Laura Anthony", 20,20);
	
	
	// Draw some wine glasses.
	
	Glass large = new Glass(100,50,225,150);
	Glass smallCC = new Glass(20,50,40,30);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	
    }       
}
