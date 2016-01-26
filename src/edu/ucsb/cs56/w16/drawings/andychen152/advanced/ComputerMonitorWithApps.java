package edu.ucsb.cs56.w16.drawings.andychen152.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
/**                                                                                      
   A ComputerMonitorWithApps                                                             
                                                                                         
   @author Andy Chen                                                                     
   @version for CS56, W16, UCSB                                                          
                                                                                         
*/
public class ComputerMonitorWithApps extends ComputerMonitor implements Shape
{
    /**                                                                                  
     * Constructor for objects of class ComputerMoniterWithApps                                        
     */
    public ComputerMonitorWithApps(double x, double y, double width, double height)
    {
        // construct the basic Computer Monitor                                               
        super(x,y,width,height);

        // get the GeneralPath that we are going to append stuff to                      
        GeneralPath gp = this.get();

        // Make two apps, different size
	// Both has toolbar on the top                     
   
	//Fist Window
	double firstWindowStartX = x + width*0.2;
	double firstWindowStartY = y + height*0.325;
	double firstWindowHeight = height*0.25;
	double firstWindowWidth = width/5;
	double toolbarLineWindow1StartAndEndY = firstWindowStartY+height*0.05;
	double toolbarLineWindow1EndX = firstWindowStartX + firstWindowWidth;
       
	//Second Window
        double secondWindowStartX = x + width/2;
        double secondWindowStartY = y + height*0.225;
	double secondWindowHeight = height*0.35;
	double secondWindowWidth = width*.3;
	double toolbarLineWindow2StartAndEndY = secondWindowStartY+height*0.05;
	double toolbarLineWindow2EndX = secondWindowStartX + secondWindowWidth;
	
        Rectangle2D.Double win1 =
            new Rectangle2D.Double(firstWindowStartX, firstWindowStartY, firstWindowWidth, firstWindowHeight);
	        Rectangle2D.Double win2 =
            new Rectangle2D.Double(secondWindowStartX, secondWindowStartY, secondWindowWidth, secondWindowHeight);
        Line2D.Double window1Toolbar = 
	    new Line2D.Double(firstWindowStartX, toolbarLineWindow1StartAndEndY, toolbarLineWindow1EndX, toolbarLineWindow1StartAndEndY);
	Line2D.Double window2Toolbar = 
	new Line2D.Double(secondWindowStartX, toolbarLineWindow2StartAndEndY, toolbarLineWindow2EndX,toolbarLineWindow2StartAndEndY);

        // add the apps to the monitor                                                  
       
        GeneralPath wholeMonitor = this.get();
        wholeMonitor.append(win1, false);
        wholeMonitor.append(win2, false);
        wholeMonitor.append(window1Toolbar, false);
	wholeMonitor.append(window2Toolbar, false);
    }
}
