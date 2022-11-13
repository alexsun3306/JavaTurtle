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

public class TurtleStaticMethods {

	
	private	static	Turtle	turtle;
	
	
	public	static	void	forward(double	steps)
	{
		turtle.forward(steps);
	}
	
	public	static	void	left(double	angle)
	{
		turtle.left(angle);
	}
	
	//test
	public	static	String	demo(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		turtle.setPenRadius(10);
		turtle.set_use_degrees(true);
		TurtleStaticMethods.turtle = turtle;

		for(int i=0;i<6;i++)
		{
			forward(50);
			left(60);
		}
		
		
		
		return	turtle.getCallerName();
	}
	
	

	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		TurtleClient tc = new	TurtleClient(new int[] {800, 800}, new double[] {-200,200}, new double[] {-200,200},true);
		tc.setDrawFunction(t->demo(t));
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
}
