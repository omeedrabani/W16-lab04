package edu.ucsb.cs56.w16.drawings.nicolemoghaddas.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.geom.Arc2D; 

/**
   A Sun with a Face
      
   @author Nicole Moghaddas
   @version for CS56, W16, UCSB
   
*/
public class SunWithFace extends Sun implements Shape
{
    /**
     * Constructor for objects of class SunWithFace
     */
    public SunWithFace(double x, double y, double r)
    {
	// construct the basic sun shell
	super(x,y,r);
	

	double noseRadius = 0.01 * r;
	double eyeRadius = 0.065 * r;
	double rightEyeCenterX = x + 0.35*r;
	double rightEyeCenterY = y - 0.35*r;
	double leftEyeCenterX = x - 0.35*r;
	double leftEyeCenterY = y - 0.35*r;

	Ellipse2D.Double nose =
	    new Ellipse2D.Double(x-noseRadius, y-noseRadius, noseRadius*2, noseRadius*2);
	Ellipse2D.Double leftEye =
	    new Ellipse2D.Double(leftEyeCenterX-eyeRadius, leftEyeCenterY-eyeRadius,
							eyeRadius*2, eyeRadius*2);
	Ellipse2D.Double rightEye =
	    new Ellipse2D.Double(rightEyeCenterX-eyeRadius, rightEyeCenterY-eyeRadius,
							 eyeRadius*2, eyeRadius*2);
	
	Rectangle2D.Double leftGlasses =
	    new Rectangle2D.Double(rightEyeCenterX-3*eyeRadius, rightEyeCenterY-3*eyeRadius,
				   6*eyeRadius, 6*eyeRadius);
	Rectangle2D.Double rightGlasses =
	    new Rectangle2D.Double(leftEyeCenterX-3*eyeRadius, leftEyeCenterY-3*eyeRadius,
				   6*eyeRadius, 6*eyeRadius);

	Line2D.Double glasses = new Line2D.Double(leftEyeCenterX+3*eyeRadius, leftEyeCenterY,
						  rightEyeCenterX-3*eyeRadius, rightEyeCenterY);
	
	Arc2D.Double smile = new Arc2D.Double(x-0.1*r, y+0.3*r,
					      0.3*r, 0.4*r,
					      180, 180, Arc2D.OPEN); 

	
        GeneralPath wholeSun = this.get();
        wholeSun.append(nose, false);
        wholeSun.append(leftEye, false);
        wholeSun.append(rightEye, false);
        wholeSun.append(leftGlasses, false);
        wholeSun.append(rightGlasses, false);
        wholeSun.append(glasses, false);
	wholeSun.append(smile, false);
    }    
}
