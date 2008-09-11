import java.io.IOException;
import java.util.Scanner;
import java.util.HashSet;
import java.awt.Point;
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
	
	private HashSet<Point> map;
	
	public Maze(Bot bot)
	{
		this.bot = bot;
		roff = 0;
		coff = 0;
//		map = new char[280][560];
		map = new HashSet<Point>();
	}
	
//	public synchronized char[][] getMap()
//	{
//		return map;
//	}
	
	public synchronized HashSet<Point> getMap()
	{
		return map;
	}
	
	public void add(int r, int c)
	{
		map.add(new Point(r,c));
	}
	
	public boolean contains(int r, int c)
	{
		return map.contains(new Point(r,c));
	}
	
	public void setOffset(int r, int c)
	{
		roff = r;
		coff = c;
		
		HashSet<Point> temp = new HashSet<Point>();
		
		for(Point p : map)
			temp.add(new Point(p.x+coff,p.y+roff));
		
		map = temp;
	}
	
	public HashSet<Point> getMaze()
	{
		return map;
	}
	
	public void loadMap(String file)
	{
		try
		{
			Scanner scan = new Scanner(new File(file));
			HashSet<Point> temp = new HashSet<Point>();
			
			while(scan.hasNextLine())
			{
				temp.add(new Point(scan.nextInt(),scan.nextInt()));
			}
			
			map = temp;
		}
		catch(IOException ioe){}
	}
}