package lib.java_turtle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import lib.edu.princeton.stdlib.*;
import lib.edu.princeton.stdlib.StdDraw;



/**
 * A turtle object is like a piece of pen, can draw on canvas while crawing
 * */

public class Turtle {
	
	
	private	static	final	double	Epsilon = 0.00000001;
	private	static	final	int	SegmentSize = 64;
	
	/**
	 * a reference to the canvas on which the turtle/pen is bond with
	 * @author Alexander Sun  
	 * */
    private	static	Canvas	canvas;
    
    private double[] arrLogicalPos= null;
    private double heading_in_radians;
	private	boolean	b_use_radians = true;

 
    enum	AngleUnit
    {
    	RADIANS,
    	DEGREES,
    }
    
    private	boolean	b_use_stddraw_arc = false;
    /**
     * @return true if turtle using stddraw for circle & arc
     * */
    public boolean get_use_stddraw_arc() {
		return b_use_stddraw_arc;
	}
    /**
     * @param true if turtle using stddraw for circle & arc
     * */
    public void set_use_stddraw_arc(boolean	b_use_stddraw_arc) {
		this.b_use_stddraw_arc = b_use_stddraw_arc;
	}
    
    
    /**
     * @return true if turtle using radians
     * */
    public boolean get_use_radians() {
		return b_use_radians;
	}

    /**
     * @param b_use_radians true if turtle using radians
     * */
	public void set_use_radians(boolean b_use_radians) {
		this.b_use_radians = b_use_radians;
	}

    /**
     * @return true if turtle using degrees
     * */
	public boolean get_use_degrees() {
		return !this.b_use_radians;
	}

    /**
     * @param b_use_degrees true if turtle using degrees
     * */
	public void set_use_degrees(boolean b_use_degrees) {
		this.b_use_radians = !b_use_degrees;
	}
	
	
	

	
	
    /**
     * @return current turtle heading direction either in radians or degrees depending on whether if turtle uses radians or degrees
     * */ 
    public double getHeading() {
    	return this.getHeading(b_use_radians? AngleUnit.RADIANS:AngleUnit.DEGREES);
	}

    /**
     * @param heading turtle heading direction either in radians or degrees depending on whether if turtle uses radians or degrees
     * */ 
	public void setHeading(double heading)
	{
		this.setHeading(b_use_radians? AngleUnit.RADIANS:AngleUnit.DEGREES,heading);
	}

    /**
     * @param au either be AngleUnit.RADIANS or AngleUnit.DEGREES
     * @param heading set turtle heading direction value
     * */ 
	public void setHeading(AngleUnit	au,double heading) {
		heading_in_radians = (au==AngleUnit.RADIANS? heading:Math.toRadians(heading));
	}

    /**
     * @param au either be AngleUnit.RADIANS or AngleUnit.DEGREES
     * @return current turtle heading in provided angle unit as per au
     * */ 
	public double getHeading(AngleUnit	au) {
		return	(au==AngleUnit.RADIANS? heading_in_radians:Math.toDegrees(heading_in_radians));
	}

    


	private	boolean	bIsPenDown;
    private	double penRadius;
    private	Color	penColor;
    private	Color	fillColor;
    
    
    private	List	points;
    
    /**
     * mark the begining of filling 
     * */
    public	void	beginFill()
    {
    	points = new	ArrayList();
    	points.add(this.getPosition());
    }
    
    /**
     * mark the end of filling 
     * */
    public	void	endFill()
    {
    	if (points!=null)
    	{
    		int	size = points.size();
    		double[] X=new	double[size];
    		double[] Y=new	double[size];
    		for(int i=0;i<size;i++)
    		{
    			X[i] = ((double[])points.get(i))[0];
    			Y[i] = ((double[])points.get(i))[1];
    		}
    		StdDraw.setPenColor(this.fillColor);
    		StdDraw.filledPolygon(X, Y);
    		StdDraw.setPenColor(this.penColor);
    		StdDraw.polygon(X, Y);
    		points.clear();
    		points = null;
    	}
    }
    
    /**
     * raise the pen, subsequent movement of turtle will not leave trace 
     * */
    public	void	penUp()
    {
    	this.bIsPenDown = false;
    }

    /**
     * put down the pen, subsequent movement of turtle will leave trace 
     * */
    public	void	penDown()
    {
    	this.bIsPenDown = true;
    }

    /**
     * @param color pen color 
     * */
    public void setPenColor(Color color) {
        penColor = color;
        StdDraw.setPenColor(this.penColor);
    }

    /**
     * @param r red component of pen color 
     * @param g green component of pen color 
     * @param b blue component of pen color 
     * */
    public void setPenColor(int r,int g,int b) {
    	setPenColor(new	Color(r,g,b));
    }
    
    /**
     * @param color fill color 
     * */
    public void setFillColor(Color color) {
        fillColor = color;
    }
    
    /**
     * @param r red component of fill color 
     * @param g green component of fill color 
     * @param b blue component of fill color 
     * */
    public void setFillColor(int r,int g,int b) {
    	setFillColor(new	Color(r,g,b));
    }
    
    /**
     * @param radius pen radius means the size of pen 
     * */
    public void setPenRadius(double radius) {
        StdDraw.setPenRadius(radius*0.0025);
    }

	
	


    /**
     * constructor - create turtle at home location (0.0,0.0) and @ degree 0.0
     * pen color is initially black
     * fill color is initially green
     * pen size is initially 2.0
     * */
    public Turtle(Canvas canvas) {
    	Turtle.canvas = canvas;
    	this.home();
    	this.setHeading(0);
        this.penDown();
        this.setPenRadius(2);
        this.setPenColor(new Color(0, 0, 0));
        this.setFillColor(new Color(0, 255, 0));
    }
    
    /**
     * @param arrLogicalPosition coordinate of the turtle on cartesian coordinate system
     * */
    public	void	setPosition(double[]	arrLogicalPosition)
    {
    	if(this.arrLogicalPos==null){this.arrLogicalPos = arrLogicalPosition.clone();}  
        if (this.bIsPenDown)
        {
            StdDraw.line(this.arrLogicalPos[0], this.arrLogicalPos[1], arrLogicalPosition[0], arrLogicalPosition[1]);
            if (points!=null)
            {
            	points.add(new	double[]{arrLogicalPosition[0],arrLogicalPosition[1]});
            }
        }
        this.arrLogicalPos = arrLogicalPosition.clone();
    }
    
    /**
     * @param x x coordinate of the turtle on cartesian coordinate system
     * @param y y coordinate of the turtle on cartesian coordinate system
     * */
    public	void	setPosition(double x,double y)
    {
    	this.setPosition(new double[]{x,y});
    }
    
    /**
     * relocate the turtle to home position @ (0.0,0.0)
     * */
    public	void	home()
    {
    	setPosition(canvas.getBaseLogicPos());
    }
    
    /**
     * @return coordinate of the turtle on cartesian coordinate system
     * */
    public	double[]	getPosition()
    {
    	return arrLogicalPos.clone();
    }
    
    /**
     * @param steps steps to move forward
     * */
    public void forward(double steps) {
    	double[]	newLogicalPosition = new	double[]
    			{
    					arrLogicalPos[0] + steps * Math.cos(heading_in_radians),
    					arrLogicalPos[1] + steps * Math.sin(heading_in_radians)
    			};
        setPosition(newLogicalPosition);
    }

    /**
     * @param steps steps to move backward
     * */
    public	void	backward(double steps)
    {
    	forward(-steps);
    }
    
    /**
     * @param x center x coordinate of the turtle on cartesian coordinate system
     * @param y center y coordinate of the turtle on cartesian coordinate system
     * @param dRadius radius of circle , must be positive
     * @param bFill whether if the circle need to be drawn filled
     * */
    public	void	circle_stddraw(double	x,double	y,double	dRadius,boolean	bFill)
    {
        if (this.bIsPenDown)
        {
        	if (bFill) 
        	{
                StdDraw.setPenColor(fillColor);
            	StdDraw.filledCircle(x,y,dRadius);
            	StdDraw.setPenColor(penColor);
            	StdDraw.circle(x,y,dRadius);
        	}
        	else {
            	StdDraw.setPenColor(penColor);
            	StdDraw.circle(x,y,dRadius);
        	}
        }
    }

    
    /**
     * draw circle from current turtle coordinate
     * @param bFollowTrack - if true, current turtle position and direction decide the tangent line to which the circle is drawn; if false, current turtle location is the center of the circle being drawn
     * @param dRadius radius of circle
     * @param bFill whether if the circle need to be drawn filled
     * */
    public	void	circle_stddraw(double	dRadius,boolean	bFollowTrack,boolean	bFill)
    {
    	if(!bFollowTrack)
    	{
        	double[]	pos = this.getPosition();
        	circle_stddraw(pos[0],pos[1],dRadius,bFill);
    	}
    	else
    	{
        	double[]	pos = this.getPosition();
        	circle_stddraw(pos[0]+dRadius*Math.cos(this.heading_in_radians+Math.PI/2),pos[1]+dRadius*Math.sin(this.heading_in_radians+Math.PI/2),dRadius,bFill);
    	}
    }
    
    

    /**
     * draw arc from coordinate
     * @param x center x coordinate of the turtle on cartesian coordinate system
     * @param y center y coordinate of the turtle on cartesian coordinate system
     * @param dRadius radius of circle
     * @param au either be AngleUnit.RADIANS or AngleUnit.DEGREES
     * @param a1 start angle of the arc
     * @param a2 end angle of the arc
     * */
    public	void	arc(double	x,double	y,double	dRadius,AngleUnit	au,double	a1,double	a2)
    {
        if (this.bIsPenDown)
        {
        	if (!b_use_stddraw_arc)
        	{
            	double[] position = this.getPosition();
            	double direction = this.getHeading();
            	this.penUp();
            	this.setPosition(x,y);
            	this.setHeading(au, a1);
            	this.forward(dRadius);
            	this.left(AngleUnit.RADIANS, Math.PI/2);
            	this.penDown();
            	this.circle(dRadius, 0, au, a2-a1);
            	this.penUp();
            	this.setPosition(position);
            	this.setHeading(direction);
            	this.penDown();
        	}
        	else
        	{
            	StdDraw.arc(x, y, dRadius,  (au==AngleUnit.RADIANS? Math.toDegrees(a1):a1),  (au==AngleUnit.RADIANS? Math.toDegrees(a2):a2));
        	}
        }
    }
    
    
    
    /**
     * draw arc from current turtle coordinate
     * @param dRadius radius of circle
     * @param au either be AngleUnit.RADIANS or AngleUnit.DEGREES
     * @param a1 start angle of the arc
     * @param a2 end angle of the arc
     * */   
    
    public	void	arc(double	dRadius,AngleUnit	au,double	a1,double	a2)
    {
    	double[]	pos = this.getPosition();
    	this.arc(pos[0],pos[1],dRadius,au,a1,a2);
    }

    
    /**
     * draw arc from coordinate
     * @param x center x coordinate of the turtle on cartesian coordinate system
     * @param y center y coordinate of the turtle on cartesian coordinate system
     * @param dRadius radius of circle
     * @param a1 start angle of the arc, angle unit is degrees or radians depending on the choice of the turtle
     * @param a2 end angle of the arc, angle unit is degrees or radians depending on the choice of the turtle
     * */  
    public	void	arc(double	x,double	y,double	dRadius,double	a1,double	a2)
    {
    	this.arc(x, y, dRadius, this.b_use_radians? AngleUnit.RADIANS:AngleUnit.DEGREES,a1, a2);
    }

    
    /**
     * draw arc from current turtle coordinate
     * @param dRadius radius of circle
     * @param a1 start angle of the arc, angle unit is degrees or radians depending on the choice of the turtle
     * @param a2 end angle of the arc, angle unit is degrees or radians depending on the choice of the turtle
     * */    
    public	void	arc(double	dRadius,double	a1,double	a2)
    {
    	double[]	pos = this.getPosition();
    	this.arc(pos[0],pos[1],dRadius,a1,a2);
    }

    /*
    public	void	circle_sys(double	dRadius,AngleUnit	au,double	angle)
    {
    	double angle_in_radians = au==AngleUnit.RADIANS?angle:Math.toRadians(angle);
    	double	half_pi_in_radians =  Math.PI/2;
    	this.penUp();
    	this.left(AngleUnit.RADIANS,Math.PI/2);
    	this.forward(dRadius);
    	this.right(AngleUnit.RADIANS,Math.PI/2);
    	this.penDown();
    	double[]	pos = this.getPosition();
    	double[]	angles = new double[2];
    	if (dRadius>=0)
    	{
    		angles[0]=this.heading_in_radians-Math.PI/2;
    		angles[1]=angle_in_radians+this.heading_in_radians-Math.PI/2;
		}
    	else
    	{
    		angles[0]=this.heading_in_radians+Math.PI/2+angle_in_radians;
    		angles[1]=+this.heading_in_radians+Math.PI/2;
    	}
    	this.arc(pos[0],pos[1],
    			Math.abs(dRadius),
    			AngleUnit.RADIANS,
    			Math.min(angles[0],angles[1]),
    			Math.max(angles[0],angles[1])
    			);
    	
    	this.penUp();
    	this.right(AngleUnit.RADIANS,Math.PI/2);
    	this.left(AngleUnit.RADIANS,angle_in_radians);
    	this.forward(dRadius);
    	this.left(AngleUnit.RADIANS,Math.PI/2);
    	this.penDown();
    }*/

    public	void	circle_stddraw_arc(double	dRadius,double	angle)
    {
    	this.circle_stddraw_arc(dRadius, this.b_use_radians? AngleUnit.RADIANS:AngleUnit.DEGREES,angle);
    }
    
    public	void	circle_stddraw_arc(double	dRadius,AngleUnit	au,double	angle)
    {
    	double angle_in_radians = au==AngleUnit.RADIANS?angle:Math.toRadians(angle);
    	double	half_pi_in_radians =  Math.PI/2;
    	this.penUp();
    	this.left(AngleUnit.RADIANS,Math.PI/2);
    	this.forward(dRadius);
    	this.right(AngleUnit.RADIANS,Math.PI/2);
    	this.penDown();
    	double[]	pos = this.getPosition();
    	double[]	angles = new double[2];
    	if (dRadius>=0)
    	{
    		angles[0]=this.heading_in_radians-Math.PI/2;
    		angles[1]=angle_in_radians+this.heading_in_radians-Math.PI/2;
		}
    	else
    	{
    		angles[0]=this.heading_in_radians+Math.PI/2+angle_in_radians;
    		angles[1]=+this.heading_in_radians+Math.PI/2;
    	}
    	StdDraw.arc(pos[0],pos[1],
    			Math.abs(dRadius),
     			Math.min(angles[0],angles[1]),
    			Math.max(angles[0],angles[1])
    			);
    	
    	this.penUp();
    	this.right(AngleUnit.RADIANS,Math.PI/2);
    	this.left(AngleUnit.RADIANS,angle_in_radians);
    	this.forward(dRadius);
    	this.left(AngleUnit.RADIANS,Math.PI/2);
    	this.penDown();
    }
    
    public  void  circle(double dRadius,int iSegments,AngleUnit	au,double	angle)
    {
    	double angle_in_radians = au==AngleUnit.RADIANS?angle:Math.toRadians(angle);
    	if (iSegments<=0) {iSegments=(int) (Turtle.SegmentSize*dRadius*angle_in_radians);}
		this.left(angle/iSegments/2);
  		for (int i =0;i<iSegments;i++)
  		{
  			this.forward(dRadius*angle_in_radians/iSegments);
  			this.left(angle/iSegments);
  		}
		this.right(angle/iSegments/2);
    }
    
    

    
    public  void  circle(double dRadius,int iSegments,double	angle)
    {
    	this.circle(dRadius, iSegments, this.b_use_radians? AngleUnit.RADIANS:AngleUnit.DEGREES,angle);
    }
    
    

    public	void	ellipse(double	x,double	y,double	a,double	b,boolean	bFill)
    {
    	if(this.bIsPenDown)
    	{
        	if (bFill) 
        	{
                StdDraw.setPenColor(fillColor);
        		StdDraw.filledEllipse(x, y, a, b);
                StdDraw.setPenColor(penColor);
        		StdDraw.ellipse(x, y, a, b);
        	}
        	else {
                StdDraw.setPenColor(penColor);
        		StdDraw.ellipse(x, y, a, b);
        	}
    	}
    }
    
    
    public	void	ellipse(double	a,double	b,boolean	bFill)
    {
    	double[]	pos = this.getPosition();
    	this.ellipse(pos[0], pos[1], a, b, bFill);
    }
    
    public	void	picture(double	x,double	y,double	a,double	b,String image_name,AngleUnit	au,double	angle)
    {
    	StdDraw.picture(x, y, image_name, a, b, (au==AngleUnit.RADIANS? Math.toDegrees(angle):angle));
    }
    
    public	void	picture(double	x,double	y,double	a,double	b,String image_name,double	angle)
    {
    	this.picture(x, y, a, b, image_name, this.b_use_radians?AngleUnit.RADIANS:AngleUnit.DEGREES,angle);
    }
    
    public	void	rectangle(double	x,double	y,double	a,double	b,boolean	bFill)
    {
    	if(this.bIsPenDown)
    	{
        	if (bFill) 
        	{
                StdDraw.setPenColor(fillColor);
        		StdDraw.filledRectangle(x, y, a, b);
                StdDraw.setPenColor(penColor);
        		StdDraw.rectangle(x, y, a, b);
        	}
        	else {
                StdDraw.setPenColor(penColor);
        		StdDraw.rectangle(x, y, a, b);
        	}
    	}
    }
    
    
    public	void	rectangle(double	a,double	b,boolean	bFill)
    {
    	double[]	pos = this.getPosition();
    	this.rectangle(pos[0], pos[1], a, b, bFill);
    }
    
    
    public	void	pixcel(double x,double y)
    {
    	StdDraw.point(x, y);
    }
    
    
    public	void	square(double	x,double	y,double	a,boolean	bFill)
    {
    	if(this.bIsPenDown)
    	{
        	if (bFill) 
        	{
                StdDraw.setPenColor(fillColor);
        		StdDraw.filledSquare(x, y, a);
                StdDraw.setPenColor(penColor);
        		StdDraw.square(x, y, a);
        	}
        	else {
                StdDraw.setPenColor(penColor);
        		StdDraw.square(x, y, a);
        	}
    	}
    }
    
    
    public	void	square(double	a,boolean	bFill)
    {
    	double[]	pos = this.getPosition();
    	this.square(pos[0], pos[1], a,bFill);
    }
    
    
    
    
    
    public void left(double delta) {
    	this.left(b_use_radians? AngleUnit.RADIANS:AngleUnit.DEGREES,delta);
    }

    public void left(AngleUnit au,double delta) {
    	heading_in_radians +=(au==AngleUnit.RADIANS? delta:Math.toRadians(delta));
    }
    
    public void right(double delta) {
    	left(-delta);
    }
    
    public void right(AngleUnit au,double delta) {
    	left(au,-delta);
    }

    
    public	void	polygon(double[]	X,double[]	Y,boolean	bFilled)
    {
    	if(this.bIsPenDown)
    	{
        	if (bFilled) {StdDraw.filledPolygon(X,Y);}else {StdDraw.polygon(X,Y);}
    	}
    }
    
    
    public	void	text(String s)
    {
    	
    }
    
    
    public void show() {
        this.canvas.proposeToUpdate(true);
    }

	public	String	getCallerName()
	{
		 return StackWalker.
			      getInstance().
			      walk(stream -> stream.skip(1).findFirst().get()).
			      getMethodName();
	}


}
