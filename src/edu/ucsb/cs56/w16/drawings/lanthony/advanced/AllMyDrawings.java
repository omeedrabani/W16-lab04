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
	
	Glass h1 = new Glass(100,170,50,75);
	g2.setColor(Color.BLACK); g2.draw(h1);

	
	Glass w2 = new Glass(200,50,100,150);
	g2.setColor(Color.BLACK); g2.draw(w2);
	g2.setColor(Color.MAGENTA); g2.draw(w2);


	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
 
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.MAGENTA); 
	g2.draw(w2);


	Glass g4 = new Glass(50,50,100,130);
	g2.setColor(Color.RED); g2.draw(g4);


	Shape g5 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	g5 = ShapeTransforms.translatedCopyOf(g5,150,0);
	g2.setColor(Color.GREEN); g2.draw(g5);

	Glass g6 = new Glass(0,100,40,70);
	g2.setColor(Color.ORANGE); g2.draw(g6);
	
	// drawing label

	Stroke orig2=g2.getStroke();
	g2.setStroke(orig2);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of glasses by Laura Anthony", 20,20);
    }
    

    public static void drawPicture2(Graphics2D g2) {

	//	Glass h1 = new Glass(100,250,50,75);
	//	g2.setColor(Color.BLACK); g2.draw(h1);


      	WineGlass w1 = new WineGlass(100,200,75,75); 
	g2.setColor(Color.MAGENTA); g2.draw(w1);

	WineGlass w2 = new WineGlass(100,100,40,75); 
	g2.setColor(Color.RED); g2.draw(w2);
	

		
	// drawing label
	Stroke orig=g2.getStroke();
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of wine glasses by Laura Anthony", 20,20);

	
    }
    
 
    public static void drawPicture3(Graphics2D g2) {
	
	
	g2.drawString("A bunch of glasses and wine glasses by Laura Anthony", 20,20);
	
	
	// Draw some wine glasses.
	
	Glass one = new Glass(100,70,30,23);
	Glass two = new Glass(100,200,40,23);
	Glass three = new Glass(25,130,40,23);
	
	g2.setColor(Color.RED);     g2.draw(one);
	g2.setColor(Color.GREEN);   g2.draw(two);
	g2.setColor(Color.BLUE);   g2.draw(three);
	
    }       
}
