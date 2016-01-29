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
	  
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 300.0; 
        final double ORIG_WIDTH = 400.0; 
        
        GeneralPath LCurve = new GeneralPath();
	
        // left side of cup
	
        LCurve.moveTo(400,400);
	LCurve.lineTo(380,395);
        LCurve.lineTo(360,390);
        LCurve.lineTo(340,385);
        LCurve.lineTo(320,380);
	LCurve.lineTo(300,375);
	LCurve.lineTo(285,370);
	LCurve.lineTo(270,360);
	LCurve.lineTo(265,350);
	LCurve.lineTo(260,340);
	LCurve.lineTo(255,330);
	LCurve.lineTo(250,325);	
        LCurve.lineTo(250,200);
	LCurve.lineTo(255,170);	
        LCurve.lineTo(260,165);
	LCurve.lineTo(265,160);	
        LCurve.lineTo(270,155);
	LCurve.lineTo(275,150);	
        LCurve.lineTo(277,145);
	LCurve.lineTo(280,140);


	Shape wineLine  = new Arc2D.Double(250.00,175.00, 600.00,
				   100.00, 0.00, -180.00, Arc2D.OPEN);
	
        Shape glassRing = new Ellipse2D.Double(280,100,555,100);
	Shape bottomCurve = new Arc2D.Double(400.00,385.00, 300.00,
				   30.00, 0.00, -180.00, Arc2D.OPEN);
	
	
        Shape RCurve = ShapeTransforms.horizontallyFlippedCopyOf(LCurve);
       
        RCurve = ShapeTransforms.translatedCopyOf(RCurve, 600.0, 0.0);
       
        GeneralPath wholeCup = new GeneralPath ();
        wholeCup.append(glassRing, false);
        wholeCup.append(LCurve, false);
        wholeCup.append(RCurve, false);
	wholeCup.append(bottomCurve, false);
	wholeCup.append(wineLine, false); 

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeCup, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	this.set(new GeneralPath(s));
        
    }

}
