package demo;

import java.awt.Color;
import java.awt.TextComponent;

import lib.java_turtle.Canvas;
import lib.java_turtle.Turtle;
import lib.java_turtle.TurtleClient;




public class TurtleTetrisDemo {

	

	

	public	static	void	L(Turtle turtle,double l)
	{
		turtle.set_use_degrees(true);
		turtle.beginFill();
		turtle.forward(l);
		turtle.right(90);
		turtle.forward(l*2);
		turtle.left(90);
		turtle.forward(l);
		turtle.right(90);
		turtle.forward(l);
		turtle.right(90);
		turtle.forward(l*2);
		turtle.right(90);
		turtle.forward(l*3);
		turtle.endFill();
		turtle.right(90);
	}

	public	static	void	S(Turtle turtle,double l)
	{
		turtle.set_use_degrees(true);
		turtle.beginFill();
		turtle.forward(l);
		turtle.left(90);
		turtle.forward(l);
		turtle.right(90);
		turtle.forward(l*2);
		turtle.right(90);
		turtle.forward(l);
		turtle.right(90);
		turtle.forward(l);
		turtle.left(90);
		turtle.forward(l);
		turtle.right(90);
		turtle.forward(l*2);
		turtle.right(90);
		turtle.forward(l);
		turtle.right(90);
		turtle.endFill();
	}

	
	public	static	void	Z(Turtle turtle,double l)
	{
		turtle.set_use_degrees(true);
		turtle.beginFill();
		turtle.forward(l);
		turtle.right(90);
		turtle.forward(l);
		turtle.left(90);
		turtle.forward(l*2);
		turtle.left(90);
		turtle.forward(l);
		turtle.left(90);
		turtle.forward(l);
		turtle.right(90);
		turtle.forward(l);
		turtle.left(90);
		turtle.forward(l*2);
		turtle.left(90);
		turtle.forward(l);
		turtle.left(90);
		turtle.endFill();
	}
	
	
	public	static	void	B(Turtle turtle,double l)
	{
		turtle.set_use_degrees(true);
		turtle.beginFill();
		turtle.forward(l*2);
		turtle.right(90);
		turtle.forward(l*2);
		turtle.right(90);
		turtle.forward(l*2);
		turtle.right(90);
		turtle.forward(l*2);
		turtle.right(90);
		turtle.endFill();
	}
	
	
	public	static	void	I(Turtle turtle,double l)
	{
		turtle.set_use_degrees(true);
		turtle.beginFill();
		turtle.forward(l*4);
		turtle.right(90);
		turtle.forward(l);
		turtle.right(90);
		turtle.forward(l*4);
		turtle.right(90);
		turtle.forward(l);
		turtle.right(90);
		turtle.endFill();
	}
	
	
	public	static	void	J(Turtle turtle,double l)
	{
		turtle.set_use_degrees(true);
		turtle.left(180);
		turtle.beginFill();
		turtle.forward(l);
		turtle.left(90);
		turtle.forward(l*2);
		turtle.right(90);
		turtle.forward(l);
		turtle.left(90);
		turtle.forward(l);
		turtle.left(90);
		turtle.forward(l*2);
		turtle.left(90);
		turtle.forward(l*2);
		turtle.endFill();
		turtle.left(90);
		turtle.left(180);
	}
	
	
	
	
	
	
	
	public	static	String	tetris(Canvas canvas)
	{
		Turtle turtle = canvas.createTurtle();
		for(int i=0;i<9;i++)
		{
			turtle.penUp();
			turtle.setPosition(i%3*100-100,i/3*100-100);
			turtle.penDown();
			L(turtle,25);
			
		}
		/*
		B(turtle,25);
		I(turtle,50);
		J(turtle,50);
		S(turtle,50);
		Z(turtle,50);
		*/
		
		
		return	turtle.getCallerName();
	}
	

	public static void main(String[] args) 
	{

		
		// TODO Auto-generated method stub
		TurtleClient tc = new	TurtleClient(new int[] {800, 800}, new double[] {-200,200}, new double[] {-200,200},true);
		tc.setDrawFunction(t->tetris(t));
		tc.runMainLoop();
		
		

		
		
		
	}
}
