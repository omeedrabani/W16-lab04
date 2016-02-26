package edu.ucsb.cs56.w16.drawings.christiannewkirk.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

/**
   An IPad
      
   @author Christian Newkirk
   @version for CS56, W16, UCSB
   
*/
public class IPad extends Rectangle implements Shape
{
    /**
     * Constructor for objects of class IPad
     */
    public IPad(double x, double y, double width, double height)
    {
	// construct the basic IPad shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make the screen, which will be scaled to 70% of shell 
	
	double w = 0.73 * width;
	double h = 0.73 * height;
	
	Rectangle2D.Double screen =
	    new Rectangle2D.Double(x + (width-w)/2, y + (height-h)/2, w, h);
	
	// Make the front camera
	// Circle x coordinate in the middle of the IPad
	// Circle y coordinate halfway inbetween the top of the screen and top of the shell.
	// Very small size

	double cameraDiameter = 0.02*width;
	double cameraX = x + width/2 - cameraDiameter/2;
	double cameraY = y + height - h - (height - h) + (height - h)/4 - cameraDiameter/2;

	// cameraHeight unneeded because it would be same as cameraWidth

	Ellipse2D.Double camera = 
	    new Ellipse2D.Double(cameraX, cameraY, cameraDiameter, cameraDiameter);
	
	
	// Make the home button
	// Circle x coordinate in the middle of the IPad
	// Circle y coordinate halfway inbetween the bottom of the screen and the bottom of the shell.
	// A lot bigger than camera, but still small

	double homeDiameter = 0.10*width;
	double homeX = (x + width/2) - (homeDiameter/2);
	double homeY = y - (height/2 - h/2)/2 - (homeDiameter/2) + height;
	
	Ellipse2D.Double home = 
	    new Ellipse2D.Double(homeX, homeY, homeDiameter, homeDiameter);

	// Make square centered inside home button
				
	double squareLength = 0.03*width;
	double squareX = x + width/2 - squareLength/2;
	double squareY = y + height - (height/2 - h/2)/2 - squareLength/2;
	
	Rectangle2D.Double square = 
	    new Rectangle2D.Double(squareX, squareY, squareLength, squareLength);
	
	
        GeneralPath wholeIPad = this.get();
        wholeIPad.append(screen, false);
        wholeIPad.append(camera, false);
        wholeIPad.append(home, false); 
	wholeIPad.append(square, false);
    }    
}
