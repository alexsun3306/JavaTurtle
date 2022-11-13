package demo;

import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Color;
import java.math.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lib.java_turtle.Canvas;
import lib.java_turtle.Turtle;
import lib.java_turtle.TurtleClient;

public class TurtleFeaturesDemo {

	//test
	public	static	String	Polygon(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.setPenRadius(10);
		//turtle.circle(0, 0, 100);
//		turtle.arc(100,  math.PI/2);
//		turtle.arc(100,  math.PI/2);
		turtle.beginFill(); 
		for (int i =0;i<6;i++)
		{
			turtle.set_use_radians(false);
		    turtle.forward(60);
		    turtle.left(60.0);
		    turtle.square(40, false);
		}
		turtle.endFill();
		/*
		for (int i =0;i<8;i++)
		{
			turtle.arc(100,  45);
		}
		*/
		//turtle.polygon(), false)
		turtle.ellipse(0, 0, 10, 20,true);
		return	turtle.getCallerName();
	}
	
	

	
	/**
	 * this is to illustrate how to draw circle with:
	 * 	- center location x,y
	 *  - radius
	 * 	- pencolor
	 * 	- fillcolor
	 * 	- filled option
	 * */
	public	static	String	circle_stddraw_from_center(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		turtle.setPenColor(new Color(255,0,0));
		for (int i=0;i<9;i++)
		{
			int r = i/3;
			int c = i%3;
			turtle.penUp();
			turtle.setHeading(i*30);
			turtle.setPosition(c*120-150,r*120-150);
			turtle.penDown();
			mark_1(turtle);
			turtle.circle_stddraw(30, false,false);/*circle is tangent from current turtle location & to turtle direction*/
			mark_2(turtle);
		}
		return	turtle.getCallerName();
	}
	
	
	/**
	 * this is to illustrate where circle is drawn:
	 * - center from specified center location x,y
	 * - center from current turtle location
	 * - circle is tangent from current turtle location & to turtle direction
	 * */
	public	static	String	circle_stddraw_follow_track(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		turtle.setPenColor(new Color(255,0,0));
		for (int i=0;i<9;i++)
		{
			int r = i/3;
			int c = i%3;
			turtle.penUp();
			turtle.setHeading(i*30);
			turtle.setPosition(c*120-150,r*120-150);
			turtle.penDown();
			mark_1(turtle);
			turtle.circle_stddraw(30, true,false);/*circle is tangent from current turtle location & to turtle direction*/
			mark_2(turtle);
		}
		return	turtle.getCallerName();
	}
	
	
	/**
	 * this is to demonstrate how arc/partial circle is drawn tagent 
	 * arc/partial circle is tangent from current turtle location & to turtle direction
	 * - radius
	 * - angles of the arc/patial circle
	 * - after the arc/partial circle is drawn, the direction and location of the turtle will change
	 * - # of sides, the bigger number, the closer to a circle/arc curve
	 * - reduce the number of sides will lead to regular polygon
	 * */
	
	
	public	static	void	mark_1(Turtle turtle)
	{
		for (int i=0;i<5;i++)
		{
			turtle.penUp();
			turtle.forward(5);
			turtle.penDown();
			turtle.forward(5);
		}
		turtle.penUp();
		turtle.backward(50);
		turtle.penDown();
	}

	public	static	void	mark_2(Turtle turtle)
	{
		turtle.forward(50);
		turtle.backward(50);
	}

	
	

	
	
	public	static	String	circle_from_polygon(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		turtle.setPenColor(new Color(255,0,0));
		for (int i=0;i<9;i++)
		{
			int r = i/3;
			int c = i%3;
			turtle.penUp();
			turtle.setHeading(0);
			turtle.setPosition(c*120-150,r*120-150);
			turtle.penDown();
			mark_1(turtle);
			turtle.circle(30, i, 180);
			mark_2(turtle);
		}

		

		return	turtle.getCallerName();
	}
	
	/**
	 * this is to illustrate where arc is drawn:
	 * - center from specified center location x,y
	 * - center from current turtle location
	 * */
	public	static	String	arc_demo(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_stddraw_arc(true);
		turtle.set_use_degrees(true);
		turtle.setPenColor(new Color(255,0,0));
		turtle.home();
		turtle.setHeading(0);
		
		for (int i=0;i<18;i++)
		{
			int r = i/3;
			int c = i%3;
			mark_1(turtle);
			turtle.arc(i*10, i*30, i*30+30);
			mark_2(turtle);
		}
	
		
	
		return	turtle.getCallerName();
		
		
	}
	
	
	
	
	/**
	 * this is to illustrate where ellipse is drawn:
	 * - center from specified center location x,y
	 * - center from current turtle location
	 * - can specify whether if filled
	 * */
	public	static	String	ellipse_demo(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		turtle.setPenColor(new Color(255,0,0));
		turtle.setFillColor(new Color(0,255,0));
		/*draw ellipse center @ specified location of x,y*/
		turtle.ellipse(-100, -150,75, 25, false);

		/*draw ellipse center @ specified location of x,y*/
		turtle.ellipse(25, 75, true);
		return	turtle.getCallerName();
	}
	
	
	/**
	 * this is to illustrate where rectangle is drawn:
	 * - center from specified center location x,y
	 * - center from current turtle location
	 * - can specify whether if filled
	 * */
	public	static	String	rectangle_demo(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		turtle.setPenColor(new Color(255,0,0));
		turtle.setFillColor(new Color(0,255,0));
		/*draw rectangle center @ specified location of x,y*/
		turtle.rectangle(-100, -150,75, 25, false);

		/*draw rectangle center @ specified location of x,y*/
		turtle.rectangle(25, 75, true);
		return	turtle.getCallerName();
	}
	
	
	
	/**
	 * this is to illustrate where square is drawn:
	 * - center from specified center location x,y
	 * - center from current turtle location
	 * - can specify whether if filled
	 * */
	public	static	String	square_demo(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		turtle.setPenColor(new Color(255,0,0));
		turtle.setFillColor(new Color(0,255,0));
		/*draw square center @ specified location of x,y*/
		turtle.square(-100, -150,75, false);

		/*draw square center @ specified location of x,y*/
		turtle.square(50, true);
		return	turtle.getCallerName();
	}
	
	
	public	static	String	where_am_i(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		double[] position;
		System.out.println(turtle.getHeading());
		
		turtle.left(30);
		System.out.println(turtle.getHeading()+20);

		turtle.left(60);
		System.out.println(turtle.getHeading());
		position = turtle.getPosition();
		System.out.println("("+position[0]+","+position[1]+")");
		
		turtle.forward(100);
		position = turtle.getPosition();
		System.out.println("("+position[0]+","+position[1]+")");

		turtle.left(90);
		System.out.println(turtle.getHeading());
		
		position = turtle.getPosition();
		System.out.println("("+position[0]+","+position[1]+")");

		turtle.forward(100);
		position = turtle.getPosition();
		System.out.println("("+position[0]+","+position[1]+")");

		return	turtle.getCallerName();
	}
	

	/**
	 * - setPosition
	 * - penUp
	 * - penDown
	 * - home
	 * */
	public static	String	coordinate_demo(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		double[]	position;
		turtle.penUp();
		turtle.setPosition(-80,-80);
		turtle.penDown();
		
		//turtle.setPenColor(new Color(255,0,0));
		turtle.setPosition(-80,80);
		position = turtle.getPosition();
		System.out.println("("+position[0]+","+position[1]+")");

		//turtle.setPenColor(new Color(0,255,0));
		turtle.setPosition(80,80);
		position = turtle.getPosition();
		System.out.println("("+position[0]+","+position[1]+")");

		//turtle.setPenColor(new Color(0,0,255));
		turtle.setPosition(80,-80);
		position = turtle.getPosition();
		System.out.println("("+position[0]+","+position[1]+")");

		//turtle.setPenColor(new Color(0,255,255));
		turtle.setPosition(-80,-80);	
		position = turtle.getPosition();
		System.out.println(turtle.getPosition());
//		System.out.println(turtle.setPosition(-80,-80));
		System.out.println("("+position[0]+","+position[1]+")");
		
		
		
		
		
		turtle.penUp();
		turtle.setPosition(-100,-100);
		turtle.penDown();
		position = turtle.getPosition();
		System.out.println("("+position[0]+","+position[1]+")");

		
		turtle.setPenColor(new Color(255,0,0));
		turtle.setPosition(-100,100);
		
		turtle.setPenColor(new Color(0,255,0));
		turtle.setPosition(100,100);
		
		turtle.setPenColor(new Color(0,0,255));
		turtle.setPosition(100,-100);
		
		turtle.setPenColor(new Color(0,255,255));
		turtle.setPosition(-100,-100);

		turtle.penUp();
		turtle.home();
		turtle.penDown();
		turtle.circle_stddraw(50, false, false);
		
		
		return	turtle.getCallerName();
	}
	
	

	
	/**
	 * forward(x) will have the same result of backward(-x)
	 * forward and backward is sensitive to current location and current direction
	 * */
	public static	String	turtle_forward_backward_demo(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.setPenColor(new Color(255,0,0));
		turtle.forward(100);
		turtle.setFillColor(new Color(255,0,0));
		turtle.circle_stddraw(10, false, true);
		turtle.setPenColor(new Color(0,255,0));
		turtle.backward(200);
		turtle.square(20,  false);
		turtle.setPenColor(new Color(0,255,255));
		turtle.forward(-50);
		turtle.square(20,true);
		
		turtle.penUp();
		turtle.home();
		turtle.set_use_degrees(true);
		turtle.setHeading(90);
		turtle.penDown();
		
		turtle.setPenColor(new Color(255,0,255));
		turtle.forward(100);
		turtle.setFillColor(new Color(255,0,255));
		turtle.circle_stddraw(10, false, true);
		turtle.setPenColor(new Color(0,128,128));
		turtle.backward(200);
		turtle.square(20,  false);
		turtle.setPenColor(new Color(255,128,0));
		turtle.forward(-50);
		turtle.square(20,true);

		
		return	turtle.getCallerName();
		
	}
	
	/**
	 * use of penup & pendown to move turtle without leaving trace/drawing
	 * */
	public static	String	penup_pendown_demo(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.penUp();
		turtle.forward(10);
		turtle.penDown();
		turtle.forward(10);
		
		turtle.penUp();
		turtle.forward(10);
		turtle.penDown();
		turtle.forward(10);
		
		turtle.penUp();
		turtle.forward(10);
		turtle.penDown();
		turtle.forward(10);
		
		turtle.penUp();
		turtle.forward(10);
		turtle.penDown();
		turtle.forward(10);
		return	turtle.getCallerName();	
	}

	/**
	 * set_use_degrees(true) will have the same effect as set_use_radians(false)
	 * set_use_degrees(false) will have the same effect as set_use_radians(true)
	 * seth set the absolute direction
	 * left(a) and right(x) will generate the same result
	 * */
	public	static	String	direction_control_demo(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		turtle.penUp();
		turtle.home();
		turtle.penDown();
		turtle.setHeading(90);
		turtle.setPenColor(new Color(0,255,0));
		turtle.forward(100);
		turtle.penUp();
		turtle.home();
		turtle.penDown();
		turtle.left(30);
		turtle.setPenColor(new Color(0,128,0));
		turtle.forward(50);
		
		turtle.set_use_radians(true);
		turtle.penUp();
		turtle.home();
		turtle.penDown();
		turtle.setHeading(Math.PI);
		turtle.setPenColor(new Color(0,0,255));
		turtle.forward(150);
		turtle.penUp();
		turtle.home();
		turtle.penDown();
		turtle.right(Math.PI/6);
		turtle.setPenColor(new Color(0,128,0));
		turtle.forward(80);
		
		
		return	turtle.getCallerName();
	}
	
	
	public	static	String	fill_demo(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		turtle.penUp();
		turtle.setPosition(-100,0);
		turtle.penDown();
		turtle.setPenColor(new Color(0,0,255));
		turtle.setFillColor(new Color(255,255,0));
		turtle.beginFill();
		turtle.forward(80);
		turtle.left(120);
		turtle.forward(80);
		turtle.left(120);
		turtle.forward(80);
		turtle.left(120);
		turtle.endFill();
		
		
		turtle.penUp();
		turtle.setPosition(100,0);
		turtle.penDown();
		turtle.setPenColor(new Color(255,0,255));
		turtle.setFillColor(new Color(0,255,0));
		turtle.beginFill();
		turtle.forward(80);
		turtle.left(90);
		turtle.forward(80);
		turtle.left(90);
		turtle.forward(80);
		turtle.left(90);
		turtle.forward(80);
		turtle.left(90);
		turtle.endFill();
		return	turtle.getCallerName();
	}
	
	
	public	static	String	stairs0(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		
		for(int i=0;i<4;i++)
		{
			turtle.forward(30);
			turtle.right(90);
			turtle.forward(30);
			turtle.left(90);
		}
		
		/*
		turtle.forward(30);
		turtle.right(90);
		turtle.forward(30);
		turtle.left(90);
		
		turtle.forward(30);
		turtle.right(90);
		turtle.forward(30);
		turtle.left(90);
		
		turtle.forward(30);
		turtle.right(90);
		turtle.forward(30);
		turtle.left(90);
		
		turtle.forward(30);
		turtle.right(90);
		turtle.forward(30);
		turtle.left(90);
		*/
		
		turtle.right(180);
		turtle.forward(30*4);
		turtle.right(90);
		turtle.forward(30*4);
		return	turtle.getCallerName();
	}
	
	public	static	String	stairs1(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		double w = 35;
		double h = 20;
		turtle.set_use_degrees(true);
		
		turtle.forward(w);
		turtle.right(90);
		turtle.forward(h);
		turtle.left(90);
		
		turtle.forward(w);
		turtle.right(90);
		turtle.forward(h);
		turtle.left(90);
		
		turtle.forward(w);
		turtle.right(90);
		turtle.forward(h);
		turtle.left(90);
		
		turtle.forward(w);
		turtle.right(90);
		turtle.forward(h);
		turtle.left(90);
		
		turtle.right(180);
		turtle.forward(w*4);
		turtle.right(90);
		turtle.forward(h*4);
		return	turtle.getCallerName();
	}
	
	public	static	String	stairs2(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		double w = 25;
		double h = 30;
		turtle.set_use_degrees(true);
		for (int i=0;i<4;i++)
		{
			turtle.forward(w);
			turtle.right(90);
			turtle.forward(h);
			turtle.left(90);
		}
		turtle.right(180);
		turtle.forward(w*4);
		turtle.right(90);
		turtle.forward(h*4);
		return	turtle.getCallerName();
	}
	
	
	public	static	String	stairs3(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		double w = 25;
		double h = 30;
		int n = 4;
		turtle.set_use_degrees(true);
		for (int i=0;i<n;i++)
		{
			turtle.forward(w);
			turtle.right(90);
			turtle.forward(h);
			turtle.left(90);
		}
		turtle.right(180);
		turtle.forward(w*n);
		turtle.right(90);
		turtle.forward(h*n);
		return	turtle.getCallerName();
	}
	
	
	
	public	static	void	stairsN(Turtle turtle,int n,double w,double h)
	{
		turtle.set_use_degrees(true);
		for (int i=0;i<n;i++)
		{
			turtle.forward(w);
			turtle.right(90);
			turtle.forward(h);
			turtle.left(90);
		}
		turtle.right(180);
		turtle.forward(w*n);
		turtle.right(90);
		turtle.forward(h*n);
	}

	public	static	void	stairsPosN(Turtle turtle,double x,double y,double a,int n,double w,double h)
	{
		turtle.set_use_degrees(true);
		turtle.penUp();
		turtle.setPosition(x,y);
		turtle.setHeading(a);
		turtle.penDown();
		for (int i=0;i<n;i++)
		{
			turtle.forward(w);
			turtle.right(90);
			turtle.forward(h);
			turtle.left(90);
		}
		turtle.right(180);
		turtle.forward(w*n);
		turtle.right(90);
		turtle.forward(h*n);
	}

	
	public	static	String	stairsNTest(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		stairsN(turtle,5,25,20);
		return	turtle.getCallerName();
	}
	
	public	static	String	stairsPosNTest(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		stairsPosN(turtle,-100,100,0,5,25,20);
		stairsPosN(turtle,0,100,45,4,15,15);
		return	turtle.getCallerName();
	}
	
	public	static	String	strange_piece(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		double h = 60;
		double w = 10;
		double r = 16;
		turtle.set_use_degrees(true);
		turtle.forward(h);
		turtle.right(90);
		turtle.forward(w);
		turtle.circle(-r,0,-90);
		turtle.circle(r,0,180);
		turtle.circle(-r,0,-180);
		turtle.circle(r,0,180);
		turtle.circle(-r,0,-180);
		turtle.circle(r,0,90);
		turtle.forward(w);
		turtle.right(90);
		turtle.forward(h-2*r);
		turtle.right(90);
		turtle.forward(2*w+10*r);
		return	turtle.getCallerName();
	}
	
	
	public	static	void	dotted_line(Turtle turtle)
	{
		double l = 10;
		int n = 5;
		for (int i=0;i<n;i++)
		{
			turtle.penUp();
			turtle.forward(l/n/2);
			turtle.penDown();
			turtle.forward(l/n/2);
		}
	}
	
	public	static	void	dotted_line(Turtle turtle,double l,int n)
	{
		for (int i=0;i<n;i++)
		{
			turtle.penUp();
			turtle.forward(l/n/2);
			turtle.penDown();
			turtle.forward(l/n/2);
		}
	}
	
	
	public	static	void	polygon(Turtle turtle)
	{
		
		double l = 3;
		int n = 5;
		turtle.set_use_degrees(true);
		for (int i=0;i<n;i++)
		{
			dotted_line(turtle);
			turtle.left(360/n);
		}
	}
	
	
	public	static	void	polygon(Turtle turtle,int sides,int segments,double side_length)
	{
		turtle.set_use_degrees(true);
		for (int i=0;i<sides;i++)
		{
			dotted_line(turtle,side_length,segments);
			turtle.left(360/sides);
		}
	}
	
	public	static	void	comp(Turtle turtle)
	{
		double l = 30;
		int n = 5;
		turtle.set_use_degrees(true);
		for (int i=0;i<n;i++)
		{
			polygon(turtle);
			turtle.penUp();
			turtle.forward(l);
			turtle.penDown();
			turtle.left(360/n);
		}
	}

	public	static	void	comp(Turtle turtle,int polygons,int sides,int segments,double side_length,double distance)
	{
		turtle.set_use_degrees(true);
		for (int i=0;i<polygons;i++)
		{
			polygon(turtle,sides,segments,side_length);
			turtle.penUp();
			turtle.forward(distance);
			turtle.penDown();
			turtle.left(360/polygons);
		}
	}
	
	public	static	String	test_comp(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		//comp(turtle);
		comp(turtle,3,5,10,60,250);
		return	turtle.getCallerName();
	}
	
	
	//Miffy
    public static void wall(Turtle turtle)
  {
		double h = 60;
		turtle.set_use_degrees(true);
    turtle.setPenColor(new Color(234,207,29));
    turtle.setFillColor(new Color(234,207,29));
    turtle.beginFill();
		turtle.forward(h);
		turtle.left(90);
		turtle.forward(h);
		turtle.left(50);
		turtle.forward(h);
		turtle.left(80);
		turtle.forward(h);
		turtle.left(50);
    turtle.forward(h);
    turtle.left(90);
    turtle.forward(h);
    turtle.endFill();
  }
	
    //Mia Qiao
    

    public static void rectangle(Turtle turtle,double cx,double cy,double height,double width)
    {
      turtle.penUp();
      turtle.setPosition(cx-width/2, cy+height/2);
  	  turtle.penDown();
      turtle.set_use_degrees(true);
      turtle.forward(width);
      turtle.right(90);
      turtle.forward(height);
      turtle.right(90);
      turtle.forward(width);
      turtle.right(90);
      turtle.forward(height);
      turtle.right(90);
      
    }

    public static void windowPane(Turtle turtle)
    {
      double h = 70;
      turtle.penUp();
      turtle.forward(h-40);
      turtle.right(90);
      turtle.forward(h-60);
      turtle.penDown();
      turtle.forward(h-50);
      turtle.right(90);
      turtle.forward(h-50);
      turtle.right(90);
      turtle.forward(h-50);
      turtle.right(90);
      turtle.forward(h-50);
    }

    
    public static void win2(Turtle turtle)
    {

      rectangle(turtle,0,0,200,200);
      rectangle(turtle,-50,-50,80,80);
      rectangle(turtle,-50,50,80,80);
      rectangle(turtle,50,-50,80,80);
      rectangle(turtle,50,50,80,80);
        


     
      
      
      
    }
    
    
	public	static	String	TEST_HOUSE(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		//comp(turtle);
		win2(turtle);
		return	turtle.getCallerName();
	}
	
	public	static	String	spiral(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		
		double	l = 145;
		double	d = 0.5;
		
		for(int i=0;i<200;i++)
		{
			System.out.println(l-i*d);
			turtle.forward(l-i*d);
			turtle.left(60);
			//l = l+d;
		}
		
		return	turtle.getCallerName();
	}
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		TurtleClient tc = new	TurtleClient(new int[] {800, 800}, new double[] {-200,200}, new double[] {-200,200},true);
		tc.setDrawFunction(t->arc_demo(t));
		/*
		tc.setDrawFunction(t->stairs0(t));
		tc.setDrawFunction(t->stairs1(t));
		tc.setDrawFunction(t->penup_pendown_demo(t));
		tc.setDrawFunction(t->coordinate_demo(t));
		tc.setDrawFunction(t->where_am_i(t));
		
		
		tc.setDrawFunction(t->turtle_forward_backward_demo(t));
		tc.setDrawFunction(t->direction_control_demo(t));
		tc.setDrawFunction(t->penup_pendown_demo(t));
		tc.setDrawFunction(t->fill_demo(t));
		tc.setDrawFunction(t->ellipse_demo(t));
		tc.setDrawFunction(t->rectangle_demo(t));
		tc.setDrawFunction(t->square_demo(t));
		tc.setDrawFunction(t->circle_demo_1(t));
		tc.setDrawFunction(t->circle_demo_2(t));
		tc.setDrawFunction(t->circle_demo_3(t));
		tc.setDrawFunction(t->arc_demo(t));
		*/
		tc.runMainLoop();
	}




	public	static	String	circle_from_polygon4(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		turtle.setHeading(0);
		turtle.setPenColor(new Color(255,0,0));
		
		
		turtle.penUp();
		turtle.setPosition(-150,-50);
		turtle.setHeading(0);
		turtle.penDown();
		mark_1(turtle);
		turtle.circle(-50, 12, 90);
		mark_2(turtle);
	
		
		turtle.penUp();
		turtle.setPosition(-150,50);
		turtle.setHeading(0);
		turtle.penDown();
		mark_1(turtle);
		turtle.circle(50, 12, 90);
		mark_2(turtle);
		
	
		turtle.penUp();
		turtle.setPosition(-0,-50);
		turtle.setHeading(0);
		turtle.penDown();
		mark_1(turtle);
		turtle.circle(-50, 12, -90);
		mark_2(turtle);
	
		
		turtle.penUp();
		turtle.setPosition(-0,50);
		turtle.setHeading(0);
		turtle.penDown();
		mark_1(turtle);
		turtle.circle(50, 12, -90);
		mark_2(turtle);
		
		
		
		return	turtle.getCallerName();
	}




	public	static	String	circle_from_polygon3(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		turtle.setPenColor(new Color(255,0,0));
		for (int i=0;i<9;i++)
		{
			int r = i/3;
			int c = i%3;
			turtle.penUp();
			turtle.setHeading(0);
			turtle.setPosition(c*120-150,r*120-150);
			turtle.penDown();
			mark_1(turtle);
			turtle.circle(30, 24, i*30);
			mark_2(turtle);
		}
	
		
	
		return	turtle.getCallerName();
	}




	public	static	String	circle_from_polygon2(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.set_use_degrees(true);
		turtle.setPenColor(new Color(255,0,0));
		for (int i=0;i<9;i++)
		{
			int r = i/3;
			int c = i%3;
			turtle.penUp();
			turtle.setHeading(i*30);
			turtle.setPosition(c*120-150,r*120-150);
			turtle.penDown();
			mark_1(turtle);
			turtle.circle(30, 12, 180);
			mark_2(turtle);
		}
	
		
	
		return	turtle.getCallerName();
	}
}
