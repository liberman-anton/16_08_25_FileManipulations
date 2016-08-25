package wix.filemanipulations.manipulations;

import java.util.*;

public class Sort implements IManipulations {

	@Override
	public List<String> manipulate(List<String> inputLines) {
		Collections.sort(inputLines);
		return inputLines;
	}

}
