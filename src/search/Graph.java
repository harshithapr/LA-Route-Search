package search;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Graph 
{
	TreeMap<String, ArrayList<Combo<String,Integer>>> route;
	HashSet<String> Vertices;
	
	Graph(ArrayList<Triplet<String,String,Integer>> lines)
	{
		route=new TreeMap<String, ArrayList<Combo<String,Integer>>>();
		Vertices=new HashSet<String>();
		for(Triplet<String,String,Integer> t:lines)
		{
			if(!route.containsKey(t.getfromLoc()))
			{
				ArrayList<Combo<String,Integer>> value=new ArrayList<Combo<String,Integer>>();
				value.add(new Combo<String,Integer>(t.gettoLoc(),t.getCost()));
				route.put(t.getfromLoc(), value);	
				Vertices.add(t.getfromLoc());
				Vertices.add(t.gettoLoc());
			}
			else
			{	
				route.get(t.getfromLoc()).add(new Combo<String,Integer>(t.gettoLoc(),t.getCost()));
				Vertices.add(t.getfromLoc());
				Vertices.add(t.gettoLoc());
			}
		}
		Iterator it=Vertices.iterator();
		String vertex;
		while(it.hasNext())
		{
			vertex=it.next().toString();
			if(!route.containsKey(vertex))
			{
				route.put(vertex,null);
			}
		}
		
	}
	
	public TreeMap<String, ArrayList<Combo<String,Integer>>> getGraph()
	{
		return route;
	}
	void display()
	{
			Set s=route.entrySet();
			Iterator it=s.iterator();
			
			while(it.hasNext())
			{
				Map.Entry<String, ArrayList<Combo<String,Integer>>> mp=(Map.Entry<String, ArrayList<Combo<String,Integer>>>)it.next();
				System.out.println("Key Value="+mp.getKey());
				ArrayList<Combo<String,Integer>> value=mp.getValue();
				System.out.println("Value List");
				if(value!=null)
				{
				for(Combo<String,Integer> c: value)
				{
					System.out.println(c.display());
				}
				}
			}
			it=Vertices.iterator();
			System.out.println("Vertices List");
			while(it.hasNext())
			{
				System.out.println(it.next().toString());
			}
	}
}
