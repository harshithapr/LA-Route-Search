package search;

import java.util.Comparator;
import java.util.HashMap;

public class NodeOrder implements Comparator<Node>
{	
	HashMap<String, Integer> liveorder;	
	NodeOrder(HashMap<String, Integer> liveorder)
	{
		this.liveorder=liveorder;
	}
	@Override
		
		public int compare(Node n1, Node n2) 
		{
			int p1;
			int p2;
			if(n1.getHeurCost()==-1 && n1.getHeurCost()==-1)
			{
			p1=n1.getPathCost();
			p2=n2.getPathCost();
			if(p1==p2)
			{
				String s1=n1.getParent().getState().getLocation()+"to"+n1.getState().getLocation();
				int or1=liveorder.get(s1);
				String s2=n2.getParent().getState().getLocation()+"to"+n2.getState().getLocation();
				int or2=liveorder.get(s2);
				return or1-or2;
				
			}
			else
			{
				return p1-p2;
			}
			}
			else
			{
				p1=n1.getTotalCost();
				p2=n2.getTotalCost();
				if(p1==p2)
				{
					String s1=n1.getParent().getState().getLocation()+"to"+n1.getState().getLocation();
					int or1=liveorder.get(s1);
					String s2=n2.getParent().getState().getLocation()+"to"+n2.getState().getLocation();
					int or2=liveorder.get(s2);
					return or1-or2;
				}
				else
				{
					return p1-p2;
				}
			}
		}

}
