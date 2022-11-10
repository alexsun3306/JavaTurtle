package demo;

import java.awt.Color;
import lib.java_turtle.Turtle;
import lib.java_turtle.TurtleClient;




public class TurtleCommandsDemo {


	
	
	
	
	
	
	public	static	String	command_forward(Turtle turtle)
	{
		turtle.set_use_degrees(true);
		turtle.setHeading(0);
		turtle.home();
		
		turtle.forward(150);
		turtle.backward(-150);
		//turtle.forward(50);
		//turtle.forward(50);
		//turtle.backward(100);
		//turtle.backward(-200);

		
		return	turtle.getCallerName();
	}
	
	
	public	static	String	command_setPos(Turtle turtle)
	{
		turtle.home();
		turtle.setPosition(100,100);
		turtle.setPosition(100,0);
		turtle.setPosition(0,0);
		
		
		return	turtle.getCallerName();
	}
	
	
	
	public	static	String	command_setHead(Turtle turtle)
	{
		turtle.set_use_degrees(true);
		turtle.setHeading(0);
		turtle.forward(80);
		turtle.setHeading(60);
		turtle.forward(80);
		turtle.setHeading(480);
		turtle.forward(80);
		turtle.set_use_radians(true);
		turtle.setHeading(Math.PI);
		turtle.forward(80);
		turtle.setHeading(Math.PI*4/3);
		turtle.forward(80);
		turtle.setHeading(Math.PI*5/3);
		turtle.forward(80);
		

		
		return	turtle.getCallerName();
	}
	
	

	
	public	static	String	command_leftright(Turtle turtle)
	{
		turtle.set_use_degrees(true);
		turtle.setHeading(0);
		turtle.forward(150);
		turtle.left(90);
		turtle.forward(150);
		turtle.set_use_degrees(false);
		turtle.left(Math.PI/2);
		turtle.forward(150);
		turtle.left(Math.PI/2);
		turtle.forward(150);
		turtle.left(Math.PI/2);
		
		return	turtle.getCallerName();
	}
	
	
	public	static	String	command_penupdown(Turtle turtle)
	{
		
		turtle.forward(50);
		
		//turtle.penUp();
		turtle.forward(50);		
		//turtle.penDown();
		
		
		turtle.forward(50);
		
		
		return	turtle.getCallerName();
	}
	
	public	static	String	command_artistic(Turtle turtle)
	{
		turtle.set_use_degrees(true);
		turtle.setHeading(0);
		
		turtle.setPenColor(255,0,0);
		turtle.setPenRadius(4);
		turtle.forward(80);
		turtle.left(60);
		turtle.setPenRadius(8);
		turtle.setPenColor(0,255,0);
		turtle.forward(80);
		turtle.left(60);
		turtle.setPenRadius(12);
		turtle.setPenColor(0,0,255);
		turtle.forward(80);
		turtle.left(60);
		turtle.setPenRadius(16);
		turtle.setPenColor(0,255,255);
		turtle.forward(80);
		turtle.left(60);
		turtle.setPenRadius(20);
		turtle.setPenColor(255,0,255);
		turtle.forward(80);
		turtle.left(60);
		turtle.setPenRadius(24);
		turtle.setPenColor(255,255,0);
		turtle.forward(80);
		turtle.left(60);
		
		
		return	turtle.getCallerName();
	}
	
	

	public	static	String	command_setPo2(Turtle turtle)
	{
		turtle.set_use_degrees(true);
		
		//fill color
		//closed shape
		//begin & end fill
		turtle.penUp();
		turtle.setPosition(-100, -100);
		turtle.penDown();
		
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);

		
		
		
		turtle.penUp();
		turtle.setPosition(100, 100);
		turtle.penDown();
		
		
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		
		
		return	turtle.getCallerName();
	}
	

	
	public	static	String	command_fill2(Turtle turtle)
	{
		turtle.set_use_degrees(true);
		
		//fill color
		//closed shape
		//begin & end fill
		turtle.penUp();
		turtle.setPosition(-100, -100);
		turtle.penDown();
		
		turtle.setFillColor(255, 0, 0);
		turtle.beginFill();
		
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		
		turtle.endFill();
		
		turtle.penUp();
		turtle.setPosition(100, 100);
		turtle.penDown();
		
		
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		
		
		return	turtle.getCallerName();
	}

	
	

	public	static	String	command_fill(Turtle turtle)
	{
		turtle.set_use_degrees(true);
		
		//fill color
		//closed shape
		//begin & end fill
		turtle.penUp();
		turtle.setPosition(-100, -100);
		turtle.penDown();
		
		turtle.setFillColor(255, 0, 0);
		turtle.beginFill();
		
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		
		turtle.endFill();
		
		turtle.penUp();
		turtle.setPosition(100, 100);
		turtle.penDown();
		
		
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		turtle.forward(50);
		turtle.left(90);
		
		
		
		return	turtle.getCallerName();
	}

	
	public	static String	command_circle_1(Turtle turtle)
	{
		turtle.setFillColor(255, 0, 0);
		turtle.circle_stddraw(0, 0, 50, true);

		turtle.setFillColor(0,255, 0);
		turtle.circle_stddraw(100, 100, 50, true);

		turtle.setFillColor(0,255, 0);
		turtle.circle_stddraw(100, 100, 80, false);
		
		return	turtle.getCallerName();
	}
	
	
	
	public	static String	command_circle_2(Turtle turtle)
	{
		turtle.set_use_degrees(true);
		
		turtle.penUp();
		turtle.setPosition(-100, -100);
		turtle.penDown();
		
		turtle.circle_stddraw(80, false, true);
		turtle.forward(100);
		turtle.forward(-100);
		
		
		
		turtle.penUp();
		turtle.setPosition(50, 50);
		turtle.penDown();
		turtle.setHeading(180);
		
		turtle.circle_stddraw(80, true, true);
		turtle.forward(100);
		turtle.forward(-100);
		
		return	turtle.getCallerName();
	}

	public	static String	command_circle_3a(Turtle turtle)
	{
		turtle.set_use_degrees(true);
		
		//turtle.beginFill();
		turtle.penUp();
		turtle.setPosition(-100, -100);
		turtle.penDown();
		turtle.circle(40, 400, 360);
		turtle.penUp();
		turtle.setPosition(-100, 100);
		turtle.penDown();
		turtle.circle(40, 10, 360);
		turtle.penUp();
		turtle.setPosition(100, -100);
		turtle.penDown();
		turtle.circle(40, 5, 360);
		turtle.penUp();
		turtle.setPosition(100, 100);
		turtle.penDown();
		turtle.circle(40, 4, 360);
		//turtle.endFill();
	
		return	turtle.getCallerName();
	}

	
	
	public	static String	command_circle_3b(Turtle turtle)
	{
		turtle.set_use_degrees(true);
		
		//turtle.beginFill();
		turtle.circle(40, 400, 90);
		turtle.forward(40);
		turtle.circle(40, 400, 90);
		turtle.forward(40);
		turtle.circle(40, 400, 90);
		turtle.forward(40);
		turtle.circle(40, 400, 90);
		turtle.forward(40);
		//turtle.endFill();
	
		return	turtle.getCallerName();
	}
	
	
	public	static String	command_circle_3c(Turtle turtle)
	{
		turtle.set_use_degrees(true);
		
		//turtle.beginFill();
		turtle.setPenColor(255,0,0);
		turtle.circle(40, 400, 90);
		turtle.forward(40);
		turtle.setPenColor(0,255,0);
		turtle.circle(-40, 400, -90);
		turtle.forward(40);
		//turtle.endFill();
	
		return	turtle.getCallerName();
	}
	
	

	public	static String	command_arc(Turtle turtle)
	{
		turtle.set_use_degrees(true);
		turtle.setPenColor(new Color(255,0,0));
		/*draw arc center @ turtle position*/
		turtle.circle_stddraw(5, false, true);
		turtle.arc(100, 45, 135);
		turtle.setPenColor(new Color(0,255,0));
		turtle.arc(70, 90, 180);
		turtle.setPenColor(new Color(0,255,255));
		turtle.arc(50,135, 225);
		
		/*draw arc center @ specified location of x,y*/
		turtle.circle_stddraw(100, 100, 5, true);
		turtle.arc(100,100,50,90, 270);
		turtle.arc(100,100,60,135, 225);
		turtle.arc(100,100,70,135, 225);
		turtle.arc(100,100,80,135, 225);
		return	turtle.getCallerName();
	}
	
	
	

	public static void main(String[] args) 
	{

		
		// TODO Auto-generated method stub
		TurtleClient tc = new	TurtleClient(new int[] {800, 800}, new double[] {-200,200}, new double[] {-200,200},true);
		tc.setDrawFunction(t->command_arc(t));
		tc.runMainLoop();
		
		

		
		
		
	}
}
