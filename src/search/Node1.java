package search;

import java.util.Comparator;

public class Node1 implements Comparator<Node1>
{
	private int Node1ID;
	private State STATE;
	private Node1 PARENT;
	Action<String,String,Integer> ACTION;
	Integer PATH_COST;
	Integer HEUR_COST;
	Node1()
	{
		
	}
	Node1(int Node1ID, State s,Node1 p,int pathcost,int heur)
	{
		this.Node1ID=Node1ID;
		this.STATE=s;
		this.PARENT=p;
		this.PATH_COST=pathcost;
		this.HEUR_COST=heur;
	}
	Node1(int Node1ID, State s,Node1 p,int pathcost,Action<String,String,Integer> act,int heur)
	{
		this.Node1ID=Node1ID;
		this.STATE=s;
		this.PARENT=p;
		this.PATH_COST=pathcost;
		this.ACTION=act;
		this.HEUR_COST=heur;
	}
	
	public State getState()
	{
		return STATE;
	}
	
	public Node1 getParent()
	{
		return PARENT;
	}
	
	public Action<String,String,Integer> getAction()
	{
		return ACTION;
	}
	
	public Integer getPathCost()
	{
		return PATH_COST;
	}
	public int getNode1ID()
	{
		return Node1ID;
	}
	public Integer getHeurCost()
	{
		return HEUR_COST;
	}
	public Integer getTotalCost()
	{
		return PATH_COST+HEUR_COST;
	}
	@Override
	public int compare(Node1 n1, Node1 n2) 
	{
		return n1.getPathCost()-n2.getPathCost();
	}
}

