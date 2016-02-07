package edu.ucsb.cs56.w16.drawings.lanthony.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.awt.geom.Arc2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A Wine Glass 
      
   @author Laura Anthony
   @version for CS56, W16, UCSB
   
*/
public class WineGlass extends Glass implements Shape
{
    public WineGlass(double x, double y, double width, double height)
    {
	// construct the basic glass
	super(x,y, width, height);
			  

	//	GeneralPath gp = this.get();

	//	double stop = height;
	//	double sW = .50*width;
		//	double sHt = 1.5 * height;
       
		Rectangle2D.Double stem =
	  new Rectangle2D.Double(3*x, 1.5*y, (1/5)*width, height);

	/*	GeneralPath stem = new GeneralPath();
	stem.moveTo(x,y);
	stem.lineTo(x,y-5);
	*/
	Shape glassRing  = new Arc2D.Double(x-100,y-250, 100.00,
				   100.0, 0.00, 180.00, Arc2D.OPEN);

	Shape glassRing2  = new Arc2D.Double(x-100,y-250, 100.00,
				   100.00, 0.00, -180.00, Arc2D.OPEN);


	GeneralPath wholeGlass = this.get();
        wholeGlass.append(stem, false);
      	wholeGlass.append(glassRing, false);
	wholeGlass.append(glassRing2, false);
	       

        



	
 
    }    
}
