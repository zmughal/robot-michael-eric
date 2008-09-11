import java.util.ArrayList;

class MapRecog
{
	private ArrayList<Maze> mazes;
	
	public MapRecog()
	{
		mazes = new ArrayList<Maze>();
	}
	
	public void setMap(Maze m, int x)
	{
		mazes.remove(x);
		mazes.add(x,m);
	}
	
	public boolean attemptMatch()
	{
		
		
		return false;
	}
}