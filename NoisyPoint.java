class NoisyPoint
{
	public int x;
	public int y;
	/* XXX Temp value */
	public static int noise=0.1;
	
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
