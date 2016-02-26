package edu.ucsb.cs56.w16.drawings.nicolemoghaddas.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a sun that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Nicole Moghaddas
   @version for CS56, W16, UCSB
   
*/
public class Sun extends GeneralPathWrapper implements Shape
{
    /**
       Constructor for objects of class Sun
       
       @param x x coord of center of sun
       @param y y coord of center of sun
       @param r radius of sun's circle
    */
   public Sun(double x, double y, double r)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, and raduis.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.

	// create the sun circle
	// upper left corner of bounding box
	// width and height are double the radius
	Ellipse2D.Double sunCircle = new Ellipse2D.Double(x-r, y-r, r*2, r*2);

	//create the 6 rays of the sun
	Line2D.Double ray1 = new Line2D.Double (x, y - 3.0*r, // top ray
						x, y - 1.75*r);
	Line2D.Double ray2 = new Line2D.Double (x + 1.25*r, y - 1.15*r, // top right ray
						x + 2.25*r, y - 2.15*r);
	Line2D.Double ray3 = new Line2D.Double (x + 1.25*r, y + 1.15*r, // bottom right ray
						x + 2.15*r, y + 2.15*r);
	Line2D.Double ray4 = new Line2D.Double (x, y + 1.75*r, // bottom ray
						x, y + 3.0*r);
	Line2D.Double ray5 = new Line2D.Double (x - 1.25*r, y + 1.05*r, // bottom left ray
						x - 2.25*r, y + 2.05*r);
	Line2D.Double ray6 = new Line2D.Double (x - 1.25*r, y - 1.05*r, // top left ray
						x - 2.25*r, y - 2.05*r);

	// put the rays and circle together
	GeneralPath wholeSun = this.get();
	wholeSun.append(sunCircle, false);
        wholeSun.append(ray1, false);
        wholeSun.append(ray2, false);
	wholeSun.append(ray3, false);
        wholeSun.append(ray4, false);
	wholeSun.append(ray5, false);
        wholeSun.append(ray6, false);
    }
}
