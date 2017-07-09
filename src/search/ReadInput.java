package search;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.*;


public class ReadInput 
{
	String filename;
	Input ip;
	
	
	public ReadInput(String filename)
	{
		this.filename=filename;
	}
	
	public Input read()
	{
		ArrayList<String> lines=new ArrayList<String>();
		try
		{
		File fp=new File(filename);
		FileReader  in=new FileReader(fp);
		BufferedReader br=new BufferedReader(in);
		
		String line;
		while((line=br.readLine())!=null)
		{
			lines.add(line);
		}
		br.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Input file doesn't exists");
		}
		catch(IOException e)
		{
			System.out.println("Error while reading data from file");
		}
		ip=loadData(lines);
		return ip;
	}
	public Input loadData(ArrayList<String> data)
	{
		String algo=data.get(0);
		String start=data.get(1);
		String goal=data.get(2);
		int livenumber=Integer.parseInt(data.get(3));
		ArrayList<Triplet<String,String,Integer>> livelines=new ArrayList<Triplet<String,String,Integer>>();
		HashMap<String,Integer> sunlines=new HashMap<String,Integer>();
		HashMap<String,Integer> liveorder=new HashMap<String,Integer>();
		int i;
		int order=0;
		for(i=0;i<livenumber;i++)
		{
			String liveline=data.get(i+4);
			StringTokenizer st=new StringTokenizer(liveline, " ");
			String[] s=new String[3];
			int j=0;
			while(st.hasMoreTokens())
			{
				s[j]=st.nextToken();
				j++;
			}
			liveorder.put(s[0]+"to"+s[1], ++order);
			livelines.add(new Triplet<String,String,Integer>(s[0],s[1],Integer.parseInt(s[2])));
		}

		int sunnumber=Integer.parseInt(data.get(i+4));
		for(int k=0; k<sunnumber; k++)
		{
			String sunline=data.get(i+5+k);
			StringTokenizer st=new StringTokenizer(sunline, " ");
			String[] s=new String[2];
			int j=0;
			while(st.hasMoreTokens())
			{
				s[j]=st.nextToken();
				j++;
			}
					sunlines.put(s[0], Integer.parseInt(s[1]));
		}
	return new Input(algo,start,goal,livenumber,livelines,sunnumber,sunlines,liveorder);
	}
}


