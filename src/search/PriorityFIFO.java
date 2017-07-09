package search;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PriorityFIFO
{
	HashMap<String, Integer> liveorder;
	PriorityQueue<Node> q;
	PriorityFIFO(HashMap<String, Integer> liveorder)
	{
		this.liveorder=liveorder;
		q=new PriorityQueue<Node>(new NodeOrder(liveorder));
	}
	

	public boolean add(Node p)
	{
		return q.add(p);
	}
	public Node remove()
	{
		return q.remove();
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
	public Node peek()
	{
		return q.peek();
	}
	public void replace(Node rep)
	{
		q.poll();
		q.add(rep);
	}
	public void display()
	{
		System.out.println("Queue Contents");
		for(Node n: q)
		{
			System.out.println(n.getState().getLocation());
		}
	}
	
}	
