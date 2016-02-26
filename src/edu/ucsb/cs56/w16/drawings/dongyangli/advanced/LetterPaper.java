package edu.ucsb.cs56.w16.drawings.dongyangli.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D; 
/**
   A LetterPaper
      
   @author Dongyang Li
   @version for CS56, W16, UCSB
   
*/
public class LetterPaper extends Paper implements Shape
{
    /**
     * Constructor for objects of class LetterPaper
     */
    public LetterPaper(double x, double y, double width, double height)
    {
	// construct the basic paper shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	
	Line2D.Double firstLine = 
            new Line2D.Double (x+0.1*width, y + (0.1)*height,
                               x+width*(0.9), y + (0.1)*height);
	
        Line2D.Double secondLine =
            new Line2D.Double (x+0.1*width, y + (0.2)*height,
                               x + width*(0.9), y + (0.2)*height);
	
	Line2D.Double thirdLine = 
            new Line2D.Double (x+0.1*width, y + (0.3)*height,
                               x + width*(0.9), y + (0.3)*height);       	
        
	GeneralPath wholePaper = this.get();
        wholePaper.append(firstLine, false);
        wholePaper.append(secondLine, false);
        wholePaper.append(thirdLine, false); 
    }    
}