package edu.ucsb.cs56.w16.drawings.lanthony.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


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
	super(x,y,width,height);
	
	GeneralPath gp = this.get();


	double stop = height;
	double sW = .50*width;
	double sHt = 1.5 * height;
		
	Rectangle2D.Double stem =
	    new Rectangle2D.Double(x + 7.5*sW, y + height, .25* sW, sHt);


	Shape glassRing = new Ellipse2D.Double(x + 7.5*sW - .30*sHt, y + (.89)*height + sHt, .65*sHt ,(1.2)*sW);

	
	//	Shape glassRing = new Ellipse2D.Double(x + 7.5*sW, y + height + sHt,(1/5)*width,(1/3)*height);

	GeneralPath wholeGlass = this.get();
        wholeGlass.append(stem, false);
      	wholeGlass.append(glassRing, false); 
       


	
 
    }    
}
