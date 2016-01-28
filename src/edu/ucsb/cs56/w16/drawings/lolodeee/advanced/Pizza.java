package edu.ucsb.cs56.w16.drawings.lolodeee.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a pizza that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Lauren Dumapias
   @version for CS56, W16, UCSB
   
*/

public class Pizza extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of top left of pizza
       @param yy coord of top left of pizza
       @param width of crust
       @param height of pizza 
    */
    public Pizza(double x, double y, double width, double height)
    {
	double crustHeight = 0.15*height;
        //make crust

	Ellipse2D.Double crust = new Ellipse2D.Double(x, y, width, crustHeight);
	

	// make the pizza shape
	Line2D.Double leftEdge = 
            new Line2D.Double (x, y+0.5*crustHeight,
                               x+width*0.5, y+crustHeight*0.5+height);

	Line2D.Double rightEdge = new Line2D.Double (x+width*0.5, y+crustHeight*0.5+height, x+width, y+0.5*crustHeight);

	//put whole pizza together
	GeneralPath pizzaSlice = this.get();
	pizzaSlice.append(crust,false);
	pizzaSlice.append(leftEdge,false);
	pizzaSlice.append(rightEdge,false);
    }
}
        
