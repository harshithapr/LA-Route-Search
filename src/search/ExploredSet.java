package search;

import java.util.HashSet;

public class ExploredSet 
{
	HashSet<Node> h;
	ExploredSet()
	{
		h=new HashSet<Node>();
	}
	public boolean add(Node n)
	{
		return h.add(n);
	}
	public boolean contains(Node n)
	{
		for(Node it:h)
		{
			int comp=it.getState().getLocation().compareTo(n.getState().getLocation());
			if(comp==0)
				return true;
		}
		return false;
	}
	public boolean isEmpty()
	{
		return h.isEmpty();
	}
	public Node get(Node n)
	{
		for(Node it:h)
		{
			int comp=it.getState().getLocation().compareTo(n.getState().getLocation());
			if(comp==0)
				return it;
		}
		return null;
	}
	public void remove(Node n)
	{
		h.remove(n);
	}
}
