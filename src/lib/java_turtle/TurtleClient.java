package lib.java_turtle;


import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

import lib.edu.princeton.stdlib.StdDraw;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TurtleClient {

	private	int[]	arrResolution = null;
	private	double[]	arrLogicalScaleX;
	private	double[]	arrLogicalScaleY;
	private	boolean	bRunning = false;
	private	boolean bBlitRequired = false;
	private	Canvas	canvas = null;
	private	Function<Turtle,String> draw_function;
	
	public	TurtleClient(int[]	arrResolution,double[]	arrLogicalScaleX,double[]	arrLogicalScaleY)
	{
		this.arrResolution = arrResolution.clone();
		this.arrLogicalScaleX = arrLogicalScaleX.clone();
		this.arrLogicalScaleY = arrLogicalScaleY.clone();
		Character a;
		
	}

	public	void runMainLoop() 
	{
		bRunning = true;
		while(bRunning)
		{
			this.eventHandling();
			this.update();
			this.draw();
		}
	}	
	
	
	public	void	setDrawFunction(Function<Turtle,String> draw_function)
	{
		this.draw_function = draw_function;
	}
	
	public	void	eventHandling()
	{}
	public	void	update()
	{}
	public	void	draw()
	{
		if (canvas == null)
		{
	         canvas = new	Canvas(arrResolution,arrLogicalScaleX,arrLogicalScaleY);
	         Turtle	t = canvas.createTurtle();
	         String	name = draw_function.apply(t);
	         bBlitRequired = true;
	         
	         Date date = new	Date();  
             DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd - hhmmss");
             String	fName = name+" - "+ dateFormat.format(date)+".png";
             File f = new File(fName);
             
             //Paths.get(fName).getParent().toFile().mkdirs();
             bBlitRequired = false;
             canvas.proposeToUpdate(true);
	         canvas.captureScreenAs(fName);
	         
		}
		if(bBlitRequired)
		{
			bBlitRequired = false;
			canvas.proposeToUpdate(true);
		}
	}
	
	

	


}
