package search;

import java.util.ArrayList;
import java.util.LinkedList;

public class DFS 
{
	int nodeCount=0;
	private Node child;
	public LinkedList<Combo<String,Integer>> DFS_Search(Problem p)
	{
		Node root=new Node(++nodeCount,p.getinitialState(),null,0,-1);
		if(p.goalTest(root.getState()))
		{
			return Solution(root,null);
		}
		LIFO frontier=new LIFO();
		frontier.add(root);
		ExploredSet explored=new ExploredSet();
		while(!frontier.isEmpty())
		{
			Node n=frontier.remove();
			String s=n.getState().getLocation();
			explored.add(n);
			ArrayList<Action<String, String, Integer>> actlist=p.getAction(n.getState());
			if(actlist!=null)
			{
			Action<String, String, Integer> action;
			for(int i=actlist.size()-1;i>=0;i--)
			{
				action=actlist.get(i);
				child=CHILD_NODE(p,n,action);
				if(!explored.contains(child)&&!frontier.contains(child))
				{
					if(p.goalTest(child.getState()))
					{
						return Solution(child, root);
					}
					frontier.add(child);
				}
			}
			}
		}
		return null;
	}

	public LinkedList<Combo<String,Integer>> Solution(Node n, Node start)
	{
			Node temp=n;
			LinkedList<Combo<String,Integer>> op=new LinkedList<Combo<String,Integer>>();
			while(temp!=null)
			{
				System.out.println(temp.getState().getLocation()+"  "+temp.getPathCost());
				Combo<String, Integer> c=new Combo<String, Integer>(temp.getState().getLocation(),temp.getPathCost());
				op.push(c);
				temp=temp.getParent();
			}
			return op;
	}
	public Node CHILD_NODE(Problem p,Node parent, Action<String,String,Integer> act)
	{
		Node child=new Node(++nodeCount, p.Result(parent.getState(),act),parent,parent.getPathCost()+1,act,-1);
			return child;	
	}
}
