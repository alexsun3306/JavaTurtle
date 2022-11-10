package sandbox;

import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Color;
import java.math.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lib.java_turtle.Turtle;
import lib.java_turtle.TurtleClient;

public class TurtleEmptyDemo {

	//test
	public	static	String	demo(Turtle turtle)
	{
		turtle.setPenRadius(10);
		turtle.set_use_degrees(true);
		turtle.forward(100);
		turtle.forward(-100);
		turtle.left(90);
		turtle.forward(100);
		turtle.forward(-100);
		turtle.left(90);
		turtle.forward(100);
		turtle.forward(-100);
		turtle.left(90);
		turtle.forward(100);
		turtle.forward(-100);
		turtle.left(90);
		return	"polygon";
	}
	
	

	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		TurtleClient tc = new	TurtleClient(new int[] {800, 800}, new double[] {-200,200}, new double[] {-200,200},false);
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
