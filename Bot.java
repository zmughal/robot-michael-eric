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
	
	public Bot()
	{
		path = new Pathfinder();
		path.start();
	}
}