package edu.ucsb.cs56.w16.drawings.christiannewkirk.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a rectangle that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Christian Newkirk 
   @version for CS56, W16, UCSB
   
*/
public class Rectangle extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of Rectangle
       @param y y coord of lower left corner of Rectangle
       @param width width of the Rectangle
       @param height of Rectangle
    */
    public Rectangle(double x, double y, double width, double height)
    {
	
        Rectangle2D.Double myRectangle = 
            new Rectangle2D.Double(x, y ,
				   width, height);
	
	
        GeneralPath rectangle = this.get();
        rectangle.append(myRectangle, false);
    
    }
}
