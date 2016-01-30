package edu.ucsb.cs56.w16.drawings.angelortega.advanced;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

public class PepperoniPizza extends Pizza {

	/**
 *          Constructor
 *                  
 *                          @param x x coord of middle crust of pizza
 *                                  @param y y coord of top crust side of pizza
 *                                                 @param radius of pizza 
 *                                                 @param pepperoniRadius of pepperoni's
 *                                                    */

	public PepperoniPizza(double x, double y, double radius, double pepperoniRadius) {
		
		super(x,y,radius);
		
		
		//Circle pepperoni = new Circle(x,y+20,pepperoniRadius);
		GeneralPath myPizzaSlice = this.get();
		Ellipse2D.Double circle = new Ellipse2D.Double(x,y+20,pepperoniRadius*2,pepperoniRadius*2);
		Ellipse2D.Double secondPep = new Ellipse2D.Double(x-5,y+52, pepperoniRadius,pepperoniRadius);
		myPizzaSlice.append(circle, false);
		myPizzaSlice.append(secondPep,false);
		//this.set(myPizzaSlice);
	}
}
