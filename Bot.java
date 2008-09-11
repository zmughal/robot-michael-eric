import static java.lang.System.*;
import java.util.*;
import java.net.*;
import java.io.*;

public class Bot
{
	public static void main(String args[])
	{
		new Bot();
	}
	
	private Pathfinder path;
	private CommCenter comm;
	private Maze maze;
	private MazeViewer mv;
	
	public Bot()
	{
		comm = new CommCenter("localhost","Bob");
		comm.registerRobot(1);
		out.println("hi");
		maze = new Maze(this);
		
		mv = new MazeViewer(maze);
		
		path = new Pathfinder(this,maze);
		path.start();
	}
}