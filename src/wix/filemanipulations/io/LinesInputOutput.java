package wix.filemanipulations.io;

import java.io.*;
import java.util.*;

public class LinesInputOutput {
	BufferedReader input;
	PrintWriter output;
	
	public LinesInputOutput(BufferedReader input, PrintWriter output) {
		super();
		this.input = input;
		this.output = output;
	}
	
	public List<String> getLines() throws IOException{
		List<String> lines = new LinkedList<>();
		while(true){
				String line = input.readLine();
				if(line == null)
					break;
				lines.add(line);
			}
			input.close();
		return lines;
	}
	
	public void putLines(List<String> lines){
		for(String line : lines){
			output.println(line);
		}
		output.close();
	}
}
