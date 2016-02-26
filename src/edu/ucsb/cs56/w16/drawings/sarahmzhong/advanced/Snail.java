package edu.ucsb.cs56.w16.drawings.sarahmzhong.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Ellipse2D;

/**
   A Snail
      
   @author Sarah Zhong 
   @version for CS56, W16, UCSB
   
*/
public class Snail extends Slug implements Shape
{
    /**
     * Constructor for objects of class Snail
     */
    public Snail(double x, double y, double length, double height, double shellRadius)
    {
	// construct the basic slug/snail body
	super(x,y,length,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
  double shellX = x + length/2.0 - shellRadius;
  double shellY = y-height - shellRadius*2.0 + height/8.0;
	
	Ellipse2D.Double shell =
	    new Ellipse2D.Double(shellX, shellY, shellRadius*2.0, shellRadius*2.0);
	
	// add the shell to the snail/slug thing
	
        GeneralPath wholeMollusk = this.get();
        wholeMollusk.append(shell, false);
    }    
}
