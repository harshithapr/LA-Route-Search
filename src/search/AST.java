package search;

import java.util.ArrayList;
import java.util.LinkedList;

public class AST 
{
	int nodeCount=0;
	private Node child;
	public LinkedList<Combo<String,Integer>> AST_Search(Problem p)
	{
		Node root=new Node(++nodeCount,p.getinitialState(),null,0,p.heuristics.get(p.getinitialState().getLocation()));
		if(p.goalTest(root.getState()))
		{
			return Solution(root,null);
		}
		PriorityFIFO frontier=new PriorityFIFO(p.liveorder);
		frontier.add(root);
		ExploredSet explored=new ExploredSet();
		while(!frontier.isEmpty())
		{
			Node n=frontier.remove();
			if(p.goalTest(n.getState()))
			{
				return Solution(n, root);
			}
			explored.add(n);
			ArrayList<Action<String, String, Integer>> actlist=p.getAction(n.getState());
			if(actlist!=null)
			{
				for(Action<String, String, Integer> action:actlist)
				{
					child=CHILD_Node(p,n,action);
					if(!explored.contains(child) && !frontier.contains(child))
					{
						frontier.add(child);
					}
					else if(frontier.contains(child) && child.getTotalCost()<frontier.peek().getTotalCost())
					{
						frontier.replace(child);
					}
					else if(frontier.contains(child) && child.getTotalCost()==frontier.peek().getTotalCost())
					{
						String s1=child.getParent().getState().getLocation()+"to"+child.getState().getLocation();
						int or1=p.liveorder.get(s1);
						String s2=frontier.peek().getParent().getState().getLocation()+"to"+frontier.peek().getState().getLocation();
						int or2=p.liveorder.get(s2);
						if(or1<or2)
							frontier.replace(child);
					}
					else if(explored.contains(child))
					{
						Node exp=explored.get(child);
						if(child.getTotalCost()<exp.getTotalCost())
						{
							explored.remove(exp);
							frontier.add(child);
						}
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
	public Node CHILD_Node(Problem p,Node parent, Action<String,String,Integer> act)
	{
		Node child=new Node(++nodeCount, p.Result(parent.getState(),act),parent,parent.getPathCost()+act.getcost(),act,p.heuristics.get(act.getloc()));
			return child;	
	}
}
