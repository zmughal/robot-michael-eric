class NoisyPoint
{
	public int x;
	public int y;
	public static int noise;
	
	public NoisyPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object o)
	{
		NoisyPoint np = (NoisyPoint)o;
		
		if(Math.abs(x-np.x) <= noise && Math.abs(y-np.y) <= noise)
			return true;
		return false;
	}
}