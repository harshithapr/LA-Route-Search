package search;

public class Action<P,R,S> 
{
	private final P op;
	private final R loc;
	private final S cost;
	Action(P op,R loc, S cost)
	{
		this.op=op;
		this.loc=loc;
		this.cost=cost;
	}
	public P getop()
	{
		return op;
	}
	
	public R getloc()
	{
		return loc;
	}
	
	public S getcost()
	{
		return cost;
	}	
	public boolean compare(Action<P,R,S> t)
	{
		return this.op==t.op && this.loc==t.loc && this.cost==t.cost;
	}
	public String displaloc()
	{
		return op+" "+loc+" "+cost;
	}
}
