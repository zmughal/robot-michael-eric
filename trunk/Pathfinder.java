import java.util.ArrayList;
import java.lang.Thread;
import java.awt.Point;

class Pathfinder extends Thread
{
	private char world[][];
	/*
		Characters used in the map will be as follows:
		  'E': an empty or unknown cell
		  'O': an obsticle
		  'B': a possible beacon location
	*/
	
	private double direction;
	//	Direction will be a double representing the direction to the next point in the path
	
	private Point goal;
	private ArrayList<Point> path;
	
	public Pathfinder()
	{
		goal = null;
		
		
		
		direction = 0;
	}
	
	public double getDirection()
	{
		return direction;
	}
	
	public void setGoal(int x, int y)
	{
		goal = new Point(x,y);
	}
	
	public void run()
	{
		
	}
}