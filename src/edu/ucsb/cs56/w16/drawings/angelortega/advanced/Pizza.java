package edu.ucsb.cs56.w16.drawings.angelortega.advanced;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

public class Pizza extends GeneralPathWrapper implements Shape {


	/**
 *        Constructor
 *               
 *                      @param x x coord of middle crust of pizza
 *                             @param y y coord of top crust side of pizza
 *                                           @param radius of pizza 
 *                                               */
	public Pizza(double x, double y, double radius) {
		GeneralPath myYummyCrust = new GeneralPath();
		
		// test radius
		//int radius = 300;
		
		myYummyCrust.moveTo(x,y);
		myYummyCrust.lineTo(x - 0.25*radius, y);
		myYummyCrust.lineTo(x - 0.20*radius, y + y * 0.10);
		myYummyCrust.lineTo(x + 0.20*radius, y + y * 0.10);
		myYummyCrust.lineTo(x + 0.25*radius, y);
		myYummyCrust.lineTo(x,y);
		
		GeneralPath cheeseOutline = new GeneralPath();
		cheeseOutline.moveTo(x, y + radius);
		cheeseOutline.lineTo(x - radius * 0.25, y);
		cheeseOutline.moveTo(x, y + radius);
		cheeseOutline.lineTo(x + radius * 0.25,y);
		
		
		//myYummyCrust
		GeneralPath myPizzaSlice = this.get();
		myPizzaSlice.append(myYummyCrust, false);
		myPizzaSlice.append(cheeseOutline, false);
		//this.set(myPizzaSlice);
	}
}
