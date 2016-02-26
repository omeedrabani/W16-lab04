package edu.ucsb.cs56.w16.drawings.angelortega.advanced;

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
 * @author Angel Ortega 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few pizzas 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	
	//House h1 = new House(100,250,50,75);
	Pizza za = new Pizza(100,250,200);
	g2.setColor(Color.RED); 
	g2.draw(za);
	
	// Make a pizza that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape za2 = ShapeTransforms.scaledCopyOfLL(za,0.5,0.5);
	za2 = ShapeTransforms.translatedCopyOf(za2,150,0);
	g2.setColor(Color.BLACK); 
	g2.draw(za2);
	
	// Here's a pizza that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	za2 = ShapeTransforms.scaledCopyOfLL(za2,4,4);
	za2 = ShapeTransforms.translatedCopyOf(za2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(za2); 
	
	// Draw two cheese pizzas with Pepperonis
	
	PepperoniPizza papaJohns = new PepperoniPizza(150,30,150,10);
	PepperoniPizza dominos = new PepperoniPizza(400,200,100,20);	
	
	g2.draw(papaJohns);
	g2.setColor(new Color(0x8F4422));
	g2.draw(dominos);
	
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few pizzas by Angel Ortega", 20,20);
    }
    
    
    /** Draw a picture with a few cheese pizzas and pepperoniPizzas
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some varied pizzas.
	
	Pizza large = new Pizza(100,50,300);
	Pizza xLarge = new Pizza(10,50,350);
	PepperoniPizza small = new PepperoniPizza(300,150,200,10);
	PepperoniPizza xsmall  = new PepperoniPizza(200,250,100,6);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(xLarge);
	g2.setColor(Color.BLUE);    g2.draw(small);
	g2.setColor(Color.MAGENTA); g2.draw(xsmall);
	
	Pizza za1 = new Pizza(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(za1);
	
	// Make a black pizza that's half the size, 
	// and moved over 150 pixels in x direction
	Shape za2 = ShapeTransforms.scaledCopyOfLL(za1,0.5,0.5);
	za2 = ShapeTransforms.translatedCopyOf(za2,150,0);
	g2.setColor(Color.BLACK); g2.draw(za2);
	
	// Here's a pizza that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	za2 = ShapeTransforms.scaledCopyOfLL(za2,4,4);
	za2 = ShapeTransforms.translatedCopyOf(za2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(za2); 
	
	// Draw two pizzas with pepperonis
	
	PepperoniPizza littleCesars = new PepperoniPizza(50,350,40,5);
	PepperoniPizza pizzaMyHeart = new PepperoniPizza(200,350,200,15);
	
	g2.draw(littleCesars);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	Shape costcoPizza = ShapeTransforms.rotatedCopyOf(pizzaMyHeart, Math.PI/4.0);
	
	g2.draw(costcoPizza);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of awesome cheese pizzas and pepperoni pizzas by Angel Ortega", 20,20);
    }
    
    /** Draw a different picture with a few pizzas
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Pizzas by Angel Ortega", 20,20);
	
	
	// Draw some pizzas
	
	Pizza costco = new Pizza(100,50,300);
	PepperoniPizza small = new PepperoniPizza(300,50,100,10);
	
	g2.setColor(Color.RED);     g2.draw(costco);
	g2.setColor(Color.GREEN);   g2.draw(small);
	
    }       
}
