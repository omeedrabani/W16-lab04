package edu.ucsb.cs56.w16.drawings.rkuang.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Line2D;

/**
   A Spork that adds prongs to a Spoon
      
   @author Ricky Kuang 
   @version for CS56, W16, UCSB
   
*/
public class Spork extends Spoon implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public Spork(double x, double y, double width, double height)
    {
	// construct the basic Spork shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	double cornerULX = x;
	double cornerULY = y;
	
	GeneralPath prongs = new GeneralPath();

	prongs.moveTo(x					,y + .1174 * height);
	prongs.lineTo(x + .20 * width	,y - .10 * height);
	prongs.lineTo(x + .30 * width	,y);
	prongs.lineTo(x + .40 * width	,y - .10 * height);
	prongs.lineTo(x + .50 * width	,y);
	prongs.lineTo(x + .60 * width	,y - .10 * height);
	prongs.lineTo(x + .70 * width	,y);
	prongs.lineTo(x + .80 * width	,y - .10 * height);
	prongs.lineTo(x + width			,y + .1174 * height);
	
	// add the windows to the Spork
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")
	
    GeneralPath wholeSpork = this.get();
    wholeSpork.append(prongs, false);
    }    
}
