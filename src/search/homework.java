package search;

import java.util.LinkedList;

public class homework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadInput r = new ReadInput("input15.txt");
		Input in=r.read();
		Graph g=new Graph(in.getLiveLines());
		Problem prob;
		WriteOutput wp;
		LinkedList<Combo<String,Integer>> op;
		switch(in.getalgo())
		{
		case "BFS":
			BFS b=new BFS();
			prob=new Problem(new State(in.getstart()),new State(in.getgoal()),g.getGraph(),in.getLiveLines(),in.getLiveOrder());
			op=b.BFS_Search(prob);
			wp=new WriteOutput("output.txt");
			wp.write(op);
			break;
		case "UCS":
			UCS u=new UCS();
			prob=new Problem(new State(in.getstart()),new State(in.getgoal()),g.getGraph(),in.getLiveLines(),in.getLiveOrder());
			op=u.UCS_Search(prob);
			wp=new WriteOutput("output.txt");
			wp.write(op);
			break;
		case "DFS":
			DFS d=new DFS();
			prob=new Problem(new State(in.getstart()),new State(in.getgoal()),g.getGraph(),in.getLiveLines(),in.getLiveOrder());
			op=d.DFS_Search(prob);
			wp=new WriteOutput("output.txt");
			wp.write(op);
			break;
		case "A*":
			AST a = new AST();
			prob=new Problem(new State(in.getstart()),new State(in.getgoal()),g.getGraph(),in.getLiveLines(),in.getLiveOrder(),in.getsunlines());
			op=a.AST_Search(prob);
			wp=new WriteOutput("output.txt");
			wp.write(op);
			break;
		}
		
		
		
	}

}
