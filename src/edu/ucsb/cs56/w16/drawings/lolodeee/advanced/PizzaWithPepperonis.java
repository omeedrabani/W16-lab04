package edu.ucsb.cs56.w16.drawings.lolodeee.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape;

import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A Slice of Pizza 
      
   @author Lauren Dumapias 
   @version for CS56, W16, UCSB
   
*/

public class PizzaWithPepperonis extends Pizza implements Shape
{
    /**
     *Constructor for objects of Pizza with Pepperonis
     */
    public PizzaWithPepperonis (double x, double y, double width, double height)
    {
	//contruct the basic pizza shell
	super(x,y,width,height);

	//get the GeneralPath that we are going to append studd to
	GeneralPath gp = this.get();

	double radius = 0.1 * width;
	Ellipse2D.Double pep = new Ellipse2D.Double(x+0.3*width, y+0.3*height, radius, radius);
	Ellipse2D.Double pep1 = new Ellipse2D.Double(x+0.55*width, y+0.4*height, radius, radius);
	Ellipse2D.Double pep2 = new Ellipse2D.Double(x+0.4*width, y+0.65*height, radius, radius);
	

	GeneralPath pepPizza = this.get();
        pepPizza.append(pep, false);
	pepPizza.append(pep1, false);
	pepPizza.append(pep2, false);
    }
}
