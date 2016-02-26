package edu.ucsb.cs56.w16.drawings.andychen152.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves                                                            
import java.awt.Shape; // general class for shapes                                                                               

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**                                                                                                                              
   A vector drawing of a computer monitor that implements                                                                                   
   the Shape interface, and so can be drawn, as well as                                                                          
   rotated, scaled, etc.                                                                                                         
                                                                                                                                 
   @author Andy Chen                                                                                                          
   @version for CS56, W16, UCSB                                                                                                  
                                                                                                                                 
*/
public class ComputerMonitor extends GeneralPathWrapper implements Shape
{
    /**                                                                                                                          
       Constructor                                                                                                               
                                                                                                                                 
       @param x x coord of lower left corner of computer monitor, not including stand                                            
       @param y y coord of lower left corner of computer monitor, not including stand                                                         
       @param width width of the computer monitor                                            
       @param height of computer monitor, including stand                                                           
    */
    public ComputerMonitor(double x, double y, double width, double height)
    {

        // Rather than having to scale at the end, we can just                                                                   
        // draw things the right way to begin with, using the                                                                    
        // x, y, width and height.   If you haven't already                                                                      
        // hard coded a particular drawing, this may be an easier                                                                
        // way.                                                                                                                  

	// variables for outside monitor
	double outsideMonitorHeight = .75 * height;

	// variables for inside monitor
	double insideMonitorHeight = .8 * outsideMonitorHeight;
	double insideMonitorUpperLeftX = x + width*0.1;
	double insideMonitorUpperLeftY = y + height*0.075;
	double insideMonitorWidth = width*0.8;
	
	// variables for stand
	double standHeight = height - outsideMonitorHeight;
	double stand1startX = x + width*0.375;
	double standALLstartY = y + outsideMonitorHeight;
	double stand1endX = x + width*0.125;
	double standALLendY = y + height;
	double stand2startX = x + width*0.625;
	double stand2endX = x + width*0.875;

	// variables for webcam
	double webcamPointY = y + height/100;
	double webcamDiameter = height/20;
	double webcamPointX = x + width/2 - webcamDiameter/2;

        // Make the outside monitor                                                                                           
	Rectangle2D.Double outsideMonitor = 
	    new Rectangle2D.Double(x, y, width, outsideMonitorHeight);
	
	// Make the inside monitor
	Rectangle2D.Double insideMonitor = 
	    new Rectangle2D.Double(insideMonitorUpperLeftX, insideMonitorUpperLeftY, insideMonitorWidth, insideMonitorHeight);

	// Make the stands
        Line2D.Double leftStand =
            new Line2D.Double (stand1startX, standALLstartY,
                               stand1endX, standALLendY);

        Line2D.Double rightStand =
            new Line2D.Double (stand2startX, standALLstartY,
                               stand2endX, standALLendY);

	// Make the webcam
	Ellipse2D.Double webcam = 
	    new Ellipse2D.Double (webcamPointX, webcamPointY, webcamDiameter, webcamDiameter);

        // put the whole monitor together                                                                        
        GeneralPath wholeMonitor = this.get();
        wholeMonitor.append(outsideMonitor, false);
        wholeMonitor.append(insideMonitor, false);
	wholeMonitor.append(leftStand, false);
	wholeMonitor.append(rightStand, false);
	wholeMonitor.append(webcam, false);
    }
}
