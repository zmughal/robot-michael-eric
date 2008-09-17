import java.util.ArrayList;
import java.lang.Thread;

class Pathfinder extends Thread
{
	private double direction;
	//	Direction will be a double representing the direction to the next point in the path
	
	private NoisyPoint goal;
	private ArrayList<NoisyPoint> path;
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
		goal = new NoisyPoint(x,y);
	}
	
	public void run()
	{
		
	}
}
