import java.util.ArrayList;
import java.lang.Thread;
import java.awt.Point;

class Pathfinder extends Thread
{
	private double direction;
	//	Direction will be a double representing the direction to the next point in the path
	
	private Point goal;
	private ArrayList<Point> path;
	private Maze maze;
	private Bot bot;
	
	public Pathfinder(Bot b, Maze m)
	{
		bot = b;
		maze = m;
		
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