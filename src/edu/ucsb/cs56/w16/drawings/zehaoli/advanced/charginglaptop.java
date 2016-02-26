package edu.ucsb.cs56.w16.drawings.zehaoli.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D; 

/**
   A charging laptop
      
   @author Zehao Li 
   @version for CS56, W16, UCSB
   
*/
public class charginglaptop extends laptop implements Shape
{
    /**
     * Constructor for objects of class charging laptop
     */
    public charginglaptop(double x, double y, double height)
    {
	// construct the basic house shell
	super(x,y,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	double width = 1.8 * height;
	double side= 0.3 * height;
	
	Rectangle2D.Double chargemain =
	    new Rectangle2D.Double(x + width + width, y + height - 0.5 * side, side, side);

        Line2D.Double upper =
            new Line2D.Double (x + 2*width + side, y + height - 0.2*side,
                               x + 2*width + 2*side, y + height - 0.2*side);

        Line2D.Double lower =
            new Line2D.Double (x + 2*width + side, y + height + 0.2*side,
                               x + 2*width + 2*side, y + height + 0.2*side);	

        Line2D.Double chargingline =
            new Line2D.Double (x + width, y+height,
                               x + width * 2, y + height);	
	// add the charger of laptop
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")
	
        GeneralPath charginglaptop = this.get();
        charginglaptop.append(chargemain, false);
        charginglaptop.append(upper, false);
        charginglaptop.append(lower, false);
        charginglaptop.append(chargingline, false);
    }    
}
