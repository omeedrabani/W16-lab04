package edu.ucsb.cs56.w16.drawings.rkuang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a spoon that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Ricky Kuang
   @version for CS56, W16, UCSB
   
*/

public class Spoon extends GeneralPathWrapper implements Shape {

    /**
       Constructor
       
       @param x x coord of lower left corner of spoon
       @param y y coord of lower left corner of spoon
       @param width width of the spoon
       @param height height of the spoon
    */

    public Spoon(double x, double y, double width, double height) {

        // Specify the upper left corner, and the 
        // width and height of the original points used to 
        // plot the *hard-coded* spoon

        final double ORIG_ULX = 130.0; 
        final double ORIG_ULY = 50.0; 
        final double ORIG_WIDTH = 200.0; 
        final double ORIG_HEIGHT = 340.0; 

        // left side of the spoon
        GeneralPath leftSide = new GeneralPath();
	
        leftSide.moveTo(130,50);
        leftSide.lineTo(100,90);
        leftSide.lineTo(100,140);
        leftSide.lineTo(140,175);
        leftSide.lineTo(125,340);
        leftSide.lineTo(140,390);

        // top of the spoon
        GeneralPath topAndBottom = new GeneralPath();
       
        topAndBottom.moveTo(130,50);
        topAndBottom.lineTo(170,50); // top of spoon
        topAndBottom.moveTo(140,390);
        topAndBottom.lineTo(160,390); // bottom of spoon

        // right side of the spoon
        // flip and move
        Shape rightSide = ShapeTransforms.horizontallyFlippedCopyOf(leftSide);
        rightSide = ShapeTransforms.translatedCopyOf(rightSide, 100.0, 0.0);

       	// ASSEMBLE THE SPOON!
        GeneralPath wholeSpoon = new GeneralPath ();
        wholeSpoon.append(topAndBottom, false);
        wholeSpoon.append(leftSide, false);
        wholeSpoon.append(rightSide, false);

        // move to (x,y)
        Shape s = ShapeTransforms.translatedCopyOf(wholeSpoon, -ORIG_ULX + x, -ORIG_ULY + y);
 
		// scale to height and width
        s =  ShapeTransforms.scaledCopyOf(s, width/ORIG_WIDTH, height/ORIG_HEIGHT);
		this.set(new GeneralPath(s));
    }

}


