package edu.ucsb.cs56.w16.drawings.dongyangli.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Dongyang Li 
   @version for CS56, W16, UCSB
   
*/
public class Paper extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of paper
       @param y y coord of lower left corner of paper
       @param width of the paper
       @param height of paper
    */
    public Paper(double x, double y, double width, double height)
    {
	
	
        Rectangle2D.Double first = 
            new Rectangle2D.Double(x, y, width, height);
	
	
        GeneralPath wholePaper = this.get();
        wholePaper.append(first, false);
  
    }
}
