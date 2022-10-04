package lib.java_turtle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import lib.edu.princeton.stdlib.*;
import lib.edu.princeton.stdlib.StdDraw;

public class Turtle {
    private	static	Canvas	canvas;
    
    private double[] arrLogicalPos= null;
    private double heading_in_radians;
	private	boolean	b_use_radians = true;

 
    enum	AngleUnit
    {
    	RADIANS,
    	DEGREES,
    }
    
    
    public boolean get_use_radians() {
		return b_use_radians;
	}

	public void set_use_radians(boolean b_use_radians) {
		this.b_use_radians = b_use_radians;
	}

	public boolean get_use_degrees() {
		return !this.b_use_radians;
	}

	public void set_use_degrees(boolean b_use_degrees) {
		this.b_use_radians = !b_use_degrees;
	}
	
	
	

	
	
    
    public double getHeading() {
    	return this.getHeading(b_use_radians? AngleUnit.RADIANS:AngleUnit.DEGREES);
	}

	public void setHeading(double heading)
	{
		this.setHeading(b_use_radians? AngleUnit.RADIANS:AngleUnit.DEGREES,heading);
	}


	public void setHeading(AngleUnit	au,double heading) {
		heading_in_radians = (au==AngleUnit.RADIANS? heading:Math.toRadians(heading));
	}


	public double getHeading(AngleUnit	au) {
		return	(au==AngleUnit.RADIANS? heading_in_radians:Math.toDegrees(heading_in_radians));
	}

    


	private	boolean	bIsPenDown;
    private	double penRadius;
    private	Color	penColor;
    private	Color	fillColor;
    
    
    private	List	points;
    
    
    public	void	beginFill()
    {
    	points = new	ArrayList();
    	points.add(this.getPosition());
    }
    
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
    
    
    public	void	penUp()
    {
    	this.bIsPenDown = false;
    }

    public	void	penDown()
    {
    	this.bIsPenDown = true;
    }

    public void setPenColor(Color color) {
        penColor = color;
        StdDraw.setPenColor(this.penColor);
    }
    
    public void setFillColor(Color color) {
        fillColor = color;
    }

    public void setPenRadius(double radius) {
        StdDraw.setPenRadius(radius*0.0025);
    }

	
	


  
    public Turtle(Canvas canvas) {
    	Turtle.canvas = canvas;
    	this.home();
    	this.setHeading(0);
        this.penDown();
        this.setPenRadius(2);
        this.setPenColor(new Color(255, 0, 0));
        this.setFillColor(new Color(0, 255, 0));
    }
    
    
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
    
    public	void	setPosition(double x,double y)
    {
    	this.setPosition(new double[]{x,y});
    }
    
    public	void	home()
    {
    	setPosition(canvas.getBaseLogicPos());
    }
    
    public	double[]	getPosition()
    {
    	return arrLogicalPos.clone();
    }
    
    public void forward(double steps) {
    	double[]	newLogicalPosition = new	double[]
    			{
    					arrLogicalPos[0] + steps * Math.cos(heading_in_radians),
    					arrLogicalPos[1] + steps * Math.sin(heading_in_radians)
    			};
        setPosition(newLogicalPosition);
    }

    public	void	backward(double steps)
    {
    	forward(-steps);
    }
    
    public	void	circle(double	x,double	y,double	dRadius,boolean	bFill)
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

    public	void	circle(double	dRadius,boolean	bFollowTrack,boolean	bFill)
    {
    	if(!bFollowTrack)
    	{
        	double[]	pos = this.getPosition();
        	circle(pos[0],pos[1],dRadius,bFill);
    	}
    	else
    	{
        	double[]	pos = this.getPosition();
        	circle(pos[0]+dRadius*Math.cos(this.heading_in_radians+Math.PI/2),pos[1]+dRadius*Math.sin(this.heading_in_radians+Math.PI/2),dRadius,bFill);
    	}
    }
    
    


    public	void	arc(double	x,double	y,double	dRadius,AngleUnit	au,double	a1,double	a2)
    {
        if (this.bIsPenDown)
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
        	//{StdDraw.arc(x, y, dRadius,  (au==AngleUnit.RADIANS? Math.toDegrees(a1):a1),  (au==AngleUnit.RADIANS? Math.toDegrees(a2):a2));}
        }
    }
    
    
    
    
    
    public	void	arc(double	dRadius,AngleUnit	au,double	a1,double	a2)
    {
    	double[]	pos = this.getPosition();
    	this.arc(pos[0],pos[1],dRadius,au,a1,a2);
    }

    public	void	arc(double	x,double	y,double	dRadius,double	a1,double	a2)
    {
    	this.arc(x, y, dRadius, this.b_use_radians? AngleUnit.RADIANS:AngleUnit.DEGREES,a1, a2);
    }

    
    
    public	void	arc(double	dRadius,double	a1,double	a2)
    {
    	double[]	pos = this.getPosition();
    	this.arc(pos[0],pos[1],dRadius,a1,a2);
    }

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
    }

    public	void	circle_sys(double	dRadius,double	angle)
    {
    	this.circle_sys(dRadius, this.b_use_radians? AngleUnit.RADIANS:AngleUnit.DEGREES,angle);
    }

    
    public  void  circle(double dRadius,int iSegments,AngleUnit	au,double	angle)
    {
    	if (iSegments<=0) {iSegments=100;}
    	double angle_in_radians = au==AngleUnit.RADIANS?angle:Math.toRadians(angle);
		this.left(angle/iSegments/2);
  		for (int i =0;i<iSegments;i++)
  		{
  			this.forward(dRadius*angle_in_radians/iSegments);
  			this.left(angle/iSegments);
  		}
		this.right(angle/iSegments/2);
    }
    
    public  void  circle(double dRadius,int iDetails,double	angle)
    {
    	this.circle(dRadius, iDetails, this.b_use_radians? AngleUnit.RADIANS:AngleUnit.DEGREES,angle);
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




}
