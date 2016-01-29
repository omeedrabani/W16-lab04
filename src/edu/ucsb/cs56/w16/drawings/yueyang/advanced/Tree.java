package edu.ucsb.cs56.w16.drawings.yueyang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, W16, UCSB
   
**/
public class Tree extends GeneralPathWrapper implements Shape

{
    public Tree(double x, double y,double width, double height)
    {   double firstStoryHeight=0.5*height;
        
	Rectangle2D.Double firstStory= new Rectangle2D.Double(x,y,width,height);
        
	
	Line2D.Double a= new Line2D.Double(x-width,y,x+2*width,y);
        
        Line2D.Double b= new Line2D.Double(x+width/2.0,y-1.5*height,x-width,y);
        
        Line2D.Double c= new Line2D.Double(x+width/2.0,y-1.5*height,x+2*width,y);

        GeneralPath tree=this.get();
        
        tree.append(firstStory, false);
        tree.append(a,false);
        tree.append(b,false);
        tree.append(c,false);
    }



}
