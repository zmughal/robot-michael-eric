import java.io.IOException;
import java.util.Scanner;
import java.util.HashSet;
import java.io.File;

class Maze
{
	private int roff;
	private int coff;
	private Bot bot;
//	private char map[][];
	/*
		Characters used in the map will be as follows:
		  ' ': an empty or unknown cell
		  'O': an obsticle
		  'B': a possible beacon location
	*/
	
	private HashSet<NoisyPoint> map;
	
	public Maze(Bot bot)
	{
		this.bot = bot;
		roff = 0;
		coff = 0;
//		map = new char[280][560];
		map = new HashSet<NoisyPoint>();
	}
	
//	public synchronized char[][] getMap()
//	{
//		return map;
//	}
	
	public synchronized HashSet<NoisyPoint> getMap()
	{
		return map;
	}
	
	public void add(int r, int c)
	{
		map.add(new NoisyPoint(r,c));
	}
	
	public boolean contains(int r, int c)
	{
		return map.contains(new NoisyPoint(r,c));
	}
	
	public void setOffset(int r, int c)
	{
		roff = r;
		coff = c;
		
		HashSet<NoisyPoint> temp = new HashSet<NoisyPoint>();
		
		for(NoisyPoint p : map)
			temp.add(new NoisyPoint(p.x+coff,p.y+roff));
		
		map = temp;
	}
	
	public HashSet<NoisyPoint> getMaze()
	{
		return map;
	}
	
	public void loadMap(String file)
	{
		try
		{
			Scanner scan = new Scanner(new File(file));
			HashSet<NoisyPoint> temp = new HashSet<NoisyPoint>();
			
			while(scan.hasNextLine())
			{
				temp.add(new NoisyPoint(scan.nextInt(),scan.nextInt()));
			}
			
			map = temp;
		}
		catch(IOException ioe){}
	}
}
