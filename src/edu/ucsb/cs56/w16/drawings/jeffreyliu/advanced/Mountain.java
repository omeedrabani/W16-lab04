package edu.ucsb.cs56.w16.drawings.jeffreyliu.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a mountain that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jeffrey Liu
   @version for CS56, W16, UCSB
   
*/
public class Mountain extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of tip of mountain
       @param y y coord of tip of mountain
       @param width width of mountain
       @param height height of mountain
    */
    public Mountain(double x, double y, double width, double height)
    {
	
        Line2D.Double leftSlope = 
            new Line2D.Double (x - width/2.0, y + height,
                               x, y);
	
        Line2D.Double rightSlope =
            new Line2D.Double (x, y,
                               x + width/2.0, y + height);
	
        GeneralPath wholeMountain = this.get();
        wholeMountain.append(leftSlope, false);
        wholeMountain.append(rightSlope, false);    
    }
}
