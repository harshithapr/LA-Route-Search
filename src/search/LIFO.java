package search;
import java.util.LinkedList;

public class LIFO
{
	LinkedList<Node> q=new LinkedList<>();
	public void add(Node p)
	{
		q.addFirst(p);
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
	public void replace(Node p)
	{
		q.pop();
		q.push(p);
	}
	public Node peek()
	{
		return q.peek();
	}
}	
