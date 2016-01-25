package edu.ucsb.cs56.w16.drawings.andrewhuang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes


import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a bracelet that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Andrew Huang
   @version for CS56, W16, UCSB
   
*/
public class Bracelet extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of bracelet
       @param y y coord of lower left corner of bracelet
       @param width width of the bracelet
       @param height of bracelet
    */
    public Bracelet(double x, double y, double width, double height)
    {
        
        // Make the band
	Rectangle2D.Double band = new Rectangle2D.Double(x, y, width, height);

	// Make the face (circle)
	double radius;
	
	// dependent on orientation
	double newX;
	double newY;
	if(width > height)
	    {
		radius = height;
		newX = x + width/2 - radius/2;
		newY = y;
	    }
	else
	    {
		radius = width;
		newX = x;
		newY = y + height/2 - radius/2;
	    }
	Ellipse2D.Double face = new Ellipse2D.Double(newX, newY, radius, radius);
	
	

        // put the whole braelet together
	
        GeneralPath wholeBracelet = this.get();
	wholeBracelet.append(band, false);
	wholeBracelet.append(face, false);

    }
}
