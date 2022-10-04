package lib.java_turtle;

import java.util.HashMap;
import java.util.Map;

import lib.edu.princeton.stdlib.StdDraw;

public class Canvas {
	private	double[]	arrLogicalScaleX= {0,0};
	private	double[]	arrLogicalScaleY= {0,0};
	private	double[]	arrLogicalSize = {0,0};		
	private	double[]	arrBaseLogicPos= {0,0};
	
	private	int[]		arrPhysicalSize= {0,0};
	
	private	double[]	arrRatios = {0,0};
	


	public	final static	int	RW_POL =	0; 
	public	final static	int	RH_POL =	1; 
	public	final static	int	RW_LOP =	2; 
	public	final static	int	RH_LOP =	3; 
	
	public	Canvas(int[] arrPhysicalSize,double[]	arrLogicalScaleX,double[]	arrLogicalScaleY)
	{
		StdDraw.enableDoubleBuffering();
		this.arrLogicalScaleX = arrLogicalScaleX.clone();
		this.arrLogicalScaleY = arrLogicalScaleY.clone();
    	arrLogicalSize = new	double[] {arrLogicalScaleX[1]-arrLogicalScaleX[0],arrLogicalScaleY[1]-arrLogicalScaleY[0]};	
    	arrBaseLogicPos = new	double[]{(arrLogicalScaleX[1]+arrLogicalScaleX[0])/2,(arrLogicalScaleY[1]+arrLogicalScaleY[0])/2};

    	this.arrPhysicalSize = arrPhysicalSize.clone();
        
    	StdDraw.setCanvasSize(arrPhysicalSize[0],arrPhysicalSize[1]);
        StdDraw.setXscale(arrLogicalScaleX[0],arrLogicalScaleX[1]);
        StdDraw.setYscale(arrLogicalScaleY[0],arrLogicalScaleY[1]);
        
        arrRatios = new	double[] 
		{
			arrPhysicalSize[0]/arrLogicalSize[0],
			arrPhysicalSize[1]/arrLogicalSize[1],
			arrLogicalSize[0]/arrPhysicalSize[0],
			arrLogicalSize[1]/arrPhysicalSize[1]
		};
	}
	
	

	
	
	
	public	double[]	logicalPosition(double[]	arrPhysicalPosition) 
	{
		return	new	double[] {
				arrRatios[this.RW_LOP]*arrPhysicalPosition[0]+arrLogicalScaleX[0],
				arrRatios[this.RH_LOP]*arrPhysicalPosition[1]+arrLogicalScaleY[0]
		};
	}
	
	public	double[]	physicalPosition(double[]	arrLogicalPosition) 
	{
		return	new	double[] {
				arrRatios[this.RW_POL]*(arrLogicalPosition[0]-arrLogicalScaleX[0]),
				arrRatios[this.RH_POL]*(arrLogicalPosition[1]-arrLogicalScaleY[0])
		};
	}

	public	double[]	getBaseLogicPos()
	{
		return	arrBaseLogicPos.clone();
	}
	
    
    public	void	proposeToUpdate(boolean	bForce)
    {
    	StdDraw.show();
    }
    
    public	Turtle	createTurtle()
    {
    	return	new	Turtle(this);
    }
    
    
    
    public	void	clear()
    {
    	StdDraw.clear();
    }
    
    public	void	captureScreenAs(String	sFileName)
    {
    	 StdDraw.save(sFileName);    
    }

}
