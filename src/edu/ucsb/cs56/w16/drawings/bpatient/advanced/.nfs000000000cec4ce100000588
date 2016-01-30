package edu.ucsb.cs56.w16.drawings.bpatient.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a screen that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Ben Patient
   @version for CS56, W16, UCSB
   
*/
public class Screen extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of screen
       @param y y coord of lower left corner of screen
       @param width width of the screen
       @param height of screen
    */
    public Screen(double x, double y, double width, double height)
    {
	
        
        double outerTop = height;
        double innerTop = height - 20;
        
        
        // Make the first story
        Line2D.Double base1 =new Line2D.Double (x + width/2.0, x + width/2.0, y + height, y +height + height/3.0);
        Line2D.Double base2 =new Line2D.Double (x + width/3.0, y + height + height/3.0, x + 2.0 * width  /3.0, y + height + height/3.0);
        Rectangle2D.Double outerLayer = new Rectangle2D.Double(x,y,width,height);
        Rectangle2D.Double innerLayer = new Rectangle2D.Double(x+10,y+10,width-20,height-20);
        Circle powerButton = new Circle(x+5,y+5,3);
	      GeneralPath wholeScreen = this.get();
        wholeScreen.append(outerLayer, false);
        wholeScreen.append(innerLayer, false);
        wholeScreen.append(base1, false);
        wholeScreen.append(base2, false);
        wholeScreen.append(powerButton, false);
    }
}