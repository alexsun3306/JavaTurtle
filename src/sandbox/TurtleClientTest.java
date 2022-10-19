package sandbox;

import java.awt.Color;
import lib.java_turtle.Turtle;
import lib.java_turtle.TurtleClient;




public class TurtleClientTest {

	
	public	static	String	Polygon(Turtle turtle)
	{
		
		turtle.forward(100);
		turtle.forward(100);
		return	"polygon";
	}
	

	public static void main(String[] args) 
	{

		
		// TODO Auto-generated method stub
		TurtleClient tc = new	TurtleClient(new int[] {800, 800}, new double[] {-200,200}, new double[] {-200,200});
		tc.setDrawFunction(t->Polygon(t));
		tc.runMainLoop();
		
		

		
		
		
	}
}
