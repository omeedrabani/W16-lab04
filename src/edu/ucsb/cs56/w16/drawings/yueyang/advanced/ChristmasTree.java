package edu.ucsb.cs56.w16.drawings.yueyang.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;


import java.awt.geom.Line2D;


public class ChristmasTree extends Tree implements Shape

{
    public ChristmasTree(double x, double y, double width, double height){
	super(x,y,width,height);
   
        GeneralPath gp= this.get();
        

	Line2D.Double a= new Line2D.Double(x-width,y-1.5*height,x+2*width,y-1.5*height);
         
	Line2D.Double b= new Line2D.Double(x-width,y-1.5*height,x+width/2.0,y-3*height);
 
        Line2D.Double c= new Line2D.Double(x+width/2.0,y-3*height,x+2*width,y-1.5*height);
      
        GeneralPath tree=this.get();
        tree.append(a,false);
        tree.append(b,false);
        tree.append(c,false);
    }

}
