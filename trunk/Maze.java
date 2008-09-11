class Maze
{
	private int roff;
	private int coff;
	private Bot bot;
	private char map[][];
	/*
		Characters used in the map will be as follows:
		  ' ': an empty or unknown cell
		  'O': an obsticle
		  'B': a possible beacon location
	*/
	
	public Maze(Bot bot)
	{
		this.bot = bot;
		roff = 0;
		coff = 0;
		map = new char[280][560];
	}
	
	public synchronized char[][] getMap()
	{
		return map;
	}
	
	public void setValue(int r, int c, char v)
	{
		map[r+roff][c+coff] = v;
	}
	
	public char getValue(int r, int c)
	{
		return map[r][c];
	}
	
	public void setOffset(int r, int c)
	{
		roff = r;
		coff = c;
	}
}