package search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class WriteOutput 
{
	String filename;
	WriteOutput(String filename)
	{
		this.filename=filename;
	}
	
	public void write(LinkedList<Combo<String,Integer>> data)
	{
		FileWriter fw;
		BufferedWriter bw;
		try
		{
			fw=new FileWriter(filename);
			bw=new BufferedWriter(fw);
			int size=data.size()-1;
		for(int i=0;i<size;i++)
		{
			bw.write(data.pop().display());
			bw.write("\n");
		}
		bw.write(data.pop().display());
		
		bw.close();
		}
		catch(IOException e)
		{
			System.out.println("Error in writing data to a file");
		}

	}
}
