package edu.ucsb.cs56.w16.drawings.sarahmzhong.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A slug
 
   @author Sarah Zhong 
   @version for CS56, W16, UCSB
   
*/
public class Slug extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of slug (if the slug were to be fit in a rectangle)
       @param y y coord of lower left corner of slug
       @param length length of the slug
       @param height height of slug without tentacles
    */
    public Slug(double x, double y, double length, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
       //make the slug body 
        
        Ellipse2D.Double body = 
            new Ellipse2D.Double(x-height, y-height,
				   length, height);
	
      // make the slug tentacles
      
        Line2D.Double rightTentacle =
            new Line2D.Double (x + length/12.0, y - height + height/4.0,
                               x + length/12.0, y - height - height/4.0);
	
        Line2D.Double leftTentacle = 
            new Line2D.Double (x+length/12.0 - length/16.0, y-height+height/4.0,
                               x+length/12.0 - length/16.0, y-height-height/4.0);

        // put the slug together
	
        GeneralPath wholeSlug = this.get();
        wholeSlug.append(body, false);
        wholeSlug.append(rightTentacle, false);
        wholeSlug.append(leftTentacle, false);    
    }
}
