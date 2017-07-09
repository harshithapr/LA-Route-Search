package search;
import java.util.LinkedList;

public class FIFO
{
	LinkedList<Node> q=new LinkedList<>();
	public boolean add(Node p)
	{
		return q.add(p);
	}
	public Node remove()
	{
		return q.removeFirst();
	}
	public boolean isEmpty()
	{
		return q.isEmpty();

	}
	public boolean contains(Node p)
	{
		for(Node item:q)
		{
			int comp=item.getState().getLocation().compareTo(p.getState().getLocation());
			if(comp==0)
				return true;
		}
		return false;
	}
}	
