package search;

public class Triple<P,R,S> 
{
	private final P x;
	private final R y;
	private final S z;
	Triple(P x,R y, S z)
	{
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public P getx()
	{
		return x;
	}
	
	public R gety()
	{
		return y;
	}
	
	public S getz()
	{
		return z;
	}	
	public boolean compare(Triple<P,R,S> t)
	{
		return this.x==t.x && this.y==t.y && this.z==t.z;
	}
	public String display()
	{
		return x+" "+y+" "+z;
	}
}