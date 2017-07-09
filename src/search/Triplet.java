package search;

public class Triplet<P,R,S> 
{
	private final P fromLoc;
	private final R toLoc;
	private final S cost;
	Triplet(P fromLoc,R toLoc, S cost)
	{
		this.fromLoc=fromLoc;
		this.toLoc=toLoc;
		this.cost=cost;
	}
	public P getfromLoc()
	{
		return fromLoc;
	}
	
	public R gettoLoc()
	{
		return toLoc;
	}
	
	public S getCost()
	{
		return cost;
	}	
	public boolean compare(Triplet<P,R,S> t)
	{
		return this.fromLoc==t.fromLoc && this.toLoc==t.toLoc && this.cost==t.cost;
	}
	public String display()
	{
		return fromLoc+" "+toLoc+" "+cost;
	}
}
