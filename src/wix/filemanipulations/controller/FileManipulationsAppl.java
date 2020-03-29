package wix.filemanipulations.controller;

import java.io.*;
import java.lang.reflect.Method;
import java.util.List;

import wix.filemanipulations.io.LinesInputOutput;

public class FileManipulationsAppl {

	private static final String PACKAGE_NAME = "wix.filemanipulations.manipulations";

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new FileReader(args[0]));
		PrintWriter output = new PrintWriter(args[1]);
			
		BufferedReader console = 
				new BufferedReader(new InputStreamReader(System.in));
		
			System.out.println("hi, please write manipulation or exit");
			String manipulation = console.readLine();
			if(manipulation == null || manipulation.equals("exit")){
				System.out.println("glad to see you");
				return;
			}
			
			try {
				manipulationAction(manipulation,input,output);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				System.out.println("incorrect manipulate");
			}
		
		System.out.println("good bye");
	}

	private static void manipulationAction(String manipulation, BufferedReader input, PrintWriter output) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		LinesInputOutput lines = new LinesInputOutput(input, output);
		List<String> linesInput = lines.getLines();
		String className = PACKAGE_NAME + "." + manipulation;
		Class clazz = Class.forName(className);
		Object obj = clazz .newInstance();
		Class objClass = obj.getClass();
		Method method = null;
		try {
			method = objClass.getMethod("manipulate", List.class);
			List<String> resLines = (List<String>)(method.invoke(obj, linesInput));
			lines.putLines(resLines);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
