package edu.ucsb.cs56.w16.drawings.bpatient.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A House
      
   @author Ben Patient 
   @version for CS56, W16, UCSB
   
*/
public class Screenception extends Screen implements Shape
{
    /**
     * Constructor for objects of class ScreenWithOS
     */
    public Screenception(double x, double y, double width, double height)
    {
	// construct the basic house shell 
		super(x,y,width,height);
		x = x;
		y = y;
		double width2 = width/2.0;
		double height2 = height/2.0; 
		Line2D.Double base1 =new Line2D.Double (x + width/2.0 - width2/2.0  + width2/2.0, y + height/2.0 - height2/2.0 + height2, x + width/2.0 - width2/2.0  + width2/2.0, y + height/2.0 - height2/2.0 +height2 + height2/3.0 - 5);
        Line2D.Double base2 =new Line2D.Double (x + width/2.0 - width2/2.0  + width2/3.0, y + height/2.0 - height2/2.0  + height2 + height2/3.0 - 5, x + width/2.0 - width2/2.0 + 2.0 * width2  /3.0, y + height/2.0 - height2/2.0  + height2 + height2/3.0 - 5);
    	Rectangle2D.Double outerLayer = new Rectangle2D.Double(x + width/2.0 - width2/2.0 ,y + height/2.0 - height2/2.0 ,width2,height2);
    	Rectangle2D.Double innerLayer = new Rectangle2D.Double(x + width/2.0 - width2/2.0+10,y + height/2.0 - height2/2.0+10,width2-20,height2-20);
    	Circle powerButton = new Circle(x + width/2.0 - width2/2.0 +5,y + height/2.0 - height2/2.0+5,3);
	    GeneralPath wholeScreen = this.get();
        wholeScreen.append(outerLayer, false);
        wholeScreen.append(innerLayer, false);
        wholeScreen.append(base1, false);
        wholeScreen.append(base2, false);
        wholeScreen.append(powerButton, false);
	}
}
	
