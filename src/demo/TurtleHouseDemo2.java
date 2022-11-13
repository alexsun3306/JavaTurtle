package demo;

import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Color;
import java.math.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lib.java_turtle.Turtle;
import lib.java_turtle.TurtleClient;
import lib.java_turtle.Canvas;

public class TurtleHouseDemo2 {

	public	static	void	rectangle(Turtle turtle,double w,double h)
	{
		turtle.set_use_degrees(true);
		double[] base_pos = turtle.getPosition();
		double angle = turtle.getHeading();
		
		turtle.beginFill();
		for(int i=0;i<2;i++)
		{
			turtle.forward(w/2.0);
			turtle.left(90);
			turtle.forward(h);
			turtle.left(90);
			turtle.forward(w/2.0);
		}
		
		turtle.endFill();

		
		turtle.penUp();
		turtle.setPosition(base_pos);
		turtle.setHeading(angle);
		turtle.penDown();

	}
	
	
	
	public	static	void	right_triangle(Turtle turtle,double x,double y,double a,double b)
	{
		turtle.set_use_degrees(true);
		double[] base_pos = turtle.getPosition();
		double angle = turtle.getHeading();
		turtle.penUp();
		turtle.forward(a);
		double[]	pos_1 = turtle.getPosition();
		turtle.setPosition(base_pos);
		turtle.setHeading(angle+90);
		turtle.forward(b);
		double[]	pos_2 = turtle.getPosition();
		turtle.setPosition(base_pos);
		turtle.beginFill();
		turtle.penDown();
		turtle.setPosition(pos_1);
		turtle.setPosition(pos_2);
		turtle.setPosition(base_pos);
		turtle.endFill();

		turtle.penUp();
		turtle.setPosition(base_pos);
		turtle.setHeading(angle);
		turtle.penDown();

	}
	
	public	static	void	isosceles_triangle(Turtle turtle,double x,double y,double a,double b)
	{
		turtle.set_use_degrees(true);
		double[] base_pos = turtle.getPosition();
		double angle = turtle.getHeading();
		turtle.penUp();
		turtle.forward(a);
		double[]	pos_1 = turtle.getPosition();
		turtle.setPosition(base_pos);
		turtle.setHeading(angle+90);
		turtle.forward(b);
		double[]	pos_2 = turtle.getPosition();
		turtle.setPosition(base_pos);
		turtle.setHeading(angle+180);
		turtle.forward(a);
		double[]	pos_3 = turtle.getPosition();
		turtle.setPosition(base_pos);
		turtle.beginFill();
		turtle.penDown();
		turtle.setPosition(pos_1);
		turtle.setPosition(pos_2);
		turtle.setPosition(pos_3);
		turtle.setPosition(base_pos);
		turtle.endFill();

		turtle.penUp();
		turtle.setPosition(base_pos);
		turtle.setHeading(angle);
		turtle.penDown();

	}
	
	
	
	
	
	
	
	
	public	static	void	bridge_n(Turtle turtle,double radius,double height,double thickness,double center_width,double side_width,int n)
	{
		turtle.set_use_degrees(true);
		double[] base_pos = turtle.getPosition();
		double angle = turtle.getHeading();
		double	half_total_width = side_width+n*radius+center_width/2.0*(n-1);
		turtle.penUp();
		turtle.backward(half_total_width);
		turtle.penDown();
		turtle.left(90);
		double	total_height = height+radius+thickness;
		turtle.beginFill();
		turtle.forward(total_height);
		turtle.right(90);
		turtle.forward(half_total_width*2);
		turtle.right(90);
		turtle.forward(total_height);
		turtle.right(90);
		turtle.forward(side_width);
		for (int i=0;i<n-1;i++)
		{
			turtle.right(90);
			turtle.forward(height);
			turtle.circle(radius, 40, 180);
			turtle.forward(height);
			turtle.right(90);
			turtle.forward(center_width);
		}
		turtle.right(90);
		turtle.forward(height);
		turtle.circle(radius, 40, 180);
		turtle.forward(height);
		turtle.right(90);
		turtle.forward(side_width);
		turtle.endFill();

		
		
		
		turtle.penUp();
		turtle.setPosition(base_pos);
		turtle.setHeading(angle);
		turtle.penDown();
	}
	
	
	
	
	
	
	
	
	
	public	static	void	stairs(Turtle turtle,double w,double h,int n)
	{
		turtle.set_use_degrees(true);
		double[] base_pos = turtle.getPosition();
		double angle = turtle.getHeading();

		turtle.beginFill();
		turtle.left(90);
		turtle.forward(n*h);
		turtle.right(90);
		for (int i=0;i<n;i++)
		{
			turtle.forward(w);
			turtle.right(90);
			turtle.forward(h);
			turtle.left(90);
		}
		turtle.right(180);
		turtle.forward(w*n);
		turtle.endFill();
		
		turtle.penUp();
		turtle.setPosition(base_pos);
		turtle.setHeading(angle);
		turtle.penDown();
		
	}
	
	
	public	static	void	door(Turtle turtle,double r,double h)
	{
		turtle.set_use_degrees(true);
		double[] base_pos = turtle.getPosition();
		double angle = turtle.getHeading();
		
		turtle.beginFill();
		turtle.forward(r);
		turtle.left(90);
		turtle.forward(h);
		turtle.circle(r, 40, 180);
		turtle.forward(h);
		turtle.left(90);
		turtle.forward(r);
		turtle.endFill();

		
		turtle.penUp();
		turtle.setPosition(base_pos);
		turtle.setHeading(angle);
		turtle.penDown();
		
	}
	
	
	public	static	void	rainbow(Turtle turtle,double r1,double r2,double h)
	{
		turtle.set_use_degrees(true);
		double[] base_pos = turtle.getPosition();
		double angle = turtle.getHeading();
		
		turtle.penUp();
		turtle.forward(r1);
		turtle.penDown();
		turtle.beginFill();
		turtle.forward(r2-r1);
		turtle.left(90);
		turtle.forward(h);
		turtle.circle(r2, 40, 180);
		turtle.forward(h);
		turtle.left(90);
		turtle.forward(r2-r1);
		turtle.left(90);
		turtle.forward(h);
		turtle.circle(-r1, 40, -180);
		turtle.forward(h);
		turtle.endFill();

		
		turtle.penUp();
		turtle.setPosition(base_pos);
		turtle.setHeading(angle);
		turtle.penDown();
		
	}
	
	
	
	
	
	
	
	public	static	String	canvas(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		//right_triangle(turtle, 0, 0, 100, 50);
		//bridge_n(turtle, 30, 30, 30, 30, 30, 3);
		//stairs(turtle,30,20,5);
		//door(turtle,50,30);
		//rainbow(turtle,90,70,30);
		rectangle(turtle,40,60);
		return	turtle.getCallerName();
	}
	
	public static void main(String[] args) 
	{
		TurtleClient tc = new	TurtleClient(new int[] {800, 800}, new double[] {-200,200}, new double[] {-200,200},true);
		tc.setDrawFunction(t->canvas(t));
	
		tc.runMainLoop();
	}
}
