package search;

public class Combo<S,T>
{
	private final S location;
	private final T cost;
	Combo(S location, T cost)
	{
		this.location=location;
		this.cost=cost;
	}
	public S getLocation()
	{
		return location;
	}
	public T getCost()
	{
		return cost;
	}	
	public boolean compare(Combo<S,T> c)
	{
		return this.location==c.location && this.cost==c.cost;
	}
	public String display()
	{
		return location+" "+cost;
	}
}
