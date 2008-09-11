import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

class MapRecog
{
	private Maze maze1;
	private Maze maze2;
	
	public MapRecog()
	{
		maze1 = null;
		maze2 = null;
	}
	
	public void setMaze(Maze m, int x)
	{
		if(x == 1)
			maze1 = m;
		if(x == 2)
			maze2 = m;
	}
	
	public boolean attemptMatch()
	{
		if(maze1 == null || maze2 == null)
			return false;
		
		
		
		return false;
	}
}