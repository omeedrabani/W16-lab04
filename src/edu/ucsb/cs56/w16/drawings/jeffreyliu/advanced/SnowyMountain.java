package edu.ucsb.cs56.w16.drawings.jeffreyliu.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
   A snowy mountain
      
   @author Jeffrey Liu 
   @version for CS56, W16, UCSB
   
*/
public class SnowyMountain extends Mountain implements Shape
{
    /**
     * Constructor for objects of class SnowyMountain
     */
    public SnowyMountain(double x, double y, double width, double height)
    {
	super(x,y,width,height);

        Line2D.Double snow =
            new Line2D.Double (x - width/8.0, y + height/4.0,
                               x + width/8.0, y + height/4.0);

        GeneralPath wholeMountain = this.get();
        wholeMountain.append(snow, false);
    }    
}
