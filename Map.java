class Map
{
	private char map[][];
	/*
		Characters used in the map will be as follows:
		  'E': an empty or unknown cell
		  'O': an obsticle
		  'B': a possible beacon location
	*/
	
	public Map()
	{
		map = new char[140][280];
		
		for(int r = 0; r < 140; r++)
			for(int c = 0; c < 280; c++)
			{
				map[r][c] = 'E';
			}
	}
	
	public synchronized char[][] getMap()
	{
		return map;
	}
	
	public void setValue(int r, int c, char v)
	{
		map[r][c] = v;
	}
}