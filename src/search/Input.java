package search;

import java.util.ArrayList;
import java.util.HashMap;

public class Input 
{
	private String algo;
	private String start;
	private String goal;
	private int livenumber;
	private ArrayList<Triplet<String,String,Integer>> livelines;
	private int sundaynumber;
	private HashMap<String, Integer> sunlines;
	private HashMap<String,Integer> liveorder;
	
	Input(String algo, String start, String goal, int livenumber, 
			ArrayList<Triplet<String,String,Integer>> livelines,
			int sundaynumber,HashMap<String, Integer> sunlines, HashMap<String,Integer> liveorder )
	{
		this.algo=algo.toUpperCase();
		this.start=start;
		this.goal=goal;
		this.livenumber=livenumber;
		this.livelines=new ArrayList<Triplet<String,String,Integer>>(livelines);
		this.sundaynumber=sundaynumber;
		this.sunlines=new HashMap<String, Integer>(sunlines);
		this.liveorder=new HashMap<String, Integer>(liveorder);
	}
	public String getalgo()
	{
		return algo;
	}
	public ArrayList<Triplet<String,String,Integer>> getLiveLines()
	{
		return livelines;
	}
	public String getstart()
	{
		return start;
	}
	public String getgoal()
	{
		return goal;
	}
	public HashMap<String, Integer> getsunlines()
	{
		return sunlines;
		
	}
	public HashMap<String, Integer> getLiveOrder()
	{
		return liveorder;
	}
}
