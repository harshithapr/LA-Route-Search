package search;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Problem 
{
	ArrayList<State> States;
	State initialState;
	State goalState;
	Integer pathCost;
	TreeMap<String, ArrayList<Combo<String,Integer>>> space;
	HashMap<String, Integer> heuristics;
	ArrayList<Triplet<String,String,Integer>> livelines;
	HashMap<String, Integer> liveorder;
	Problem(State initialState,State goalState, TreeMap<String, ArrayList<Combo<String,Integer>>> space,ArrayList<Triplet<String,String,Integer>> livelines, HashMap<String, Integer> liveorder)
	{
		this.initialState=initialState;
		this.goalState=goalState;
		this.space=space;
		this.livelines=livelines;
		this.liveorder=liveorder;
	}
	Problem(State initialState,State goalState, TreeMap<String, ArrayList<Combo<String,Integer>>> space, ArrayList<Triplet<String,String,Integer>> livelines, HashMap<String, Integer> liveorder, HashMap<String, Integer> heuristics)
	{
		this.initialState=initialState;
		this.goalState=goalState;
		this.space=space;
		this.heuristics=heuristics;
		this.livelines=livelines;
		this.liveorder=liveorder;
	}
	public ArrayList<Action<String, String, Integer>> getAction(State s)
	{
		ArrayList<Action<String, String, Integer>> actions=new ArrayList<Action<String, String, Integer>>();
		ArrayList<Combo<String,Integer>> links=space.get(s.getLocation());
		if(links!=null)
		{
			for(Combo<String,Integer> c: links)
			{
				actions.add(new Action<String, String, Integer>("Go",c.getLocation(),c.getCost()));
			}
//			Combo<String,Integer> c;
//			for(int i=links.size()-1;i>=0;i--)
//			{
//				c=links.get(i);
//				actions.add(new Action<String, String, Integer>("Go",c.getLocation(),c.getCost()));
//			}
			return actions;
		}
		return null;
	}
	public State Result(State x, Action<String, String, Integer> a)
	{
		State y=new State(a.getloc());
		return y;
	}
	
	public boolean goalTest(State current)
	{
		String s1=goalState.getLocation();
		String s2=current.getLocation();
		
		int comp=s1.compareTo(s2);
		if(comp==0)
			return true;
		else
			return false;
	}
	public Integer updatePathCost()
	{
		return 0;
	}
	public State getinitialState()
	{
		return initialState;
	}
	public State getgoalState()
	{
		return goalState;
	}
}
