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
		setUndecorated(true);
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
			setBackground(Color.GREEN);
		}
		
		public void paintComponent(Graphics g)
		{
			for(int r = 0; r < 280; r++)
				for(int c = 0; c < 560; c++)
				{
					if(maze.getValue(r,c) == 'O')
						g.setColor(Color.BLACK);
					else
						g.setColor(Color.GREEN);
					g.fillRect(c*2,r*2,2,2);
				}
		}
	}
}