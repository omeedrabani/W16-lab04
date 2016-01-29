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
	/*
	GeneralPath stem = new GeneralPath();
	stem.moveTo( 288, 330);
	stem.lineTo(288, 400);

	GeneralPath stem2 = new GeneralPath();
	stem2.moveTo(292, 330);
	stem2.lineTo(292, 400);
	
	GeneralPath stem = new GeneralPath();
	stem.moveTo( x + (1/2)*width , y + (1/2)*height);
	stem.lineTo(x + (1/2)*width , y + (1/2)*height + height);

	GeneralPath stem2 = new GeneralPath();
	stem2.moveTo(x + (1/2)*width + (1/10)*width, y + (1/2)*height);
	stem2.lineTo(x + (1/2) * width + (1/10)*width,  y + (1/2)*height + height);
	


	GeneralPath stem = new GeneralPath();
	stem.moveTo(x + (1/2)*width,  y);
	stem.lineTo(x + (1/2)*width, y + height );

	Shape stem2 =  new Line2D.Double(x + (1/2)*width + (1/10)*width,
					y + height,x + (1/2)*width + (1/10)*width,y + 2*height );
    
	
      	GeneralPath gp2 = this.get();
	gp2.draw(new Line2D.Double(x + (1/2)*width + (1/10)*width,
				   y + height,x + (1/2)*width + (1/10)*width,y + 2*height ));
    */

	double stop = height;
	double sW = .50*width;
	double sHt = 1.5 * height;
		
	Rectangle2D.Double stem =
	    new Rectangle2D.Double(x + sW, y + height, .50* sW, sHt);
	
	//	Shape glassRing = new Ellipse2D.Double(x+265,y+397,(1/5)*width,(1/3)*height);

	GeneralPath wholeGlass = this.get();
        wholeGlass.append(stem, false);
	// wholeGlass.append(stem2, false);
	//	wholeGlass.append(glassRing, false); 
       


	
 
    }    
}
