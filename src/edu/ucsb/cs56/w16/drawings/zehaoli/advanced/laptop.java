package edu.ucsb.cs56.w16.drawings.zehaoli.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a laptop
      
   @author Zehao Li 
   @version for CS56, W16, UCSB
   
*/
public class laptop extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of upper left corner of house
       @param y y coord of upper left corner of house
       @param height of screen (16:9)
    */
    public laptop(double x, double y, double height)
    {
	
        
        double width = 1.8 * height;
        
	double keyheight= 0.3 * height;

        // Make the screen
        
        Rectangle2D.Double screen = 
            new Rectangle2D.Double(x, y ,
				   width, height);
	
        
        Line2D.Double leftkey = 
            new Line2D.Double (x, y + height,
                               x - keyheight , y + height + keyheight);
	
        Line2D.Double rightkey =
            new Line2D.Double (x + width , y + height,
                               x + width + keyheight, y + height + keyheight);
	
        Line2D.Double botkey = 
            new Line2D.Double (x - keyheight, y + height + keyheight,
                               x + width + keyheight, y + height + keyheight);

        // put the whole parts together
	
        GeneralPath thislaptop = this.get();
        thislaptop.append(screen, false);
        thislaptop.append(leftkey, false);
        thislaptop.append(rightkey, false);
	thislaptop.append(botkey, false);
    }
}
