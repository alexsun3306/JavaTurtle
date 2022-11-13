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
	private	boolean bDrawRequired = false;
	private	boolean bBlitRequired = false;
	private	Canvas	canvas = null;
	private	Function<Canvas,String> draw_function;
	private	boolean	bCaptureOn = false;
	private	boolean	bAnimationMode = false;
	
	public	TurtleClient(int[]	arrResolution,double[]	arrLogicalScaleX,double[]	arrLogicalScaleY,boolean bCaptureOn)
	{
		this.arrResolution = arrResolution.clone();
		this.arrLogicalScaleX = arrLogicalScaleX.clone();
		this.arrLogicalScaleY = arrLogicalScaleY.clone();
		this.bCaptureOn = bCaptureOn;
        this.canvas = new	Canvas(arrResolution,arrLogicalScaleX,arrLogicalScaleY);
        this.triggerDraw();
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
	
	
	public	void	setDrawFunction(Function<Canvas,String> draw_function)
	{
		this.draw_function = draw_function;
	}
	
	public	void	triggerDraw()
	{
		this.bDrawRequired = true;
		this.bBlitRequired = true;
	}
	
	public	void	triggerBlit()
	{
		this.bBlitRequired = true;
	}
	
	public	void	eventHandling()
	{}
	public	void	update()
	{}
	public	void	draw()
	{
		if(this.bDrawRequired)
		{
			this.bDrawRequired = false;
			String	name = draw_function.apply(this.canvas);
			canvas.proposeToUpdate(true);
			 
			if(this.bCaptureOn) 
			{
				Date date = new	Date();  
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd - hhmmss");
				String	fName = "e:\\turtle exec images\\"+name+"\\"+name+" - "+ dateFormat.format(date)+".png";
				File f = new File(fName);
				Paths.get(fName).getParent().toFile().mkdirs();
				canvas.captureScreenAs(fName);
			}
		}
		if(bBlitRequired)
		{
			bBlitRequired = false;
			canvas.proposeToUpdate(true);
		}
	}
	
	
	public	String	getName()
	{
		 return StackWalker.
			      getInstance().
			      walk(stream -> stream.skip(1).findFirst().get()).
			      getMethodName();
	}
	


}
