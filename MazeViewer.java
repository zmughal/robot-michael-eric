import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class MazeViewer extends JFrame
{
	private Maze maze;
	
	public MazeViewer(Maze m)
	{
		setMaze(m);
		setSize(1160,580);
//		setUndecorated(true);
		setLocationRelativeTo(null);
		add(new MazePanel());
		setVisible(true);
	}
	
	public void setMaze(Maze m)
	{
		maze = m;
	}
	
	class MazePanel extends JPanel
	{
		public MazePanel()
		{
			setPreferredSize(new Dimension(1160,580));
		}
		
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.GREEN);
			g.fillRect(0,0,1160,580);
			g.setColor(Color.BLACK);
			for(NoisyPoint p : maze.getMaze())
				g.fillRect(p.x*2,p.y*2,2,2);
		}
	}
}