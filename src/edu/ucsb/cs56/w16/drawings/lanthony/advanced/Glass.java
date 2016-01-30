package edu.ucsb.cs56.w16.drawings.lanthony.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A Glass (wrapper around a General Path, implements Shape)

  
   @author Laura Anthony 
   @version for CS56, W16, UCSB
   
*/
public class Glass extends GeneralPathWrapper implements Shape
{   
    /**
     * Constructor for objects of class Glass 
     */
    public Glass (double x, double y, double width, double height)
    {
	
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* coffee cup
		  
        final double ORIG_ULX = -200.0; 
        final double ORIG_ULY = -200.0; 
        final double ORIG_HEIGHT = 300.0; 
        final double ORIG_WIDTH = 300.0; 
	 
        GeneralPath LCurve = new GeneralPath();
	
        // left side of glass
	
        LCurve.moveTo(x,y);
	LCurve.lineTo(x-20,y-5);
	LCurve.lineTo(x-40,y-10);
	LCurve.lineTo(x-60,y-15);
	LCurve.lineTo(x-80,y-20);
	LCurve.lineTo(x-100,y-25);
	LCurve.lineTo(x-100,y-200);		
	LCurve.lineTo(x-95,y-200);
	LCurve.lineTo(x-90,y-200);
       


	Shape glassRing2  = new Arc2D.Double(x-100,y-250, 600.00,
				   100.00, 0.00, -180.00, Arc2D.OPEN);

	
	Shape wineLine  = new Arc2D.Double(x-100,y-200, 600.00,
				   100.00, 0.00, -180.00, Arc2D.OPEN);
	Shape bottomCurve  = new Arc2D.Double(x,y, 400.00,
				   0.00, 0.00, -180.00, Arc2D.OPEN);

	Shape glassRing  = new Arc2D.Double(x-100,y-250, 600.00,
				   100.0, 0.00, 180.00, Arc2D.OPEN);
	

	
        Shape RCurve = ShapeTransforms.horizontallyFlippedCopyOf(LCurve);
       
        RCurve = ShapeTransforms.translatedCopyOf(RCurve, 600.0, 0.0);
       
        GeneralPath wholeGlass = new GeneralPath ();
        wholeGlass.append(glassRing, false);
        wholeGlass.append(LCurve, false);
        wholeGlass.append(RCurve, false);
	wholeGlass.append(bottomCurve, false);
	wholeGlass.append(wineLine, false);
        wholeGlass.append(glassRing2, false);
	

        
		Shape s = ShapeTransforms.translatedCopyOf(wholeGlass, -ORIG_ULX + x, -ORIG_ULY + y);
		s =  ShapeTransforms.scaledCopyOf(s,  width/ORIG_WIDTH, height/ORIG_HEIGHT) ;
		this.set(new GeneralPath(s));
        
    }

}
