import java.net.*;
import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Bot
{
	public static void main(String args[])
	{
		new Bot();
	}
	
	private char world[][];
	private Pathfinder path;
	
	/*
		Characters used in the map will be as follows:
		  'E': an empty or unknown cell
		  'O': an obsticle
		  'B': a possible beacon location
	*/
	
	public Bot()
	{
		world = new char[140][280];
		
		for(int r = 0; r < 140; r++)
			for(int c = 0; c < 280; c++)
			{
				world[r][c] = 'E';
			}
		
		path = new Pathfinder();
		path.start();
		
		while(true){}
	}
}