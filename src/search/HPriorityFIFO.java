package search;
import java.util.PriorityQueue;

public class HPriorityFIFO
{
	PriorityQueue<Node1> q=new PriorityQueue<Node1>(new Node1());
	public boolean add(Node1 p)
	{
		return q.add(p);
	}
	public Node1 remove()
	{
		return q.remove();
	}
	public boolean isEmpty()
	{
		return q.isEmpty();

	}
	public boolean contains(Node1 p)
	{
		for(Node1 item:q)
		{
			int comp=item.getState().getLocation().compareTo(p.getState().getLocation());
			if(comp==0)
				return true;
		}
		return false;
	}
	public Node1 peek()
	{
		return q.peek();
	}
	public void replace(Node1 rep)
	{
		q.poll();
		q.add(rep);
	}
	
}	
