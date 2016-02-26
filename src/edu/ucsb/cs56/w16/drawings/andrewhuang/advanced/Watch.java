package edu.ucsb.cs56.w16.drawings.andrewhuang.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
/**
   Watch
      
   @author Andrew Huang
   @version for CS56, W16, UCSB
   
*/
public class Watch  extends Bracelet implements Shape
{
    /**
     * Constructor for objects of class Watch
     */
    public Watch(double x, double y, double width, double height)
    {
	// construct the basic Bracelet shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	// determines various values based off of orientation
	double rimRad;
	double rimX;
	double rimY;
	double minX;
	double minY;
	double hrX;
	double hrY;
	
	if(width > height)
	    {
		rimRad = height*.9;
		rimX = x + width/2 - rimRad/2;
		rimY = y + height * 0.05;

		minX = x + width/2;
		minY = y + height/2 - rimRad/2 * .75;

		hrX = x + width/2 + rimRad/2 * .5;
		hrY = y + height/2;
	    }
	else
	    {
		rimRad = width*.9;
		rimX = x + width * 0.05;
		rimY = y + height/2 - rimRad/2;

		minX = x + width/2 - rimRad/2*.75;
		minY = y + height/2;
		
		hrX = x + width/2;
		hrY = y + height/2 - rimRad/2*.5;
	    }
	
	//creates rim
	Ellipse2D.Double rim = new Ellipse2D.Double(rimX, rimY, rimRad, rimRad);
	// creates minute hand
	Line2D.Double minHand = new Line2D.Double (x+width/2, y + height/2, minX, minY);
	// creates hour hand
	Line2D.Double hrHand = new Line2D.Double (x+width/2, y + height/2, hrX, hrY);
	
        GeneralPath wholeBracelet = this.get();
        wholeBracelet.append(rim, false);
	wholeBracelet.append(minHand, false);
	wholeBracelet.append(hrHand, false);
    }    
}
