import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

class MapRecog
{
	private Maze maze1;
	private Maze maze2;
	private double maze1dist[][];
	private double maze2dist[][];
	
	public MapRecog()
	{
		maze1 = null;
		maze2 = null;
	}
	
	public void setMaze(Maze m, int x)
	{
		if(x == 1)
		{
			maze1 = m;
		}
		if(x == 2)
		{
			maze2 = m;
		}
	}
	
	public boolean attemptMatch()
	{
		if(maze1 == null || maze2 == null)
			return false;
		
		ArrayList<NoisyPoint> map = new ArrayList<NoisyPoint>();
		
		for(NoisyPoint np : maze1.getMaze())
			map.add(np);
		
		maze1dist = formDistanceGraph(maze1,map);
		
		map = new ArrayList<NoisyPoint>();
		
		for(NoisyPoint np : maze2.getMaze())
			map.add(np);
		
		maze2dist = formDistanceGraph(maze2,map);
		
		checkPoints(maze1dist,maze2dist);
		
		return false;
	}
	
	private double[][] formDistanceGraph(Maze m, ArrayList<NoisyPoint> points)
	{
		double temp[][] = new double[m.getMaze().size()][m.getMaze().size()];
		
		for(int x = 0; x < temp.length; x++)
			for(int y = 0; y < temp.length; y++)
				temp[x][y] = getDistance(points.get(x),points.get(y));
		
		return temp;
	}
	
	private void checkPoints(double p1[][], double p2[][])
	{
		double temp[] = p1[0];
		
		for(int x = 0; x < temp.length; x++)
		{
			if(temp[x] != 0)
			{
				for(int r = 0; r < p2.length; r++)
					for(int c = 0; c < p2.length; c++)
						if(temp[x] == p2[r][c])
							bounce()
			}
		}
	}
	
	private double getDistance(NoisyPoint one, NoisyPoint two)
	{
		return Math.sqrt(Math.pow((one.x-two.x),2)+Math.pow((one.y-two.y),2));
	}
}