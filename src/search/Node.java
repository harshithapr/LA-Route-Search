package search;


public class Node
{
	private int nodeID;
	private State STATE;
	private Node PARENT;
	Action<String,String,Integer> ACTION;
	Integer PATH_COST;
	Integer HEUR_COST;
	Node()
	{
		
	}
	Node(int nodeID, State s,Node p,int pathcost,int heur)
	{
		this.nodeID=nodeID;
		this.STATE=s;
		this.PARENT=p;
		this.PATH_COST=pathcost;
		this.HEUR_COST=heur;
	}
	Node(int nodeID, State s,Node p,int pathcost,Action<String,String,Integer> act,int heur)
	{
		this.nodeID=nodeID;
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
	
	public Node getParent()
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
	public int getnodeID()
	{
		return nodeID;
	}
	public Integer getHeurCost()
	{
		return HEUR_COST;
	}
	public Integer getTotalCost()
	{
		return PATH_COST+HEUR_COST;
	}
}

